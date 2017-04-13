package com.unionx.core.vo;

import lombok.Data;

/**
 * ajax请求时，返回给前端数据的封装
 *
 * @author song junjie
 */
@Data
public class CommonResponse {

    //=======常量============
    /**
     * 店关闭
     */
    public static final String STORE_CLOSE = "店家已关闭，帐号无效";
    /**
     * 店冻结
     */
    public static final String STORE_FREEZE = "用户帐号已冻结";
    /**
     * 店未审核
     */
    public static final String STORE_UNAUDITED_CHECK = "帐号正在审核，请耐心等待";
    /**
     * 店审核不通过
     */
    public static final String STORE_NO_PASS = "STORE_NO_PASS";
    /**
     * 系统异常
     */
    public static final String SYS_EXCEPTION = "系统错误";
    /**
     * 保存成功
     */
    public static final String SAVE_SUCCESS = "保存成功";
    /**
     * 编辑成功
     */
    public static final String EDIT_SUCCESS = "保存成功";
    /**
     * 删除成功
     */
    public static final String DEL_SUCCESS = "删除成功";

    /**
     * 操作失败
     */
    public static final String OPT_FAILED = "操作失败";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAILED = "账号或密码错误,请重新输入";

    /**
     * 查询成功
     */
    public static final String QUERY_SUCCESS = "查询成功";

     /**
     * 查询失败
     */
    public static final String QUERY_FAILED = "查询失败";
    /**
     * 修改密码失败
     */
    public static final String UPDATE_PASSWORD_SUCCESS = "修改密码成功！";
    /**
     * 修改密码失败
     */
    public static final String UPDATE_PASSWORD_EXCEPTION = "原密码错误，修改密码失败！";
    //=======================
    /**
     * 操作结果
     */
    private boolean success;
    /**
     * 提示信息
     */
    private String message;

    /**
     * 业务数据
     */
    private Object data;


    public CommonResponse() {

    }

    public CommonResponse(boolean success) {
        this.success = success;
    }

    public CommonResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public CommonResponse(boolean success, String message,Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
    
    
}
