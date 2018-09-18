package com.wayming.codeland.service;

import com.wayming.codeland.pojo.vo.ServerResponseVO;
import com.wayming.codeland.pojo.eo.SysUser;
import com.wayming.codeland.pojo.vo.PageVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-6-22 上午12:06
 */
public interface UserService {

    ServerResponseVO rePassword(String username, String newPassword, String oldPassword);

    ServerResponseVO saveUser(SysUser user);

    ServerResponseVO updateUser(SysUser user);

    void registerUser(SysUser user);

    PageVO<SysUser> listUser(Integer pageNo,Integer pageSize);

    PageVO<SysUser> listUserByHot(Integer pageNo,Integer pageSize);

    ServerResponseVO deleteUserById(Integer id);

    SysUser getUserById(Integer id);

    ServerResponseVO activeAccount(String activeCode);

    SysUser getUserByUsername(String username);

    ServerResponseVO incrementVisitCount(String username);

    ServerResponseVO deleteByInvalid();

    List<SysUser> listUserByNotActive();

    ServerResponseVO uploadAvatar(Integer userId,MultipartFile file);

}
