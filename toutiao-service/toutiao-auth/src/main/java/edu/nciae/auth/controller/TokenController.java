package edu.nciae.auth.controller;

import edu.nciae.auth.service.AccessTokenService;
import edu.nciae.auth.service.SysLoginService;
import edu.nciae.auth.vo.LoginVo;
import edu.nciae.common.core.domain.CodeMsgConstants;
import edu.nciae.common.core.domain.Result;
import edu.nciae.common.exception.BaseException;
import edu.nciae.common.exception.login.UserNotExistException;
import edu.nciae.system.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TokenController {
    @Autowired
    private SysLoginService sysLoginService;
    @Autowired
    private AccessTokenService accessTokenService;

    @PostMapping("authorizations")
    public Result login(@RequestBody LoginVo loginVo) {
        // 用户登录
        try {
            SysUser user = sysLoginService.login(loginVo.getPhonenumber());
            // 获取登录token
            Map<String, Object> token = accessTokenService.createToken(user);
            return Result.success(token);
        } catch (UserNotExistException e) {
            e.printStackTrace();
            return Result.error(CodeMsgConstants.USER_NOTEXIST);
        } catch (BaseException e) {
            e.printStackTrace();
            return Result.error(CodeMsgConstants.ARGS_ERROR);
        }
    }

    @PostMapping("refreshtoken")
    public Result refreshToken(@RequestParam String refreshtoken) {
        Map<String, Object> token = accessTokenService.refreshToken(refreshtoken);
        return token != null ? Result.success(token) : Result.error(CodeMsgConstants.ARGS_ERROR);
    }

}
