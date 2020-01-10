package edu.nciae.news.mapper;

import edu.nciae.news.domain.NewsChannel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsChannelMapper {
    int deleteByPrimaryKey(Integer channelId);

    int insert(NewsChannel record);

    NewsChannel selectByPrimaryKey(Integer channelId);

    List<NewsChannel> selectAll();

    int updateByPrimaryKey(NewsChannel record);

    /**
     * 获取默认列表
     * @return
     */
    List<NewsChannel> selectDefaultChannel();

    /**
     * 获取用户默认列表
     * @param userId
     * @return
     */
    List<NewsChannel> selectUserDefaultChannel(@Param("userId") Integer userId);
}