package com.wayming.codeland.pojo.eo;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {

    private Integer id;

    private Integer userId;

    private SysUser user;

    private String title;

    private String summary;

    private String content;

    private String htmlContent;

    private String images;

    private Integer readCount;

    private Integer commentCount;

    private Integer voteCount;

    private Integer type;

    private Integer status;

    private String tags;

    private Integer categoryId;

    private Date createTime;

    private Date updateTime;

    public Article(Integer id, Integer userId, String title, String summary, String content, String htmlContent, String images, Integer readCount, Integer commentCount, Integer voteCount, Integer type, Integer status, String tags, Integer categoryId, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.htmlContent = htmlContent;
        this.images = images;
        this.readCount = readCount;
        this.commentCount = commentCount;
        this.voteCount = voteCount;
        this.type = type;
        this.status = status;
        this.tags = tags;
        this.categoryId = categoryId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Article() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent == null ? null : htmlContent.trim();
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", userId=" + userId +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", htmlContent='" + htmlContent + '\'' +
                ", images='" + images + '\'' +
                ", readCount=" + readCount +
                ", commentCount=" + commentCount +
                ", voteCount=" + voteCount +
                ", type=" + type +
                ", status=" + status +
                ", tags='" + tags + '\'' +
                ", categoryId=" + categoryId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}