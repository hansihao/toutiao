package edu.nciae.system.service;

import edu.nciae.system.domain.SysUser;
import edu.nciae.system.vo.SysUserVo;

import java.util.List;

/**
 * 用户 业务层
 */
public interface SysUserService {
    /**
     * 通过用户ID查询用户
     * @param userId
     * @return
     */
    SysUserVo selectUserById(Integer userId);

    /**
     * 通过用户id查询用户详细信息
     * @param userId
     * @return
     */
    SysUser selectUserinfoById(Integer userId);

    /**
     * 通过用户名查询用户
     * @param phonenumber
     * @return
     */
    SysUser selectSysUserByPhonenumber(String phonenumber);

    /**
     * 记录登陆信息
     * @return
     */
    int updateUser(SysUser sysUser);

    /**
     * 记录登陆信息
     * @param user
     * @return
     */
    int updateUser(SysUser user, SysUser sysUser);

    /**
     * 添加用户
     * @param sysUser
     */
    int addUser(SysUser sysUser);

}
