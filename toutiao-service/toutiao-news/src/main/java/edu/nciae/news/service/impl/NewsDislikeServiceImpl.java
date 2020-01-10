package edu.nciae.news.service.impl;

import edu.nciae.common.utils.DateUtils;
import edu.nciae.news.domain.NewsDislike;
import edu.nciae.news.mapper.NewsDislikeMapper;
import edu.nciae.news.service.NewsDislikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NewsDislikeServiceImpl implements NewsDislikeService {
    @Autowired
    private NewsDislikeMapper newsDislikeMapper;

    /**
     * 添加不喜欢新闻
     * @param userId
     * @param newsId
     * @return
     */
    @Transactional
    @Override
    public int addNewsDislike(Integer userId, Long newsId) {
        NewsDislike newsDislike = new NewsDislike();
        newsDislike.setUserId(userId);
        newsDislike.setNewsId(newsId);
        newsDislike.setDislikeTime(DateUtils.getNowDate());
        newsDislike.setStatus("0");
        return newsDislikeMapper.insert(newsDislike);
    }

    /**
     * 取消对新闻不喜欢
     * @param userId
     * @param newsId
     * @return
     */
    @Transactional
    @Override
    public int deleteDislike(Integer userId, Long newsId) {
        return newsDislikeMapper.deleteDislikeByUserIdAndNewsId(userId, newsId);
    }
}
