package com.iterror.prediction.common.util.constants;

/**
 * Created by tony.yan on 2018/1/2.
 */
public class CommonConstants {

    /**
     * 默认返回的pageSize
     */
    public static final int    DEFAULT_PAGE_SIZE             = 20;

    /**
     * 公共正确，成功状态
     */
    public static final int    COMMON_STATUS_OK              = 1;

    public static final int    RETURN_RESULT_SUCCESS         = 1;
    public static final String RETURN_RESULT_SUCCESS_MSG     = "成功";

    public static final int    CODE_SESSION_OVERDUE          = -1;
    public static final String CODE_SESSION_OVERDUE_MSG      = "会话已过期，请重新登陆";

    public static final int    CODE_CHAT_TITLES              = -2;
    public static final String CODE_CHAT_TITLES_MSG          = "您已被封号";

    public static final int    CODE_OTHER_LOGIN              = -3;
    public static final String CODE_OTHER_LOGIN_MSG          = "您在其它地方登陆";

    public static final int    CODE_ROLE_ERROR               = -5;
    public static final String CODE_ROLE_ERROR_MSG           = "你无权进行此操作";

    public static final int    CODE_USER_NOT_EXIST_ERROR     = -6;
    public static final String CODE_USER_NOT_EXIST_ERROR_MSG = "用户信息不存在，请重试！";

    public static final int    CODE_GOLD_ERROR               = -7;
    public static final String CODE_GOLD_ERROR_MSG           = "金币不足，请充值";

    // 少了签名参数
    public static final int    CODE_SYSTEM_NOSIGN_ERROR      = -900;
    // 时间戳有问题
    public static final int    CODE_SYSTEM_TIME_ERROR        = -901;
    // 签名有问题
    public static final int    CODE_SYSTEM_SIGN_ERROR        = -902;

    public static final int    RETURN_RESULT_FAILE           = -999;
    public static final String RETURN_RESULT_FAILE_MSG       = "请求出错，请重试！";

    public static final int    PARAM_CHECK_ERROR             = -998;
    public static final String PARAM_CHECK_ERROR_MSG         = "请求参数有误！";


    /**用户登录名称*/
    public static final String SESSION_KEY_LOGIN_NAME="LOGIN_NAME";

    /**初始化密码*/
    public static final String INIT_LOGIN_PWD = "123456";
}
