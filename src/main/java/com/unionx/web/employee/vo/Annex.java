package com.unionx.web.employee.vo;

import java.io.Serializable;
import java.util.Date;

public class Annex implements Serializable {
    private String id;

    private String idFront;

    private String idBack;

    private String accountHome;

    private String accountBack;

    private String employeeId;

    private String isdel;

    private String createName;

    private Date createDate;

    private String updateName;

    private Date updateDate;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdFront() {
        return idFront;
    }

    public void setIdFront(String idFront) {
        this.idFront = idFront;
    }

    public String getIdBack() {
        return idBack;
    }

    public void setIdBack(String idBack) {
        this.idBack = idBack;
    }

    public String getAccountHome() {
        return accountHome;
    }

    public void setAccountHome(String accountHome) {
        this.accountHome = accountHome;
    }

    public String getAccountBack() {
        return accountBack;
    }

    public void setAccountBack(String accountBack) {
        this.accountBack = accountBack;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Annex other = (Annex) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIdFront() == null ? other.getIdFront() == null : this.getIdFront().equals(other.getIdFront()))
            && (this.getIdBack() == null ? other.getIdBack() == null : this.getIdBack().equals(other.getIdBack()))
            && (this.getAccountHome() == null ? other.getAccountHome() == null : this.getAccountHome().equals(other.getAccountHome()))
            && (this.getAccountBack() == null ? other.getAccountBack() == null : this.getAccountBack().equals(other.getAccountBack()))
            && (this.getEmployeeId() == null ? other.getEmployeeId() == null : this.getEmployeeId().equals(other.getEmployeeId()))
            && (this.getIsdel() == null ? other.getIsdel() == null : this.getIsdel().equals(other.getIsdel()))
            && (this.getCreateName() == null ? other.getCreateName() == null : this.getCreateName().equals(other.getCreateName()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateName() == null ? other.getUpdateName() == null : this.getUpdateName().equals(other.getUpdateName()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIdFront() == null) ? 0 : getIdFront().hashCode());
        result = prime * result + ((getIdBack() == null) ? 0 : getIdBack().hashCode());
        result = prime * result + ((getAccountHome() == null) ? 0 : getAccountHome().hashCode());
        result = prime * result + ((getAccountBack() == null) ? 0 : getAccountBack().hashCode());
        result = prime * result + ((getEmployeeId() == null) ? 0 : getEmployeeId().hashCode());
        result = prime * result + ((getIsdel() == null) ? 0 : getIsdel().hashCode());
        result = prime * result + ((getCreateName() == null) ? 0 : getCreateName().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateName() == null) ? 0 : getUpdateName().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        return result;
    }
}