package com.unionx.web.insurance.vo;

import java.io.Serializable;

public class RsInsuranceBase implements Serializable {
    private Integer id;

    private String insuranceUuid;

    private String dictCode;

    private String dictName;

    private Double ceiling;

    private Double floor;

    private Double ceilingBase;

    private Double floorBase;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInsuranceUuid() {
        return insuranceUuid;
    }

    public void setInsuranceUuid(String insuranceUuid) {
        this.insuranceUuid = insuranceUuid;
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

    public Double getCeiling() {
        return ceiling;
    }

    public void setCeiling(Double ceiling) {
        this.ceiling = ceiling;
    }

    public Double getFloor() {
        return floor;
    }

    public void setFloor(Double floor) {
        this.floor = floor;
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
        RsInsuranceBase other = (RsInsuranceBase) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInsuranceUuid() == null ? other.getInsuranceUuid() == null : this.getInsuranceUuid().equals(other.getInsuranceUuid()))
            && (this.getDictCode() == null ? other.getDictCode() == null : this.getDictCode().equals(other.getDictCode()))
            && (this.getDictName() == null ? other.getDictName() == null : this.getDictName().equals(other.getDictName()))
            && (this.getCeiling() == null ? other.getCeiling() == null : this.getCeiling().equals(other.getCeiling()))
            && (this.getFloor() == null ? other.getFloor() == null : this.getFloor().equals(other.getFloor()))
            && (this.getCeilingBase() == null ? other.getCeilingBase() == null : this.getCeilingBase().equals(other.getCeilingBase()))
            && (this.getFloorBase() == null ? other.getFloorBase() == null : this.getFloorBase().equals(other.getFloorBase()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getInsuranceUuid() == null) ? 0 : getInsuranceUuid().hashCode());
        result = prime * result + ((getDictCode() == null) ? 0 : getDictCode().hashCode());
        result = prime * result + ((getDictName() == null) ? 0 : getDictName().hashCode());
        result = prime * result + ((getCeiling() == null) ? 0 : getCeiling().hashCode());
        result = prime * result + ((getFloor() == null) ? 0 : getFloor().hashCode());
        result = prime * result + ((getCeilingBase() == null) ? 0 : getCeilingBase().hashCode());
        result = prime * result + ((getFloorBase() == null) ? 0 : getFloorBase().hashCode());
        return result;
    }
}