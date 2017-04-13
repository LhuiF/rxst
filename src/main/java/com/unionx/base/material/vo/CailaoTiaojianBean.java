package com.unionx.base.material.vo;

import java.io.Serializable;
import java.util.List;

import com.unionx.base.material.vo1.SysTiaojian;

public class CailaoTiaojianBean extends SysTiaojian implements Serializable {
	
	private String productid;//产品id
	private String condition01s;//产品满足的条件
	private List<CailaoBean> CL;
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getCondition01s() {
		return condition01s;
	}
	public void setCondition01s(String condition01s) {
		this.condition01s = condition01s;
	}
	public List<CailaoBean> getCL() {
		return CL;
	}
	public void setCL(List<CailaoBean> cL) {
		CL = cL;
	}
	
	
}
