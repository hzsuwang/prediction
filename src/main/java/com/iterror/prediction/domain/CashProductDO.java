package com.iterror.prediction.domain;

import com.iterror.prediction.common.dao.domain.BaseDO;
import lombok.Data;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Table;

/**
 * Created by tony.yan on 2017/12/23.
 */
@Data
@Table("p_cash_product")
@Comment("商品信息表")
public class CashProductDO extends BaseDO {

    @Column("name")
    @Comment("价格名称")
    private String name;          // 价格名称

    @Column("prize")
    @Comment("价格")
    private int    prize;         // 价格

    @Column("num")
    @Comment("购买的金币数量/会员的天数/铁杆粉丝的天数")
    private int    num;          // 购买的金币数量/会员的天数/铁杆粉丝的天数

    @Column("order_num")
    @Comment("显示顺序")
    private int    orderNum;      // 显示顺序

    @Column("description")
    @Comment("描述")
    private String description;   // 描述

    @Column("status")
    @Comment("1-生效，0-无效")
    private int    status;        // 1-生效，0-无效

    @Column("giving_num")
    @Comment("赠送的数量")
    private int    givingNum;    // 赠送的金币数

    @Column("thirdparty_pid")
    @Comment("第三方产品id")
    private String thirdpartyPid; // 第三方产品id

    @Column("pro_type")
    @Comment("支付类型1表示金币充值， 2表示会员充值")
    private int    proType;       // 支付类型1表示金币充值， 2表示会员充值

    @Column("icon")
    @Comment("图标")
    private String icon;          // 图标

    @Column("channel")
    @Comment("渠道")
    private String channel;       // 渠道
}
