package com.unionx.web.insurance.po;

public class InsuranceResult {

	private InsuranceProportionDetail detail;
	private String id;
	private String uuid;
	private String name;
	
	//yyp 20161120 new add
	private String dictCode;

	
	public InsuranceProportionDetail getDetail() {
		return detail;
	}

	public void setDetail(InsuranceProportionDetail detail) {
		this.detail = detail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDictCode() {
		return dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}


}
