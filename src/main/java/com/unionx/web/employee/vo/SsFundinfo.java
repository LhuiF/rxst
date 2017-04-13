package com.unionx.web.employee.vo;

import java.io.Serializable;
import java.util.Date;

public class SsFundinfo implements Serializable {
    private String id;

    private String employeeId;

    private String ssPeopleType;

    private String citizenIdCode;

    private String mtPeopleType;

    private String obtainSsWay;

    private String insuredTele;

    private Date issuanceSscardDate;

    private Date issuanceMtcardDate;

    private String bankName;

    private String bankCode;

    private String isSick;

    private Double averageWage;

    private Double ssWage;

    private Double pfWage;

    private Date ssDeclareDate;

    private Date pfDeclareDate;

    private Date ssStartDate;

    private Date pfStartDate;

    private String addReason;

    private String designated1;

    private String designated2;

    private String designated3;

    private String designated4;

    private String designated5;

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

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getSsPeopleType() {
        return ssPeopleType;
    }

    public void setSsPeopleType(String ssPeopleType) {
        this.ssPeopleType = ssPeopleType;
    }

    public String getCitizenIdCode() {
        return citizenIdCode;
    }

    public void setCitizenIdCode(String citizenIdCode) {
        this.citizenIdCode = citizenIdCode;
    }

    public String getMtPeopleType() {
        return mtPeopleType;
    }

    public void setMtPeopleType(String mtPeopleType) {
        this.mtPeopleType = mtPeopleType;
    }

    public String getObtainSsWay() {
        return obtainSsWay;
    }

    public void setObtainSsWay(String obtainSsWay) {
        this.obtainSsWay = obtainSsWay;
    }

    public String getInsuredTele() {
        return insuredTele;
    }

    public void setInsuredTele(String insuredTele) {
        this.insuredTele = insuredTele;
    }

    public Date getIssuanceSscardDate() {
        return issuanceSscardDate;
    }

    public void setIssuanceSscardDate(Date issuanceSscardDate) {
        this.issuanceSscardDate = issuanceSscardDate;
    }

    public Date getIssuanceMtcardDate() {
        return issuanceMtcardDate;
    }

    public void setIssuanceMtcardDate(Date issuanceMtcardDate) {
        this.issuanceMtcardDate = issuanceMtcardDate;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getIsSick() {
        return isSick;
    }

    public void setIsSick(String isSick) {
        this.isSick = isSick;
    }

    public Double getAverageWage() {
        return averageWage;
    }

    public void setAverageWage(Double averageWage) {
        this.averageWage = averageWage;
    }

    public Double getSsWage() {
        return ssWage;
    }

    public void setSsWage(Double ssWage) {
        this.ssWage = ssWage;
    }

    public Double getPfWage() {
        return pfWage;
    }

    public void setPfWage(Double pfWage) {
        this.pfWage = pfWage;
    }

    public Date getSsDeclareDate() {
        return ssDeclareDate;
    }

    public void setSsDeclareDate(Date ssDeclareDate) {
        this.ssDeclareDate = ssDeclareDate;
    }

    public Date getPfDeclareDate() {
        return pfDeclareDate;
    }

    public void setPfDeclareDate(Date pfDeclareDate) {
        this.pfDeclareDate = pfDeclareDate;
    }

    public Date getSsStartDate() {
        return ssStartDate;
    }

    public void setSsStartDate(Date ssStartDate) {
        this.ssStartDate = ssStartDate;
    }

    public Date getPfStartDate() {
        return pfStartDate;
    }

    public void setPfStartDate(Date pfStartDate) {
        this.pfStartDate = pfStartDate;
    }

    public String getAddReason() {
        return addReason;
    }

    public void setAddReason(String addReason) {
        this.addReason = addReason;
    }

    public String getDesignated1() {
        return designated1;
    }

    public void setDesignated1(String designated1) {
        this.designated1 = designated1;
    }

    public String getDesignated2() {
        return designated2;
    }

    public void setDesignated2(String designated2) {
        this.designated2 = designated2;
    }

    public String getDesignated3() {
        return designated3;
    }

    public void setDesignated3(String designated3) {
        this.designated3 = designated3;
    }

    public String getDesignated4() {
        return designated4;
    }

    public void setDesignated4(String designated4) {
        this.designated4 = designated4;
    }

    public String getDesignated5() {
        return designated5;
    }

    public void setDesignated5(String designated5) {
        this.designated5 = designated5;
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
        SsFundinfo other = (SsFundinfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEmployeeId() == null ? other.getEmployeeId() == null : this.getEmployeeId().equals(other.getEmployeeId()))
            && (this.getSsPeopleType() == null ? other.getSsPeopleType() == null : this.getSsPeopleType().equals(other.getSsPeopleType()))
            && (this.getCitizenIdCode() == null ? other.getCitizenIdCode() == null : this.getCitizenIdCode().equals(other.getCitizenIdCode()))
            && (this.getMtPeopleType() == null ? other.getMtPeopleType() == null : this.getMtPeopleType().equals(other.getMtPeopleType()))
            && (this.getObtainSsWay() == null ? other.getObtainSsWay() == null : this.getObtainSsWay().equals(other.getObtainSsWay()))
            && (this.getInsuredTele() == null ? other.getInsuredTele() == null : this.getInsuredTele().equals(other.getInsuredTele()))
            && (this.getIssuanceSscardDate() == null ? other.getIssuanceSscardDate() == null : this.getIssuanceSscardDate().equals(other.getIssuanceSscardDate()))
            && (this.getIssuanceMtcardDate() == null ? other.getIssuanceMtcardDate() == null : this.getIssuanceMtcardDate().equals(other.getIssuanceMtcardDate()))
            && (this.getBankName() == null ? other.getBankName() == null : this.getBankName().equals(other.getBankName()))
            && (this.getBankCode() == null ? other.getBankCode() == null : this.getBankCode().equals(other.getBankCode()))
            && (this.getIsSick() == null ? other.getIsSick() == null : this.getIsSick().equals(other.getIsSick()))
            && (this.getAverageWage() == null ? other.getAverageWage() == null : this.getAverageWage().equals(other.getAverageWage()))
            && (this.getSsWage() == null ? other.getSsWage() == null : this.getSsWage().equals(other.getSsWage()))
            && (this.getPfWage() == null ? other.getPfWage() == null : this.getPfWage().equals(other.getPfWage()))
            && (this.getSsDeclareDate() == null ? other.getSsDeclareDate() == null : this.getSsDeclareDate().equals(other.getSsDeclareDate()))
            && (this.getPfDeclareDate() == null ? other.getPfDeclareDate() == null : this.getPfDeclareDate().equals(other.getPfDeclareDate()))
            && (this.getSsStartDate() == null ? other.getSsStartDate() == null : this.getSsStartDate().equals(other.getSsStartDate()))
            && (this.getPfStartDate() == null ? other.getPfStartDate() == null : this.getPfStartDate().equals(other.getPfStartDate()))
            && (this.getAddReason() == null ? other.getAddReason() == null : this.getAddReason().equals(other.getAddReason()))
            && (this.getDesignated1() == null ? other.getDesignated1() == null : this.getDesignated1().equals(other.getDesignated1()))
            && (this.getDesignated2() == null ? other.getDesignated2() == null : this.getDesignated2().equals(other.getDesignated2()))
            && (this.getDesignated3() == null ? other.getDesignated3() == null : this.getDesignated3().equals(other.getDesignated3()))
            && (this.getDesignated4() == null ? other.getDesignated4() == null : this.getDesignated4().equals(other.getDesignated4()))
            && (this.getDesignated5() == null ? other.getDesignated5() == null : this.getDesignated5().equals(other.getDesignated5()))
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
        result = prime * result + ((getEmployeeId() == null) ? 0 : getEmployeeId().hashCode());
        result = prime * result + ((getSsPeopleType() == null) ? 0 : getSsPeopleType().hashCode());
        result = prime * result + ((getCitizenIdCode() == null) ? 0 : getCitizenIdCode().hashCode());
        result = prime * result + ((getMtPeopleType() == null) ? 0 : getMtPeopleType().hashCode());
        result = prime * result + ((getObtainSsWay() == null) ? 0 : getObtainSsWay().hashCode());
        result = prime * result + ((getInsuredTele() == null) ? 0 : getInsuredTele().hashCode());
        result = prime * result + ((getIssuanceSscardDate() == null) ? 0 : getIssuanceSscardDate().hashCode());
        result = prime * result + ((getIssuanceMtcardDate() == null) ? 0 : getIssuanceMtcardDate().hashCode());
        result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
        result = prime * result + ((getBankCode() == null) ? 0 : getBankCode().hashCode());
        result = prime * result + ((getIsSick() == null) ? 0 : getIsSick().hashCode());
        result = prime * result + ((getAverageWage() == null) ? 0 : getAverageWage().hashCode());
        result = prime * result + ((getSsWage() == null) ? 0 : getSsWage().hashCode());
        result = prime * result + ((getPfWage() == null) ? 0 : getPfWage().hashCode());
        result = prime * result + ((getSsDeclareDate() == null) ? 0 : getSsDeclareDate().hashCode());
        result = prime * result + ((getPfDeclareDate() == null) ? 0 : getPfDeclareDate().hashCode());
        result = prime * result + ((getSsStartDate() == null) ? 0 : getSsStartDate().hashCode());
        result = prime * result + ((getPfStartDate() == null) ? 0 : getPfStartDate().hashCode());
        result = prime * result + ((getAddReason() == null) ? 0 : getAddReason().hashCode());
        result = prime * result + ((getDesignated1() == null) ? 0 : getDesignated1().hashCode());
        result = prime * result + ((getDesignated2() == null) ? 0 : getDesignated2().hashCode());
        result = prime * result + ((getDesignated3() == null) ? 0 : getDesignated3().hashCode());
        result = prime * result + ((getDesignated4() == null) ? 0 : getDesignated4().hashCode());
        result = prime * result + ((getDesignated5() == null) ? 0 : getDesignated5().hashCode());
        result = prime * result + ((getIsdel() == null) ? 0 : getIsdel().hashCode());
        result = prime * result + ((getCreateName() == null) ? 0 : getCreateName().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateName() == null) ? 0 : getUpdateName().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        return result;
    }
}