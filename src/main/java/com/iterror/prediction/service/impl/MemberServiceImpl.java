package com.iterror.prediction.service.impl;

import com.iterror.prediction.common.service.BaseService;
import com.iterror.prediction.common.util.DateUtil;
import com.iterror.prediction.domain.MemberDO;
import com.iterror.prediction.domain.MemberFlowDO;
import com.iterror.prediction.service.MemberFlowService;
import com.iterror.prediction.service.MemberService;
import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("memberService")
public class MemberServiceImpl extends BaseService implements MemberService {

    @Autowired
    private MemberFlowService memberFlowService;

    @Override
    public int updateMember(MemberDO member) {
        member.flashEditTime();
        return dao.update(member);
    }

    @Override
    public MemberDO getByUid(long userId) {
        return dao.fetch(MemberDO.class, Cnd.where("user_id", "=", userId));
    }

    @Override
    public Map<Long, MemberDO> queryMembersMap(List<Long> uids) {
        Condition cnd = Cnd.where("1", "=", 1);
        if (uids == null || uids.isEmpty()) {
            ((Cnd) cnd).and("id", "=", 0);
        } else {
            ((Cnd) cnd).and("id", "in", uids);
        }

        List<MemberDO> memberDOList = dao.query(MemberDO.class, cnd);
        Map<Long, MemberDO> memMap = new HashMap<>();
        for (MemberDO memberDO : memberDOList) {
            memMap.put(memberDO.getUserId(), memberDO);
        }
        return memMap;
    }

    @Override
    public int updateMemberDayTime(long uid, int days, long pid) {
        MemberFlowDO memberFlow = new MemberFlowDO();
        memberFlow.setPid(pid);
        memberFlow.setTimes(days);
        memberFlow.setUserId(uid);
        memberFlowService.addMemberFlow(memberFlow);
        MemberDO memberDO = getByUid(uid);
        Date nowTime = DateUtil.getCurrentTime();
        if (memberDO == null) {
            memberDO = new MemberDO();
            memberDO.setExpiredTime(DateUtil.addDay(nowTime, days));
            memberDO.setUserId(uid);
            dao.insert(memberDO);
        } else {
            if (memberDO.isValid()) {
                memberDO.setExpiredTime(DateUtil.addTime(memberDO.getExpiredTime(), days));
            } else {
                memberDO.setExpiredTime(DateUtil.addDay(nowTime, days));
            }

            updateMember(memberDO);
        }
        return 0;
    }
}
