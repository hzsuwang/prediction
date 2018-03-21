package com.iterror.prediction.service.impl;

import com.iterror.prediction.common.service.BaseService;
import com.iterror.prediction.common.util.CommonUtil;
import com.iterror.prediction.domain.CashFlowDO;
import com.iterror.prediction.service.CashFlowService;
import org.nutz.dao.Cnd;
import org.springframework.stereotype.Service;

@Service("cashFlowService")
public class CashFlowServiceImpl extends BaseService implements CashFlowService {

    @Override
    public String genCashFlowOrderId() {
        return System.currentTimeMillis() + String.valueOf(CommonUtil.getRandomNum(1000000));
    }

    @Override
    public CashFlowDO getById(long id) {
        return dao.fetch(CashFlowDO.class, id);
    }

    @Override
    public CashFlowDO getCashFlowByOrderId(String orderId) {
        return dao.fetch(CashFlowDO.class, Cnd.where("order_id", "", orderId));
    }

    @Override
    public CashFlowDO getCashFlowByTpTradeId(String tpTradeId) {
        return dao.fetch(CashFlowDO.class, Cnd.where("tp_trade_id", "", tpTradeId));
    }

    @Override
    public int update(CashFlowDO cashFlow) {
        cashFlow.flashEditTime();
        return dao.update(cashFlow);
    }
}
