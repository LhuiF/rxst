package com.unionx.web.accumulation.vo;

import java.io.Serializable;
import java.util.Date;

public class RsAccumulationFund implements Serializable {
    private Integer id;

    private String uuid;

    private String dictCode;

    private String dictName;

    private String fundYear;

    private Date startTime;

    private Date endTime;

    private String clearMonth;

    private Long averagePay;

    private String ceiling;

    private String ceilingBase;

    private String floorBase;

    private String yearCity;

    private String comment;

    private Boolean isdel;

    private String createName;

    private Date createDate;

    private String updateName;

    private Date updateDate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getFundYear() {
        return fundYear;
    }

    public void setFundYear(String fundYear) {
        this.fundYear = fundYear;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getClearMonth() {
        return clearMonth;
    }

    public void setClearMonth(String clearMonth) {
        this.clearMonth = clearMonth;
    }

    public Long getAveragePay() {
        return averagePay;
    }

    public void setAveragePay(Long averagePay) {
        this.averagePay = averagePay;
    }

    public String getCeiling() {
        return ceiling;
    }

    public void setCeiling(String ceiling) {
        this.ceiling = ceiling;
    }

    public String getCeilingBase() {
        return ceilingBase;
    }

    public void setCeilingBase(String ceilingBase) {
        this.ceilingBase = ceilingBase;
    }

    public String getFloorBase() {
        return floorBase;
    }

    public void setFloorBase(String floorBase) {
        this.floorBase = floorBase;
    }

    public String getYearCity() {
        return yearCity;
    }

    public void setYearCity(String yearCity) {
        this.yearCity = yearCity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getIsdel() {
        return isdel;
    }

    public void setIsdel(Boolean isdel) {
        this.isdel = isdel;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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
        RsAccumulationFund other = (RsAccumulationFund) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getDictCode() == null ? other.getDictCode() == null : this.getDictCode().equals(other.getDictCode()))
            && (this.getDictName() == null ? other.getDictName() == null : this.getDictName().equals(other.getDictName()))
            && (this.getFundYear() == null ? other.getFundYear() == null : this.getFundYear().equals(other.getFundYear()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getClearMonth() == null ? other.getClearMonth() == null : this.getClearMonth().equals(other.getClearMonth()))
            && (this.getAveragePay() == null ? other.getAveragePay() == null : this.getAveragePay().equals(other.getAveragePay()))
            && (this.getCeiling() == null ? other.getCeiling() == null : this.getCeiling().equals(other.getCeiling()))
            && (this.getCeilingBase() == null ? other.getCeilingBase() == null : this.getCeilingBase().equals(other.getCeilingBase()))
            && (this.getFloorBase() == null ? other.getFloorBase() == null : this.getFloorBase().equals(other.getFloorBase()))
            && (this.getYearCity() == null ? other.getYearCity() == null : this.getYearCity().equals(other.getYearCity()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()))
            && (this.getIsdel() == null ? other.getIsdel() == null : this.getIsdel().equals(other.getIsdel()))
            && (this.getCreateName() == null ? other.getCreateName() == null : this.getCreateName().equals(other.getCreateName()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateName() == null ? other.getUpdateName() == null : this.getUpdateName().equals(other.getUpdateName()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getDictCode() == null) ? 0 : getDictCode().hashCode());
        result = prime * result + ((getDictName() == null) ? 0 : getDictName().hashCode());
        result = prime * result + ((getFundYear() == null) ? 0 : getFundYear().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getClearMonth() == null) ? 0 : getClearMonth().hashCode());
        result = prime * result + ((getAveragePay() == null) ? 0 : getAveragePay().hashCode());
        result = prime * result + ((getCeiling() == null) ? 0 : getCeiling().hashCode());
        result = prime * result + ((getCeilingBase() == null) ? 0 : getCeilingBase().hashCode());
        result = prime * result + ((getFloorBase() == null) ? 0 : getFloorBase().hashCode());
        result = prime * result + ((getYearCity() == null) ? 0 : getYearCity().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        result = prime * result + ((getIsdel() == null) ? 0 : getIsdel().hashCode());
        result = prime * result + ((getCreateName() == null) ? 0 : getCreateName().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateName() == null) ? 0 : getUpdateName().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        return result;
    }
}