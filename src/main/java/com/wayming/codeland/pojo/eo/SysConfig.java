package com.wayming.codeland.pojo.eo;

import java.util.Date;

public class SysConfig {
    private Integer id;

    private String configKey;

    private String configValue;

    private Integer flag;

    private String memo;

    private Date createTime;

    private Date updateTime;

    public SysConfig(Integer id, String configKey, String configValue, Integer flag, String memo, Date createTime, Date updateTime) {
        this.id = id;
        this.configKey = configKey;
        this.configValue = configValue;
        this.flag = flag;
        this.memo = memo;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public SysConfig() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey == null ? null : configKey.trim();
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue == null ? null : configValue.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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