package edu.nciae.system.feign.factory;

import edu.nciae.system.domain.SysUser;
import edu.nciae.system.feign.RemoteUserService;
import edu.nciae.system.vo.SysUserVo;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RemoteUserFallbackFactory implements FallbackFactory<RemoteUserService> {
    @Override
    public RemoteUserService create(Throwable throwable) {
        return new RemoteUserService() {
            @Override
            public SysUser selectSysUserByPhonenumber(String phonenumber) {
                return null;
            }

            @Override
            public int updateUserLoginRecord(SysUser user) {
                return 0;
            }

            @Override
            public SysUserVo selectUserById(Integer userId) {
                return null;
            }

            @Override
            public SysUser selectUserinfoById(Integer userId) {
                return null;
            }
        };
    }
}
