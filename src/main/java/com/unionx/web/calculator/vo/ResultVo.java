package com.unionx.web.calculator.vo;

import java.util.List;

public class ResultVo {
	private List<ResultInsuranceVo> insurance;
	private List<ResultAccumulation> accumulation;

	public List<ResultAccumulation> getAccumulation() {
		return accumulation;
	}

	public void setAccumulation(List<ResultAccumulation> accumulation) {
		this.accumulation = accumulation;
	}

	public List<ResultInsuranceVo> getInsurance() {
		return insurance;
	}

	public void setInsurance(List<ResultInsuranceVo> insurance) {
		this.insurance = insurance;
	}
	
	
}
