package com.unionx.web.company.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EntermainBean implements Serializable {
	
	private String dept;//社保的参数的uuid
	private String shebaoCanshuYearcity;//年度城市
	
	

	private Date enterprisestartTime;// 企业表里设置的政策开始执行时间
    private Date enterpriseendTime;//企业社保表里设置的政策结束时间
    private String enterpriseName;//企业名称
    private String enterpriseUUid;//企业的uuid
    
 
	
	List <CompanyShebaoBili>rsInsuranceAccountList=new ArrayList();

	

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Date getEnterprisestartTime() {
		return enterprisestartTime;
	}

	public void setEnterprisestartTime(Date enterprisestartTime) {
		this.enterprisestartTime = enterprisestartTime;
	}

	public Date getEnterpriseendTime() {
		return enterpriseendTime;
	}

	public void setEnterpriseendTime(Date enterpriseendTime) {
		this.enterpriseendTime = enterpriseendTime;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getEnterpriseUUid() {
		return enterpriseUUid;
	}

	public void setEnterpriseUUid(String enterpriseUUid) {
		this.enterpriseUUid = enterpriseUUid;
	}
	public List<CompanyShebaoBili> getRsInsuranceAccountList() {
		return rsInsuranceAccountList;
	}

	public void setRsInsuranceAccountList(
			List<CompanyShebaoBili> rsInsuranceAccountList) {
		this.rsInsuranceAccountList = rsInsuranceAccountList;
	}
	public String getShebaoCanshuYearcity() {
		return shebaoCanshuYearcity;
	}

	public void setShebaoCanshuYearcity(String shebaoCanshuYearcity) {
		this.shebaoCanshuYearcity = shebaoCanshuYearcity;
	}
 
}
