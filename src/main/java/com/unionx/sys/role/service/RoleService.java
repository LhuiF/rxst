package com.unionx.sys.role.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unionx.core.util.Identities;
import com.unionx.sys.role.dao.RoleMapper;
import com.unionx.sys.role.dao.UserRoleMapper;
import com.unionx.sys.role.vo.Role;
import com.unionx.sys.role.vo.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yangxiao.
 * date:2016/5/16
 */
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 根据主键查询
     */
    public Role getSysRoleById(String id){
        return roleMapper.getSysRoleById(id);
    }

    /**
     * 查询出所有记录
     */
    public List<Role> findAllSysRole(){

        return roleMapper.findAllSysRole();
    }

    /**

     * 保存信息
     * @param sysRole
     */
    public void saveRole(Role sysRole){
//        String id = UUID.randomUUID().toString().replace("-","");
        sysRole.setId(Identities.uuid());
        sysRole.setUpdateTime(new Date());
        roleMapper.saveSysRole(sysRole);
    }

    /**
     * 获得列表
     * @return
     */
    public PageInfo<Role> getList(Role sysRole, int page, int rows){
        PageHelper.startPage(page,rows);
        List<Role> list = new ArrayList<Role>();
        list = roleMapper.findRoleByName(sysRole);
        return new PageInfo(list);
    }

    /**
     * 验证
     * @return
     */
    public boolean validate(Role sysRole){
        Role sr = new Role();
        Boolean b = false;
        String id = "";
        if(sysRole != null){
            id = sysRole.getId();
        }

        //数据库没此数据 true
        //有数据false
        if(!"".equals(id) && id != null){
            //编辑验证
            sr = roleMapper.findSysRole(sysRole);
            if(sr != null){
                id = sr.getId();
                b = sysRole.getId().equals(id);
            }else{
                b = true;
            }
        }else{
            //新增验证
            sr = roleMapper.findSysRole(sysRole);
            if(sr == null){
                b = true;
            }
        }

        return b;
    }

    /**
     * 根据Id获得role对象
     * @param id
     * @return
     */
    public Role getRoleById(String id){
        Role sysRole = new Role();
        sysRole = roleMapper.getRoleById(id);
        return sysRole;

    }

    /**
     * 编辑角色信息
     * @param sysRole
     */
    public void updateRole(Role sysRole){

        roleMapper.updateSysRole(sysRole);
    }

    /**
     * 根据id删除role
     * @param roleId
     * @return
     */
    public boolean deleteRoleById(String roleId){
        boolean b = false;
        UserRole userRole = null;
        userRole = userRoleMapper.getSysUserByRoleId(roleId);
        if(userRole != null ){
            b = true;
        }else{
            roleMapper.deleteSysRole(roleId);
        }
        return b;
    }

    /**
     * 根据条件获得role对象
     * @param sysRole
     * @return
     */
    public Role findSysRole(Role sysRole){
        return roleMapper.findSysRole(sysRole);
    }


    /**
     * 根据条件获得role
     * @param sysRole
     * @return
     */
    public List<Role> findRoleByName(Role sysRole){
        return roleMapper.findRoleByName(sysRole);
    }


    public List<String> findRoleName(List<String> roleIdList) {
            return roleMapper.findRoleName(roleIdList);
    }
}
