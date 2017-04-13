package com.unionx.sys.region.vo;

import lombok.Data;
import java.util.Date;

/**
 * @author   Yanli Yang
 */
@Data
public class SysRegion{
    /**
     * 
     */
    private String id;
    /**
     * 代码
     */
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 上级id
     */
    private String parentId;
    /**
     * 级别
     */
    private Integer level;
    /**
     * 排序号
     */
    private Integer orderNo;
    /**
     * 英文名字
     */
    private String nameEn;
    /**
     * 英文名字简写
     */
    private String shortnameEn;

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
     * 上级id
     */
    public String getParentId(){
        return this.parentId;
    }

    /**
     * 上级id
     */
    public void setParentId(String parentId){
        this.parentId = parentId;
    }    
    /**
     * 级别
     */
    public Integer getLevel(){
        return this.level;
    }

    /**
     * 级别
     */
    public void setLevel(Integer level){
        this.level = level;
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
     * 英文名字
     */
    public String getNameEn(){
        return this.nameEn;
    }

    /**
     * 英文名字
     */
    public void setNameEn(String nameEn){
        this.nameEn = nameEn;
    }    
    /**
     * 英文名字简写
     */
    public String getShortnameEn(){
        return this.shortnameEn;
    }

    /**
     * 英文名字简写
     */
    public void setShortnameEn(String shortnameEn){
        this.shortnameEn = shortnameEn;
    }    
}