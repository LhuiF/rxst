package com.unionx.sys.role.service;

import com.unionx.sys.role.dao.UserRoleMapper;
import com.unionx.sys.role.vo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author  yangxiao.
 * date:2016/5/19
 */
@Service
public class UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 根据主键查询
     */
    public UserRole getSysUserRoleById(String roleId, String userId){
        return userRoleMapper.getUserRoleById(roleId,userId);
    }

    /**
     * 查询出所有记录
     */
    public List<UserRole> findAllSysUserRole(){
        return userRoleMapper.findAllUserRole();
    }

    /**
     * 保存
     */
    public int saveSysUserRole(UserRole userRole){
        return saveSysUserRole(userRole);
    }

    /**
     * 根据主键更新（参数对象中的主键将作为更新条件）
     */
    public int updateSysUserRole(UserRole userRole){
        return userRoleMapper.updateUserRole(userRole);
    }

    /**
     * 根据主键删除
     */
    public int deleteUserRole(String userId){
        return userRoleMapper.deleteUserRole(userId);
    }

    /**
     * 根据roleId查询用户
     * @param roleId
     * @return
     */
    public UserRole getSysUserByRoleId(String roleId){
        return userRoleMapper.getSysUserByRoleId(roleId);
    }

}
