package edu.nciae.auth.service;

import cn.hutool.core.util.IdUtil;
import edu.nciae.common.constant.Constants;
import edu.nciae.common.redis.utils.RedisUtils;
import edu.nciae.system.domain.SysUser;
import edu.nciae.system.feign.RemoteUserService;
import edu.nciae.system.vo.SysUserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccessTokenService {
    @Autowired
    private RedisUtils redis;
    @Autowired
    private RemoteUserService userService;

    // 2 小时后过期
    private final static long EXPIRE = 2 * 60 * 60;

    // 12 天过期
    private final static long REEXPIRE = 12 * 24 * 60 * 60;

    private final static String ACCESS_TOKEN  = Constants.ACCESS_TOKEN;

    private final static String ACCESS_USERID = Constants.ACCESS_USERID;

    private final static String ACCESS_REFRESHTOKEN = Constants.ACCESS_REFRESHTOKEN;

    public SysUser queryByToken(String token) {
        return redis.get(ACCESS_TOKEN + token, SysUser.class);
    }

    public Map<String, Object> createToken(SysUser sysUser) {
        // 生成token
        String token = IdUtil.simpleUUID();
        String refreshtoken = IdUtil.simpleUUID();
        // 保存或更新用户token
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", sysUser.getUserId());
        map.put("token", token);
        map.put("refreshtoken", refreshtoken);
        expireToken(sysUser.getUserId());
        redis.set(ACCESS_TOKEN + token, sysUser, EXPIRE);
        redis.set(ACCESS_USERID + sysUser.getUserId(), token, EXPIRE);
        redis.set(ACCESS_REFRESHTOKEN + refreshtoken, sysUser.getUserId(), REEXPIRE);
        return map;

    }

    /**
     * 删除token
     * @param userId
     */
    public void expireToken(Integer userId) {
        String token = redis.get(ACCESS_USERID + userId);
        if (StringUtils.isNotBlank(token)) {
            redis.delete(ACCESS_USERID + userId);
            redis.delete(ACCESS_TOKEN + token);
        }
    }

    /**
     * 刷新token
     * @param refreshtoken
     * @return
     */
    public Map<String, Object> refreshToken(String refreshtoken) {
        String userId = redis.get(ACCESS_REFRESHTOKEN + refreshtoken);
        if (StringUtils.isNotBlank(userId)) {
            SysUser sysUser = userService.selectUserinfoById(Integer.parseInt(userId));
            redis.delete(ACCESS_REFRESHTOKEN + refreshtoken);
            return createToken(sysUser);
        }
        return null;
    }
}
