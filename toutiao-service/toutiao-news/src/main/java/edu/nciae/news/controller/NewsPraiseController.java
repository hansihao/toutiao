package edu.nciae.news.controller;

import edu.nciae.common.annotation.LoginUser;
import edu.nciae.common.core.domain.CodeMsgConstants;
import edu.nciae.common.core.domain.Result;
import edu.nciae.news.service.NewsPraiseService;
import edu.nciae.system.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 新闻点赞控制层
 */
@RestController
@RequestMapping("newspraise")
public class NewsPraiseController {
    @Autowired
    private NewsPraiseService newsPraiseService;

    @PostMapping("praise")
    public Result addNewsPraise(@LoginUser SysUserVo sysUserVo, @RequestParam Long newsId) {
        int i = newsPraiseService.addNewsPraise(sysUserVo.getUserId(), newsId);
        return i == 1 ? Result.success(CodeMsgConstants.SUCCESS) : Result.error(CodeMsgConstants.FAIL);
    }

    @DeleteMapping("unpraise")
    public Result deleteNewsPraise(@LoginUser SysUserVo sysUserVo, @RequestParam Long newsId) {
        int i = newsPraiseService.deleteNewsPraise(sysUserVo.getUserId(), newsId);
        return i == 1 ? Result.success(CodeMsgConstants.SUCCESS) : Result.error(CodeMsgConstants.FAIL);
    }
}
