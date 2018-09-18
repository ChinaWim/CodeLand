package com.wayming.codeland.pojo.eo;

import java.io.Serializable;
import java.util.Date;

public class CommentVote implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer commentId;

    private Date createTime;

    private Date updateTime;

    public CommentVote(Integer id, Integer userId, Integer commentId, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.commentId = commentId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public CommentVote() {
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