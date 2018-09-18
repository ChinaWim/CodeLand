package com.wayming.codeland.pojo.eo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class SysUser implements UserDetails,Serializable {
    private Integer id;

    private String username;

    private String password;

    private String realname;

    private String nickname;

    private String bio;

    private String avatar;

    private String email;

    private String phone;

    private Boolean active;

    private String activeCode;

    private Integer visitedCount;

    private Date lastloginTime;

    private Date createTime;

    private Date updateTime;

    private List<SysRole> roleList;

    public SysUser(Integer id, String username, String password, String realname, String nickname, String bio, String avatar, String email, String phone, Boolean active, String activeCode, Integer visitedCount, Date lastloginTime, Date createTime, Date updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.nickname = nickname;
        this.bio = bio;
        this.avatar = avatar;
        this.email = email;
        this.phone = phone;
        this.active = active;
        this.activeCode = activeCode;
        this.visitedCount = visitedCount;
        this.lastloginTime = lastloginTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public SysUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        List<SysRole> roleList = this.getRoleList();
        for (SysRole sysRole : roleList) {
            auths.add(new SimpleGrantedAuthority(sysRole.getName()));
        }
        return auths;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio == null ? null : bio.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode == null ? null : activeCode.trim();
    }

    public Integer getVisitedCount() {
        return visitedCount;
    }

    public void setVisitedCount(Integer visitedCount) {
        this.visitedCount = visitedCount;
    }

    public Date getLastloginTime() {
        return lastloginTime;
    }

    public void setLastloginTime(Date lastloginTime) {
        this.lastloginTime = lastloginTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", bio='" + bio + '\'' +
                ", avatar='" + avatar + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", active=" + active +
                ", activeCode='" + activeCode + '\'' +
                ", visitedCount=" + visitedCount +
                ", lastloginTime=" + lastloginTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", roleList=" + roleList +
                '}';
    }
}