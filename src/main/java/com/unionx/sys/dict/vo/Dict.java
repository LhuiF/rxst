package com.unionx.sys.dict.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author   Yanli Yang
 */
@Data
public class Dict{
    /**
     *
     */
    private String dictCode;
    /**
     * 名称
     */
    private String name;
    /**
     * 备注
     */
    private String remark;
    /**
     * 排序号
     */
    private Integer orderNo;
    /**
     * 最后修改时间
     */
    private Date updateDatatime;
    /**
     * 最后操作人id
     */
    private String updateUserId;

    /**
     *
     */
    public String getDictCode(){
        return this.dictCode;
    }

    /**
     *
     */
    public void setDictCode(String dictCode){
        this.dictCode = dictCode;
    }
    /**
     * 名称
     */
    public String getName(){
        return this.name;
    }

    /**
     * 名称
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * 备注
     */
    public String getRemark(){
        return this.remark;
    }

    /**
     * 备注
     */
    public void setRemark(String remark){
        this.remark = remark;
    }
    /**
     * 排序号
     */
    public Integer getOrderNo(){
        return this.orderNo;
    }

    /**
     * 排序号
     */
    public void setOrderNo(Integer orderNo){
        this.orderNo = orderNo;
    }
    /**
     * 最后修改时间
     */
    public Date getUpdateDatatime(){
        return this.updateDatatime;
    }

    /**
     * 最后修改时间
     */
    public void setUpdateDatatime(Date updateDatatime){
        this.updateDatatime = updateDatatime;
    }
    /**
     * 最后操作人id
     */
    public String getUpdateUserId(){
        return this.updateUserId;
    }

    /**
     * 最后操作人id
     */
    public void setUpdateUserId(String updateUserId){
        this.updateUserId = updateUserId;
    }
}