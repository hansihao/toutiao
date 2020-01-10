package edu.nciae.news.service;

/**
 * 新闻不喜欢服务层
 */
public interface NewsDislikeService {
    /**
     * 添加不喜欢新闻
     * @param userId
     * @param newsId
     * @return
     */
    int addNewsDislike(Integer userId, Long newsId);

    /**
     * 取消对新闻不喜欢
     * @param userId
     * @param newsId
     * @return
     */
    int deleteDislike(Integer userId, Long newsId);
}
