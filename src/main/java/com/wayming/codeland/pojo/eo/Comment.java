package com.wayming.codeland.pojo.eo;

import java.util.Date;
import java.util.List;

public class Comment {
    private Integer id;

    private Integer userId;

    private SysUser user;

    private Integer articleId;

    private String content;

    private Integer voteCount;

    private List<SubComment> subCommentList;

    private Date createTime;

    private Date updateTime;

    public Comment(Integer id, Integer userId, Integer articleId, String content, Integer voteCount, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.articleId = articleId;
        this.content = content;
        this.voteCount = voteCount;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Comment() {
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

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
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

    public List<SubComment> getSubCommentList() {
        return subCommentList;
    }

    public void setSubCommentList(List<SubComment> subCommentList) {
        this.subCommentList = subCommentList;
    }


    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", userId=" + userId +
                ", user=" + user +
                ", articleId=" + articleId +
                ", content='" + content + '\'' +
                ", voteCount=" + voteCount +
                ", subCommentList=" + subCommentList +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}