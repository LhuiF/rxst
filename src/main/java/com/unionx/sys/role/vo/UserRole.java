package com.unionx.sys.role.vo;

import lombok.Data;
import java.util.Date;

/**
 *
 * @author 
 */
@Data
public class UserRole {
    /**
     * 用id
     */
    private String userId;
    /**
     * 角色id
     */
    private String roleId;
    /**
     * 最后修改时间
     */
    private Date updateDatatime;
    /**
     * 最后操作人id
     */
    private String updateUserId;

    /**
     * 用id
     */
    public String getUserId(){
        return this.userId;
    }

    /**
     * 用id
     */
    public void setUserId(String userId){
        this.userId = userId;
    }    
    /**
     * 角色id
     */
    public String getRoleId(){
        return this.roleId;
    }

    /**
     * 角色id
     */
    public void setRoleId(String roleId){
        this.roleId = roleId;
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