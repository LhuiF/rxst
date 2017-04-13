package com.unionx.web.employee.vo;

import java.io.Serializable;
import java.util.Date;

public class EmployeeInfo implements Serializable {
    //员工id
	private String id;
	//员工姓名
    private String employeeName;
    //证件号码	
    private String paperWorkCode;
    //企业名称
    private String enterpriseName;
    //社保申报时间
    private Date ssDeclareDate;
    //社保开始时间
    private Date ssStartDate;
    //社保申报人类型
    private String ssPeopleType;
    //公积金申报时间
    private Date pfDeclareDate;
    //公积金开始时间
    private Date pfStartDate;
    //医疗人类型
    private String mtPeopleType;
    //申报工资
    private Double averageWage;
    //社保基数
    private Double ssWage;	
    //公积金基数
    private Double pfWage;
    //养老
    private String pension;
    //失业
    private String unemployment;
    //生育
    private String fertility;
    //工伤
    private String workInjury;
    //医疗
    private String medicalTreatment;
    //公积金
    private String providentFund;

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

	public String getPaperWorkCode() {
		return paperWorkCode;
	}

	public void setPaperWorkCode(String paperWorkCode) {
		this.paperWorkCode = paperWorkCode;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public Date getSsDeclareDate() {
		return ssDeclareDate;
	}

	public void setSsDeclareDate(Date ssDeclareDate) {
		this.ssDeclareDate = ssDeclareDate;
	}

	public Date getSsStartDate() {
		return ssStartDate;
	}

	public void setSsStartDate(Date ssStartDate) {
		this.ssStartDate = ssStartDate;
	}

	public String getSsPeopleType() {
		return ssPeopleType;
	}

	public void setSsPeopleType(String ssPeopleType) {
		this.ssPeopleType = ssPeopleType;
	}

	public Date getPfDeclareDate() {
		return pfDeclareDate;
	}

	public void setPfDeclareDate(Date pfDeclareDate) {
		this.pfDeclareDate = pfDeclareDate;
	}

	public Date getPfStartDate() {
		return pfStartDate;
	}

	public void setPfStartDate(Date pfStartDate) {
		this.pfStartDate = pfStartDate;
	}

	public String getMtPeopleType() {
		return mtPeopleType;
	}

	public void setMtPeopleType(String mtPeopleType) {
		this.mtPeopleType = mtPeopleType;
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
    
    
}