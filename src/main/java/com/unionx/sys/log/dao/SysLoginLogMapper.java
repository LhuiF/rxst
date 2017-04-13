package com.unionx.sys.log.dao;

import java.util.Date;
import java.util.List;
import com.unionx.sys.log.vo.SysLoginLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * TODO
 * @author zhaihonghong
 * @data 2016-05-18
 */
@Repository
public interface SysLoginLogMapper{   
    /**
     * 根据主键查询
     */
    public SysLoginLog getSysLoginLogById(@Param("id")String id); 

    /**
     * 查询出所有记录
     */
    public List<SysLoginLog> findAllSysLoginLog();    
    
    /**
     * 保存
     */
    public int saveSysLoginLog(SysLoginLog sysLoginLog);
    
    /**
     * 根据主键更新（参数对象中的主键将作为更新条件）
     */
    public int updateSysLoginLog(SysLoginLog sysLoginLog);
    
    /**
     * 根据主键删除
     */
    public int deleteSysLoginLog(@Param("id")String id);

    /**
     * 登录日志列表查询
     * @author zhaihonghong
     * @param loginname 登录账号
     * @param dateStart 开始值
     * @param dateEnd 结束值
     * @return
     */
    List<SysLoginLog> getSysLoginLogListByParam(@Param("loginname") String loginname, @Param("dateStart") Date dateStart,
                                                @Param("dateEnd") Date dateEnd);

    /**
     * 删除登录日志
     *
     * @param id
     * @return
     * @author abner
     */
    void removeLoginLog(@Param("id") String id);
}

