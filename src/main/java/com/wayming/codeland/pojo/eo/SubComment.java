package com.wayming.codeland.pojo.eo;

import java.util.Date;

public class SubComment {
    private Integer id;

    private Integer userId;

    private Integer commentId;

    private String content;

    private Date createTime;

    private Date updateTime;

    public SubComment(Integer id, Integer userId, Integer commentId, String content, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.commentId = commentId;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public SubComment() {
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

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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
}