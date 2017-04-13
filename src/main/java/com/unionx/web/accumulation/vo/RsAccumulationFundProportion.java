package com.unionx.web.accumulation.vo;

import java.io.Serializable;
import java.util.Date;

public class RsAccumulationFundProportion implements Serializable {
    private Integer id;

    private String accumulationFundUuid;

    private String code;

    private String name;

    private String enterprise;

    private String personalNotFloor;

    private String personalFloor;

    private Boolean isdel;

    private String createName;

    private Date createDate;

    private String updateName;

    private Date updateDate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccumulationFundUuid() {
        return accumulationFundUuid;
    }

    public void setAccumulationFundUuid(String accumulationFundUuid) {
        this.accumulationFundUuid = accumulationFundUuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getPersonalNotFloor() {
        return personalNotFloor;
    }

    public void setPersonalNotFloor(String personalNotFloor) {
        this.personalNotFloor = personalNotFloor;
    }

    public String getPersonalFloor() {
        return personalFloor;
    }

    public void setPersonalFloor(String personalFloor) {
        this.personalFloor = personalFloor;
    }

    public Boolean getIsdel() {
        return isdel;
    }

    public void setIsdel(Boolean isdel) {
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
        RsAccumulationFundProportion other = (RsAccumulationFundProportion) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAccumulationFundUuid() == null ? other.getAccumulationFundUuid() == null : this.getAccumulationFundUuid().equals(other.getAccumulationFundUuid()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getEnterprise() == null ? other.getEnterprise() == null : this.getEnterprise().equals(other.getEnterprise()))
            && (this.getPersonalNotFloor() == null ? other.getPersonalNotFloor() == null : this.getPersonalNotFloor().equals(other.getPersonalNotFloor()))
            && (this.getPersonalFloor() == null ? other.getPersonalFloor() == null : this.getPersonalFloor().equals(other.getPersonalFloor()))
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
        result = prime * result + ((getAccumulationFundUuid() == null) ? 0 : getAccumulationFundUuid().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getEnterprise() == null) ? 0 : getEnterprise().hashCode());
        result = prime * result + ((getPersonalNotFloor() == null) ? 0 : getPersonalNotFloor().hashCode());
        result = prime * result + ((getPersonalFloor() == null) ? 0 : getPersonalFloor().hashCode());
        result = prime * result + ((getIsdel() == null) ? 0 : getIsdel().hashCode());
        result = prime * result + ((getCreateName() == null) ? 0 : getCreateName().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateName() == null) ? 0 : getUpdateName().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        return result;
    }
}