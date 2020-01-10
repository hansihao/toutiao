package edu.nciae.news.mapper;

import edu.nciae.news.domain.NewsDislike;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsDislikeMapper {
    int deleteByPrimaryKey(Long dislikeId);

    int insert(NewsDislike record);

    NewsDislike selectByPrimaryKey(Long dislikeId);

    List<NewsDislike> selectAll();

    int updateByPrimaryKey(NewsDislike record);

    /**
     * 根据用户id和新闻id取消对新闻的不喜欢
     * @param userId
     * @param newsId
     * @return
     */
    int deleteDislikeByUserIdAndNewsId(@Param("userId") Integer userId, @Param("newsId") Long newsId);
}