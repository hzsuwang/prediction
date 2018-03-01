package com.iterror.prediction.common.manager;

/**
 * Created by tony.yan on 2018/1/13.
 */
public class ActivemqReceiver {

    private String url;
    private String user;
    private String password;
    private final String QUEUE;

    public ActivemqReceiver(String queue, String url) {
        this.url = url;
        this.QUEUE = queue;
    }

    public ActivemqReceiver(String queue, String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.QUEUE = queue;
    }
}
