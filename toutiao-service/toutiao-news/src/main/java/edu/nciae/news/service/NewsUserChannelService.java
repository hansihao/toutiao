package edu.nciae.news.service;

import edu.nciae.news.domain.NewsUserChannel;

import java.util.List;

public interface NewsUserChannelService {
    /**
     * 添加关注频道
     * @param newsUserChannel
     * @return
     */
    int addNewsUserChannel(NewsUserChannel newsUserChannel);

    /**
     * 取消关注频道
     * @param userId
     * @param newsChannelId
     * @return
     */
    int cancelNewsUserChannel(Integer userId, Integer newsChannelId);

    /**
     * 根据用户id和频道id查询关注的频道
     * @param userId
     * @param newsChannelId
     * @return
     */
    NewsUserChannel getNewsUserChannelByUserIdAndNewsUserChannelId(Integer userId, Integer newsChannelId);

    /**
     * 根据频道id批量取消关注频道
     * @param userId
     * @param newsChannelIds
     * @return
     */
    int cancelBatchNewsChannel(Integer userId, List<String> newsChannelIds);
}
