package com.unionx.web.calculator.vo;

import java.io.Serializable;


public class ResultInsuranceVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 养老企业
	private Double pensionsEnterprise;
	// 养老个人
	private Double pensionsPersonal;
	// 失业企业
	private Double unemploymentEnterprise;
	// 失业个人
	private Double unemploymentPersonal;
	// 工伤企业
	private Double injuriesEnterprise;
	// 工伤个人
	private Double injuriesPersonal;
	// 生育企业
	private Double birthEnterprise;
	// 生育个人
	private Double birthPersonal;
	// 医疗企业
	private Double medicalEnterprise;
	// 医疗个人
	private Double medicalPersonal;
	
	private String name;
	private Double EnterpriseSum;
	private Double PersonalSum;
	private Double total;
	
	
	public Double getEnterpriseSum() {
		return EnterpriseSum;
	}

	public void setEnterpriseSum() {
		EnterpriseSum = getPensionsEnterprise()+getUnemploymentEnterprise()+getInjuriesEnterprise()+getBirthEnterprise()+getMedicalEnterprise();
	}

	public Double getPersonalSum() {
		return PersonalSum;
	}

	public void setPersonalSum() {
		PersonalSum = getPensionsPersonal()+getUnemploymentPersonal()+getInjuriesPersonal()+getBirthPersonal()+getMedicalPersonal();
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal() {
		this.total = EnterpriseSum+PersonalSum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPensionsEnterprise() {
		return pensionsEnterprise;
	}

	public void setPensionsEnterprise(Double pensionsEnterprise) {
		this.pensionsEnterprise = pensionsEnterprise;
	}

	public Double getPensionsPersonal() {
		return pensionsPersonal;
	}

	public void setPensionsPersonal(Double pensionsPersonal) {
		this.pensionsPersonal = pensionsPersonal;
	}

	public Double getUnemploymentEnterprise() {
		return unemploymentEnterprise;
	}

	public void setUnemploymentEnterprise(Double unemploymentEnterprise) {
		this.unemploymentEnterprise = unemploymentEnterprise;
	}

	public Double getUnemploymentPersonal() {
		return unemploymentPersonal;
	}

	public void setUnemploymentPersonal(Double unemploymentPersonal) {
		this.unemploymentPersonal = unemploymentPersonal;
	}

	public Double getInjuriesEnterprise() {
		return injuriesEnterprise;
	}

	public void setInjuriesEnterprise(Double injuriesEnterprise) {
		this.injuriesEnterprise = injuriesEnterprise;
	}

	public Double getInjuriesPersonal() {
		return injuriesPersonal;
	}

	public void setInjuriesPersonal(Double injuriesPersonal) {
		this.injuriesPersonal = injuriesPersonal;
	}

	public Double getBirthEnterprise() {
		return birthEnterprise;
	}

	public void setBirthEnterprise(Double birthEnterprise) {
		this.birthEnterprise = birthEnterprise;
	}

	public Double getBirthPersonal() {
		return birthPersonal;
	}

	public void setBirthPersonal(Double birthPersonal) {
		this.birthPersonal = birthPersonal;
	}

	public Double getMedicalEnterprise() {
		return medicalEnterprise;
	}

	public void setMedicalEnterprise(Double medicalEnterprise) {
		this.medicalEnterprise = medicalEnterprise;
	}

	public Double getMedicalPersonal() {
		return medicalPersonal;
	}

	public void setMedicalPersonal(Double medicalPersonal) {
		this.medicalPersonal = medicalPersonal;
	}

	public void setEnterpriseSum(Double enterpriseSum) {
		EnterpriseSum = enterpriseSum;
	}

	public void setPersonalSum(Double personalSum) {
		PersonalSum = personalSum;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	

}
