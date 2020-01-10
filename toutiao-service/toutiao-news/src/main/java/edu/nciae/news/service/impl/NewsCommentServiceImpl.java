package edu.nciae.news.service.impl;

import edu.nciae.common.utils.DateUtils;
import edu.nciae.news.domain.NewsComment;
import edu.nciae.news.mapper.NewsCommentMapper;
import edu.nciae.news.service.NewsCommentService;
import edu.nciae.news.vo.NewsCommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsCommentServiceImpl implements NewsCommentService {
    @Autowired
    private NewsCommentMapper newsCommentMapper;

    /**
     * 添加评论
     * @param userId
     * @param newsCommentVo
     * @return
     */
    @Override
    public int addNewsComment(Integer userId, NewsCommentVo newsCommentVo) {
        NewsComment newsComment = new NewsComment();
        newsComment.setUserId(userId);
        if (newsCommentVo.getArtId() == null || newsCommentVo.getArtId() == 0) {
            newsComment.setNewsId(newsCommentVo.getTarget());
        } else {
            newsComment.setCommentParentId(newsCommentVo.getTarget());
        }
        newsComment.setCommentContent(newsCommentVo.getContent());
        newsComment.setCommentTime(DateUtils.getNowDate());
        newsComment.setStatus("0");
        return newsCommentMapper.insert(newsComment);
    }
}
