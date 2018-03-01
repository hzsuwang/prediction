package com.iterror.prediction.common.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.iterror.prediction.common.util.constants.CommonConstants;
import com.iterror.prediction.common.util.constants.SystemConstants;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by tony.yan on 2018/1/2.
 */
public class EncryptUtil {
    private static Logger logger = LoggerFactory.getLogger(EncryptUtil.class);

    public static JSONObject getParamJson(String content, boolean checkTime) {
        try {
            if (StringUtils.isBlank(content)) {
                return null;
            }
            JSONObject jsonObj = null;
            try {
                jsonObj = JSONObject.parseObject(content);
                if (jsonObj == null) {
                    return null;
                }
            } catch (Exception ex) {
                return null;
            }
            jsonObj.put("encrypt_rc", CommonConstants.RETURN_RESULT_SUCCESS);
            String paramValue = jsonObj.getString("param");
            if (StringUtils.isBlank(paramValue)) {
                return jsonObj;
            }
            String data = DesUtil.decode(paramValue);
            if (StringUtils.isBlank(data)) {
                jsonObj.put("encrypt_rc", CommonConstants.CODE_SYSTEM_NOSIGN_ERROR);
                return jsonObj;
            }
            JSONObject dataJson = JSONObject.parseObject(data);
            dataJson.put("is_encrypt", true);
            long t = dataJson.getLongValue("t");
            String sign = dataJson.getString("sign");

            if (StringUtils.isBlank(sign)) {
                dataJson.put("encrypt_rc", CommonConstants.CODE_SYSTEM_NOSIGN_ERROR);
                return dataJson;
            }

            // 请求在五分钟以外的不处理
            long nowTime = System.currentTimeMillis();
            long lefTime = Math.abs(nowTime - t);
            if (checkTime && lefTime > 600000) {
                dataJson.put("encrypt_rc", CommonConstants.CODE_SYSTEM_TIME_ERROR);
                logger.error("encrypt_rc="+CommonConstants.CODE_SYSTEM_TIME_ERROR+" dataJson=" + dataJson.toString());
                return dataJson;
            }

            SortedMap<String, Object> packageParams = new TreeMap();

            for (String key : dataJson.keySet()) {
                Object obj = dataJson.get(key);
                if (obj instanceof JSONObject || obj instanceof JSONArray) {
                    continue;
                }
                if (null == obj || "sign".equals(key) || "is_encrypt".equals(key) || "encrypt_rc".equals(key)) {
                    continue;
                }
                packageParams.put(key, obj);
            }
            String newsign = createSign(packageParams, SystemConstants.APP_MD5_KEY);
            if (!newsign.equals(sign)) { // 验证不通过
                dataJson.put("encrypt_rc", CommonConstants.CODE_SYSTEM_SIGN_ERROR);
                logger.error("encrypt_rc=" + CommonConstants.CODE_SYSTEM_SIGN_ERROR + " dataJson=" + dataJson.toString());
                return dataJson;
            }
            dataJson.put("encrypt_rc", CommonConstants.RETURN_RESULT_SUCCESS);
            return dataJson;
        } catch (Exception ex) {
            logger.error("EncryptUtil getParamJson", ex);
        }
        return null;
    }

    private static String createSign(SortedMap<String, Object> packageParams, String secret_key) {
        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();
        sb.append("secret_key=" + secret_key);
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (v instanceof Boolean) {
                sb.append(k + "=" + ((Boolean) v ? 1 : 0));
            } else {
                sb.append(k + "=" + v);
            }
        }
        sb.append("secret_key=" + secret_key);
        return MD5.md5Digest(sb.toString());
    }
}
