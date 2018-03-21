package com.iterror.prediction.service.impl;

import com.iterror.prediction.common.service.BaseService;
import com.iterror.prediction.domain.MemberFlowDO;
import com.iterror.prediction.service.MemberFlowService;
import org.springframework.stereotype.Service;

@Service("memberFlowService")
public class MemberFlowServiceImpl extends BaseService implements MemberFlowService {
    @Override
    public void addMemberFlow(MemberFlowDO memberFlowDO) {
        memberFlowDO.init();
        dao.insert(memberFlowDO);
    }
}
