package edu.nciae.system.service;

import edu.nciae.system.vo.UserFollowVo;

import java.util.List;

/**
 * 粉丝服务层
 */
public interface UserFansService {
    /**
     * 添加粉丝
     * @param userId 用户id
     * @param fansUserId 粉丝id
     * @return
     */
    int addFans(Integer userId, Integer fansUserId);

    /**
     * 删除粉丝
     * @param userId 用户id
     * @param fansUserId 粉丝id
     * @return
     */
    int unfans(Integer userId, Integer fansUserId);

    /**
     * 获取用户粉丝列表
     * @param userId
     * @param pageSize
     * @param pageNum
     * @param keyword
     * @return
     */
    List<UserFollowVo> getUserFansList(Integer userId, Integer pageSize, Integer pageNum, String keyword);
}
