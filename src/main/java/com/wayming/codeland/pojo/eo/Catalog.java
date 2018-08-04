package com.wayming.codeland.pojo.eo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Catalog implements Serializable {

    private Integer id;

    private Integer userId;

    private SysUser user;

    private String name;

    private Date createTime;

    private Date updateTime;

    private List<Article> articleList;

    public Catalog(Integer id, Integer userId, String name, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Catalog() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                ", userId=" + userId +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", articleList=" + articleList +
                '}';
    }
}