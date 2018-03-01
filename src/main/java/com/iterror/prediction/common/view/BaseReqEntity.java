package com.iterror.course.common.base.view;

import lombok.Data;

/**
 * Created by tony.yan on 2018/1/10.
 */
@Data
public class BaseReqEntity {

    private long   uid;    // 当前用户id
    private String sid;    // 当前用户sid
    private String version;// 版本号
    private int    ct;     // 客户 端类型
    private String channel;// 渠道名称
    private String src;    // 来源
    private String did;//设备号
}
