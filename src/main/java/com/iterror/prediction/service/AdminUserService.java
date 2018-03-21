package com.iterror.prediction.service;

import com.iterror.prediction.domain.AdminUserDO;
import org.nutz.dao.QueryResult;

public interface AdminUserService {
    public AdminUserDO addAdminUser(AdminUserDO adminUserDO);

    public boolean updateAdminUser(AdminUserDO adminUserDO);

    public QueryResult queryAdminUser(QueryResult queryResult);

    public AdminUserDO getByName(String name);
}
