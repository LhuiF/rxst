package com.unionx.web.proxy.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProxyInfo implements Serializable {
    private String id;

    private String proxyName;

    private String openBank;

    private String openBankAccount;

    private String openBankUsername;
    
    private String appointmentPaymentString;
    private Date appointmentPaymentDate;
    
    private String clientName;

    private String registeredAddress;

    private String officeAddress;

    private Byte changeTheCost;

    private String createName;

    private String createString;
    private Date createDate;

    private String updateName;

    private Date updateDate;

    private String isdel;
    
    private String remarks;
    
    private List<RsLinkpeople> list;
    
    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProxyName() {
        return proxyName;
    }

    public void setProxyName(String proxyName) {
        this.proxyName = proxyName;
    }

    public String getOpenBank() {
        return openBank;
    }

    public void setOpenBank(String openBank) {
        this.openBank = openBank;
    }

    public String getOpenBankAccount() {
        return openBankAccount;
    }

    public void setOpenBankAccount(String openBankAccount) {
        this.openBankAccount = openBankAccount;
    }

    public String getOpenBankUsername() {
        return openBankUsername;
    }

    public void setOpenBankUsername(String openBankUsername) {
        this.openBankUsername = openBankUsername;
    }
    public Date getAppointmentPaymentDate() {
        return appointmentPaymentDate;
    }

    public void setAppointmentPaymentDate(Date appointmentPaymentDate) {
        this.appointmentPaymentDate = appointmentPaymentDate;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public Byte getChangeTheCost() {
        return changeTheCost;
    }

    public void setChangeTheCost(Byte changeTheCost) {
        this.changeTheCost = changeTheCost;
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

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel;
    }
    
    
    public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
	public List<RsLinkpeople> getList() {
		return list;
	}

	public void setList(List<RsLinkpeople> list) {
		this.list = list;
	}


	public String getAppointmentPaymentString() {
		return appointmentPaymentString;
	}

	public void setAppointmentPaymentString(String appointmentPaymentString) {
		this.appointmentPaymentString = appointmentPaymentString;
	}

	public String getCreateString() {
		return createString;
	}

	public void setCreateString(String createString) {
		this.createString = createString;
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
        ProxyInfo other = (ProxyInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProxyName() == null ? other.getProxyName() == null : this.getProxyName().equals(other.getProxyName()))
            && (this.getOpenBank() == null ? other.getOpenBank() == null : this.getOpenBank().equals(other.getOpenBank()))
            && (this.getOpenBankAccount() == null ? other.getOpenBankAccount() == null : this.getOpenBankAccount().equals(other.getOpenBankAccount()))
            && (this.getOpenBankUsername() == null ? other.getOpenBankUsername() == null : this.getOpenBankUsername().equals(other.getOpenBankUsername()))
            && (this.getAppointmentPaymentDate() == null ? other.getAppointmentPaymentDate() == null : this.getAppointmentPaymentDate().equals(other.getAppointmentPaymentDate()))
            && (this.getClientName() == null ? other.getClientName() == null : this.getClientName().equals(other.getClientName()))
            && (this.getRegisteredAddress() == null ? other.getRegisteredAddress() == null : this.getRegisteredAddress().equals(other.getRegisteredAddress()))
            && (this.getOfficeAddress() == null ? other.getOfficeAddress() == null : this.getOfficeAddress().equals(other.getOfficeAddress()))
            && (this.getChangeTheCost() == null ? other.getChangeTheCost() == null : this.getChangeTheCost().equals(other.getChangeTheCost()))
            && (this.getCreateName() == null ? other.getCreateName() == null : this.getCreateName().equals(other.getCreateName()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateName() == null ? other.getUpdateName() == null : this.getUpdateName().equals(other.getUpdateName()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getIsdel() == null ? other.getIsdel() == null : this.getIsdel().equals(other.getIsdel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProxyName() == null) ? 0 : getProxyName().hashCode());
        result = prime * result + ((getOpenBank() == null) ? 0 : getOpenBank().hashCode());
        result = prime * result + ((getOpenBankAccount() == null) ? 0 : getOpenBankAccount().hashCode());
        result = prime * result + ((getOpenBankUsername() == null) ? 0 : getOpenBankUsername().hashCode());
        result = prime * result + ((getAppointmentPaymentDate() == null) ? 0 : getAppointmentPaymentDate().hashCode());
        result = prime * result + ((getClientName() == null) ? 0 : getClientName().hashCode());
        result = prime * result + ((getRegisteredAddress() == null) ? 0 : getRegisteredAddress().hashCode());
        result = prime * result + ((getOfficeAddress() == null) ? 0 : getOfficeAddress().hashCode());
        result = prime * result + ((getChangeTheCost() == null) ? 0 : getChangeTheCost().hashCode());
        result = prime * result + ((getCreateName() == null) ? 0 : getCreateName().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateName() == null) ? 0 : getUpdateName().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getIsdel() == null) ? 0 : getIsdel().hashCode());
        return result;
    }
}