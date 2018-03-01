package com.iterror.prediction.service;


import com.iterror.prediction.domain.CashFlowDO;

/**
 * Created by tony.yan on 2017/12/27.
 */
public interface CashFlowService {

    String genCashFlowOrderId();

    /**
     * @param id
     * @return
     */
    CashFlowDO getById(long id);

    /**
     * @param orderId
     * @return
     */
    CashFlowDO getCashFlowByOrderId(String orderId);

    /**
     * @param tpTradeId
     * @return
     */
    CashFlowDO getCashFlowByTpTradeId(String tpTradeId);


    /**
     * @param cashFlow
     * @return
     */
    public int update(CashFlowDO cashFlow);
}
