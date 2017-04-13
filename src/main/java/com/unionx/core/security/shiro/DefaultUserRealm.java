package com.unionx.core.security.shiro;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 自定义的shiro的Realm
 * @author songjunjie
 */
public class DefaultUserRealm extends AuthorizingRealm {

    private ShiroSecurityService shiroSecurityService;

    public ShiroSecurityService getShiroSecurityService() {
        return shiroSecurityService;
    }

    public void setShiroSecurityService(ShiroSecurityService shiroSecurityService) {
        this.shiroSecurityService = shiroSecurityService;
    }

    /**
     * 方法的功能描述：shiro授权
     * @Author abner
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        return authorizationInfo;
    }
    /**
     * 方法的功能描述：shiro登录验证
     * @Author abner
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername().trim();
        String password = new String(usernamePasswordToken.getPassword());
        UserAccount userAccount = shiroSecurityService.getUserAccount(username);
        if (null == userAccount) throw new UnknownAccountException("账号或密码错误,请重新输入");
        UserDetails userDetails = shiroSecurityService.getUserDetails(userAccount.getUserId());
        if (!userAccount.getPassWord().equals(DigestUtils.sha256Hex(password))) {
            throw new UnknownAccountException("账号或密码错误,请重新输入");
        }
        if (null == userDetails) throw new UnknownAccountException("账号或密码错误,请重新输入");
        userDetails.setHost(usernamePasswordToken.getHost());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userDetails, userAccount.getPassWord(), getName());
        return info;
    }
    
}
