package edu.nciae.system.mapper;

import edu.nciae.system.domain.UserFollow;
import edu.nciae.system.vo.UserFollowVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserFollowMapper {
    int deleteByPrimaryKey(Integer followId);

    int insert(UserFollow record);

    UserFollow selectByPrimaryKey(Integer followId);

    List<UserFollow> selectAll();

    int updateByPrimaryKey(UserFollow record);

    /**
     * 根据用户和被关注着id查询记录
     * @param userId
     * @param followUserId
     * @return
     */
    UserFollow selectByUserIdAndFollowId(@Param("userId") Integer userId, @Param("followUserId") Integer followUserId);

    /**
     * 根据用户id和关注者id取消关注
     * @param userId
     * @param followUserId
     * @return
     */
    int unfollowByUserIdAndFollowId(@Param("userId") Integer userId, @Param("followUserId") Integer followUserId);

    /**
     * 根据用户名查找用户关注列表
     * @param userId
     * @param keyword
     * @return
     */
    List<UserFollowVo> selectUserFollowList(@Param("userId") Integer userId, @Param("keyword") String keyword);
}