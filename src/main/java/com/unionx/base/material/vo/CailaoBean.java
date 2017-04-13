package com.unionx.base.material.vo;

import java.io.Serializable;

import com.unionx.base.material.vo1.SysCailiao;

public class CailaoBean extends SysCailiao implements Serializable {
 
	
	public int getClNum() {
		return clNum;
	}
	public void setClNum(int clNum) {
		this.clNum = clNum;
	}
	public String getClName() {
		return clName;
	}
	public void setClName(String clName) {
		this.clName = clName;
	}
	public String getClRqst() {
		return clRqst;
	}
	public void setClRqst(String clRqst) {
		this.clRqst = clRqst;
	}
	
	private int clNum;//分数
	private String clName;//材料名称
	private String clRqst;//材料内容
	
	
	
}
