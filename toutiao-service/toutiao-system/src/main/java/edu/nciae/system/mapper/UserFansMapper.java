package edu.nciae.system.mapper;

import edu.nciae.system.domain.UserFans;
import edu.nciae.system.vo.UserFollowVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserFansMapper {
    int deleteByPrimaryKey(Integer fansId);

    int insert(UserFans record);

    UserFans selectByPrimaryKey(Integer fansId);

    List<UserFans> selectAll();

    int updateByPrimaryKey(UserFans record);

    /**
     * 删除粉丝
     * @param userId
     * @param fansUserId
     * @return
     */
    int unfansByUserIdAndFollowId(@Param("userId") Integer userId, @Param("fansUserId") Integer fansUserId);

    /**
     * 根据用户名查找用户粉丝列表
     * @param userId
     * @param keyword
     * @return
     */
    List<UserFollowVo> selectUserFansList(@Param("userId") Integer userId, @Param("keyword") String keyword);
}