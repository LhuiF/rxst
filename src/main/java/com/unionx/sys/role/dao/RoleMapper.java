package com.unionx.sys.role.dao;

import java.util.List;

import com.unionx.sys.role.vo.Role;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;

/**
 * TODO
 * @author 
 */
 @Repository

public interface RoleMapper {
    /**
     * 根据主键查询
     */
    Role getSysRoleById(@Param("id") String id);

    /**
     * 查询出所有记录
     */
    List<Role> findAllSysRole();
    
    /**
     * 保存
     */
    int saveSysRole(Role sysRole);
    
    /**
     * 根据主键更新（参数对象中的主键将作为更新条件）
     */
    int updateSysRole(Role sysRole);
    
    /**
     * 根据主键删除
     */
    int deleteSysRole(@Param("id") String id);

    /**
     * 根据条件获得role对象
     * @param sysRole
     * @return
     */
    Role findSysRole(Role sysRole);

    /**
     * 根据id获得role
     * @param id
     * @return
     */
    Role getRoleById(String id);

    /**
     * 根据条件获得role
     * @param sysRole
     * @return
     */
    List<Role> findRoleByName(Role sysRole);

    List<String> findRoleName(@Param("roleIdList") List<String> roleIdList);
}

