package com.unionx.web.calculator.vo;

public class ResultAccumulation {
	private String name;
	private Double enterprise;
	private Double personal;
	private Double total;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Double enterprise) {
		this.enterprise = enterprise;
	}

	public Double getPersonal() {
		return personal;
	}

	public void setPersonal(Double personal) {
		this.personal = personal;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal() {
		this.total = enterprise + personal;
	}

}
