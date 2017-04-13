package com.unionx.sys.log.vo;

import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;

import java.util.Date;

/**
 *
 * @author 
 */
@Data
public class SysLoginLog{
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
     * 用户姓名
     */
    @Excel(name = "登录姓名",orderNum = "2")
    private String name;
    /**
     * 登录时间
     */
    @Excel(name = "登录时间",exportFormat = "yyyy/MM/dd", orderNum = "4")
    private Date loginDatatime;
    /**
     * ip地址
     */
    @Excel(name = "登录IP", orderNum = "5")
    private String ip;
    /**
     * 登录状态
     */
    @Excel(name = "登录状态",replace = {"成功_0","失败_1","方法异常_2"}, orderNum = "3")
    private String status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getLoginDatatime() {
		return loginDatatime;
	}
	public void setLoginDatatime(Date loginDatatime) {
		this.loginDatatime = loginDatatime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

    
    
    
}