package edu.nciae.news.service.impl;

import edu.nciae.news.mapper.NewsMapper;
import edu.nciae.news.service.NewsService;
import edu.nciae.news.vo.NewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;

    /**
     * 根据id查询新闻
     * @param userId
     * @param newsId
     * @return
     */
    @Override
    public NewsVo getNewsById(Integer userId, Long newsId) {
        newsMapper.addNewsReadingVolume(newsId);
        return newsMapper.selectNewsByNewsId(userId, newsId);
    }

    /**
     * 添加点赞量
     * @param newsId
     * @return
     */
    @Override
    public int addNewsPraise(Long newsId) {
        return newsMapper.addNewsPraiseVolume(newsId);
    }

    /**
     * 减少点赞量
     * @param newsId
     * @return
     */
    @Override
    public int unNewsPraise(Long newsId) {
        return newsMapper.reduceNewsPraiseVolume(newsId);
    }
}
