package com.boot.mybatis.bean;

import java.math.BigDecimal;
import java.util.Date;

public class User {
    private String userId;

    private Object userName;

    private String loginId;

    private Object userPwd;

    private Date createTime;

    private BigDecimal status;

    private Object email;

    private Object telephone;

    private Object userDesc;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Object getUserName() {
        return userName;
    }

    public void setUserName(Object userName) {
        this.userName = userName;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId == null ? null : loginId.trim();
    }

    public Object getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(Object userPwd) {
        this.userPwd = userPwd;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getStatus() {
        return status;
    }

    public void setStatus(BigDecimal status) {
        this.status = status;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public Object getTelephone() {
        return telephone;
    }

    public void setTelephone(Object telephone) {
        this.telephone = telephone;
    }

    public Object getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(Object userDesc) {
        this.userDesc = userDesc;
    }
}