package edu.nciae.system.feign;

import edu.nciae.common.core.domain.Result;
import edu.nciae.system.domain.SysUser;
import edu.nciae.system.feign.factory.RemoteUserFallbackFactory;
import edu.nciae.system.vo.SysUserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户feign服务层
 */
@FeignClient(name = "system", fallbackFactory = RemoteUserFallbackFactory.class, contextId = "user")
public interface RemoteUserService {
    @GetMapping("user/find/{phonenumber}")
    SysUser selectSysUserByPhonenumber(@PathVariable("phonenumber") String phonenumber);

    @PostMapping("user/update/login")
    int updateUserLoginRecord(@RequestBody SysUser user);

    @GetMapping("user/get/{userId}")
    SysUserVo selectUserById(@PathVariable("userId") Integer userId);

    @GetMapping("user/getinfo/{userId}")
    SysUser selectUserinfoById(@PathVariable("userId") Integer userId);
}
