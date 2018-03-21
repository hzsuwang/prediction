package com.iterror.prediction.service;

import com.iterror.prediction.domain.FortuneFlowDO;

import java.util.List;

public interface FortuneFlowService {

    /**
     * @param phone
     * @return
     */
    public FortuneFlowDO getByPhone(String phone);

    /**
     * @param str
     * @return
     */
    public List<FortuneFlowDO> queryByFortuneStr(String str);

    /**
     * @param fortuneFlowDO
     * @return
     */
    public FortuneFlowDO addFortuneFlow(FortuneFlowDO fortuneFlowDO);

}
