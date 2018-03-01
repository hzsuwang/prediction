package com.iterror.prediction.common.dao.domain;

import lombok.Data;
import org.nutz.dao.entity.annotation.Comment;

import java.util.Date;

/**
 * Created by tony.yan on 2018/1/15.
 */
@Data
public class BaseVO implements java.io.Serializable {

    @Comment("序号")
    private long id;

    @Comment("删除标记")
    private int  deleted;

    @Comment("创建时间")
    private Date createTime;

    @Comment("修改时间")
    private Date editTime;
}
