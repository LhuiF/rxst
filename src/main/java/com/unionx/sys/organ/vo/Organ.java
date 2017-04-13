package com.unionx.sys.organ.vo;

import org.springframework.stereotype.Repository;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author songjunjie
 */
@Data
public class Organ{
    /**
     * 
     */
    private String id;
    /**
     * 机构名称
     */
    private String name;
    /**
     * 机构编码
     */
    private String code;
    /**
     * 联系人
     */
    private String contactPerson;
    /**
     * 联系电话
     */
    private String tel;
    /**
     * 备注
     */
    private String remark;
    /**
     * 地址
     */
    private String address;
    /**
     * 网址
     */
    private String website;
    /**
     * 删除标志 1删除 0未删除
            
     */
    private Integer deleted;
    /**
     * 机构类型1 机构 2部门
     */
    private Integer type;
    /**
     * 简拼
     */
    private String jianpin;
    /**
     * 层级码
     */
    private String tierCode;
    /**
     * 上级机构id
     */
    private String parentId;
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
     * 注册时间
     */
    private Date createDatatime;

    private List<Organ> children = new ArrayList<>();

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
     * 机构名称
     */
    public String getName(){
        return this.name;
    }

    /**
     * 机构名称
     */
    public void setName(String name){
        this.name = name;
    }    
    /**
     * 机构编码
     */
    public String getCode(){
        return this.code;
    }

    /**
     * 机构编码
     */
    public void setCode(String code){
        this.code = code;
    }    
    /**
     * 联系人
     */
    public String getContactPerson(){
        return this.contactPerson;
    }

    /**
     * 联系人
     */
    public void setContactPerson(String contactPerson){
        this.contactPerson = contactPerson;
    }    
    /**
     * 联系电话
     */
    public String getTel(){
        return this.tel;
    }

    /**
     * 联系电话
     */
    public void setTel(String tel){
        this.tel = tel;
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
     * 地址
     */
    public String getAddress(){
        return this.address;
    }

    /**
     * 地址
     */
    public void setAddress(String address){
        this.address = address;
    }    
    /**
     * 网址
     */
    public String getWebsite(){
        return this.website;
    }

    /**
     * 网址
     */
    public void setWebsite(String website){
        this.website = website;
    }    
    /**
     * 删除标志 1删除 0未删除
            
     */
    public Integer getDeleted(){
        return this.deleted;
    }

    /**
     * 删除标志 1删除 0未删除
            
     */
    public void setDeleted(Integer deleted){
        this.deleted = deleted;
    }    
    /**
     * 机构类型1 机构 2部门
     */
    public Integer getType(){
        return this.type;
    }

    /**
     * 机构类型1 机构 2部门
     */
    public void setType(Integer type){
        this.type = type;
    }    
    /**
     * 简拼
     */
    public String getJianpin(){
        return this.jianpin;
    }

    /**
     * 简拼
     */
    public void setJianpin(String jianpin){
        this.jianpin = jianpin;
    }    
    /**
     * 层级码
     */
    public String getTierCode(){
        return this.tierCode;
    }

    /**
     * 层级码
     */
    public void setTierCode(String tierCode){
        this.tierCode = tierCode;
    }    
    /**
     * 上级机构id
     */
    public String getParentId(){
        return this.parentId;
    }

    /**
     * 上级机构id
     */
    public void setParentId(String parentId){
        this.parentId = parentId;
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
    /**
     * 注册时间
     */
    public Date getCreateDatatime(){
        return this.createDatatime;
    }

    /**
     * 注册时间
     */
    public void setCreateDatatime(Date createDatatime){
        this.createDatatime = createDatatime;
    }    
}