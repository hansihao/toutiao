package edu.nciae.system.service.impl;

import edu.nciae.common.utils.DateUtils;
import edu.nciae.system.domain.SysUser;
import edu.nciae.system.mapper.SysUserMapper;
import edu.nciae.system.service.SysUserService;
import edu.nciae.system.vo.SysUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper userMapper;

    /**
     * 通过用户ID查询用户
     *
     * @param userId
     * @return
     */
    @Override
    public SysUserVo selectUserById(Integer userId) {
        SysUserVo sysUserVo = userMapper.selectSysUserByUserId(userId);
        return sysUserVo;
    }

    /**
     * 通过用户id查询用户详细信息
     * @param userId
     * @return
     */
    @Override
    public SysUser selectUserinfoById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    /**
     * 通过用户名查询用户
     *
     * @param phonenumber
     * @return
     */
    @Override
    public SysUser selectSysUserByPhonenumber(String phonenumber) {
        return userMapper.selectSysUserByPhonenumber(phonenumber);
    }

    /**
     * 更新用户
     * @param sysUser
     * @return
     */
    @Transactional
    @Override
    public int updateUser(SysUser sysUser) {
        return userMapper.updateByPrimaryKey(sysUser);
    }

    /**
     * 记录登陆信息
     *
     * @param user
     * @return
     */
    @Override
    @Transactional
    public int updateUser(SysUser user, SysUser sysUser) {
        sysUser.setUpdateTime(DateUtils.getNowDate());
        return userMapper.updateByPrimaryKey(sysUser);
    }

    /**
     * 添加用户
     * @param sysUser
     * @return
     */
    @Transactional
    @Override
    public int addUser(SysUser sysUser) {
        return userMapper.insert(sysUser);
    }

}
