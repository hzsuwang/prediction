package com.iterror.prediction.service.impl;

import com.iterror.prediction.common.service.BaseService;
import com.iterror.prediction.domain.CashProductDO;
import com.iterror.prediction.service.CashProductService;
import org.nutz.dao.Cnd;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("cashProductService")
public class CashProductServiceImpl extends BaseService implements CashProductService {
    @Override
    public CashProductDO createCashProduct(CashProductDO cashProduct) {
        return dao.insert(cashProduct);
    }

    @Override
    public int updateCashProduct(CashProductDO cashProduct) {
        return dao.update(cashProduct);
    }

    @Override
    public List<CashProductDO> queryCashProduct(int type, String channel) {
        return dao.query(CashProductDO.class, Cnd.where("pro_type", "=", type).and("channel", "=", channel));
    }

    @Override
    public CashProductDO getById(long id) {
        return dao.fetch(CashProductDO.class, id);
    }
}
