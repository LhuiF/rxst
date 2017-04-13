package com.unionx.core.security.shiro;

import com.unionx.sys.module.vo.Module;

import java.util.List;

/**
 *  用户shiro登录获取信息
 *  @author abner
 */
public interface ShiroSecurityService {

    /**
     * 用于shiro登录获取用户对象 保存到shiro中
     * @author abner
     * @param userId
     * @return
     */
    UserDetails getUserDetails(String userId);

    /**
     * 获取用户帐号对象用于shiro登录
     * @param loginName
     * @return
     * @author abner
     */
    UserAccount getUserAccount(String loginName);

    /**
     * 获取用户模块权限用于shiro
     * @param userId
     * @return
     * @author abner
     */
    List<Module> getUserModuleList(String userId);

    /**
     * 获取用户id 获取按钮权限
     * @param userId
     * @return
     * @author abner
     */
    List<String> getUserButtonList(String userId);
}
