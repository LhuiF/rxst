package com.unionx.sys.region.dao;

import com.unionx.sys.region.vo.SysRegion;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Yanli Yang
 */
 @Repository
public interface SysRegionMapper{
    /**
     * 根据主键查询
     */
    public SysRegion getSysRegionById(@Param("id") String id);

    /**
     * 查询出所有记录
     */
    public List<SysRegion> findAllSysRegion();

    /**
     * 保存
     */
    public int saveSysRegion(SysRegion sysRegion);

    /**
     * 根据主键更新（参数对象中的主键将作为更新条件）
     */
    public int updateSysRegion(SysRegion sysRegion);

    /**
     * 根据主键删除
     */
    public int deleteSysRegion(@Param("id") String id);

    /**
     * 通过父Id获取区域
     * @param parentId
     * @return
     */
    public List<SysRegion> getRegionByParentId(@Param("parentId") String parentId);
}

