package com.unionx.sys.log.vo;

import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;

import java.util.Date;

/**
 *
 * @author 
 */
@Data
public class SysOptLog{
    /**
     * 
     */
    private String id;
    /**
     * 登录人id
     */
    private String userId;
    /**
     * 登录人账号
     */
    @Excel(name = "登录帐号", orderNum = "1")
    private String loginname;
    /**
     * 操作人姓名
     */
    @Excel(name = "登录姓名", orderNum = "2")
    private String username;
    /**
     * 操作名
     */
    @Excel(name = "操作名", orderNum = "3")
    private String optName;
    /**
     * ip地址
     */
    @Excel(name = "登录IP", orderNum = "6")
    private String ip;
    /**
     * 详情
     */
    @Excel(name = "操作内容", orderNum = "4")
    private String details;
    /**
     * 耗时 毫秒
     */
    private Integer timeConsuming;
    /**
     * 操作日期
     */
    @Excel(name = "操作时间",exportFormat = "yyyy/MM/dd", orderNum = "5")
    private Date optDate;
    /**
     * 操作状态
     */
    private String optStatus;
    
	
    
}