package com.iterror.prediction.domain;

import com.iterror.prediction.common.dao.domain.BaseDO;
import lombok.Data;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Table;

import java.util.Date;

/**
 * Created by tony.yan on 2017/10/11.
 */
@Data
@Table("p_member")
@Comment("会员信息表")
public class MemberDO extends BaseDO {

    @Column("user_id")
    @Comment("用户id")
    private long userId;      // 用户id

    @Column("expired_time")
    @Comment("过期时间")
    private Date expiredTime; // 过期时间

    @Column("use_num")
    @Comment("使用次数")
    private int useNum;
}
