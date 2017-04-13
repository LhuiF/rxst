package com.unionx.sys.auth.service;

import com.unionx.sys.module.dao.ModuleMapper;
import com.unionx.sys.module.vo.Module;
import com.unionx.sys.role.dao.RoleAuthMapper;
import com.unionx.sys.role.dao.RoleMapper;
import com.unionx.sys.role.vo.Role;
import com.unionx.sys.role.vo.RoleAuth;
import com.unionx.sys.user.vo.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author rjm
 */
@Service
public class AuthServiceImpl {

    @Autowired
    private RoleAuthMapper roleAuthManager;
    @Autowired
    private ModuleMapper moduleMapper;
    @Autowired
    private RoleMapper sysRoleMapper;

    /**
     * 根据角色找权限模块
     * @param roleId
     * @return
     */
    public List<Module> getByRoleId(String roleId) {
        List<Module> list =moduleMapper.getRoleAuthByRoleId(roleId);
        return list;
    }

    /**
     * 查询所有角色
     * @return
     */
    public List<Role> findAllSysRole() {
        List<Role> allSysRole = sysRoleMapper.findAllSysRole();
        return allSysRole;
    }

    /**
     * 保存角色权限关系
     * @param dataS
     */
    @Transactional
    public void saveRoleAuth(String[] dataS,String roleId) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        // 删除原来的关系
        int x =roleAuthManager.deleteByRoleId(roleId);
        //插入
        if(null != dataS){
            for (int i=0;i<dataS.length;i++) {
                String d =dataS[i];
                RoleAuth ra= new RoleAuth();
                ra.setRoleId(roleId);
                ra.setModuleCode(d);
                ra.setUpdateDatatime(new Date());
                ra.setUpdateUserId(user.getId());
                int y =roleAuthManager.saveRoleAuth(ra);
            }
        }
    }

}
