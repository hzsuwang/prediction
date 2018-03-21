package com.iterror.prediction.service.impl;

import com.iterror.prediction.common.service.BaseService;
import com.iterror.prediction.domain.FortuneFlowDO;
import com.iterror.prediction.service.FortuneFlowService;
import org.nutz.dao.Cnd;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("fortuneFlowService")
public class FortuneFlowServiceImpl extends BaseService implements FortuneFlowService {
    @Override
    public FortuneFlowDO getByPhone(String phone) {
        return dao.fetch(FortuneFlowDO.class, Cnd.where("phone", "=", phone));
    }

    @Override
    public List<FortuneFlowDO> queryByFortuneStr(String str) {
        return dao.query(FortuneFlowDO.class, Cnd.where("fortune_str", "=", str));
    }

    @Override
    public FortuneFlowDO addFortuneFlow(FortuneFlowDO fortuneFlowDO) {
        fortuneFlowDO.init();
        return dao.insert(fortuneFlowDO);
    }
}
