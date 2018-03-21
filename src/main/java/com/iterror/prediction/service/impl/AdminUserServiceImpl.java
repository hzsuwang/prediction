package com.iterror.prediction.service.impl;

import com.iterror.prediction.common.service.BaseService;
import com.iterror.prediction.domain.AdminUserDO;
import com.iterror.prediction.service.AdminUserService;
import org.nutz.dao.Cnd;
import org.nutz.dao.QueryResult;
import org.nutz.dao.pager.Pager;
import org.springframework.stereotype.Service;

@Service("adminUserService")
public class AdminUserServiceImpl extends BaseService implements AdminUserService {
    @Override
    public AdminUserDO addAdminUser(AdminUserDO adminUserDO) {
        return dao.insert(adminUserDO);
    }

    @Override
    public boolean updateAdminUser(AdminUserDO adminUserDO) {
        adminUserDO.flashEditTime();
        int result = dao.update(adminUserDO);
        if (result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public QueryResult queryAdminUser(QueryResult queryResult) {
        Pager page = queryResult.getPager();
        page.setRecordCount(dao.count(AdminUserDO.class));
        queryResult.setList(dao.query(AdminUserDO.class, null, page));
        return queryResult;
    }

    @Override
    public AdminUserDO getByName(String name) {
        return dao.fetch(AdminUserDO.class, Cnd.where("user_name", "=", name));
    }
}
