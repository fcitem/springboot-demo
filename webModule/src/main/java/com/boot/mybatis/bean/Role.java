package com.boot.mybatis.bean;

import java.math.BigDecimal;

public class Role {
    private String roleId;

    private Object roleName;

    private Object status;

    private Object roleDesc;

    private BigDecimal roleSort;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public Object getRoleName() {
        return roleName;
    }

    public void setRoleName(Object roleName) {
        this.roleName = roleName;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Object getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(Object roleDesc) {
        this.roleDesc = roleDesc;
    }

    public BigDecimal getRoleSort() {
        return roleSort;
    }

    public void setRoleSort(BigDecimal roleSort) {
        this.roleSort = roleSort;
    }
}