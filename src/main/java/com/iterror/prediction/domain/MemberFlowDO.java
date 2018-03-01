package com.iterror.prediction.domain;

import com.iterror.prediction.common.dao.domain.BaseDO;
import lombok.Data;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Table;

/**
 * Created by tony.yan on 2017/10/24.
 */
@Data
@Table("p_member_flow")
@Comment("会员记录表")
public class MemberFlowDO extends BaseDO {

    @Column("user_id")
    @Comment("用户id")
    private long userId;

    @Column("pid")
    @Comment("产品id")
    private long pid;

    @Column("times")
    @Comment("时长天")
    private int times;
}
