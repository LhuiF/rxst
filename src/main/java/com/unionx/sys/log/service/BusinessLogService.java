package com.unionx.sys.log.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unionx.core.util.DateUtils;
import com.unionx.sys.log.dao.SysOptLogMapper;
import com.unionx.sys.log.vo.SysOptLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * 业务日志
 * @author abner
 * @date 2016-05-18
 */
@Service
public class BusinessLogService {

    @Autowired
    private SysOptLogMapper sysOptLogMapper;

    /**
     * 保存业务日志
     * @author abner
     * @param sysOptLog
     */
    public void saveBusinessLog(SysOptLog sysOptLog) {
        sysOptLogMapper.saveSysOptLog(sysOptLog);
    }

    public PageInfo getSysOptLogListByParam(String loginname, String createDateStart, String createDateEnd, int page, int rows) {
        Date dateStart = DateUtils.stringToDate(createDateStart,"yyyy-MM-dd");
        Date dateEnd = DateUtils.getEndDatetime(createDateEnd,"yyyy-MM-dd");
        PageHelper.startPage(page,rows);
        List<SysOptLog> list = this.sysOptLogMapper.getSysOptLogListByParam(loginname,dateStart,dateEnd);
        return new PageInfo(list);
    }

    public List<SysOptLog> exportOptLogList(String loginname, String createDateStart, String createDateEnd) {
        Date dateStart = DateUtils.stringToDate(createDateStart,"yyyy-MM-dd");
        Date dateEnd = DateUtils.getEndDatetime(createDateEnd,"yyyy-MM-dd");
        List<SysOptLog> list = this.sysOptLogMapper.getSysOptLogListByParam(loginname,dateStart,dateEnd);
        return list;
    }

    /**
     * 删除业务日志
     *
     * @param id
     * @return
     * @author abner
     */
    public void removeOperateLog(String id) {
        sysOptLogMapper.removeOperateLog(id);
    }
}
