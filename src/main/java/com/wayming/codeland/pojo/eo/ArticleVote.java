package com.wayming.codeland.pojo.eo;

import java.io.Serializable;
import java.util.Date;

public class ArticleVote implements Serializable {
    private Integer id;

    private Integer articleId;

    private Integer userId;

    private Date createTime;

    private Date updateTime;

    public ArticleVote(Integer id, Integer articleId, Integer userId, Date createTime, Date updateTime) {
        this.id = id;
        this.articleId = articleId;
        this.userId = userId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ArticleVote() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
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
}