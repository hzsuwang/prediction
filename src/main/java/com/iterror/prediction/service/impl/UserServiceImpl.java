package com.iterror.prediction.service.impl;

import com.iterror.prediction.common.service.BaseService;
import com.iterror.prediction.domain.UserDO;
import com.iterror.prediction.service.UserService;
import org.nutz.dao.Cnd;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl extends BaseService implements UserService {
    @Override
    public UserDO getByPhone(String phone) {
        return dao.fetch(UserDO.class, Cnd.where("phone", "=", phone));
    }

    @Override
    public UserDO getByEmail(String email) {
        return dao.fetch(UserDO.class, Cnd.where("email", "=", email));
    }

    @Override
    public UserDO getById(long userId) {
        return dao.fetch(UserDO.class, Cnd.where("id", "=", userId));
    }

    @Override
    public UserDO getByThId(String thId) {
        return dao.fetch(UserDO.class, Cnd.where("open_uid", "=", thId));
    }

    @Override
    public UserDO getByUnionid(String unionid) {
        return dao.fetch(UserDO.class, Cnd.where("unionid", "=", unionid));
    }
}
