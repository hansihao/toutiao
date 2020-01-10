package edu.nciae.news.service;

import edu.nciae.news.vo.NewsVo;

/**
 * 新闻服务层
 */
public interface NewsService {
    /**
     * 根据id查询新闻
     * @param userId
     * @param newsId
     * @return
     */
    NewsVo getNewsById(Integer userId, Long newsId);

    /**
     * 增加点赞量
     * @param newsId
     * @return
     */
    int addNewsPraise(Long newsId);

    /**
     * 取消点赞量
     * @param newsId
     * @return
     */
    int unNewsPraise(Long newsId);
}
