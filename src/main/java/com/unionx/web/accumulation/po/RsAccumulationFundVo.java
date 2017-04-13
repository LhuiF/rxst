package com.unionx.web.accumulation.po;

import com.unionx.web.accumulation.vo.RsAccumulationFund;

public class RsAccumulationFundVo extends RsAccumulationFund {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] name;
	private String[] code;
	private String[] start;
	private String[] end;

	private String fundCode;
	private String fundCodeName;
	private String fundStartTime;
	private String fundEndTime;
	private String fundId;
	private String[] fundIds;

	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
	}

	public String[] getCode() {
		return code;
	}

	public void setCode(String[] code) {
		this.code = code;
	}

	public String[] getStart() {
		return start;
	}

	public void setStart(String[] start) {
		this.start = start;
	}

	public String[] getEnd() {
		return end;
	}

	public void setEnd(String[] end) {
		this.end = end;
	}

	public String getFundCode() {
		return fundCode;
	}

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	public String getFundCodeName() {
		return fundCodeName;
	}

	public void setFundCodeName(String fundCodeName) {
		this.fundCodeName = fundCodeName;
	}

	public String getFundStartTime() {
		return fundStartTime;
	}

	public void setFundStartTime(String fundStartTime) {
		this.fundStartTime = fundStartTime;
	}

	public String getFundEndTime() {
		return fundEndTime;
	}

	public void setFundEndTime(String fundEndTime) {
		this.fundEndTime = fundEndTime;
	}

	public String getFundId() {
		return fundId;
	}

	public void setFundId(String fundId) {
		this.fundId = fundId;
	}

	public String[] getFundIds() {
		return fundIds;
	}

	public void setFundIds(String[] fundIds) {
		this.fundIds = fundIds;
	}

}
