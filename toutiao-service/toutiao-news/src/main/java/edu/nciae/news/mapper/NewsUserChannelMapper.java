package edu.nciae.news.mapper;

import edu.nciae.news.domain.NewsUserChannel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsUserChannelMapper {
    int deleteByPrimaryKey(Integer userChannelId);

    int insert(NewsUserChannel record);

    NewsUserChannel selectByPrimaryKey(Integer userChannelId);

    List<NewsUserChannel> selectAll();

    int updateByPrimaryKey(NewsUserChannel record);

    /**
     * 根据用户id取消关注频道
     * @param userId
     * @param newsChannelId
     * @return
     */
    int cancelNewsUserChannel(@Param("userId") Integer userId, @Param("newsChannelId") Integer newsChannelId);

    /**
     * 根据频道id批量取消关注频道
     * @param userId
     * @param newsChannelIds
     * @return
     */
    int cancelBatchNewsChannel(@Param("userId") Integer userId, @Param("newsChannelIds") List<String> newsChannelIds);

    /**
     * 根据用户id和频道id查询关注的频道
     * @param userId
     * @param newsChannelId
     * @return
     */
    NewsUserChannel selectNewsUserChannelByUserIdAndNewsUserChannelId(Integer userId, Integer newsChannelId);
}