package edu.nciae.system.service;

import edu.nciae.system.vo.UserFollowVo;

import java.util.List;

public interface UserFollowService {
    /**
     * 添加关注
     * @param userId 用户id
     * @param followUserId 被关注着id
     * @return
     */
    int addFollow(Integer userId, Integer followUserId);

    /**
     * 取消关注
     * @param userId 用户id
     * @param followUserId 被关注着id
     * @return
     */
    int unfollow(Integer userId, Integer followUserId);

    /**
     * 根据用户名查找用户关注列表
     * @param userId
     * @param pageSize
     * @param pageNum
     * @param keyword
     * @return
     */
    List<UserFollowVo> getUserFollowList(Integer userId, Integer pageSize, Integer pageNum, String keyword);

}
