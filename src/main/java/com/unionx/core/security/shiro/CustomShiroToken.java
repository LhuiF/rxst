package com.unionx.core.security.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 自定义令牌
 * @author abner
 */
public class CustomShiroToken extends UsernamePasswordToken {

    private String username;

    private char[] password;

    private boolean rememberMe = false;

    private String host;

    private String userType;

    public CustomShiroToken(final String username, final String password,
                            final boolean rememberMe, final String host, final String userType) {

        this(username, password != null ? password.toCharArray() : null, rememberMe, host,userType);
    }

    public CustomShiroToken(final String username, final char[] password,
                                 final boolean rememberMe, final String host , final String userType) {

        this.username = username;
        this.password = password;
        this.rememberMe = rememberMe;
        this.host = host;
        this.userType = userType;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public char[] getPassword() {
        return password;
    }

    @Override
    public void setPassword(char[] password) {
        this.password = password;
    }

    @Override
    public boolean isRememberMe() {
        return rememberMe;
    }

    @Override
    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public void setHost(String host) {
        this.host = host;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
