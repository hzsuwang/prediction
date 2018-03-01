package com.iterror.prediction.service;


import com.iterror.prediction.domain.UserDO;

/**
 * Created by tony.yan on 2017/12/27.
 */
public interface UserService {

    /**
     * 通过手机号查询用户信息
     *
     * @param phone
     * @return
     */
    public UserDO getByPhone(String phone);

    /**
     * 通过email查询用户信息
     *
     * @param email
     * @return
     */
    public UserDO getByEmail(String email);

    /**
     * 获取用户信息
     *
     * @param userId
     * @return
     */
    public UserDO getById(long userId);

    /**
     * 第三方的用户id
     * 
     * @param thId
     * @return
     */
    public UserDO getByThId(String thId);

    /**
     * 第三方的用户unionid
     * 
     * @param unionid
     * @return
     */
    public UserDO getByUnionid(String unionid);
}
