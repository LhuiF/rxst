package com.unionx.sys.user.vo;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author xuchengbin
 */
@Data
public class UserStoreRelation{
    /**
     * 主键id
     */
    private String id;
    /**
     * 一龄用户id
     */
    private String sysUserId;
    /**
     * 店家id
     */
    private String storeId;
    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 主键id
     */
    public String getId(){
        return this.id;
    }

    /**
     * 主键id
     */
    public void setId(String id){
        this.id = id;
    }    
    /**
     * 一龄用户id
     */
    public String getSysUserId(){
        return this.sysUserId;
    }

    /**
     * 一龄用户id
     */
    public void setSysUserId(String sysUserId){
        this.sysUserId = sysUserId;
    }    
    /**
     * 店家id
     */
    public String getStoreId(){
        return this.storeId;
    }

    /**
     * 店家id
     */
    public void setStoreId(String storeId){
        this.storeId = storeId;
    }    
    /**
     * 创建时间
     */
    public Date getCreateDate(){
        return this.createDate;
    }

    /**
     * 创建时间
     */
    public void setCreateDate(Date createDate){
        this.createDate = createDate;
    }    
}