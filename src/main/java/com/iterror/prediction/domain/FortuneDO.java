package com.iterror.prediction.domain;

import com.iterror.prediction.common.dao.domain.BaseDO;
import lombok.Data;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Table;

@Data
@Table("p_fortune")
@Comment("算命表")
public class FortuneDO extends BaseDO {

    @Column("fortune_str")
    @Comment("算命字符")
    private String fortuneStr;

    @Column("gender")
    @Comment("性别")
    private int gender;

    @Column("title1")
    @Comment("标题1 个性解析")
    private String title1;
    @Column("content1")
    @Comment("内容1")
    private String content1;

    @Column("title2")
    @Comment("标题2 事业职场")
    private String title2;
    @Column("content2")
    @Comment("内容2")
    private String content2;

    @Column("title3")
    @Comment("标题3 财运大势")
    private String title3;
    @Column("content3")
    @Comment("内容3")
    private String content3;

    @Column("title4")
    @Comment("标题4 情感婚姻")
    private String title4;
    @Column("content4")
    @Comment("内容4")
    private String content4;

    @Column("tit5le")
    @Comment("标题5 健康平安")
    private String title5;
    @Column("content5")
    @Comment("内容5")
    private String content5;

    @Column("title6")
    @Comment("标题6 子女学业")
    private String title6;
    @Column("content6")
    @Comment("内容6")
    private String content6;

    @Column("title7")
    @Comment("标题7")
    private String title7;
    @Column("content7")
    @Comment("内容7")
    private String content7;

    @Column("title8")
    @Comment("标题8")
    private String title8;
    @Column("content8")
    @Comment("内容8")
    private String content8;

    @Column("title9")
    @Comment("标题9")
    private String title9;
    @Column("content9")
    @Comment("内容9")
    private String content9;
}
