package com.unionx.web.insurance.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InsurancePage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[] id;
	private String uuid;
	private List<InsuranceProportionDetail> list = new ArrayList<InsuranceProportionDetail>();
	private String[] names;
	private String[] codes;
	
	public String[] getId() {
		return id;
	}

	public void setId(String[] id) {
		this.id = id;
	}

	public String[] getNames() {
		return names;
	}

	public void setNames(String[] names) {
		this.names = names;
	}

	public String[] getCodes() {
		return codes;
	}

	public void setCodes(String[] codes) {
		this.codes = codes;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public List<InsuranceProportionDetail> getList() {
		return list;
	}

	public void setList(List<InsuranceProportionDetail> list) {
		this.list = list;
	}

}
