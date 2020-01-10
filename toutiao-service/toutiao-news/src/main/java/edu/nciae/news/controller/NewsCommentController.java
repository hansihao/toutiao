package edu.nciae.news.controller;

import edu.nciae.common.annotation.LoginUser;
import edu.nciae.common.core.domain.CodeMsgConstants;
import edu.nciae.common.core.domain.Result;
import edu.nciae.news.service.NewsCommentService;
import edu.nciae.news.vo.NewsCommentVo;
import edu.nciae.system.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 新闻评论控制层
 */
@RestController
@RequestMapping("newscomment")
public class NewsCommentController {
    @Autowired
    private NewsCommentService newsCommentService;

    /**
     * 添加评论
     * @param sysUserVo
     * @param newsCommentVo
     * @return
     */
    @PostMapping("add")
    public Result addNewsComment(@LoginUser SysUserVo sysUserVo, @RequestBody NewsCommentVo newsCommentVo) {
        int i = newsCommentService.addNewsComment(sysUserVo.getUserId(), newsCommentVo);
        return i == 1 ? Result.success(CodeMsgConstants.SUCCESS) : Result.error(CodeMsgConstants.FAIL);
    }
}
