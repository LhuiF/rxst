package com.unionx.core.security.shiro;
import com.unionx.sys.account.dao.AccountMapper;
import com.unionx.sys.account.vo.Account;
import com.unionx.sys.user.dao.UserMapper;
import com.unionx.sys.user.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * shiro登录获取运维用户信息
 * @author abner
 */
@Service
public class ShiroSecurityServiceImpl extends ShiroSecurityServiceAbstract {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AccountMapper accountMapper;

    /**
     * 用于shiro登录获取用户对象 保存到shiro中
     *
     * @param userId
     * @return
     * @author abner
     */
    @Override
    public User getUserDetails(String userId) {
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
        return accountMapper.getAccount(loginName,"0");
    }

}
