package com.unionx.sys.dict.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author   Yanli Yang
 */
@Data
public class DictItem{
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
     * 备注
     */
    private String remark;
    /**
     * 字典id
     */
    private String dataDictCode;
    /**
     * 排序号
     */
    private Integer orderNo;
    /**
     * 最后操作人id
     */
    private String updateUserId;
    /**
     * 最后修改时间
     */
    private Date updateDatatime;
	


    
    
}