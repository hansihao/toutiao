package edu.nciae.news.mapper;

import edu.nciae.news.domain.News;
import edu.nciae.news.vo.NewsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {
    int deleteByPrimaryKey(Long newsId);

    int insert(News record);

    News selectByPrimaryKey(Long newsId);

    List<News> selectAll();

    int updateByPrimaryKey(News record);

    /**
     * 根据新闻id查询
     * @param userId
     * @param newsId
     * @return
     */
    NewsVo selectNewsByNewsId(@Param("userId") Integer userId, @Param("newsId") Long newsId);

    /**
     * 添加点赞量
     * @param newsId
     * @return
     */
    int addNewsPraiseVolume(@Param("newsId") Long newsId);

    /**
     * 减少点赞量
     * @param newsId
     * @return
     */
    int reduceNewsPraiseVolume(@Param("newsId") Long newsId);

    /**
     * 添加阅读量
     * @param newsId
     * @return
     */
    int addNewsReadingVolume(@Param("newsId") Long newsId);
}