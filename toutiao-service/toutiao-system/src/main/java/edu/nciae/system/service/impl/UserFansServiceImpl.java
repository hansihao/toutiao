package edu.nciae.system.service.impl;

import com.github.pagehelper.PageHelper;
import edu.nciae.common.utils.DateUtils;
import edu.nciae.system.domain.UserFans;
import edu.nciae.system.mapper.UserFansMapper;
import edu.nciae.system.service.UserFansService;
import edu.nciae.system.vo.UserFollowVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFansServiceImpl implements UserFansService {
    @Autowired
    private UserFansMapper userFansMapper;

    /**
     * 添加粉丝
     * @param userId 用户id
     * @param fansUserId 粉丝id
     * @return
     */
    @Override
    public int addFans(Integer userId, Integer fansUserId) {
        UserFans userFans = new UserFans();
        userFans.setUserId(userId);
        userFans.setFansUser(fansUserId);
        userFans.setCreateTime(DateUtils.getNowDate());
        userFans.setStatus("0");
        return userFansMapper.insert(userFans);
    }

    /**
     * 删除粉丝
     * @param userId 用户id
     * @param fansUserId 粉丝id
     * @return
     */
    @Override
    public int unfans(Integer userId, Integer fansUserId) {
        return userFansMapper.unfansByUserIdAndFollowId(userId, fansUserId);
    }

    /**
     * 获取用户粉丝列表
     * @param userId
     * @param pageSize
     * @param pageNum
     * @param keyword
     * @return
     */
    @Override
    public List<UserFollowVo> getUserFansList(Integer userId, Integer pageSize, Integer pageNum, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserFollowVo> userFansList = userFansMapper.selectUserFansList(userId, keyword);
        return userFansList;
    }
}
