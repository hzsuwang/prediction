package com.iterror.prediction.service;


import com.iterror.prediction.domain.CashProductDO;

import java.util.List;

/**
 * Created by tony.yan on 2017/12/27.
 */
public interface CashProductService {
    /**
     * 新增支付产品
     * @param cashProduct
     * @return
     */
    public long createCashProduct(CashProductDO cashProduct);

    /**
     * 更新支付产品
     * @param cashProduct
     * @return
     */
    public int updateCashProduct(CashProductDO cashProduct);

    /**
     * 读取支付产品
     *
     * @param type 1：金币充值 2：会员充值 3铁杆粉丝价格列表
     * @param channel
     * @return
     */
    public List<CashProductDO> queryCashProduct(int type, String channel);

    /**
     * @param id
     * @return
     */
    public CashProductDO getById(long id);
}
