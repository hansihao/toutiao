package edu.nciae.news.mapper;

import edu.nciae.news.domain.NewsPraise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsPraiseMapper {
    int deleteByPrimaryKey(Long praiseId);

    int insert(NewsPraise record);

    NewsPraise selectByPrimaryKey(Long praiseId);

    List<NewsPraise> selectAll();

    int updateByPrimaryKey(NewsPraise record);

    /**
     * 根据用户id和新闻id取消点赞
     * @param userId
     * @param newsId
     * @return
     */
    int deletePraiseByUserIdAndNewsId(@Param("userId") Integer userId, @Param("newsId") Long newsId);
}