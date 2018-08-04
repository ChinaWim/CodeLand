package com.wayming.codeland.dao;

import com.wayming.codeland.pojo.eo.SysUser;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser findByUsername(String username);

    List<SysUser> listUser();

    SysUser findByActiveCode(String activeCode);

    int incrementVisitCount(String username);

    List<SysUser> listUserByHot();

    int deleteByInvalid();
}