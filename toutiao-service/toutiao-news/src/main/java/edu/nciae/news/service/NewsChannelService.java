package edu.nciae.news.service;

import edu.nciae.news.domain.NewsChannel;
import edu.nciae.system.vo.SysUserVo;

import java.util.List;

/**
 * 频道列表服务层
 */
public interface NewsChannelService {

    /**
     * 获取全部频道列表
     * @return
     */
    List<NewsChannel> getAllNewsChannel();

    /**
     * 获取默认的频道列表
     * @return
     */
    List<NewsChannel> getDefaultNewsChannel(SysUserVo sysUserVo);

    /**
     * 用户根据频道id添加关注频道
     * @param userId
     * @param newsChannelId
     * @return
     */
    int addNewsChannel(Integer userId, Integer newsChannelId);

    /**
     * 用户根据频道id取消关注频道
     * @param userId
     * @param newsChannelId
     * @return
     */
    int cancelNewsChannel(Integer userId, Integer newsChannelId);

    /**
     * 根据频道id批量取消关注频道
     * @param userId
     * @param newsChannelIds
     * @return
     */
    int cancelBatchNewsChannel(Integer userId, List<String> newsChannelIds);
}
