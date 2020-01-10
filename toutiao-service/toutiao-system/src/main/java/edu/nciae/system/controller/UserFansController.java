package edu.nciae.system.controller;

import edu.nciae.common.annotation.LoginUser;
import edu.nciae.common.core.domain.CodeMsgConstants;
import edu.nciae.common.core.domain.Result;
import edu.nciae.system.service.UserFansService;
import edu.nciae.system.vo.SysUserVo;
import edu.nciae.system.vo.UserFollowVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 粉丝提供者
 */
@RestController
@RequestMapping("fans")
public class UserFansController {
    @Autowired
    private UserFansService userFansService;

    /**
     * 获取用户的粉丝列表
     * @param sysUserVo
     * @param pageSize
     * @param pageNum
     * @param keyword
     * @return
     */
    @GetMapping(value = {"list/{pageSize}/{pageNum}", "list/{pageSize}/{pageNum}/{keyword}"})
    public Result followList(@LoginUser SysUserVo sysUserVo, @PathVariable("pageSize") Integer pageSize, @PathVariable("pageNum") Integer pageNum, @PathVariable(name = "keyword", required = false) String keyword) {
        List<UserFollowVo> userFansList = userFansService.getUserFansList(sysUserVo.getUserId(), pageSize, pageNum, keyword);
        if (userFansList == null || userFansList.size() == 0) {
            return Result.success(CodeMsgConstants.FANS_NOTEXIST);
        }
        return Result.success(userFansList);
    }
}
