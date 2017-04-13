package com.unionx.sys.account.service;

import com.unionx.core.security.shiro.UserAccount;
import com.unionx.sys.account.dao.AccountMapper;
import com.unionx.sys.account.vo.Account;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by abner on 2016/5/17.
 */
@Service
public class AccountService{

    @Autowired
    private AccountMapper accountMapper;

    public void deleteAccount(String userId) {
        this.accountMapper.deleteAccount(userId);
    }

    /**
     * 修改密码
     * @param userId
     * @param passWord    原密码
     * @param newPassWord 新密码
     * @return 返回受影响行数 int
     * @author abner
     */
    public int updateUserPassword(String userId,String passWord,String newPassWord){
        return accountMapper.updateUserPassword(userId,passWord,newPassWord);
    }

    public List<String> validLoginName(String loginName) {
            return this.accountMapper.validLoginName(loginName);
    }

    /**
     * 会员注册校验登录名
     * @param loginName
     * @return
     */
    public List<String> validMemloninname(String loginName) {
            return this.accountMapper.validMemloninname(loginName);
    }

    /**
     * 重置密码
     * @param id
     */
    public void updatePassword(String id) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUserId(id);
        userAccount.setPassWord(DigestUtils.sha256Hex("123456"));
        this.accountMapper.updatePassword(userAccount);
    }

    /**
     * 根据帐号查询
     * @author abner
     * @param loginName
     * @return
     */
    public Account getAccountByLoginName(String loginName, String userType) {
        return this.accountMapper.getAccount(loginName, userType);
    }

    /**
     * 找回密码
     * @param loginName
     * @param password
     */
    public void forgetPassword(String loginName, String password) {
        this.accountMapper.forgetPassword(loginName, password);
    }
}
