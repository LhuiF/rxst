package com.unionx.sys.region.service;

import com.unionx.sys.region.dao.SysRegionMapper;
import com.unionx.sys.region.vo.SysRegion;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能：地区功能
 * Author:Yang yanli
 */
@Service
public class SysRegionService {
    @Autowired
    private SysRegionMapper sysRegionMapper;
    /**
     * 根据主键查询
     */
    public SysRegion getSysRegionById(String id){
        return this.sysRegionMapper.getSysRegionById(id);
    }

    /**
     * 查询出所有记录
     */
    public List<SysRegion> findAllSysRegion(){
        return this.sysRegionMapper.findAllSysRegion();
    }

    /**
     * 保存
     */
    public int saveSysRegion(SysRegion sysRegion){
        return this.sysRegionMapper.saveSysRegion(sysRegion);
    }

    /**
     * 根据主键更新（参数对象中的主键将作为更新条件）
     */
    public int updateSysRegion(SysRegion sysRegion){
        return this.sysRegionMapper.updateSysRegion(sysRegion);
    }

    /**
     * 根据主键删除
     */
    public int deleteSysRegion(String id){
        return this.sysRegionMapper.deleteSysRegion(id);
    }

     /**
     * 通过父Id获取区域
     * @param parentId
     * @return
     */
    public List<SysRegion> getRegionByParentId(String parentId){
        return this.sysRegionMapper.getRegionByParentId(parentId);
    }
}
