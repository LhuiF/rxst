package com.unionx.sys.role.vo;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author 
 */
@Data
public class Role {
    /**
     * 
     */
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 代码
     */
    private String code;
    /**
     * 备注
     */
    private String remark;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 操作人
     */
    private String optUserId;
    /**
     * 1、正常；0、删除；默认为正常
     */
    private Short isDelete;
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
    public String getId(){
        return this.id;
    }

    /**
     * 
     */
    public void setId(String id){
        this.id = id;
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
     * 代码
     */
    public String getCode(){
        return this.code;
    }

    /**
     * 代码
     */
    public void setCode(String code){
        this.code = code;
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
     * 更新时间
     */
    public Date getUpdateTime(){
        return this.updateTime;
    }

    /**
     * 更新时间
     */
    public void setUpdateTime(Date updateTime){
        this.updateTime = updateTime;
    }    
    /**
     * 操作人
     */
    public String getOptUserId(){
        return this.optUserId;
    }

    /**
     * 操作人
     */
    public void setOptUserId(String optUserId){
        this.optUserId = optUserId;
    }    
    /**
     * 1、正常；0、删除；默认为正常
     */
    public Short getIsDelete(){
        return this.isDelete;
    }

    /**
     * 1、正常；0、删除；默认为正常
     */
    public void setIsDelete(Short isDelete){
        this.isDelete = isDelete;
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