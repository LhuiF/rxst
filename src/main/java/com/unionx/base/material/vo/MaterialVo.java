package com.unionx.base.material.vo;

import java.util.List;

public class MaterialVo extends SysMaterial {//用来接收前端封来的数据
	
	private static final long serialVersionUID = 1L;
	private List<CailaoTiaojianBean> TJ;
	
	

	
	public List<CailaoTiaojianBean> getTJ() {
		return TJ;
	}

	public void setTJ(List<CailaoTiaojianBean> tJ) {
		TJ = tJ;
	}

	
	
	
	
	

}
