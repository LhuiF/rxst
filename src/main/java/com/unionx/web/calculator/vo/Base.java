package com.unionx.web.calculator.vo;

public class Base {
	private String uuid;
	private String cityCode;
	private String yearCity;
	private String dictCode;
	private String dictName;
	private Double ceilingBase;
	private Double floorBase;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getYearCity() {
		return yearCity;
	}

	public void setYearCity(String yearCity) {
		this.yearCity = yearCity;
	}

	public String getDictCode() {
		return dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}

	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public Double getCeilingBase() {
		return ceilingBase;
	}

	public void setCeilingBase(Double ceilingBase) {
		this.ceilingBase = ceilingBase;
	}

	public Double getFloorBase() {
		return floorBase;
	}

	public void setFloorBase(Double floorBase) {
		this.floorBase = floorBase;
	}

}
