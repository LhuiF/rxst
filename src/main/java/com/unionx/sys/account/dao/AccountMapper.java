package com.unionx.sys.account.dao;

import com.unionx.core.security.shiro.UserAccount;
import com.unionx.sys.account.vo.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by abner on 2016/5/17.
 */
@Repository
public interface AccountMapper {

    /**
     * 根据用户帐号查询帐号表 返回帐号对象
     *
     * @param loginName
     * @return
     * @author abner
     */
    Account getAccount(@Param("loginName") String loginName,@Param("userType") String userType);

    void saveAccount(Account account);

    /**
     * 修改密码
     * @author abner
     * @param userId 帐号
     * @param passWord 原密码
     * @param newPassWord 新密码
     * @return 返回受影响行数 int
     */
    int updateUserPassword(@Param("userId") String userId,@Param("passWord") String passWord,@Param("newPassWord") String newPassWord);

    void deleteAccount(@Param("userId") String userId);

    /**
     * 查询登录帐号是否重复
     * @param loginName
     * @return
     */
    List<String> validLoginName(@Param("loginName") String loginName);

    /**
     * 会员注册校验登录名
     * @param loginName
     * @return
     */
    List<String> validMemloninname(@Param("loginName") String loginName);

    void updatePassword(UserAccount userAccount);

    /**
     * 根据userId查询account
     * @author abner
     * @param userId
     * @return
     */
    Account getAccountByUserId(@Param("userId") String userId);

    /**
     * 根据帐号查询
     * @author abner
     * @param loginName
     */
    Account getAccountByLoginName(@Param("loginName") String loginName);

    void forgetPassword(@Param("loginName")String loginName, @Param("password")String password);
}