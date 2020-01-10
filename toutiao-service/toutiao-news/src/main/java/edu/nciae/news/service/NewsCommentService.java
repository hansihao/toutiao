package edu.nciae.news.service;

import edu.nciae.news.vo.NewsCommentVo;

/**
 * 新闻评论业务层
 */
public interface NewsCommentService {
    /**
     * 添加评论
     * @param userId
     * @param newsCommentVo
     * @return
     */
    int addNewsComment(Integer userId, NewsCommentVo newsCommentVo);
}
