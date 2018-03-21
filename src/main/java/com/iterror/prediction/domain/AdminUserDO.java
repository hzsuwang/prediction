package com.iterror.prediction.domain;

import com.iterror.prediction.common.dao.domain.BaseDO;
import lombok.Data;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Table;

@Data
@Table("p_admin_user")
@Comment("充值记录表")
public class AdminUserDO extends BaseDO {

    @Column("user_name")
    @Comment("用户名")
    private String userName;

    @Column("password")
    @Comment("密码")
    private String password;

    @Column("user_mark")
    @Comment("用户备注")
    private String userMark;

    @Column("status")
    @Comment("用户状态")
    private int status;
}
