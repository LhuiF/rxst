package com.unionx.sys.user.service;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unionx.core.enums.AccountTypeEnum;
import com.unionx.core.util.Identities;
import com.unionx.sys.account.dao.AccountMapper;
import com.unionx.sys.account.vo.Account;
import com.unionx.sys.role.dao.UserRoleMapper;
import com.unionx.sys.role.vo.UserRole;
import com.unionx.sys.user.dao.UserMapper;
import com.unionx.sys.user.vo.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;


/**
 * 功能：用户管理实现类
 * @Author: xuchengbin
 *
 */

@Service
public class UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 查询出所有记录
     */
    public List<User> findAllUser(){
        return this.userMapper.findAllUser();
    }

    /**
     * 带条件查询用户管理
     * @param user
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageInfo<User> getUserList(User user, int currentPage,int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<User> userList = this.userMapper.getUserList(user);
        return new PageInfo(userList);
    }

    /**
     * 用户管理增加
     * @param user
     */
    @Transactional
    public int saveUser(User user) {
        User us = (User) SecurityUtils.getSubject().getPrincipal();
        String uuid = Identities.uuid19();
        /*保存到用户角色关系表*/
        UserRole userRole= new UserRole();
        List<String> roleIdList = user.getRoleIdList();
        for(String roleId : roleIdList) {
            userRole.setUserId(uuid);
            userRole.setRoleId(roleId);
            userRole.setUpdateDatatime(new Date());
            userRole.setUpdateUserId(us.getId());
            this.userRoleMapper.saveUserRole(userRole);
        }
        /*保存到帐号表*/
        Account account = new Account();
        account.setId(Identities.uuid19());
        account.setUserId(uuid);
        account.setLoginName(user.getLoginName());
        account.setPassWord(DigestUtils.sha256Hex(user.getPassword()));
        if(user.getPost().equals("00")){
            account.setUserType("0");
        }else{
            account.setUserType(AccountTypeEnum.YLUSER.getCode());
        }
        account.setDeleted("0");
        this.accountMapper.saveAccount(account);
        /*保存用户表*/
        user.setId(uuid);
        user.setDeleted(0);
        user.setUpdateDatatime(new Date());
        user.setUpdateUserId(us.getId());
        return this.userMapper.saveUser(user);
    }




    /**
     * 删除用户信息
     * @param id
     */
    @Transactional
    public void deleteUser(String id) {
         this.userMapper.deleteUser(id);

    }

    /**
     * 通过用户id查询用户信息
     * @param id
     * @return
     */
    public User getUserById(String id) {
        User user = this.userMapper.getUserById(id);
        List<String> roleIdList = this.userRoleMapper.findByRoleList(user.getId());
        user.setRoleIdList(roleIdList);
      return user;

    }

    /**
     * 修改用户信息
     * @param user
     */
    @Transactional
    public void updateUser(User user) {
        User us = (User) SecurityUtils.getSubject().getPrincipal();
        user.setUpdateDatatime(new Date());
        user.setUpdateUserId(us.getId());
        this.userMapper.updateUser(user);
      //  UserRole userRole= new UserRole();
      //   userRole.setUserId(user.getId());
        /*先删除该用户所有的角色*/
  /*      this.userRoleMapper.deleteUserRole(user.getId());
          List<String> roleIdList = user.getRoleIdList();
          for (String roleId : roleIdList) {
            userRole.setRoleId(roleId);
            userRole.setUpdateDatatime(new Date());
            userRole.setUpdateUserId(us.getId());
            this.userRoleMapper.saveUserRole(userRole);
        }*/
    }

    /**
     *根据岗位编码返回该岗位用户列表
     * @author abner
     * @param post
     * @return
     */
    public List<User> getUserListByPost(String post) {
        return userMapper.getUserListByPost(post);
    }

    /**
     * 个人资料修改
     * @param user
     */
    @Transactional
    public void updatePerson(User user) {
        User us = (User) SecurityUtils.getSubject().getPrincipal();
        user.setUpdateUserId(us.getId());
        user.setUpdateDatatime(new Date());
        this.userMapper.updateUser(user);
    }

    /**
     * 查询用户id是否存在店家信息表里
     */
    public List findByUserToStore(String id) {
     return this.userMapper.findByUserToStore(id);
    }

    /**
     *获取岗位为接待人员列表
     * @param postId
     * @return
     */
    public List<User> findByUserReceiver(String postId) {
       return this.userMapper.findByUserReceiver(postId);
    }

    /**
     * 根据会员id查询售后服务课岗位的人的信息
     * 店家版行程信息新增页面需要的内容
     * @param memberId
     * @param isOperation
     * @return
     */
    public User getUserByMemberId(String memberId, String post, int isOperation) {
        return this.userMapper.getUserByMenberId(memberId,post,isOperation);
    }

    /**
     * 根据页面 领导信息和岗位id 查询是否添加过该岗位的领导
     *
     * @param organId
     * @return
     */
    public User findIsLeader(String organId) {
       return this.userMapper.findIsLeader(organId);
    }

    /**
     * 获取店家手机号
     * @author abner
     * @param userId
     * @return
     */
    public String getStoreUserPhoneById(String userId) {
        return this.userMapper.getStoreUserPhoneById(userId);
    }
}
