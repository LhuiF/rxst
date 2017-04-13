package com.unionx.web.company.vo;

import java.io.Serializable;
import java.util.Date;

public class CompanyShebaoBili implements Serializable {
    private Integer id;

    private String uuid;

    private Double companyEndowment;//公司养老

    private Double personEndowment;//个人养老

    private Double companyUnemployment;//公司失业

    private Double personUnemployment;//个人失业

    private Double companyInjury;//企业工伤

    private Double personInjury;//个人工伤

    private Double companyMedical;//企业医疗

    private Double personMedical;//个人医疗

    private Double personMedicalDb;//个人大病

    private Double companyMaternity;//企业生育

    private Double personMaternity;//个人生育

    private String payPersonType;//缴费人员类别

    private String payPersonName;//缴费人员类别name

    private String companyUuid;//企业的uuid

    private String companyName;//企业的name

    private String shebaoCanshuUuid;//社保参数uuid

    private String shebaoCanshuYearcity;//社保年度城市

    private Date shebaoCanshuStarttime;//社保政策开始时间

    private Date shebaoCanshuEndtime;//社保政策结束时间

    private Double shebaoCanshuCelling;//上限值

    private Double shebaoCanshuFloor;//下限值

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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Double getCompanyEndowment() {
        return companyEndowment;
    }

    public void setCompanyEndowment(Double companyEndowment) {
        this.companyEndowment = companyEndowment;
    }

    public Double getPersonEndowment() {
        return personEndowment;
    }

    public void setPersonEndowment(Double personEndowment) {
        this.personEndowment = personEndowment;
    }

    public Double getCompanyUnemployment() {
        return companyUnemployment;
    }

    public void setCompanyUnemployment(Double companyUnemployment) {
        this.companyUnemployment = companyUnemployment;
    }

    public Double getPersonUnemployment() {
        return personUnemployment;
    }

    public void setPersonUnemployment(Double personUnemployment) {
        this.personUnemployment = personUnemployment;
    }

    public Double getCompanyInjury() {
        return companyInjury;
    }

    public void setCompanyInjury(Double companyInjury) {
        this.companyInjury = companyInjury;
    }

    public Double getPersonInjury() {
        return personInjury;
    }

    public void setPersonInjury(Double personInjury) {
        this.personInjury = personInjury;
    }

    public Double getCompanyMedical() {
        return companyMedical;
    }

    public void setCompanyMedical(Double companyMedical) {
        this.companyMedical = companyMedical;
    }

    public Double getPersonMedical() {
        return personMedical;
    }

    public void setPersonMedical(Double personMedical) {
        this.personMedical = personMedical;
    }

    public Double getPersonMedicalDb() {
        return personMedicalDb;
    }

    public void setPersonMedicalDb(Double personMedicalDb) {
        this.personMedicalDb = personMedicalDb;
    }

    public Double getCompanyMaternity() {
        return companyMaternity;
    }

    public void setCompanyMaternity(Double companyMaternity) {
        this.companyMaternity = companyMaternity;
    }

    public Double getPersonMaternity() {
        return personMaternity;
    }

    public void setPersonMaternity(Double personMaternity) {
        this.personMaternity = personMaternity;
    }

    public String getPayPersonType() {
        return payPersonType;
    }

    public void setPayPersonType(String payPersonType) {
        this.payPersonType = payPersonType;
    }

    public String getPayPersonName() {
        return payPersonName;
    }

    public void setPayPersonName(String payPersonName) {
        this.payPersonName = payPersonName;
    }

    public String getCompanyUuid() {
        return companyUuid;
    }

    public void setCompanyUuid(String companyUuid) {
        this.companyUuid = companyUuid;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getShebaoCanshuUuid() {
        return shebaoCanshuUuid;
    }

    public void setShebaoCanshuUuid(String shebaoCanshuUuid) {
        this.shebaoCanshuUuid = shebaoCanshuUuid;
    }

    public String getShebaoCanshuYearcity() {
        return shebaoCanshuYearcity;
    }

    public void setShebaoCanshuYearcity(String shebaoCanshuYearcity) {
        this.shebaoCanshuYearcity = shebaoCanshuYearcity;
    }

    public Date getShebaoCanshuStarttime() {
        return shebaoCanshuStarttime;
    }

    public void setShebaoCanshuStarttime(Date shebaoCanshuStarttime) {
        this.shebaoCanshuStarttime = shebaoCanshuStarttime;
    }

    public Date getShebaoCanshuEndtime() {
        return shebaoCanshuEndtime;
    }

    public void setShebaoCanshuEndtime(Date shebaoCanshuEndtime) {
        this.shebaoCanshuEndtime = shebaoCanshuEndtime;
    }

    public Double getShebaoCanshuCelling() {
        return shebaoCanshuCelling;
    }

    public void setShebaoCanshuCelling(Double shebaoCanshuCelling) {
        this.shebaoCanshuCelling = shebaoCanshuCelling;
    }

    public Double getShebaoCanshuFloor() {
        return shebaoCanshuFloor;
    }

    public void setShebaoCanshuFloor(Double shebaoCanshuFloor) {
        this.shebaoCanshuFloor = shebaoCanshuFloor;
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
        CompanyShebaoBili other = (CompanyShebaoBili) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getCompanyEndowment() == null ? other.getCompanyEndowment() == null : this.getCompanyEndowment().equals(other.getCompanyEndowment()))
            && (this.getPersonEndowment() == null ? other.getPersonEndowment() == null : this.getPersonEndowment().equals(other.getPersonEndowment()))
            && (this.getCompanyUnemployment() == null ? other.getCompanyUnemployment() == null : this.getCompanyUnemployment().equals(other.getCompanyUnemployment()))
            && (this.getPersonUnemployment() == null ? other.getPersonUnemployment() == null : this.getPersonUnemployment().equals(other.getPersonUnemployment()))
            && (this.getCompanyInjury() == null ? other.getCompanyInjury() == null : this.getCompanyInjury().equals(other.getCompanyInjury()))
            && (this.getPersonInjury() == null ? other.getPersonInjury() == null : this.getPersonInjury().equals(other.getPersonInjury()))
            && (this.getCompanyMedical() == null ? other.getCompanyMedical() == null : this.getCompanyMedical().equals(other.getCompanyMedical()))
            && (this.getPersonMedical() == null ? other.getPersonMedical() == null : this.getPersonMedical().equals(other.getPersonMedical()))
            && (this.getPersonMedicalDb() == null ? other.getPersonMedicalDb() == null : this.getPersonMedicalDb().equals(other.getPersonMedicalDb()))
            && (this.getCompanyMaternity() == null ? other.getCompanyMaternity() == null : this.getCompanyMaternity().equals(other.getCompanyMaternity()))
            && (this.getPersonMaternity() == null ? other.getPersonMaternity() == null : this.getPersonMaternity().equals(other.getPersonMaternity()))
            && (this.getPayPersonType() == null ? other.getPayPersonType() == null : this.getPayPersonType().equals(other.getPayPersonType()))
            && (this.getPayPersonName() == null ? other.getPayPersonName() == null : this.getPayPersonName().equals(other.getPayPersonName()))
            && (this.getCompanyUuid() == null ? other.getCompanyUuid() == null : this.getCompanyUuid().equals(other.getCompanyUuid()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getShebaoCanshuUuid() == null ? other.getShebaoCanshuUuid() == null : this.getShebaoCanshuUuid().equals(other.getShebaoCanshuUuid()))
            && (this.getShebaoCanshuYearcity() == null ? other.getShebaoCanshuYearcity() == null : this.getShebaoCanshuYearcity().equals(other.getShebaoCanshuYearcity()))
            && (this.getShebaoCanshuStarttime() == null ? other.getShebaoCanshuStarttime() == null : this.getShebaoCanshuStarttime().equals(other.getShebaoCanshuStarttime()))
            && (this.getShebaoCanshuEndtime() == null ? other.getShebaoCanshuEndtime() == null : this.getShebaoCanshuEndtime().equals(other.getShebaoCanshuEndtime()))
            && (this.getShebaoCanshuCelling() == null ? other.getShebaoCanshuCelling() == null : this.getShebaoCanshuCelling().equals(other.getShebaoCanshuCelling()))
            && (this.getShebaoCanshuFloor() == null ? other.getShebaoCanshuFloor() == null : this.getShebaoCanshuFloor().equals(other.getShebaoCanshuFloor()))
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
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getCompanyEndowment() == null) ? 0 : getCompanyEndowment().hashCode());
        result = prime * result + ((getPersonEndowment() == null) ? 0 : getPersonEndowment().hashCode());
        result = prime * result + ((getCompanyUnemployment() == null) ? 0 : getCompanyUnemployment().hashCode());
        result = prime * result + ((getPersonUnemployment() == null) ? 0 : getPersonUnemployment().hashCode());
        result = prime * result + ((getCompanyInjury() == null) ? 0 : getCompanyInjury().hashCode());
        result = prime * result + ((getPersonInjury() == null) ? 0 : getPersonInjury().hashCode());
        result = prime * result + ((getCompanyMedical() == null) ? 0 : getCompanyMedical().hashCode());
        result = prime * result + ((getPersonMedical() == null) ? 0 : getPersonMedical().hashCode());
        result = prime * result + ((getPersonMedicalDb() == null) ? 0 : getPersonMedicalDb().hashCode());
        result = prime * result + ((getCompanyMaternity() == null) ? 0 : getCompanyMaternity().hashCode());
        result = prime * result + ((getPersonMaternity() == null) ? 0 : getPersonMaternity().hashCode());
        result = prime * result + ((getPayPersonType() == null) ? 0 : getPayPersonType().hashCode());
        result = prime * result + ((getPayPersonName() == null) ? 0 : getPayPersonName().hashCode());
        result = prime * result + ((getCompanyUuid() == null) ? 0 : getCompanyUuid().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getShebaoCanshuUuid() == null) ? 0 : getShebaoCanshuUuid().hashCode());
        result = prime * result + ((getShebaoCanshuYearcity() == null) ? 0 : getShebaoCanshuYearcity().hashCode());
        result = prime * result + ((getShebaoCanshuStarttime() == null) ? 0 : getShebaoCanshuStarttime().hashCode());
        result = prime * result + ((getShebaoCanshuEndtime() == null) ? 0 : getShebaoCanshuEndtime().hashCode());
        result = prime * result + ((getShebaoCanshuCelling() == null) ? 0 : getShebaoCanshuCelling().hashCode());
        result = prime * result + ((getShebaoCanshuFloor() == null) ? 0 : getShebaoCanshuFloor().hashCode());
        result = prime * result + ((getIsdel() == null) ? 0 : getIsdel().hashCode());
        result = prime * result + ((getCreateName() == null) ? 0 : getCreateName().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateName() == null) ? 0 : getUpdateName().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        return result;
    }
}