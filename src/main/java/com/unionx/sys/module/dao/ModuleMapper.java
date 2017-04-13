package com.unionx.sys.module.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.unionx.sys.module.vo.Module;
import org.apache.ibatis.annotations.Param;

/**
 * 模块
 * @author song junjie
 */
 @Repository
public interface ModuleMapper{   
    /**
     * 根据主键查询
     */
    Module getModuleByCode(@Param("code")String code);

    /**
     * 查询出所有记录
     */
    List<Module> findAllModule();    
    
    /**
     * 保存
     */
    int saveModule(Module module);
    
    /**
     * 根据主键更新（参数对象中的主键将作为更新条件）
     */
    int updateModule(Module module);
    
    /**
     * 根据主键删除
     */
    int deleteModule(@Param("code")String code);

    /**
     * yw
     * @param roleId
     * @return
     */
    List<Module> getRoleAuthByRoleId(String roleId);

    /**
     * store
     * @param roleId
     * @return
     */
    List<Module> getStoreModuleByRoleId(@Param("roleId") String roleId);

    /**
     * 获取用户模块权限用于shiro
     *
     * @param userId
     * @return
     * @author abner
     */
    List<Module> getModuleList(@Param("userId") String userId);

    /**
     * 获取用户id 获取按钮权限
     * @param userId
     * @return
     * @author abner
     */
    List<String> getButtonList(@Param("userId") String userId);

    List<Module> findAllModuleBySystem(@Param("flg") String flg);

    /**
     * 获取用户模块权限用于shiro
     *
     * @return
     * @author abner
     */
    List<Module> getSysUserModuleList();

    /**
     * 获取用户id 获取按钮权限
     *
     * @return
     * @author abner
     */
    List<String> getSysUserButtonList();
}

