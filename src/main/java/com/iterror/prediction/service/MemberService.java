package com.iterror.prediction.service;


import com.iterror.prediction.domain.MemberDO;

import java.util.List;
import java.util.Map;

/**
 * Created by tony.yan on 2017/12/27.
 */
public interface MemberService {
    /**
     * 更新
     * @param member
     * @return
     */
    public int updateMember(MemberDO member);
    /**
     * 按userID查询用户的会员信息
     *
     * @param userId
     * @return
     */
    public MemberDO getByUid(long userId);

    /**
     * @param uids
     * @return
     */
    public Map<Long, MemberDO> queryMembersMap(List<Long> uids);

    /**
     * 更新用户的会员时间
     *
     * @param uid
     * @param days
     * @param pid
     * @return
     */
    public int updateMemberDayTime(long uid, int days, long pid);
}
