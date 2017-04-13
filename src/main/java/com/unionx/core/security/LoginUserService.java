package com.unionx.core.security;

import java.util.Set;

/**
 * 登陆用户服务
 * @author songjunjie
 */
public interface LoginUserService {

    /**
     * 根据用户
     * @return
     */
    String getPasswordByLoginname(String loginname);

    /**
     * 得到角色列表。列表中保存的是角色的字符标识
     * @param loginname
     * @return
     */
    Set<String> getRoles(String loginname);

    /**
     * 得到权限列表
     * @param loginname
     * @return
     */
    Set<String> getPermissions(String loginname);
}
