package edu.nciae.news.mapper;

import edu.nciae.news.domain.NewsComment;

import java.util.List;

public interface NewsCommentMapper {
    int deleteByPrimaryKey(Long commentId);

    int insert(NewsComment record);

    NewsComment selectByPrimaryKey(Long commentId);

    List<NewsComment> selectAll();

    int updateByPrimaryKey(NewsComment record);
}