package com.iterror.prediction.common.manager;

/**
 * Created by tony.yan on 2018/1/11.
 */
public abstract  class Message {
    protected String msgBody = null; // 原始的消息体
    protected int    tid     = 0;   // 消息类型编号
    protected String mrt     = null; // 消息请求类型 REQ/RES IND/CONF，可选
    protected String ph      = null; // 电话号码
    protected String sph     = null; // 信息发送者号码
    protected int    rcd     = 0;   // 返回结果码
    protected String msr     = null; // 消息来源

   // public abstract void onHandler(ApplicationContext ctx);

    public abstract void sendJms(MessageProducer queueProducer) throws Exception;
}
