package com.unionx.sys.log.dao;

import java.util.Date;
import java.util.List;
import com.unionx.sys.log.vo.SysOptLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * TODO
 * @author zhaihonghong
 * 业务日志
 */
@Repository
public interface SysOptLogMapper{   
    /**
     * 根据主键查询
     */
    public SysOptLog getSysOptLogById(@Param("id")String id); 

    /**
     * 查询出所有记录
     */
    public List<SysOptLog> findAllSysOptLog();    
    
    /**
     * 保存
     */
    public int saveSysOptLog(SysOptLog sysOptLog);
    
    /**
     * 根据主键更新（参数对象中的主键将作为更新条件）
     */
    public int updateSysOptLog(SysOptLog sysOptLog);
    
    /**
     * 根据主键删除
     */
    public int deleteSysOptLog(@Param("id")String id);

    List<SysOptLog> getSysOptLogListByParam(@Param("loginname") String loginname, @Param("dateStart") Date dateStart,
                                            @Param("dateEnd") Date dateEnd);

    /**
     * 删除业务日志
     *
     * @param id
     * @return
     * @author abner
     */
    void removeOperateLog(String id);
}

