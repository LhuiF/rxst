package com.unionx.sys.produce.vo;

import java.io.Serializable;
import java.util.Date;

public class SysProduct implements Serializable {
    private String id;

    private String cityId; //城市id

    private String typeId; //业务类型

    private String name; //产品名称

    private Float standPrice; //标准报价

    private Date applyEndTime;//申报截止时间

    private Date feedbackEndTime;//反馈截止时间

    private Integer feedbackLoop;//反馈周期

    private Float costPrice;//成本价格

    private Integer mouthService;//是否包月 1：是 0：不是

    private Integer taskList;//对任务单 1：社保报增任务单 0：社保报减任务单

    private String createUserId;//创建人id

    private Date createTime;//创建时间

    private String introduction;//产品简介

    private String remark;//备注
   
    private String cityName; //城市名称
    
    private String typeName;//业务类型名称
    
    public String getAppliyTime() {
		return appliyTime;
	}

	public void setAppliyTime(String appliyTime) {
		this.appliyTime = appliyTime;
	}

	public String getBackTime() {
		return backTime;
	}

	public void setBackTime(String backTime) {
		this.backTime = backTime;
	}

	public String getCreTime() {
		return creTime;
	}

	public void setCreTime(String creTime) {
		this.creTime = creTime;
	}

	public String getBackETime() {
		return backETime;
	}

	public void setBackETime(String backETime) {
		this.backETime = backETime;
	}

	private String appliyTime;//申报截止时间
    private String backTime;//反馈时间
    private String creTime;//创建时间
    private String backETime;//反馈截止时间
    
    
    

    private static final long serialVersionUID = 1L;

    
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getStandPrice() {
        return standPrice;
    }

    public void setStandPrice(Float standPrice) {
        this.standPrice = standPrice;
    }

    public Date getApplyEndTime() {
        return applyEndTime;
    }

    public void setApplyEndTime(Date applyEndTime) {
        this.applyEndTime = applyEndTime;
    }

    public Date getFeedbackEndTime() {
        return feedbackEndTime;
    }

    public void setFeedbackEndTime(Date feedbackEndTime) {
        this.feedbackEndTime = feedbackEndTime;
    }

    public Integer getFeedbackLoop() {
        return feedbackLoop;
    }

    public void setFeedbackLoop(Integer feedbackLoop) {
        this.feedbackLoop = feedbackLoop;
    }

    public Float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Float costPrice) {
        this.costPrice = costPrice;
    }

    public Integer getMouthService() {
        return mouthService;
    }

    public void setMouthService(Integer mouthService) {
        this.mouthService = mouthService;
    }

    public Integer getTaskList() {
        return taskList;
    }

    public void setTaskList(Integer taskList) {
        this.taskList = taskList;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysProduct other = (SysProduct) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getStandPrice() == null ? other.getStandPrice() == null : this.getStandPrice().equals(other.getStandPrice()))
            && (this.getApplyEndTime() == null ? other.getApplyEndTime() == null : this.getApplyEndTime().equals(other.getApplyEndTime()))
            && (this.getFeedbackEndTime() == null ? other.getFeedbackEndTime() == null : this.getFeedbackEndTime().equals(other.getFeedbackEndTime()))
            && (this.getFeedbackLoop() == null ? other.getFeedbackLoop() == null : this.getFeedbackLoop().equals(other.getFeedbackLoop()))
            && (this.getCostPrice() == null ? other.getCostPrice() == null : this.getCostPrice().equals(other.getCostPrice()))
            && (this.getMouthService() == null ? other.getMouthService() == null : this.getMouthService().equals(other.getMouthService()))
            && (this.getTaskList() == null ? other.getTaskList() == null : this.getTaskList().equals(other.getTaskList()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getIntroduction() == null ? other.getIntroduction() == null : this.getIntroduction().equals(other.getIntroduction()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getStandPrice() == null) ? 0 : getStandPrice().hashCode());
        result = prime * result + ((getApplyEndTime() == null) ? 0 : getApplyEndTime().hashCode());
        result = prime * result + ((getFeedbackEndTime() == null) ? 0 : getFeedbackEndTime().hashCode());
        result = prime * result + ((getFeedbackLoop() == null) ? 0 : getFeedbackLoop().hashCode());
        result = prime * result + ((getCostPrice() == null) ? 0 : getCostPrice().hashCode());
        result = prime * result + ((getMouthService() == null) ? 0 : getMouthService().hashCode());
        result = prime * result + ((getTaskList() == null) ? 0 : getTaskList().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIntroduction() == null) ? 0 : getIntroduction().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
}