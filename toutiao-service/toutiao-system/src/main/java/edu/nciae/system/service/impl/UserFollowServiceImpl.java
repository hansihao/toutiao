package edu.nciae.system.service.impl;

import com.github.pagehelper.PageHelper;
import edu.nciae.common.utils.DateUtils;
import edu.nciae.system.domain.UserFollow;
import edu.nciae.system.mapper.UserFollowMapper;
import edu.nciae.system.service.UserFansService;
import edu.nciae.system.service.UserFollowService;
import edu.nciae.system.vo.UserFollowVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 关注服务层
 */
@Service
@Slf4j
public class UserFollowServiceImpl implements UserFollowService {
    @Autowired
    private UserFollowMapper userFollowMapper;
    @Autowired
    private UserFansService userFansService;

    /**
     * 添加关注,同时添加粉丝
     * @param userId 用户id
     * @param followUserId 被关注着id
     * @return
     */
    @Transactional
    @Override
    public int addFollow(Integer userId, Integer followUserId) {
        UserFollow userFollow = new UserFollow();
        userFollow.setUserId(userId);
        userFollow.setFollowUser(followUserId);
        userFollow.setStatus("0");
        userFollow.setCreateTime(DateUtils.getNowDate());

        userFansService.addFans(followUserId, userId);
        return userFollowMapper.insert(userFollow);
    }

    /**
     * 取消关注
     * @param userId 用户id
     * @param followUserId 被关注着id
     * @return
     */
    @Transactional
    @Override
    public int unfollow(Integer userId, Integer followUserId) {
        userFansService.unfans(followUserId, userId);
        return userFollowMapper.unfollowByUserIdAndFollowId(userId, followUserId);
    }

    /**
     * 根据用户名查找用户关注列表
     * @param userId
     * @param pageSize
     * @param pageNum
     * @param keyword
     * @return
     */
    @Override
    public List<UserFollowVo> getUserFollowList(Integer userId, Integer pageSize, Integer pageNum, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserFollowVo> userFollowVos = userFollowMapper.selectUserFollowList(userId, keyword);
        return userFollowVos;
    }
}
