package com.unionx.sys.user.controller;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.github.pagehelper.PageInfo;
import com.unionx.core.aop.business.BusinessLogAop;
import com.unionx.core.enums.SexEnum;
import com.unionx.core.util.BeanUtilsExt;
import com.unionx.core.vo.CommonResponse;
import com.unionx.core.vo.DataGridData;
import com.unionx.sys.account.service.AccountService;
import com.unionx.sys.dict.service.DictService;
import com.unionx.sys.dict.vo.DictItem;
import com.unionx.sys.organ.service.OrganService;
import com.unionx.sys.organ.vo.Organ;
import com.unionx.sys.role.service.RoleService;
import com.unionx.sys.role.service.UserRoleService;
import com.unionx.sys.user.service.UserService;
import com.unionx.sys.user.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


/**
 * 功能：用户管理
 * Date:2016/5/16
 * Time:18:42
 * Author:xuchengbin
 */

@Controller
@RequestMapping("userController")
@Slf4j
public class UserController {

    @Autowired
    private  UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private OrganService organService;

    @Autowired
    private DictService dictService;
    @Autowired
    private RoleService roleService;

    /**
     * 返回用户管理页面
     * @param request
     * @return
     */
    @RequestMapping("user")
    public String returnUrl(HttpServletRequest request){
        request.setAttribute("user",SexEnum.getList());
        return "user/user";
    }

    /**
     * 返回个人信息
     * @return
     */
    @RequestMapping("personData")
    public String returnPersonUserUrl() {
        return "user/personData";
    }
    /**
     * 用户管理列表查询
     * @param user
     * @param page
     * @param rows
     * @return
     */
    @ResponseBody
    @RequestMapping("/getUserList")
    public DataGridData getUserList(User user, int page, int rows){
        DataGridData data = new DataGridData();
        try {
            PageInfo<User> userPage = this.userService.getUserList(user,page,rows);
            data.setRows(userPage.getList());
            data.setTotal(userPage.getTotal());
        }catch (Exception e){
            log.error("获取用户管理列表",e);
        }
        return data;
    }

    /**
     * 保存用户信息或者修改用户
     * @param user
     * @return
     */
    @BusinessLogAop("保存用户信息或者修改用户")
    @ResponseBody
    @RequestMapping("/saveUserOrUpdate")
    public CommonResponse saveUser(User user) {
        CommonResponse commonResponse = new CommonResponse();
        try {
            User leader = null;
            if (StringUtils.isNotEmpty(user.getId())) {
                User u = this.userService.getUserById(user.getId());
                if (u.getLeader() == user.getLeader() && u.getLoginName().equals(user.getLoginName())) {
                    this.userService.updateUser(user);
                    commonResponse.setSuccess(true);
                    commonResponse.setMessage(CommonResponse.EDIT_SUCCESS);
                } else {
                    if (1 == user.getLeader()) {
                        leader = this.userService.findIsLeader(user.getOrganId());
                    }
                    if (null != leader) {
                        commonResponse.setSuccess(false);
                        commonResponse.setMessage("该机构已有领导!");
                    } else {
                        this.userService.updateUser(user);
                        commonResponse.setSuccess(true);
                        commonResponse.setMessage(CommonResponse.EDIT_SUCCESS);
                    }
                }
            } else {
                if (1 == user.getLeader()) {
                    leader = this.userService.findIsLeader(user.getOrganId());
                }
                if (null != leader) {
                    commonResponse.setSuccess(false);
                    commonResponse.setMessage("该机构已有领导!");
                } else {
                    this.userService.saveUser(user);
                    commonResponse.setSuccess(true);
                    commonResponse.setMessage(CommonResponse.SAVE_SUCCESS);
                }
            }
        } catch (Exception e) {
            log.error("", e);
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
        }
        return commonResponse;
    }

    /**
     * 验登录帐号是否重复
     * @param loginName
     * @return
     */
    @ResponseBody
    @RequestMapping("/validLoginName")
    public boolean validLoginName(String loginName){
        try {
            List<String> name = this.accountService.validLoginName(loginName);
            if(CollectionUtils.isEmpty(name)){
                return true;
            }
        }catch (Exception e){
            log.error("",e);
        }
        return false;
    }

    /**
     * 会员注册校验登录名
     * @param loginName
     * @return
     */
    @ResponseBody
    @RequestMapping("/validMemloninname")
    public boolean validMemloninname(String loginName){
        try {
            List<String> name = this.accountService.validMemloninname(loginName);
            if(CollectionUtils.isEmpty(name)){
                return true;
            }
        }catch (Exception e){
            log.error("",e);
        }
        return false;
    }


    /**
     * 删除用户信息
     * @param id
     * @return
     */
    @BusinessLogAop("删除用户信息")
    @ResponseBody
    @RequestMapping("/deleteUser")
    public CommonResponse deleteUser(String id){
        CommonResponse commonResponse = new CommonResponse();
        try {
            // 查询用户id是否存在店家信息表里
            List userStoreList = this.userService.findByUserToStore(id);
            if(CollectionUtils.isNotEmpty(userStoreList) && userStoreList.size()>0){
                    commonResponse.setSuccess(false);
                    commonResponse.setData("1");
                    commonResponse.setMessage("该用户有对应的店家不允许删除，需要转移后方可删除!");
           }else{
                this.userService.deleteUser(id);
                this.accountService.deleteAccount(id);
                this.userRoleService.deleteUserRole(id);
                commonResponse.setSuccess(true);
                commonResponse.setMessage(CommonResponse.DEL_SUCCESS);
            }
        }catch (Exception e){
            log.error("",e);
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
        }
        return commonResponse;
    }

    /**
     * 通过用户id查询用户信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getUserById")
    public CommonResponse getUserById(String id){
        CommonResponse commonResponse = new CommonResponse();
        try {
            User user = this.userService.getUserById(id);
            Organ organ = this.organService.getOrganById(user.getOrganId());
            DictItem dictItem = this.dictService.findByDictItemName("1003", user.getPost() );
            List<String> roleName = this.roleService.findRoleName(user.getRoleIdList());
            Map<String, Object> map = BeanUtilsExt.beanToMap(user,null);
            map.put("organName", organ.getName());
            map.put("postName", dictItem.getName());
            map.put("roleName", roleName);
            commonResponse.setSuccess(true);
            commonResponse.setData(map);
        }catch (Exception e){
            log.error("",e);
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
        }
        return commonResponse;
    }

    /**
     * 个人资料修改
     * @param user
     * @return
     */
    @BusinessLogAop("个人资料修改")
    @ResponseBody
    @RequestMapping("/updatePerson")
    public CommonResponse updatePerson(User user) {
        CommonResponse commonResponse = new CommonResponse();
        try {
            if (StringUtils.isNotBlank(user.getId())) {
                this.userService.updatePerson(user);
            }
            commonResponse.setSuccess(true);
            commonResponse.setMessage(CommonResponse.SAVE_SUCCESS);
        } catch (Exception e) {
            log.error("", e);
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
        }
        return commonResponse;
    }

}
