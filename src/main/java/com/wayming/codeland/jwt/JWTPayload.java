package com.wayming.codeland.jwt;

import java.util.Arrays;
import java.util.Date;

/**
 * JWT Payload
 * @author m969130721@163.com
 * @date 18-6-20 下午7:15
 */
public class JWTPayload {

    //*************************JWT标准字段*********************

    /**
     * 签发者 issuer
     */
    private String iss;
    /**
     * 签发时间(时间戳) issued at
     */
    private Date iat;
    /**
     * 过期时间(时间戳) expire
     *  为防止Replay Attacks, 过期时间应该设置的比较短，比如exp = iat + 2(s)
     */
    private Date exp;
    /**
     *  not before(时间戳)
     *  如果当前时间在nbf里的时间之前，则Token不被接受
     */
    private Date nbf;
    /**
     * JWT ID
     *　当前token的唯一标识，使用UUID
     */
    private String jti;
    /**
     * 接收方 Audience
     */
    private String [] aud;
    /**
     * 面向的用户 Subject
     */
    private String sub;

    //*************************自定义字段*********************

    /**
     * 用户ID
     */
    private String userId;
    /**
     *　登录名
     */
    private String loginName;
    /**
     * 登录头像
     */
    private String icon;
    /**
     * 角色ID列表
     */
    private String[] roleIdList;

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public Date getIat() {
        return iat;
    }

    public void setIat(Date iat) {
        this.iat = iat;
    }

    public Date getExp() {
        return exp;
    }

    public void setExp(Date exp) {
        this.exp = exp;
    }

    public Date getNbf() {
        return nbf;
    }

    public void setNbf(Date nbf) {
        this.nbf = nbf;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }

    public String[] getAud() {
        return aud;
    }

    public void setAud(String[] aud) {
        this.aud = aud;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String[] getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(String[] roleIdList) {
        this.roleIdList = roleIdList;
    }

    @Override
    public String toString() {
        return "JWTPayload{" +
                "iss='" + iss + '\'' +
                ", iat=" + iat +
                ", exp=" + exp +
                ", nbf=" + nbf +
                ", jti='" + jti + '\'' +
                ", aud=" + Arrays.toString(aud) +
                ", sub='" + sub + '\'' +
                ", userId='" + userId + '\'' +
                ", loginName='" + loginName + '\'' +
                ", icon='" + icon + '\'' +
                ", roleIdList=" + Arrays.toString(roleIdList) +
                '}';
    }
}
