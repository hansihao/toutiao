package edu.nciae.news.controller;

import edu.nciae.common.annotation.LoginUser;
import edu.nciae.common.core.domain.CodeMsgConstants;
import edu.nciae.common.core.domain.Result;
import edu.nciae.news.service.NewsDislikeService;
import edu.nciae.system.vo.SysUserVo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("newsdislike")
public class NewsDislikeController {
    private NewsDislikeService newsDislikeService;

    @PostMapping("dislike")
    public Result addNewsDislike(@LoginUser SysUserVo sysUserVo, @RequestParam Long newsId) {
        int i = newsDislikeService.addNewsDislike(sysUserVo.getUserId(), newsId);
        return i == 1 ? Result.success(CodeMsgConstants.SUCCESS) : Result.error(CodeMsgConstants.FAIL);
    }

    @DeleteMapping("undislike")
    public Result deleteDislike(@LoginUser SysUserVo sysUserVo, @RequestParam Long newsId) {
        int i = newsDislikeService.deleteDislike(sysUserVo.getUserId(), newsId);
        return i == 1 ? Result.success(CodeMsgConstants.SUCCESS) : Result.error(CodeMsgConstants.FAIL);
    }
}
