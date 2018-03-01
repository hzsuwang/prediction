package com.iterror.prediction.service;


import com.iterror.prediction.domain.UserSysinfoDO;

import java.util.List;
import java.util.Map;

/**
 * Created by tony.yan on 2017/12/27.
 */
public interface UserSysinfoService {
    /**
     * @param userId
     * @return
     */
    public UserSysinfoDO getByUserId(long userId);
    /**
     *  通过ids查找用户信息
     * @param ids
     * @return
     */
    public Map<Long, UserSysinfoDO> queryUserSysInfoMap(List<Long> ids);

    /**
     * 保存客户端信息
     *
     * @param userSysinfoDO
     */
    public void saveUserSysinfo(UserSysinfoDO userSysinfoDO);
}
