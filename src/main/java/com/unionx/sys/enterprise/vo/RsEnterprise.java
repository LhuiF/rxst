package com.unionx.sys.enterprise.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.unionx.web.proxy.vo.RsLinkpeople;

public class RsEnterprise implements Serializable {
    private String id;

    private String name;

    private String insuranceAccount;

    private String orgCode;

    private String workAddr;

    private String regAddr;

    private String legalName;

    private String legalPhone;

    private String agentName;

    private String agentPhone;

    private String insureanceArea;

    private String accumulationArea;

    private String angency;

    private String angencyId;

    private String isinsurance;

    private String ishealthinsurance;

    private String isbankfees;

    private String openBank;

    private String openCode;

    private String openAccount;

    private String isdel;

    private Date dcDate;

    private String createName;

    private Date createDate;

    private String updateName;

    private Date updateDate;
    
    private List<RsLinkpeople> list;
    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInsuranceAccount() {
        return insuranceAccount;
    }

    public void setInsuranceAccount(String insuranceAccount) {
        this.insuranceAccount = insuranceAccount;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getWorkAddr() {
        return workAddr;
    }

    public void setWorkAddr(String workAddr) {
        this.workAddr = workAddr;
    }

    public String getRegAddr() {
        return regAddr;
    }

    public void setRegAddr(String regAddr) {
        this.regAddr = regAddr;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getLegalPhone() {
        return legalPhone;
    }

    public void setLegalPhone(String legalPhone) {
        this.legalPhone = legalPhone;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentPhone() {
        return agentPhone;
    }

    public void setAgentPhone(String agentPhone) {
        this.agentPhone = agentPhone;
    }

    public String getInsureanceArea() {
        return insureanceArea;
    }

    public void setInsureanceArea(String insureanceArea) {
        this.insureanceArea = insureanceArea;
    }

    public String getAccumulationArea() {
        return accumulationArea;
    }

    public void setAccumulationArea(String accumulationArea) {
        this.accumulationArea = accumulationArea;
    }

    public String getAngency() {
        return angency;
    }

    public void setAngency(String angency) {
        this.angency = angency;
    }

    public String getAngencyId() {
        return angencyId;
    }

    public void setAngencyId(String angencyId) {
        this.angencyId = angencyId;
    }

    public String getIsinsurance() {
        return isinsurance;
    }

    public void setIsinsurance(String isinsurance) {
        this.isinsurance = isinsurance;
    }

    public String getIshealthinsurance() {
        return ishealthinsurance;
    }

    public void setIshealthinsurance(String ishealthinsurance) {
        this.ishealthinsurance = ishealthinsurance;
    }

    public String getIsbankfees() {
        return isbankfees;
    }

    public void setIsbankfees(String isbankfees) {
        this.isbankfees = isbankfees;
    }

    public String getOpenBank() {
        return openBank;
    }

    public void setOpenBank(String openBank) {
        this.openBank = openBank;
    }

    public String getOpenCode() {
        return openCode;
    }

    public void setOpenCode(String openCode) {
        this.openCode = openCode;
    }

    public String getOpenAccount() {
        return openAccount;
    }

    public void setOpenAccount(String openAccount) {
        this.openAccount = openAccount;
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel;
    }

    public Date getDcDate() {
        return dcDate;
    }

    public void setDcDate(Date dcDate) {
        this.dcDate = dcDate;
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
    
    
    public List<RsLinkpeople> getList() {
		return list;
	}

	public void setList(List<RsLinkpeople> list) {
		this.list = list;
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
        RsEnterprise other = (RsEnterprise) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getInsuranceAccount() == null ? other.getInsuranceAccount() == null : this.getInsuranceAccount().equals(other.getInsuranceAccount()))
            && (this.getOrgCode() == null ? other.getOrgCode() == null : this.getOrgCode().equals(other.getOrgCode()))
            && (this.getWorkAddr() == null ? other.getWorkAddr() == null : this.getWorkAddr().equals(other.getWorkAddr()))
            && (this.getRegAddr() == null ? other.getRegAddr() == null : this.getRegAddr().equals(other.getRegAddr()))
            && (this.getLegalName() == null ? other.getLegalName() == null : this.getLegalName().equals(other.getLegalName()))
            && (this.getLegalPhone() == null ? other.getLegalPhone() == null : this.getLegalPhone().equals(other.getLegalPhone()))
            && (this.getAgentName() == null ? other.getAgentName() == null : this.getAgentName().equals(other.getAgentName()))
            && (this.getAgentPhone() == null ? other.getAgentPhone() == null : this.getAgentPhone().equals(other.getAgentPhone()))
            && (this.getInsureanceArea() == null ? other.getInsureanceArea() == null : this.getInsureanceArea().equals(other.getInsureanceArea()))
            && (this.getAccumulationArea() == null ? other.getAccumulationArea() == null : this.getAccumulationArea().equals(other.getAccumulationArea()))
            && (this.getAngency() == null ? other.getAngency() == null : this.getAngency().equals(other.getAngency()))
            && (this.getAngencyId() == null ? other.getAngencyId() == null : this.getAngencyId().equals(other.getAngencyId()))
            && (this.getIsinsurance() == null ? other.getIsinsurance() == null : this.getIsinsurance().equals(other.getIsinsurance()))
            && (this.getIshealthinsurance() == null ? other.getIshealthinsurance() == null : this.getIshealthinsurance().equals(other.getIshealthinsurance()))
            && (this.getIsbankfees() == null ? other.getIsbankfees() == null : this.getIsbankfees().equals(other.getIsbankfees()))
            && (this.getOpenBank() == null ? other.getOpenBank() == null : this.getOpenBank().equals(other.getOpenBank()))
            && (this.getOpenCode() == null ? other.getOpenCode() == null : this.getOpenCode().equals(other.getOpenCode()))
            && (this.getOpenAccount() == null ? other.getOpenAccount() == null : this.getOpenAccount().equals(other.getOpenAccount()))
            && (this.getIsdel() == null ? other.getIsdel() == null : this.getIsdel().equals(other.getIsdel()))
            && (this.getDcDate() == null ? other.getDcDate() == null : this.getDcDate().equals(other.getDcDate()))
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
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getInsuranceAccount() == null) ? 0 : getInsuranceAccount().hashCode());
        result = prime * result + ((getOrgCode() == null) ? 0 : getOrgCode().hashCode());
        result = prime * result + ((getWorkAddr() == null) ? 0 : getWorkAddr().hashCode());
        result = prime * result + ((getRegAddr() == null) ? 0 : getRegAddr().hashCode());
        result = prime * result + ((getLegalName() == null) ? 0 : getLegalName().hashCode());
        result = prime * result + ((getLegalPhone() == null) ? 0 : getLegalPhone().hashCode());
        result = prime * result + ((getAgentName() == null) ? 0 : getAgentName().hashCode());
        result = prime * result + ((getAgentPhone() == null) ? 0 : getAgentPhone().hashCode());
        result = prime * result + ((getInsureanceArea() == null) ? 0 : getInsureanceArea().hashCode());
        result = prime * result + ((getAccumulationArea() == null) ? 0 : getAccumulationArea().hashCode());
        result = prime * result + ((getAngency() == null) ? 0 : getAngency().hashCode());
        result = prime * result + ((getAngencyId() == null) ? 0 : getAngencyId().hashCode());
        result = prime * result + ((getIsinsurance() == null) ? 0 : getIsinsurance().hashCode());
        result = prime * result + ((getIshealthinsurance() == null) ? 0 : getIshealthinsurance().hashCode());
        result = prime * result + ((getIsbankfees() == null) ? 0 : getIsbankfees().hashCode());
        result = prime * result + ((getOpenBank() == null) ? 0 : getOpenBank().hashCode());
        result = prime * result + ((getOpenCode() == null) ? 0 : getOpenCode().hashCode());
        result = prime * result + ((getOpenAccount() == null) ? 0 : getOpenAccount().hashCode());
        result = prime * result + ((getIsdel() == null) ? 0 : getIsdel().hashCode());
        result = prime * result + ((getDcDate() == null) ? 0 : getDcDate().hashCode());
        result = prime * result + ((getCreateName() == null) ? 0 : getCreateName().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateName() == null) ? 0 : getUpdateName().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        return result;
    }
}