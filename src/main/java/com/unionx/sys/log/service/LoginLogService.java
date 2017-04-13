package com.unionx.sys.log.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unionx.core.util.DateUtils;
import com.unionx.sys.log.dao.SysLoginLogMapper;
import com.unionx.sys.log.dao.SysOptLogMapper;
import com.unionx.sys.log.vo.SysLoginLog;
import com.unionx.sys.log.vo.SysOptLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author zhaihonghong
 * @date 2016-05-18
 * 登录日志
 */
@Service
public class LoginLogService {

    @Autowired
    private SysLoginLogMapper sysLoginLogMapper;

    /**
     * 登录日志列表查询
     * @author zhaihonghong
     * @param loginname 登录账号
     * @param createDateStart  时间的开始值
     * @param createDateEnd  时间的结束值
     * @param page 页码
     * @param rows 显示记录数
     * @return
     */
    public PageInfo getSysLoginLogListByParam(String loginname,String createDateStart,String createDateEnd,int page,int rows){
        Date dateStart = DateUtils.stringToDate(createDateStart,"yyyy-MM-dd");
        Date dateEnd = DateUtils.getEndDatetime(createDateEnd,"yyyy-MM-dd");
        PageHelper.startPage(page,rows);
        List<SysLoginLog> list = this.sysLoginLogMapper.getSysLoginLogListByParam(loginname,dateStart,dateEnd);
        return new PageInfo(list);
    }

    /**
     * 保存登录日志
     * @param sysLoginLog
     * @author abner
     */
    public void saveLoginLog(SysLoginLog sysLoginLog){
        sysLoginLogMapper.saveSysLoginLog(sysLoginLog);
    }


    public List<SysLoginLog> exportLoginLogList(String loginname, String createDateStart, String createDateEnd) {
        Date dateStart = DateUtils.stringToDate(createDateStart,"yyyy-MM-dd");
        Date dateEnd = DateUtils.getEndDatetime(createDateEnd,"yyyy-MM-dd");
        List<SysLoginLog> list = this.sysLoginLogMapper.getSysLoginLogListByParam(loginname,dateStart,dateEnd);
        return list;
    }

    /**
     * 删除登录日志
     * @param id
     * @return
     * @author abner
     */
    public void removeLoginLog(String id) {
        this.sysLoginLogMapper.removeLoginLog(id);
    }
}
