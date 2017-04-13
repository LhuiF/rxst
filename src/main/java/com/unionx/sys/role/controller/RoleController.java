package com.unionx.sys.role.controller;

import com.github.pagehelper.PageInfo;
import com.unionx.core.aop.business.BusinessLogAop;
import com.unionx.core.vo.CommonResponse;
import com.unionx.core.vo.DataGridData;
import com.unionx.sys.role.service.RoleService;
import com.unionx.sys.role.vo.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author  yangxiao.
 * date:2016/5/16
 */
@Controller
@RequestMapping("/role")
@Slf4j
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 初始化角色页面
     * @return
     */
    @RequestMapping("/initrole")
    public String initStoreRole(){
        return "role/role";
    }

    /**
     * 保存信息
     * @param sysRole
     * @return
     */
    @BusinessLogAop("删除保存信息role.save")
    @ResponseBody
    @RequestMapping("/save")
    public CommonResponse saveRole(Role sysRole){
        CommonResponse commonResponse = new CommonResponse();
        try {
            roleService.saveRole(sysRole);
            commonResponse.setSuccess(true);
            commonResponse.setMessage(CommonResponse.SAVE_SUCCESS);
        } catch (Exception e) {
            log.error("",e);
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
        }
        return commonResponse;
    }

    /**
     * 修改信息
     * @param sysRole
     * @return
     */
    @BusinessLogAop("删除修改信息role.update")
    @ResponseBody
    @RequestMapping("/update")
    public CommonResponse updateRole(Role sysRole){
        CommonResponse commonResponse = new CommonResponse();
        try {
            roleService.updateRole(sysRole);
            commonResponse.setSuccess(true);
            commonResponse.setMessage(CommonResponse.SAVE_SUCCESS);
        } catch (Exception e) {
            log.error("",e);
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
        }
        return commonResponse;
    }

    /**
     * 获得列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/getList")
    public DataGridData getList(Role sysRole, int page, int rows){
        DataGridData dataGridData = new DataGridData();
        try{
            PageInfo<Role> pageInfo = roleService.getList(sysRole,page,rows);
            dataGridData.setTotal(pageInfo.getTotal());
            dataGridData.setRows(pageInfo.getList());
        }catch (Exception e){
            log.error("",e);
        }
        return dataGridData;
    }

    /**
     * 验证
     * @param sysRole
     * @return
     */
    @ResponseBody
    @RequestMapping("/validate")
    public Boolean validate(Role sysRole){
        Boolean b = false;
        try{
            //数据库没此数据 true
            //有数据false
            b = roleService.validate(sysRole);
        }catch (Exception e){
           log.error("",e);
        }
        return b;
    }

    /**
     * 根据id获得role对象
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getRoleById")
    public CommonResponse getRoleById(String id){
        CommonResponse commonResponse = new CommonResponse();
        Role sysRole = null;
        try {
            sysRole = roleService.getRoleById(id);
            if(sysRole != null){
                commonResponse.setSuccess(true);
                commonResponse.setData(sysRole);
            }else{
                commonResponse.setSuccess(false);
            }
        } catch (Exception e) {
            log.error("",e);
            commonResponse.setSuccess(false);
        }
        return commonResponse;
    }

    /**
     * 根据id删除role
     * @param id
     * @return
     */
    @BusinessLogAop("删除根据id删除role")
    @ResponseBody
    @RequestMapping("/delete")
    public CommonResponse delete(String id ){
        CommonResponse commonResponse = new CommonResponse();
        Boolean b = false;
        try {
            //b=true 该角色下有用户
            b = roleService.deleteRoleById(id);
            commonResponse.setSuccess(b);

        } catch (Exception e) {
            log.error("",e);
            commonResponse.setSuccess(b);
        }
        return commonResponse;
    }

}
