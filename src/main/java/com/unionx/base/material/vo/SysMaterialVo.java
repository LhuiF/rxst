package com.unionx.base.material.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysMaterialVo extends SysMaterial {
	
	private static final long serialVersionUID = 1L;
	private Integer[] ids;
	
	

	private String qu;

    private String typeId;

    private String productName;

    private Integer isMaterial;

    private Integer isApply;

    private Date createTime;

    private String createUserId;

    private String remark;

    private String[] condition01s;//条件

    private String[] conditon01s;//材料

    private String[] marerialRequests;

    private String[] fenshus;
    List<SysMaterialVo> voList = new ArrayList<SysMaterialVo>();

    public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public String getQu() {
		return qu;
	}

	public void setQu(String qu) {
		this.qu = qu;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getIsMaterial() {
		return isMaterial;
	}

	public void setIsMaterial(Integer isMaterial) {
		this.isMaterial = isMaterial;
	}

	public Integer getIsApply() {
		return isApply;
	}

	public void setIsApply(Integer isApply) {
		this.isApply = isApply;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String[] getCondition01s() {
		return condition01s;
	}

	public void setCondition01s(String[] condition01s) {
		this.condition01s = condition01s;
	}

	public String[] getConditon01s() {
		return conditon01s;
	}

	public void setConditon01s(String[] conditon01s) {
		this.conditon01s = conditon01s;
	}

	public String[] getMarerialRequests() {
		return marerialRequests;
	}

	public void setMarerialRequests(String[] marerialRequests) {
		this.marerialRequests = marerialRequests;
	}

	public String[] getFenshus() {
		return fenshus;
	}

	public void setFenshus(String[] fenshus) {
		this.fenshus = fenshus;
	}

	public String getStr03() {
		return str03;
	}

	public void setStr03(String str03) {
		this.str03 = str03;
	}

	private String str03;
    
    

	
	
	

}
