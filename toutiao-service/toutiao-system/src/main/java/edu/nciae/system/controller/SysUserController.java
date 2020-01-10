package edu.nciae.system.controller;

import edu.nciae.common.core.domain.CodeMsgConstants;
import edu.nciae.common.core.domain.Result;
import edu.nciae.common.utils.DateUtils;
import edu.nciae.system.domain.SysUser;
import edu.nciae.system.service.SysUserService;
import edu.nciae.system.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户提供者
 */
@RestController
@RequestMapping("user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 根据id查询用户
     *
     * @param userId
     * @return
     */
    @GetMapping("get/{userId}")
    public SysUserVo get(@PathVariable("userId") Integer userId) {
        return sysUserService.selectUserById(userId);
    }

    /**
     * 根据id查询用户详细信息
     *
     * @param userId
     * @return
     */
    @GetMapping("getinfo/{userId}")
    public SysUser getinfo(@PathVariable("userId") Integer userId) {
        return sysUserService.selectUserinfoById(userId);
    }

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @GetMapping("{userId}")
    public Result getSysUserByUserId(@PathVariable("userId") Integer userId) {
        SysUserVo sysUserVo = sysUserService.selectUserById(userId);
        if (sysUserVo != null) {
            return Result.success(CodeMsgConstants.SUCCESS, sysUserVo);
        }
        return Result.error(CodeMsgConstants.USER_NOTEXIST);
    }

    /**
     * 根据用户名查询用户
     *
     * @param phonenumber
     * @return
     */
    @GetMapping("find/{phonenumber}")
    public SysUser selectSysUserByPhonenumber(@PathVariable("phonenumber") String phonenumber) {
        return sysUserService.selectSysUserByPhonenumber(phonenumber);
    }

    /**
     * 记录登陆信息
     *
     * @param sysUser
     * @return
     */
    @PostMapping("update/login")
    public int updateLoginRecord(@RequestBody SysUser sysUser) {
        return sysUserService.updateUser(sysUser);
    }

    /**
     * 添加用户
     * @param sysUser
     * @return
     */
    @PostMapping("add")
    public Result addSysUser(@RequestBody SysUser sysUser) {
        if (sysUser.getPhonenumber() == null || "".equals(sysUser.getPhonenumber().trim()) || sysUser.getPhonenumber().trim().length() != 11) {
            return Result.error(CodeMsgConstants.ARGS_NOTEXIST);
        }
        int i = sysUserService.addUser(sysUser);
        return i == 1 ? Result.success(CodeMsgConstants.SUCCESS) : Result.error(CodeMsgConstants.FAIL);
    }
}
