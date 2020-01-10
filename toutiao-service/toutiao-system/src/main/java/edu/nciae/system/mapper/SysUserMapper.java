package edu.nciae.system.mapper;

import edu.nciae.system.domain.SysUser;
import edu.nciae.system.vo.SysUserVo;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(SysUser record);

    SysUser selectByPrimaryKey(Integer userId);

    List<SysUser> selectAll();

    int updateByPrimaryKey(SysUser record);

    /**
     * 通过用户名查询用户
     *
     * @param phonenumber 用户名
     * @return 用户对象信息
     */
    SysUser selectSysUserByPhonenumber(String phonenumber);

    /**
     * 根据id查询用户
     * @param userid
     * @return
     */
    SysUserVo selectSysUserByUserId(Integer userid);

}