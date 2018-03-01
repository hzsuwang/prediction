package com.iterror.prediction.common.util;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CompleteMultipartUploadRequest;
import com.aliyun.oss.model.InitiateMultipartUploadRequest;
import com.aliyun.oss.model.InitiateMultipartUploadResult;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PartETag;
import com.aliyun.oss.model.UploadPartRequest;
import com.aliyun.oss.model.UploadPartResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by tony.yan on 2018/1/13.
 */
public class AliyunOssUtil {

    private static final long PART_SIZE     = 512 * 1024L; // 每个Part的大小，最小为500kb
    private static final int  CONCURRENCIES = 4;               // 上传Part的并发线程数。

    private static OSSClient  client        = null;

    private OSSClient getOSSClient(String ossUrl, String ossAccessId, String ossAccessKey) {
        if (client == null) {
            client = new OSSClient(ossUrl, ossAccessId, ossAccessKey);
        }
        return client;
    }

    private OSSClient getOSSClient(){
        return client;
    }

    // 根据文件的大小和每个Part的大小计算需要划分的Part个数。
    private int calPartCount(File f) {
        int partCount = (int) (f.length() / PART_SIZE);
        if (f.length() % PART_SIZE != 0) {
            partCount++;
        }
        return partCount;
    }

    // 初始化一个Multi-part upload请求。
    private String initMultipartUpload(String bucketName, String key) throws OSSException, ClientException {
        InitiateMultipartUploadRequest initUploadRequest = new InitiateMultipartUploadRequest(bucketName, key);
        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentType("audio/mpeg");
        initUploadRequest.setObjectMetadata(meta);
        InitiateMultipartUploadResult initResult = getOSSClient().initiateMultipartUpload(initUploadRequest);
        return initResult.getUploadId();
    }

    // 完成一个multi-part请求。
    private void completeMultipartUpload(String bucketName, String key, String uploadId, List<PartETag> eTags) throws OSSException, ClientException {
        // 为part按partnumber排序
        Collections.sort(eTags, new Comparator<PartETag>() {

            @Override
            public int compare(PartETag arg0, PartETag arg1) {
                PartETag part1 = arg0;
                PartETag part2 = arg1;
                return part1.getPartNumber() - part2.getPartNumber();
            }
        });
        CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(bucketName, key, uploadId, eTags);
        getOSSClient().completeMultipartUpload(completeMultipartUploadRequest);
    }

    // 通过Multipart的方式上传一个大文件
    // 要上传文件的大小必须大于一个Part允许的最小大小，即500kb。
    public boolean uploadBigFile(String bucketName, String key, File uploadFile) throws OSSException, ClientException, InterruptedException {
        // 不能以/开头
        key = key.substring(1, key.length());

        boolean result = false;
        try {
            int partCount = calPartCount(uploadFile);
            if (partCount <= 1) {
                return false;
                // throw new IllegalArgumentException("要上传文件的大小必须大于一个Part的字节数：" + PART_SIZE);
            }
            String uploadId = initMultipartUpload(bucketName, key);

            ThreadPoolExecutor executor = new ThreadPoolExecutor(CONCURRENCIES, 10, 15, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

            List<PartETag> eTags = Collections.synchronizedList(new ArrayList<PartETag>());
            for (int i = 0; i < partCount; i++) {
                long start = PART_SIZE * i;
                long curPartSize = PART_SIZE < uploadFile.length() - start ? PART_SIZE : uploadFile.length() - start;
                executor.execute(new UploadPartThread(getOSSClient(), bucketName, key, uploadFile, uploadId, i + 1, PART_SIZE * i, curPartSize, eTags));
            }
            executor.shutdown();
            while (!executor.isTerminated()) {
                executor.awaitTermination(5, TimeUnit.SECONDS);
            }
            if (eTags.size() != partCount) {
                // throw new IllegalStateException("Multipart上传失败，有Part未上传成功。");
                return result;
            }
            completeMultipartUpload(bucketName, key, uploadId, eTags);
            result = true;
            return result;
        } catch (Exception ex) {
            return false;
        }
    }

    private class UploadPartThread implements Runnable {

        private File           uploadFile;
        private String         bucket;
        private String         object;
        private long           start;
        private long           size;
        private List<PartETag> eTags;
        private int            partId;
        private OSSClient      client;
        private String         uploadId;

        UploadPartThread(OSSClient client, String bucket, String object, File uploadFile, String uploadId, int partId, long start, long partSize, List<PartETag> eTags){
            this.uploadFile = uploadFile;
            this.bucket = bucket;
            this.object = object;
            this.start = start;
            this.size = partSize;
            this.eTags = eTags;
            this.partId = partId;
            this.client = client;
            this.uploadId = uploadId;
        }


        @Override
        public void run() {

            InputStream in = null;
            try {
                in = new FileInputStream(uploadFile);
                in.skip(start);

                UploadPartRequest uploadPartRequest = new UploadPartRequest();
                uploadPartRequest.setBucketName(bucket);
                uploadPartRequest.setKey(object);
                uploadPartRequest.setUploadId(uploadId);
                uploadPartRequest.setInputStream(in);
                uploadPartRequest.setPartSize(size);
                uploadPartRequest.setPartNumber(partId);

                UploadPartResult uploadPartResult = client.uploadPart(uploadPartRequest);

                eTags.add(uploadPartResult.getPartETag());

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (in != null){ try {
                    in.close();
                } catch (Exception e) {
                }}
            }
        }
    }
}
