package edu.nciae.news.controller;

import edu.nciae.common.annotation.LoginUser;
import edu.nciae.common.core.domain.CodeMsgConstants;
import edu.nciae.common.core.domain.Result;
import edu.nciae.news.domain.NewsChannel;
import edu.nciae.news.service.NewsChannelService;
import edu.nciae.system.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("newschannel")
public class NewsChannelController {
    @Autowired
    private NewsChannelService newsChannelService;

    /**
     * 获取全部频道
     *
     * @return
     */
    @GetMapping("all")
    public Result getAllNewsChannel() {
        List<NewsChannel> allNewsChannel = newsChannelService.getAllNewsChannel();
        return Result.success(allNewsChannel);
    }

    /**
     * 获取默认频道列表
     * @return
     */
    @GetMapping("default")
    public Result getDefaultNewsChannel(@LoginUser SysUserVo sysUserVo) {
        List<NewsChannel> defaultNewsChannel = newsChannelService.getDefaultNewsChannel(sysUserVo);
        return Result.success(defaultNewsChannel);
    }

    /**
     * 根据频道id关注频道
     * @param sysUserVo
     * @param newsChannelId
     * @return
     */
    @PostMapping("follow")
    public Result addNewsChannel(@LoginUser SysUserVo sysUserVo, @RequestParam Integer newsChannelId) {
        int i = newsChannelService.addNewsChannel(sysUserVo.getUserId(), newsChannelId);
        return i == 1 ? Result.success(CodeMsgConstants.SUCCESS) : Result.error(CodeMsgConstants.FAIL);
    }

    /**
     * 根据频道id取消关注频道
     * @param sysUserVo
     * @param newsChannelId
     * @return
     */
    @DeleteMapping("unfollow")
    public Result cancelNewsChannel(@LoginUser SysUserVo sysUserVo, @RequestParam Integer newsChannelId) {
        int i = newsChannelService.cancelNewsChannel(sysUserVo.getUserId(), newsChannelId);
        return i == 1 ? Result.success(CodeMsgConstants.SUCCESS) : Result.error(CodeMsgConstants.FAIL);
    }

    /**
     * 根据频道id批量取消关注频道
     * @param sysUserVo
     * @param newsChannelIds
     * @return
     */
    @DeleteMapping("unfollows")
    public Result cancelBatchNewsChannel(@LoginUser SysUserVo sysUserVo, @RequestParam List<String> newsChannelIds) {
        int i = newsChannelService.cancelBatchNewsChannel(sysUserVo.getUserId(), newsChannelIds);
        return i == newsChannelIds.size() ? Result.success(CodeMsgConstants.SUCCESS) : Result.error(CodeMsgConstants.FAIL);
    }

}
