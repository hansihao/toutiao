package edu.nciae.system.controller;

import edu.nciae.common.annotation.LoginUser;
import edu.nciae.common.core.domain.CodeMsgConstants;
import edu.nciae.common.core.domain.Result;
import edu.nciae.system.domain.SysUser;
import edu.nciae.system.service.UserFollowService;
import edu.nciae.system.vo.SysUserVo;
import edu.nciae.system.vo.UserFollowVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 关注
 */
@RestController
@RequestMapping("follow")
@Slf4j
public class UserFollowController {
    @Autowired
    private UserFollowService userFollowServicel;

    /**
     * 添加关注
     *
     * @param sysUserVo
     * @param userId
     * @return
     */
    @PostMapping("addFollow")
    public Result addFollow(@LoginUser SysUserVo sysUserVo, @RequestParam Integer userId) {
        if (userId == null) {
            return Result.error(CodeMsgConstants.ARGS_NOTEXIST);
        }
        int i = userFollowServicel.addFollow(sysUserVo.getUserId(), userId);
        return i == 1 ? Result.success(CodeMsgConstants.SUCCESS) : Result.error(CodeMsgConstants.FAIL);
    }

    /**
     * 取消关注
     * @param sysUserVo
     * @param userId
     * @return
     */
    @DeleteMapping("unfollow")
    public Result unfollow(@LoginUser SysUserVo sysUserVo, @RequestParam Integer userId) {
        if (userId == null) {
            return Result.error(CodeMsgConstants.ARGS_NOTEXIST);
        }
        int i = userFollowServicel.unfollow(sysUserVo.getUserId(), userId);
        return i == 1 ? Result.success(CodeMsgConstants.SUCCESS) : Result.error(CodeMsgConstants.FAIL);
    }

    /**
     * 获取用户的关注列表
     * @param sysUserVo
     * @param pageSize
     * @param pageNum
     * @param keyword
     * @return
     */
    @GetMapping(value = {"list/{pageSize}/{pageNum}", "list/{pageSize}/{pageNum}/{keyword}"})
    public Result followList(@LoginUser SysUserVo sysUserVo, @PathVariable("pageSize") Integer pageSize, @PathVariable("pageNum") Integer pageNum, @PathVariable(name = "keyword", required = false) String keyword) {
        List<UserFollowVo> userFllowList = userFollowServicel.getUserFollowList(sysUserVo.getUserId(), pageSize, pageNum, keyword);
        if (userFllowList == null || userFllowList.size() == 0) {
            return Result.success(CodeMsgConstants.FOLLOW_NOTEXIST);
        }
        return Result.success(userFllowList);
    }
}
