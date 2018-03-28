package com.iterror.prediction.common.dao.vo;

import lombok.Data;

import java.util.Date;

@Data
public class UserVO implements java.io.Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_user.user_id
     *
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_user.user_login_name
     *
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    private String userLoginName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_user.user_name
     *
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_user.user_password
     *
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    private String userPassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_user.user_status
     *
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    private Long userStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_user.creator
     *
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    private String creator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_user.create_time
     *
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_user.modifier
     *
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    private String modifier;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cc_user.update_time
     *
     * @mbggenerated Mon Aug 15 22:46:30 CST 2016
     */
    private Date updateTime;


    /**
     * 用户所对应的角色id
     */
    private String roleIds;
    /**
     * 用户所对应的角色名称
     */
    private String roleNames;
    /**
     * 查询项
     */
    private String searchTerm;
    /**
     * 查询内容
     */
    private String searchContent;
}