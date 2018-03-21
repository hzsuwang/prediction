package com.iterror.prediction.service.impl;

import com.iterror.prediction.common.service.BaseService;
import com.iterror.prediction.domain.FortuneDO;
import com.iterror.prediction.service.FortuneService;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("fortuneService")
public class FortuneServiceImpl extends BaseService implements FortuneService {
    @Override
    public FortuneDO addFortune(FortuneDO fortuneDO) {
        fortuneDO.init();
        return dao.insert(fortuneDO);
    }

    @Override
    public int updateFortune(FortuneDO fortuneDO) {
        fortuneDO.flashEditTime();
        return dao.update(fortuneDO);
    }

    @Override
    public List<FortuneDO> queryFortuneByStr(String str) {
        return dao.query(FortuneDO.class, Cnd.where("fortune_str", "=", str));
    }

    @Override
    public int deleteFortune(long id) {
        //dao.update(Person.class, Chain.makeSpecial("age", "+1").add("location", "yvr"), Cnd.where("name","=", "wendal"));
        return dao.update(FortuneDO.class, Chain.make("deleted", 1).add("edit_time", new Date()), Cnd.where("id", "=", id));
    }
}
