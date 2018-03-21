package com.iterror.prediction.service;

import com.iterror.prediction.domain.FortuneDO;

import java.util.List;

public interface FortuneService {
    /**
     * @param fortuneDO
     * @return
     */
    public FortuneDO addFortune(FortuneDO fortuneDO);

    /**
     * @param fortuneDO
     * @return
     */
    public int updateFortune(FortuneDO fortuneDO);

    /**
     * @param str
     * @return
     */
    public List<FortuneDO> queryFortuneByStr(String str);

    /**
     *      * @param id
     * @return
     */
    public int deleteFortune(long id);



}
