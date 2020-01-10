package edu.nciae.news.service.impl;

import edu.nciae.common.utils.DateUtils;
import edu.nciae.news.domain.NewsPraise;
import edu.nciae.news.mapper.NewsPraiseMapper;
import edu.nciae.news.service.NewsPraiseService;
import edu.nciae.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NewsPraiseServiceImpl implements NewsPraiseService {
    @Autowired
    private NewsPraiseMapper newsPraiseMapper;
    @Autowired
    private NewsService newsService;

    /**
     * 添加点赞
     * @param userId
     * @param newsId
     * @return
     */
    @Transactional
    @Override
    public int addNewsPraise(Integer userId, Long newsId) {
        newsService.addNewsPraise(newsId);
        NewsPraise newsPraise = new NewsPraise();
        newsPraise.setUserId(userId);
        newsPraise.setNewsId(newsId);
        newsPraise.setStatus("0");
        newsPraise.setPraiseTime(DateUtils.getNowDate());
        return newsPraiseMapper.insert(newsPraise);
    }

    /**
     * 取消点赞
     * @param userId
     * @param newsId
     * @return
     */
    @Transactional
    @Override
    public int deleteNewsPraise(Integer userId, Long newsId) {
        newsService.unNewsPraise(newsId);
        return newsPraiseMapper.deletePraiseByUserIdAndNewsId(userId, newsId);
    }

}
