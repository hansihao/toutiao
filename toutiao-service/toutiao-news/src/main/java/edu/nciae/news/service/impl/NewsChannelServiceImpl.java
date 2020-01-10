package edu.nciae.news.service.impl;

import edu.nciae.news.domain.NewsChannel;
import edu.nciae.news.domain.NewsUserChannel;
import edu.nciae.news.mapper.NewsChannelMapper;
import edu.nciae.news.mapper.NewsUserChannelMapper;
import edu.nciae.news.service.NewsChannelService;
import edu.nciae.news.service.NewsUserChannelService;
import edu.nciae.system.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsChannelServiceImpl implements NewsChannelService {
    @Autowired
    private NewsChannelMapper newsChannelMapper;
    @Autowired
    private NewsUserChannelService newsUserChannelService;

    /**
     * 获取全部频道列表
     * @return
     */
    @Override
    public List<NewsChannel> getAllNewsChannel() {
        List<NewsChannel> newsChannels = newsChannelMapper.selectAll();
        return newsChannels;
    }

    /**
     * 获取默认的频道列表
     * @return
     */
    @Override
    public List<NewsChannel> getDefaultNewsChannel(SysUserVo sysUserVo) {
        if (sysUserVo == null || sysUserVo.getUserId() == null) {
            List<NewsChannel> newsChannels = newsChannelMapper.selectDefaultChannel();
            return newsChannels;
        }
        List<NewsChannel> newsChannels = newsChannelMapper.selectUserDefaultChannel(sysUserVo.getUserId());
        return newsChannels;
    }

    /**
     * 用户根据频道id添加关注频道
     * @param userId
     * @param newsChannelId
     * @return
     */
    @Override
    public int addNewsChannel(Integer userId, Integer newsChannelId) {
        NewsUserChannel newsUserChannel = new NewsUserChannel();
        newsUserChannel.setUserId(userId);
        newsUserChannel.setChannelId(newsChannelId);
        newsUserChannel.setStatus("0");
        return newsUserChannelService.addNewsUserChannel(newsUserChannel);
    }

    /**
     * 用户根据频道id取消关注频道
     * @param userId
     * @param newsChannelId
     * @return
     */
    @Override
    public int cancelNewsChannel(Integer userId, Integer newsChannelId) {
        return newsUserChannelService.cancelNewsUserChannel(userId, newsChannelId);
    }

    /**
     * 根据频道id批量取消关注频道
     * @param userId
     * @param newsChannelIds
     * @return
     */
    @Override
    public int cancelBatchNewsChannel(Integer userId, List<String> newsChannelIds) {
        return newsUserChannelService.cancelBatchNewsChannel(userId, newsChannelIds);
    }
}
