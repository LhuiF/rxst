package com.unionx.base.material.vo;

import java.io.Serializable;
import java.util.Date;

import org.jeecgframework.poi.excel.annotation.Excel;

import lombok.Data;

import com.unionx.sys.log.vo.SysLoginLog;

@Data
public class SysMaterial implements Serializable {
    private String id;

    private String uuid;//产品的uuid

   
    private String qu;//区
    @Excel(name = "区", orderNum = "0")
    private String quName;//区名称
    
    private String createUserName;//创建人姓名
    
    @Excel(name = "产品名称",orderNum = "2")
    private String proName;//产品名称
    
    @Excel(name = "业务类型",replace = {"社保_001","公积金_002"}, orderNum = "1")
    private String typeId;//业务类型

   
    private String productName;//产品id

    @Excel(name = "有无材料",replace = {"需要_1","不需要_2"}, orderNum = "3")
    private Integer isMaterial;//有无材料

    @Excel(name = "是否网申",replace = {"是_1","否_2"}, orderNum = "4")
    private Integer isApply;//是否网申

    @Excel(name = "创建时间",exportFormat = "yyyy/MM/dd", orderNum = "5")
    private Date createTime;//创建时间

    @Excel(name = "创建人", orderNum = "6")
    private String createUserId;//创建人的id

    @Excel(name = "备注", orderNum = "7")
    private String remark;

    @Excel(name = "符合条件", orderNum = "8")
    private String condition01;//条件

    @Excel(name = "所需材料", orderNum = "9")
    private String conditon01;//材料

    private String marerialRequest;

    private String fenshu;

    private String str03;

    private static final long serialVersionUID = 1L;

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

    public String getCondition01() {
        return condition01;
    }

    public void setCondition01(String condition01) {
        this.condition01 = condition01;
    }

    public String getConditon01() {
        return conditon01;
    }

    public void setConditon01(String conditon01) {
        this.conditon01 = conditon01;
    }

    public String getMarerialRequest() {
        return marerialRequest;
    }

    public void setMarerialRequest(String marerialRequest) {
        this.marerialRequest = marerialRequest;
    }

    public String getFenshu() {
        return fenshu;
    }

    public void setFenshu(String fenshu) {
        this.fenshu = fenshu;
    }

    public String getStr03() {
        return str03;
    }

    public void setStr03(String str03) {
        this.str03 = str03;
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
        SysMaterial other = (SysMaterial) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getQu() == null ? other.getQu() == null : this.getQu().equals(other.getQu()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getIsMaterial() == null ? other.getIsMaterial() == null : this.getIsMaterial().equals(other.getIsMaterial()))
            && (this.getIsApply() == null ? other.getIsApply() == null : this.getIsApply().equals(other.getIsApply()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCondition01() == null ? other.getCondition01() == null : this.getCondition01().equals(other.getCondition01()))
            && (this.getConditon01() == null ? other.getConditon01() == null : this.getConditon01().equals(other.getConditon01()))
            && (this.getMarerialRequest() == null ? other.getMarerialRequest() == null : this.getMarerialRequest().equals(other.getMarerialRequest()))
            && (this.getFenshu() == null ? other.getFenshu() == null : this.getFenshu().equals(other.getFenshu()))
            && (this.getStr03() == null ? other.getStr03() == null : this.getStr03().equals(other.getStr03()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getQu() == null) ? 0 : getQu().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getIsMaterial() == null) ? 0 : getIsMaterial().hashCode());
        result = prime * result + ((getIsApply() == null) ? 0 : getIsApply().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCondition01() == null) ? 0 : getCondition01().hashCode());
        result = prime * result + ((getConditon01() == null) ? 0 : getConditon01().hashCode());
        result = prime * result + ((getMarerialRequest() == null) ? 0 : getMarerialRequest().hashCode());
        result = prime * result + ((getFenshu() == null) ? 0 : getFenshu().hashCode());
        result = prime * result + ((getStr03() == null) ? 0 : getStr03().hashCode());
        return result;
    }
}