package com.unionx.web.calculator.vo;

public class RequestVo {
	// 城市
	private String cityCode;
	// 缴费日期
	private String paymentDate;
	// 社保工资
	private double insurance;
	// 公积金工资
	private double accumulationFund;

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getInsurance() {
		return insurance;
	}

	public void setInsurance(double insurance) {
		this.insurance = insurance;
	}

	public double getAccumulationFund() {
		return accumulationFund;
	}

	public void setAccumulationFund(double accumulationFund) {
		this.accumulationFund = accumulationFund;
	}

}
