package com.unionx.web.employee.vo;

import java.io.Serializable;
import java.util.Date;

public class FiveRisks implements Serializable {
    private String id;

    private String pension;

    private String unemployment;

    private String fertility;

    private String workInjury;

    private String medicalTreatment;

    private String providentFund;

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

    public String getPension() {
        return pension;
    }

    public void setPension(String pension) {
        this.pension = pension;
    }

    public String getUnemployment() {
        return unemployment;
    }

    public void setUnemployment(String unemployment) {
        this.unemployment = unemployment;
    }

    public String getFertility() {
        return fertility;
    }

    public void setFertility(String fertility) {
        this.fertility = fertility;
    }

    public String getWorkInjury() {
        return workInjury;
    }

    public void setWorkInjury(String workInjury) {
        this.workInjury = workInjury;
    }

    public String getMedicalTreatment() {
        return medicalTreatment;
    }

    public void setMedicalTreatment(String medicalTreatment) {
        this.medicalTreatment = medicalTreatment;
    }

    public String getProvidentFund() {
        return providentFund;
    }

    public void setProvidentFund(String providentFund) {
        this.providentFund = providentFund;
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
        FiveRisks other = (FiveRisks) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPension() == null ? other.getPension() == null : this.getPension().equals(other.getPension()))
            && (this.getUnemployment() == null ? other.getUnemployment() == null : this.getUnemployment().equals(other.getUnemployment()))
            && (this.getFertility() == null ? other.getFertility() == null : this.getFertility().equals(other.getFertility()))
            && (this.getWorkInjury() == null ? other.getWorkInjury() == null : this.getWorkInjury().equals(other.getWorkInjury()))
            && (this.getMedicalTreatment() == null ? other.getMedicalTreatment() == null : this.getMedicalTreatment().equals(other.getMedicalTreatment()))
            && (this.getProvidentFund() == null ? other.getProvidentFund() == null : this.getProvidentFund().equals(other.getProvidentFund()))
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
        result = prime * result + ((getPension() == null) ? 0 : getPension().hashCode());
        result = prime * result + ((getUnemployment() == null) ? 0 : getUnemployment().hashCode());
        result = prime * result + ((getFertility() == null) ? 0 : getFertility().hashCode());
        result = prime * result + ((getWorkInjury() == null) ? 0 : getWorkInjury().hashCode());
        result = prime * result + ((getMedicalTreatment() == null) ? 0 : getMedicalTreatment().hashCode());
        result = prime * result + ((getProvidentFund() == null) ? 0 : getProvidentFund().hashCode());
        result = prime * result + ((getEmployeeId() == null) ? 0 : getEmployeeId().hashCode());
        result = prime * result + ((getIsdel() == null) ? 0 : getIsdel().hashCode());
        result = prime * result + ((getCreateName() == null) ? 0 : getCreateName().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateName() == null) ? 0 : getUpdateName().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        return result;
    }
}