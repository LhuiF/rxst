package com.unionx.sys.user.dao;

import java.util.List;

import com.unionx.sys.user.vo.User;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @xuchengbin
 */
@Repository
public interface UserMapper{   
    /**
     * 根据主键查询
     */
    User getUserById(@Param("id") String id);

    /**
     * 查询出所有记录
     */
    List<User> findAllUser();    
    
    /**
     * 保存
     */
    int saveUser(User user);
    
    /**
     * 根据主键更新（参数对象中的主键将作为更新条件）
     */
    int updateUser(User user);
    
    /**
     * 根据主键删除
     */
    void deleteUser(@Param("id") String id);

    /**
     * 带条件查询用户管理
     * @param user
     * @return
     */
    List<User> getUserList(User user);

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     * @author abner
     */
    User getUser(@Param("userId") String userId);

    String validLoginName(@Param("loginName") String loginName);

    List<User> findUserListByOrgan(String organId);

    /**
     * 根据岗位编码返回该岗位用户列表
     * @author abner
     * @param post
     * @return
     */
    List<User> getUserListByPost(String post);

    /**
     *  查询用户id是否存在店家信息表里
     */
    List findByUserToStore(@Param("id") String id);

    /**
     * 获取岗位为接待人员列表
     *
     * @param postId
     * @return
     */
    List<User> findByUserReceiver(@Param("postId") String postId);
    /**
     * 根据会员id查询售后服务课岗位的人的信息
     * 店家版行程信息新增页面需要的内容
     * @param memberId
     * @param isOperation
     * @return
     */
    User getUserByMenberId(@Param("memberId") String memberId, @Param("post") String post,@Param("isOperation") int isOperation);

    /**
     * 查询手诊专家名称
     * @param userId
     * @return
     */
    String getFirstExpertName(@Param("userId") String userId);

    User findIsLeader(@Param("organId") String organId);

    /**
     * 获取店家手机号
     *
     * @param userId
     * @return
     * @author abner
     */
    String getStoreUserPhoneById(@Param("userId") String userId);
}

