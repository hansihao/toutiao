package edu.nciae.news.service.impl;

import edu.nciae.news.domain.NewsUserChannel;
import edu.nciae.news.mapper.NewsUserChannelMapper;
import edu.nciae.news.service.NewsUserChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsUserChannelServiceImpl implements NewsUserChannelService {
    @Autowired
    private NewsUserChannelMapper newsUserChannelMapper;

    /**
     * 添加关注频道
     * @param newsUserChannel
     * @return
     */
    @Override
    public int addNewsUserChannel(NewsUserChannel newsUserChannel) {
        return newsUserChannelMapper.insert(newsUserChannel);
    }

    /**
     * 取消关注频道
     * @param userId
     * @param newsChannelId
     * @return
     */
    @Override
    public int cancelNewsUserChannel(Integer userId, Integer newsChannelId) {
        return newsUserChannelMapper.cancelNewsUserChannel(userId, newsChannelId);
    }

    /**
     * 根据用户id和频道id查询关注的频道
     * @param userId
     * @param newsChannelId
     * @return
     */
    @Override
    public NewsUserChannel getNewsUserChannelByUserIdAndNewsUserChannelId(Integer userId, Integer newsChannelId) {
        return newsUserChannelMapper.selectNewsUserChannelByUserIdAndNewsUserChannelId(userId, newsChannelId);
    }

    /**
     * 根据频道id批量取消关注频道
     * @param userId
     * @param newsChannelIds
     * @return
     */
    @Override
    public int cancelBatchNewsChannel(Integer userId, List<String> newsChannelIds) {
        return newsUserChannelMapper.cancelBatchNewsChannel(userId, newsChannelIds);
    }
}
