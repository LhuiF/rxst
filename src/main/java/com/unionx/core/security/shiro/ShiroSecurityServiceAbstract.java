package com.unionx.core.security.shiro;

import com.unionx.sys.account.dao.AccountMapper;
import com.unionx.sys.account.vo.Account;
import com.unionx.sys.module.dao.ModuleMapper;
import com.unionx.sys.module.vo.Module;
import com.unionx.sys.user.dao.UserMapper;
import com.unionx.sys.user.vo.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 抽象shiro登录业务层
 * @author abner
 */
public abstract class ShiroSecurityServiceAbstract implements ShiroSecurityService{


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private ModuleMapper moduleMapper;

    /**
     * 用于shiro登录获取用户对象 保存到shiro中
     *
     * @param userId
     * @return
     * @author abner
     */
    @Override
    public UserDetails getUserDetails(String userId) {
        User user = userMapper.getUser(userId);
        user.setModuleList(getUserModuleList(userId));
        user.setButtonList(getUserButtonList(userId));
        return user;
    }

    /**
     * 获取用户帐号对象用于shiro登录
     *
     * @param loginName
     * @return
     * @author abner
     */
    @Override
    public Account getUserAccount(String loginName) {
        return accountMapper.getAccount(loginName,null);
    }

    /**
     * 获取用户模块权限用于shiro
     *
     * @param userId
     * @return
     * @author abner
     */
    @Override
    public List<Module> getUserModuleList(String userId) {
        return moduleMapper.getModuleList(userId);
    }

    /**
     * 获取用户id 获取按钮权限
     *
     * @param userId
     * @return
     * @author abner
     */
    @Override
    public List<String> getUserButtonList(String userId) {
        return moduleMapper.getButtonList(userId);
    }

}
