package com.iterror.prediction.common.view;


import com.iterror.prediction.common.util.constants.CommonConstants;

/**
 * Created by tony.yan on 2018/1/10.
 */
public enum RespCode {
    SUCCESS(CommonConstants.RETURN_RESULT_SUCCESS, "请求成功"),
    ;

    private int code;
    private String msg;

    RespCode(int code, String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
