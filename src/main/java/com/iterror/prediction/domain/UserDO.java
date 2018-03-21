package com.iterror.prediction.domain;

import com.iterror.prediction.common.dao.domain.BaseDO;
import lombok.Data;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Table;

import java.util.Date;

/**
 * Created by tony.yan on 2017/10/10.
 */
@Data
@Table("p_user")
@Comment("用户表")
public class UserDO extends BaseDO {

    @Column("nick_name")
    @Comment("名称")
    private String nickName;

    @Column("head")
    @Comment("头像")
    private String head;       // 头像

    @Column("phone")
    @Comment("手机号")
    private String phone;

    @Column("password")
    @Comment("密码")
    private String password;

    @Column("status")
    @Comment("状态 1：正常用户 0：无效用户")
    private int status;

    @Column("oauth_from")
    @Comment("0 邮箱注册 1微信 2腾讯qq 3新浪微博 4 github")
    private int oauthFrom;

    @Column("open_uid")
    @Comment("第三方提供id")
    private String  openUid;    // 第三方提供id

    @Column("unionid")
    @Comment("微信登录统一平台账号id")
    private String unionid;

    @Column("ip")
    @Comment("ip")
    private String ip;         // ip


    @Column("active_time")
    @Comment("活跃时间")
    private Date activeTime; // 活跃时间

    @Column("login_days")
    @Comment("用户连续登陆的天数")
    private int loginDays;  // 用户连续登陆的天数

    @Column("login_time")
    @Comment("登录时间")
    private Date loginTime;  // 登录时间
}
