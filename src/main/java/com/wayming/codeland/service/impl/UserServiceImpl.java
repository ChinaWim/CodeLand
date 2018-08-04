package com.wayming.codeland.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wayming.codeland.constant.RestStatusConstant;
import com.wayming.codeland.constant.SysRolesEnum;
import com.wayming.codeland.dao.SysRoleMapper;
import com.wayming.codeland.dao.SysUserMapper;
import com.wayming.codeland.dao.SysUserRoleMapper;
import com.wayming.codeland.exception.ApplicationException;
import com.wayming.codeland.pojo.eo.SysRole;
import com.wayming.codeland.pojo.eo.SysUser;
import com.wayming.codeland.pojo.eo.SysUserRole;
import com.wayming.codeland.pojo.vo.PageVO;
import com.wayming.codeland.pojo.vo.ServerResponseVO;
import com.wayming.codeland.service.UserService;
import com.wayming.codeland.util.DateUtil;
import com.wayming.codeland.util.FileUtil;
import com.wayming.codeland.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @author m969130721@163.com
 * @date 18-6-22 上午12:06
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private JavaMailSender javaMailSender;


    @Value("${file.server.avatar.url}")
    private String fileServerAvatarUrl;

    @Value("${file.location.path}")
    private String fileLocationPath;


    @Override
    public ServerResponseVO rePassword(String username, String newPassword, String oldPassword) {
        SysUser user = sysUserMapper.findByUsername(username);
//        String encodeOldPassword = passwordEncoder.encode(oldPassword);
        if (!oldPassword.equals(user.getPassword())) {
            return ServerResponseVO.sendFail(RestStatusConstant.PASSWORD_ERROR, "旧密码错误");
        }
        user.setPassword(newPassword);
        sysUserMapper.updateByPrimaryKeySelective(user);
        return ServerResponseVO.sendSuccess("更新成功");
    }

    @Override
    public ServerResponseVO saveUser(SysUser user) {
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//        user.setPassword(encoder.encode(user.getPassword()));
        sysUserMapper.insertSelective(user);
        return ServerResponseVO.sendSuccess("添加成功");
    }

    @Override
    public ServerResponseVO updateUser(SysUser user) {
        sysUserMapper.updateByPrimaryKeySelective(user);
        return ServerResponseVO.sendSuccess("更新成功");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void registerUser(SysUser user) {
        user.setActiveCode(UUIDUtil.createByAPI());
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            //send email
            helper = new MimeMessageHelper(message, true);
            helper.setFrom("969130721@qq.com");
            helper.setTo(user.getEmail());
            helper.setSubject("CodeLand博客激活邮件");
            String html = "<h2>亲爱的" + user.getRealname() + "用户你好：</h2><br/>";
            html += "&nbsp&nbsp恭喜你的账号：" + user.getUsername() + " 注册成功！请48小时内，点击此链接激活" +
                    "<a href = 'http://localhost:8080/user/activeAccount/?activeCode=" + user.getActiveCode() + "'>"
                    + user.getActiveCode() + "</a>";
            helper.setText(html, true);
            javaMailSender.send(message);
            //insert data
            sysUserMapper.insertSelective(user);
        } catch (Exception e) {
            throw new ApplicationException(RestStatusConstant.EMAIL_ERROR, e.getMessage());
        }
    }

    @Override
    public PageVO<SysUser> listUser(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<SysUser> sysUserList = sysUserMapper.listUser();
        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUserList);
        PageVO pageVO = new PageVO(pageNo, pageSize, pageInfo.getPages(), pageInfo.getTotal(), sysUserList);
        return pageVO;
    }

    /**
     * 热门用户
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageVO<SysUser> listUserByHot(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize, true);
        List<SysUser> sysUserList = sysUserMapper.listUserByHot();
        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUserList);
        PageVO pageVO = new PageVO(pageNo, pageSize, pageInfo.getPages(), pageInfo.getTotal(), sysUserList);
        return pageVO;
    }

    @Override
    public ServerResponseVO deleteUserById(Integer id) {
        sysUserMapper.deleteByPrimaryKey(id);
        return ServerResponseVO.sendSuccess("删除成功");
    }

    @Override
    public SysUser getUserById(Integer id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ServerResponseVO activeAccount(String activeCode) {
        SysUser user = sysUserMapper.findByActiveCode(activeCode);
        if (null == user) {
            return ServerResponseVO.sendFail(RestStatusConstant.INVALID_ACTIVE_CODE, "无效的激活码");
        }
        Long min = DateUtil.getDifferMin(user.getCreateTime(), new Date());
        double hours = min * 1.0 / 60;
        if (hours > 48) {
            return ServerResponseVO.sendFail(RestStatusConstant.INVALID_ACTIVE_CODE, "无效的激活码,已超过有效期，请重新注册");
        }
        user.setActive(true);
        sysUserMapper.updateByPrimaryKeySelective(user);
        //分配role
        SysRole role = sysRoleMapper.findByName(SysRolesEnum.ROLE_USER.getName());
        SysUserRole userRole = new SysUserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(role.getId());
        sysUserRoleMapper.insertSelective(userRole);

        return ServerResponseVO.sendSuccess("激活成功");
    }

    @Override
    public SysUser getUserByUsername(String username) {
        return sysUserMapper.findByUsername(username);
    }

    @Override
    public ServerResponseVO incrementVisitCount(String username) {
        sysUserMapper.incrementVisitCount(username);
        return ServerResponseVO.sendSuccess("增加成功");
    }

    @Override
    public ServerResponseVO deleteByInvalid() {
        sysUserMapper.deleteByInvalid();
        return ServerResponseVO.sendSuccess("清除成功");
    }


    @Override
    public List<SysUser> listUserByNotActive() {
        //todo
        return null;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public ServerResponseVO uploadAvatar(Integer userId, MultipartFile file) {
        SysUser originUser = sysUserMapper.selectByPrimaryKey(userId);
        if (null != originUser.getAvatar()) {
            String avatar = originUser.getAvatar();
            String avatarName = avatar.substring(avatar.lastIndexOf("/") + 1);
            File avatarFile = new File(fileLocationPath + "/" + avatarName);
            if (null != avatarFile) {
                avatarFile.delete();
            }
        }
        String path = FileUtil.upload(file, fileLocationPath, null, ".png");
        if (null == path) {
            return ServerResponseVO.sendFail(RestStatusConstant.SERVER_EXCEPTION, "头像上传异常");
        }
        originUser.setAvatar(fileServerAvatarUrl + "/" + path);
        sysUserMapper.updateByPrimaryKey(originUser);
        return ServerResponseVO.sendSuccess("更新头像成功");
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        SysUser user = sysUserMapper.findByUsername(username);
        if (null == user || !user.getActive()) {
            throw new UsernameNotFoundException("用户未找到");
        }
        return user;
    }
}
