package com.unionx.web.proxy.vo;

import java.io.Serializable;
import java.util.Date;

public class RsLinkpeople implements Serializable {
    private Integer id;

    private String peoName;

    private String sex;

    private String duty;

    private String phone;

    private String eamil;

    private String qq;

    private String state;

    private Date createDate;

    private Date updateDate;

    private String createPeo;

    private String associationId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPeoName() {
        return peoName;
    }

    public void setPeoName(String peoName) {
        this.peoName = peoName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreatePeo() {
        return createPeo;
    }

    public void setCreatePeo(String createPeo) {
        this.createPeo = createPeo;
    }

    public String getAssociationId() {
        return associationId;
    }

    public void setAssociationId(String associationId) {
        this.associationId = associationId;
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
        RsLinkpeople other = (RsLinkpeople) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPeoName() == null ? other.getPeoName() == null : this.getPeoName().equals(other.getPeoName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getDuty() == null ? other.getDuty() == null : this.getDuty().equals(other.getDuty()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getEamil() == null ? other.getEamil() == null : this.getEamil().equals(other.getEamil()))
            && (this.getQq() == null ? other.getQq() == null : this.getQq().equals(other.getQq()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getCreatePeo() == null ? other.getCreatePeo() == null : this.getCreatePeo().equals(other.getCreatePeo()))
            && (this.getAssociationId() == null ? other.getAssociationId() == null : this.getAssociationId().equals(other.getAssociationId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPeoName() == null) ? 0 : getPeoName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getDuty() == null) ? 0 : getDuty().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getEamil() == null) ? 0 : getEamil().hashCode());
        result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getCreatePeo() == null) ? 0 : getCreatePeo().hashCode());
        result = prime * result + ((getAssociationId() == null) ? 0 : getAssociationId().hashCode());
        return result;
    }
}