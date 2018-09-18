package com.wayming.codeland.pojo.eo;

import java.io.Serializable;
import java.util.Date;

public class SysRole implements Serializable {
    private Integer id;

    private String name;

    private String comment;

    private Date createTime;

    private Date updateTime;

    public SysRole(Integer id, String name, String comment, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public SysRole() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
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