package com.unionx.sys.prompt.vo;

import lombok.Data;
import java.util.Date;
/**
 *
 * @author 
 */
@Data
public class Prompt{
    /**
     * 
     */
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 编码
     */
    private String code;
    /**
     * 内容
     */
    private String content;
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
     * 编码
     */
    public String getCode(){
        return this.code;
    }

    /**
     * 编码
     */
    public void setCode(String code){
        this.code = code;
    }    
    /**
     * 内容
     */
    public String getContent(){
        return this.content;
    }

    /**
     * 内容
     */
    public void setContent(String content){
        this.content = content;
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