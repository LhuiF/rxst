package com.unionx.web.insurance.po;

import java.io.Serializable;

/**
 * 社保基数比例封装类
 * 
 * @author Administrator
 * 
 */
public class InsuranceProportionDetail implements Serializable {

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
	// 个人大病
	private Double personalIllness;

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

	public Double getPersonalIllness() {
		return personalIllness;
	}

	public void setPersonalIllness(Double personalIllness) {
		this.personalIllness = personalIllness;
	}

}
