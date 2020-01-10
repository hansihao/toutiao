package edu.nciae.auth.service;

import edu.nciae.common.constant.Constants;
import edu.nciae.common.enums.UserStatus;
import edu.nciae.common.exception.BaseException;
import edu.nciae.common.exception.login.UserNotExistException;
import edu.nciae.common.utils.DateUtils;
import edu.nciae.common.utils.IpUtils;
import edu.nciae.common.utils.ServletUtils;
import edu.nciae.system.domain.SysUser;
import edu.nciae.system.feign.RemoteUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysLoginService {
    @Autowired
    private RemoteUserService userService;

    public SysUser login(String phonenumber) {
        if (StringUtils.isAnyBlank(phonenumber)) {
            throw new BaseException("user", "登录信息不能为空");
        }
        // 查询用户信息
        SysUser user = userService.selectSysUserByPhonenumber(phonenumber);
        if (user == null) {
            throw new UserNotExistException("user", "用户不存在");
        }
        if (UserStatus.DELETED.getCode().equals(user.getDelFlag())) {
            throw new UserNotExistException("user", "用户不存在");
        }
        if (UserStatus.DISABLE.getCode().equals(user.getStatus())) {
            throw new UserNotExistException("user", "用户已锁定");
        }
        recordLoginInfo(user);
        return user;

    }

    /**
     * 记录登录信息
     */
    public void recordLoginInfo(SysUser user) {
        user.setLoginIp(IpUtils.getIpAddr(ServletUtils.getRequest()));
        user.setLoginDate(DateUtils.getNowDate());
        userService.updateUserLoginRecord(user);
    }

    /**
     * 登出
     * @param loginName
     */
    public void logout(String loginName) {

    }

}
