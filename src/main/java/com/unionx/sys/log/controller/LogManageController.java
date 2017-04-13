package com.unionx.sys.log.controller;

import com.github.pagehelper.PageInfo;
import com.unionx.core.aop.business.BusinessLogAop;
import com.unionx.core.enums.StatusEnum;
import com.unionx.core.util.JsonUtils;
import com.unionx.core.util.ResponseUtils;
import com.unionx.core.vo.CommonResponse;
import com.unionx.core.vo.DataGridData;
import com.unionx.sys.log.service.BusinessLogService;
import com.unionx.sys.log.service.LoginLogService;
import com.unionx.sys.log.vo.SysLoginLog;
import com.unionx.sys.log.vo.SysOptLog;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/5/18.
 */
@Controller
@RequestMapping("/logManage")
@Slf4j
public class LogManageController {

    @Autowired
    private LoginLogService loginLogService;
    @Autowired
    private BusinessLogService businessLogService;

    /**
     * 返回登录日志页面
     * @return
     */
    @RequestMapping("returnLoginLog")
    public String returnLoginLog(HttpServletRequest request){
        request.setAttribute("statusEnum", JsonUtils.writeValueAsString(StatusEnum.toMap()));
        return "log/loginLog";
    }

    /**
     * 返回业务日志页面
     * @return
     */
    @RequestMapping("returnOperateLog")
    public String returnoperateLog(){
        return "log/operateLog";
    }

    /**
     * 登录日志列表查询
     * @author zhaihonghong
     * @param loginname 登录账号
     * @param createDateStart  时间段的开始值
     * @param createDateEnd 时间段的结束时间
     * @param page 页码
     * @param rows 行数
     * @return
     */
    @RequestMapping("getSysLoginLogListByParam")
    @ResponseBody
    public DataGridData<SysLoginLog> getSysLoginLogListByParam(String loginname,String createDateStart,String createDateEnd,int page,int rows){
        DataGridData<SysLoginLog> dataGridData = new DataGridData<>();
        PageInfo pageInfo = this.loginLogService.getSysLoginLogListByParam(loginname,createDateStart,createDateEnd,page,rows);
        dataGridData.setRows(pageInfo.getList());
        dataGridData.setTotal(pageInfo.getTotal());
        return dataGridData;
    }

    /**
     * 业务日志列表查询
     * @author zhaihonghong
     * @param loginname
     * @param createDateStart
     * @param createDateEnd
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("getSysOptLogListByParam")
    @ResponseBody
    public DataGridData<SysOptLog> getSysOptLogListByParam(String loginname, String createDateStart, String createDateEnd, int page, int rows){
        DataGridData<SysOptLog> dataGridData = new DataGridData<>();
        PageInfo pageInfo = this.businessLogService.getSysOptLogListByParam(loginname,createDateStart,createDateEnd,page,rows);
        dataGridData.setRows(pageInfo.getList());
        dataGridData.setTotal(pageInfo.getTotal());
        return dataGridData;
    }

    /**
     * 导出业务操作日志Excel表格
     * @param response
     * @param loginname
     * @param createDateStart
     * @param createDateEnd
     */
    @RequestMapping("exportOptLogOperateExcel")
    @ResponseBody
    public void exportOptLogOperateExcel(HttpServletResponse response,String loginname, String createDateStart, String createDateEnd){
        List<SysOptLog> logList = this.businessLogService.exportOptLogList(loginname,createDateStart,createDateEnd);
        //设置导出Excel的内容
        ExportParams exportParams = new ExportParams();
        exportParams.setTitle("业务操作日志");
        exportParams.setSheetName("业务操作日志");
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, SysOptLog.class, logList);
        //将数据写到输出流中
        try {
            ResponseUtils.writeExcel(response, workbook, "业务操作日志.xls");
        } catch (IOException e) {
            log.error("",e);
        }
    }
    /**
     * 导出登录日志Excel表格
     * @param response
     * @param loginname
     * @param createDateStart
     * @param createDateEnd
     */
    @RequestMapping("exportLoginLogOperateExcel")
    @ResponseBody
    public void exportLoginLogOperateExcel(HttpServletResponse response,String loginname, String createDateStart, String createDateEnd){
        List<SysLoginLog> logList = this.loginLogService.exportLoginLogList(loginname,createDateStart,createDateEnd);
        //设置导出Excel的内容
        ExportParams exportParams = new ExportParams();
        exportParams.setTitle("登录日志");
        exportParams.setSheetName("登录日志");
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, SysLoginLog.class, logList);
        //将数据写到输出流中
        try {
            ResponseUtils.writeExcel(response, workbook, "登录日志.xls");
        } catch (IOException e) {
            log.error("",e);
        }
    }

    /**
     * 删除登录日志
     * @author abner
     * @param id
     * @return
     */
    @BusinessLogAop("删除登录日志")
    @ResponseBody
    @RequestMapping("/removeLoginLog")
    public CommonResponse removeLoginLog(String id){
        CommonResponse commonResponse = new CommonResponse();
        try{
            loginLogService.removeLoginLog(id);
            commonResponse.setSuccess(true);
            commonResponse.setMessage(CommonResponse.DEL_SUCCESS);
        }catch (Exception e){
            log.error("",e);
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
        }
        return commonResponse;
    }

    /**
     * 删除业务日志
     * @author abner
     * @param id
     * @return
     */
    @BusinessLogAop("删除业务日志")
    @ResponseBody
    @RequestMapping("/removeOperateLog")
    public CommonResponse removeOperateLog(String id){
        CommonResponse commonResponse = new CommonResponse();
        try {
            businessLogService.removeOperateLog(id);
            commonResponse.setSuccess(true);
            commonResponse.setMessage(CommonResponse.DEL_SUCCESS);
        } catch (Exception e) {
            log.error("", e);
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
        }
        return commonResponse;
    }

}
