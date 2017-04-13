package com.unionx.sys.role.dao;

import java.util.List;

import com.unionx.sys.role.vo.UserRole;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @xuchengbin
 */
 @Repository
public interface UserRoleMapper{   
    /**
     * 根据主键查询
     */
    UserRole getUserRoleById(@Param("roleId") String roleId
            , @Param("userId") String userId);

    /**
     * 查询出所有记录
     */
    List<UserRole> findAllUserRole();    
    
    /**
     * 保存
     */
    int saveUserRole(UserRole userRole);
    
    /**
     * 根据主键更新（参数对象中的主键将作为更新条件）
     */
    int updateUserRole(UserRole userRole);
    
    /**
     * 根据主键删除
     */
    int deleteUserRole(@Param("userId") String userId);
    /*

     */
    List<String> findByRoleList(@Param("userId") String userId);

    UserRole getSysUserByRoleId(@Param("roleId") String roleId);
}

