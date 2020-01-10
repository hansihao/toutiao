package edu.nciae.news.service;

/**
 * 新闻点赞服务层
 */
public interface NewsPraiseService {
    /**
     * 添加点赞
     * @param userId
     * @param newsId
     * @return
     */
    int addNewsPraise(Integer userId, Long newsId);

    /**
     * 取消点赞
     * @param userId
     * @param newsId
     * @return
     */
    int deleteNewsPraise(Integer userId, Long newsId);
}
