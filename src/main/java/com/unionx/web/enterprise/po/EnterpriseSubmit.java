package com.unionx.web.enterprise.po;

import com.unionx.web.enterprise.vo.RsEnterpriseProportion;

public class EnterpriseSubmit extends RsEnterpriseProportion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String uuid;
	private String[] ids;
	private String[] names;
	private String[] codes;
	private String[] enterprises;
	private String[] personalNotFloors;
	private String[] personalFloors;

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	public String[] getEnterprises() {
		return enterprises;
	}

	public void setEnterprises(String[] enterprises) {
		this.enterprises = enterprises;
	}

	public String[] getPersonalNotFloors() {
		return personalNotFloors;
	}

	public void setPersonalNotFloors(String[] personalNotFloors) {
		this.personalNotFloors = personalNotFloors;
	}

	public String[] getPersonalFloors() {
		return personalFloors;
	}

	public void setPersonalFloors(String[] personalFloors) {
		this.personalFloors = personalFloors;
	}

}
