package com.iterror.prediction.common.view;


/**
 * Created by tony.yan on 2018/1/10.
 */
public enum RespCode {
    SUCCESS(1, "成功"),
    // 成功
    GLOBAL_SUCCESS(1,"成功"),
    //失败
    GLOBAL_ERROR(9999, "系统正在维护中,请稍后再试!"),

    /**通用 */
    GLOBAL_LOGIN_NAME_NULL(0501,"用户名不能为空"),
    GLOBAL_LOGIN_PASS_NULL(0502,"密码不能为空"),

    GLOBAL_LOGIN_FAIL(0503,"用户名或密码不匹配"),

    GLOBAL_LOGIN_ERROR(0504,"系统登录异常"),

    GLOBAL_CAPTCHA_NULL(0505,"验证码不能为空"),

    GLOBAL_CAPTCHA_ERROR(0506,"验证码输入错误"),




    RES_SAVE_ERROR(1501,"菜单资源信息保存失败"),
    ROLE_SAVE_ERROR(1502,"角色信息保存失败"),
    USER_SAVE_ERROR(1503,"用户信息保存失败"),
    USER_ROLE_SAVE_ERROR(1504,"用户分配角色信息失败"),
    USER_FAIL_ERROR(1505,"失效用户失败,程序异常"),
    ROLE_FAILK_ERROR(1506,"失效角色失败,程序异常"),
    RES_FAILK_ERROR(1507,"失效资源失败,程序异常"),
    USER_LOGIN_NAME_EXIST(1508,"用户账号已存在，请重新输入"),
    ROLE_RES_SAVE_ERROR(1509,"角色分配菜单失败"),
    ROLE_NAME_EXIST(1508,"角色名称已存在，请重新输入"),
    ANNOUNCEMENT_SAVE_ERROR(1509,"公告信息保存失败"),
    ANNOUNCEMENT_DEL_ERROR(1510,"删除公告失败,程序异常"),
    ANNOUNCEMENT_USER_INSERT_ERROR(1511,"标记为已读失败,程序异常")
    ;

    private int code;
    private String msg;

    RespCode(int code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
