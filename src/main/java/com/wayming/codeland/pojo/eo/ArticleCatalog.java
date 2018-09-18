package com.wayming.codeland.pojo.eo;

import java.io.Serializable;
import java.util.Date;

public class ArticleCatalog implements Serializable {
    private Integer id;

    private Integer articleId;

    private Integer catalogId;

    private Date createTime;

    private Date updateTime;

    public ArticleCatalog(Integer id, Integer articleId, Integer catalogId, Date createTime, Date updateTime) {
        this.id = id;
        this.articleId = articleId;
        this.catalogId = catalogId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ArticleCatalog() {
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

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
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