package com.unionx.web.accumulation.po;

import com.unionx.web.accumulation.vo.RsAccumulationFundProportion;

public class RsAccumulationFundProportionVo extends RsAccumulationFundProportion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer[] ids;
	String[] codes;
	String[] names;
	String[] company;
	String[] notFloor;
	String[] floor;
	String startTime;
	String endTime;
	String fundYear;
	
	
	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public String getFundYear() {
		return fundYear;
	}

	public void setFundYear(String fundYear) {
		this.fundYear = fundYear;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String[] getCodes() {
		return codes;
	}

	public void setCodes(String[] codes) {
		this.codes = codes;
	}

	public String[] getNames() {
		return names;
	}

	public void setNames(String[] names) {
		this.names = names;
	}

	public String[] getCompany() {
		return company;
	}

	public void setCompany(String[] company) {
		this.company = company;
	}

	public String[] getNotFloor() {
		return notFloor;
	}

	public void setNotFloor(String[] notFloor) {
		this.notFloor = notFloor;
	}

	public String[] getFloor() {
		return floor;
	}

	public void setFloor(String[] floor) {
		this.floor = floor;
	}

}
