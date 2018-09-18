package com.wayming.codeland.pojo.eo;

import java.io.Serializable;
import java.util.Date;

public class Friend implements Serializable {
    private Integer id;

    private Integer userId;

    private SysUser user;

    private Integer friendId;

    private SysUser friendUser;

    private Boolean active;

    private Date createTime;

    private Date updateTime;

    public Friend(Integer id, Integer userId, Integer friendId, Boolean active, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.friendId = friendId;
        this.active = active;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Friend() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public SysUser getFriendUser() {
        return friendUser;
    }

    public void setFriendUser(SysUser friendUser) {
        this.friendUser = friendUser;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", userId=" + userId +
                ", user=" + user +
                ", friendId=" + friendId +
                ", friendUser=" + friendUser +
                ", active=" + active +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}