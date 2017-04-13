package com.unionx.web.employee.vo;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
    private String id;

    private String employeeName;

    private String sex;

    private String paperWorkType;

    private String paperWorkCode;

    private Date birthDate;

    private Integer age;

    private String nation;

    private String nativePlace;

    private String educationalLevel;

    private String countryRegion;

    private String personalIdentity;

    private String citizenIdCode;

    private String accountNature;

    private String accountAddress;

    private String accountZipCode;

    private String logPhoto;

    private String address;

    private String addressZipCode;

    private String tele;

    private String email;

    private String enterpriseId;

    private String enterpriseName;

    private String jobNumber;

    private Date joinWork;

    private String exPassportCode;

    private String exPermitCode;

    private String isdel;

    private String createName;

    private Date createDate;

    private String updateName;

    private Date updateDate;
    
    private SsFundinfo ssFundinfo;
    
    private FiveRisks fiveRisks;
    private Annex annex;
    
    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPaperWorkType() {
        return paperWorkType;
    }

    public void setPaperWorkType(String paperWorkType) {
        this.paperWorkType = paperWorkType;
    }

    public String getPaperWorkCode() {
        return paperWorkCode;
    }

    public void setPaperWorkCode(String paperWorkCode) {
        this.paperWorkCode = paperWorkCode;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getEducationalLevel() {
        return educationalLevel;
    }

    public void setEducationalLevel(String educationalLevel) {
        this.educationalLevel = educationalLevel;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public String getPersonalIdentity() {
        return personalIdentity;
    }

    public void setPersonalIdentity(String personalIdentity) {
        this.personalIdentity = personalIdentity;
    }

    public String getCitizenIdCode() {
        return citizenIdCode;
    }

    public void setCitizenIdCode(String citizenIdCode) {
        this.citizenIdCode = citizenIdCode;
    }

    public String getAccountNature() {
        return accountNature;
    }

    public void setAccountNature(String accountNature) {
        this.accountNature = accountNature;
    }

    public String getAccountAddress() {
        return accountAddress;
    }

    public void setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
    }

    public String getAccountZipCode() {
        return accountZipCode;
    }

    public void setAccountZipCode(String accountZipCode) {
        this.accountZipCode = accountZipCode;
    }

    public String getLogPhoto() {
        return logPhoto;
    }

    public void setLogPhoto(String logPhoto) {
        this.logPhoto = logPhoto;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressZipCode() {
        return addressZipCode;
    }

    public void setAddressZipCode(String addressZipCode) {
        this.addressZipCode = addressZipCode;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public Date getJoinWork() {
        return joinWork;
    }

    public void setJoinWork(Date joinWork) {
        this.joinWork = joinWork;
    }

    public String getExPassportCode() {
        return exPassportCode;
    }

    public void setExPassportCode(String exPassportCode) {
        this.exPassportCode = exPassportCode;
    }

    public String getExPermitCode() {
        return exPermitCode;
    }

    public void setExPermitCode(String exPermitCode) {
        this.exPermitCode = exPermitCode;
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
    
    
    public SsFundinfo getSsFundinfo() {
		return ssFundinfo;
	}

	public void setSsFundinfo(SsFundinfo ssFundinfo) {
		this.ssFundinfo = ssFundinfo;
	}
	
	public FiveRisks getFiveRisks() {
		return fiveRisks;
	}

	public void setFiveRisks(FiveRisks fiveRisks) {
		this.fiveRisks = fiveRisks;
	}

	
	public Annex getAnnex() {
		return annex;
	}

	public void setAnnex(Annex annex) {
		this.annex = annex;
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
        Employee other = (Employee) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEmployeeName() == null ? other.getEmployeeName() == null : this.getEmployeeName().equals(other.getEmployeeName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getPaperWorkType() == null ? other.getPaperWorkType() == null : this.getPaperWorkType().equals(other.getPaperWorkType()))
            && (this.getPaperWorkCode() == null ? other.getPaperWorkCode() == null : this.getPaperWorkCode().equals(other.getPaperWorkCode()))
            && (this.getBirthDate() == null ? other.getBirthDate() == null : this.getBirthDate().equals(other.getBirthDate()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getNation() == null ? other.getNation() == null : this.getNation().equals(other.getNation()))
            && (this.getNativePlace() == null ? other.getNativePlace() == null : this.getNativePlace().equals(other.getNativePlace()))
            && (this.getEducationalLevel() == null ? other.getEducationalLevel() == null : this.getEducationalLevel().equals(other.getEducationalLevel()))
            && (this.getCountryRegion() == null ? other.getCountryRegion() == null : this.getCountryRegion().equals(other.getCountryRegion()))
            && (this.getPersonalIdentity() == null ? other.getPersonalIdentity() == null : this.getPersonalIdentity().equals(other.getPersonalIdentity()))
            && (this.getCitizenIdCode() == null ? other.getCitizenIdCode() == null : this.getCitizenIdCode().equals(other.getCitizenIdCode()))
            && (this.getAccountNature() == null ? other.getAccountNature() == null : this.getAccountNature().equals(other.getAccountNature()))
            && (this.getAccountAddress() == null ? other.getAccountAddress() == null : this.getAccountAddress().equals(other.getAccountAddress()))
            && (this.getAccountZipCode() == null ? other.getAccountZipCode() == null : this.getAccountZipCode().equals(other.getAccountZipCode()))
            && (this.getLogPhoto() == null ? other.getLogPhoto() == null : this.getLogPhoto().equals(other.getLogPhoto()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getAddressZipCode() == null ? other.getAddressZipCode() == null : this.getAddressZipCode().equals(other.getAddressZipCode()))
            && (this.getTele() == null ? other.getTele() == null : this.getTele().equals(other.getTele()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getEnterpriseId() == null ? other.getEnterpriseId() == null : this.getEnterpriseId().equals(other.getEnterpriseId()))
            && (this.getEnterpriseName() == null ? other.getEnterpriseName() == null : this.getEnterpriseName().equals(other.getEnterpriseName()))
            && (this.getJobNumber() == null ? other.getJobNumber() == null : this.getJobNumber().equals(other.getJobNumber()))
            && (this.getJoinWork() == null ? other.getJoinWork() == null : this.getJoinWork().equals(other.getJoinWork()))
            && (this.getExPassportCode() == null ? other.getExPassportCode() == null : this.getExPassportCode().equals(other.getExPassportCode()))
            && (this.getExPermitCode() == null ? other.getExPermitCode() == null : this.getExPermitCode().equals(other.getExPermitCode()))
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
        result = prime * result + ((getEmployeeName() == null) ? 0 : getEmployeeName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getPaperWorkType() == null) ? 0 : getPaperWorkType().hashCode());
        result = prime * result + ((getPaperWorkCode() == null) ? 0 : getPaperWorkCode().hashCode());
        result = prime * result + ((getBirthDate() == null) ? 0 : getBirthDate().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getNation() == null) ? 0 : getNation().hashCode());
        result = prime * result + ((getNativePlace() == null) ? 0 : getNativePlace().hashCode());
        result = prime * result + ((getEducationalLevel() == null) ? 0 : getEducationalLevel().hashCode());
        result = prime * result + ((getCountryRegion() == null) ? 0 : getCountryRegion().hashCode());
        result = prime * result + ((getPersonalIdentity() == null) ? 0 : getPersonalIdentity().hashCode());
        result = prime * result + ((getCitizenIdCode() == null) ? 0 : getCitizenIdCode().hashCode());
        result = prime * result + ((getAccountNature() == null) ? 0 : getAccountNature().hashCode());
        result = prime * result + ((getAccountAddress() == null) ? 0 : getAccountAddress().hashCode());
        result = prime * result + ((getAccountZipCode() == null) ? 0 : getAccountZipCode().hashCode());
        result = prime * result + ((getLogPhoto() == null) ? 0 : getLogPhoto().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getAddressZipCode() == null) ? 0 : getAddressZipCode().hashCode());
        result = prime * result + ((getTele() == null) ? 0 : getTele().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getEnterpriseId() == null) ? 0 : getEnterpriseId().hashCode());
        result = prime * result + ((getEnterpriseName() == null) ? 0 : getEnterpriseName().hashCode());
        result = prime * result + ((getJobNumber() == null) ? 0 : getJobNumber().hashCode());
        result = prime * result + ((getJoinWork() == null) ? 0 : getJoinWork().hashCode());
        result = prime * result + ((getExPassportCode() == null) ? 0 : getExPassportCode().hashCode());
        result = prime * result + ((getExPermitCode() == null) ? 0 : getExPermitCode().hashCode());
        result = prime * result + ((getIsdel() == null) ? 0 : getIsdel().hashCode());
        result = prime * result + ((getCreateName() == null) ? 0 : getCreateName().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateName() == null) ? 0 : getUpdateName().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        return result;
    }
}