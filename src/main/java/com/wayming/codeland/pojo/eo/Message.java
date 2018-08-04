package com.wayming.codeland.pojo.eo;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    private Integer id;

    private Integer friendId;

    private SysUser friendUser;

    private String content;

    private Integer userId;

    private SysUser user;

    private Date createTime;

    private Date updateTime;

    public Message(Integer id, Integer friendId, String content, Integer userId, Date createTime, Date updateTime) {
        this.id = id;
        this.friendId = friendId;
        this.content = content;
        this.userId = userId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Message() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public SysUser getFriendUser() {
        return friendUser;
    }

    public void setFriendUser(SysUser friendUser) {
        this.friendUser = friendUser;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", friendId=" + friendId +
                ", friendUser=" + friendUser +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", user=" + user +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}