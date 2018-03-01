package com.iterror.prediction.domain;

import com.iterror.prediction.common.dao.domain.BaseDO;
import lombok.Data;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Table;

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

    @Column("email")
    @Comment("邮箱地扯")
    private String  email;

    @Column("phone")
    @Comment("手机号")
    private String  phone;

    @Column("password")
    @Comment("密码")
    private String  password;

    @Column("status")
    @Comment("状态 1：正常用户 0：无效用户")
    private int status;

    @Column("oauth_from")
    @Comment("0 邮箱注册 1微信 2腾讯qq 3新浪微博 4 github")
    private int oauthFrom;

    @Column("unionid")
    @Comment("微信登录统一平台账号id")
    private String  unionid;
}
