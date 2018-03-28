package com.iterror.prediction.common.view;

import lombok.Data;

/**
 * Created by tony.yan on 2018/1/10.
 */
@Data
public class ReqEntity implements java.io.Serializable{

    private BaseReqEntity base;
    private long          t;    // 请求时间
    private String        sign; // 签名值
}
