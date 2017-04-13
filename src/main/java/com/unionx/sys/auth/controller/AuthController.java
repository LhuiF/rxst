package com.unionx.sys.auth.controller;

import com.unionx.core.aop.business.BusinessLogAop;
import com.unionx.core.vo.CommonResponse;
import com.unionx.sys.auth.service.AuthServiceImpl;
import com.unionx.sys.module.vo.Module;
import com.unionx.sys.role.vo.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author rjm on 2016/5/17.
 */
@Controller
@RequestMapping("/auth")
@Slf4j
public class AuthController {
    @Autowired
    private AuthServiceImpl authService;

    /**
     * 访问页面
     */
    @RequestMapping("/page")
    public String page() {

        return "auth/auth";
    }
    /**
     * 查询所有角色
     */
    @ResponseBody
    @RequestMapping("/getAllRole")
    public List<Role> getAllRole() {
        try {
            List<Role> list = authService.findAllSysRole();
            return list;
        } catch (Exception e) {
            log.error("auth.getAllRole", e);
        }
        return null;
    }


    /**
     * 根据角色查找权限
     *
     * @param roleId
     */
    @ResponseBody
    @RequestMapping("/getListByRoleId")
    public List<Module> getListByRoleId(String roleId) {
        try {
            List<Module> list = authService.getByRoleId(roleId);
            return list;
        } catch (Exception e) {
            log.error("auth.getListByRoleId", e);
        }
        return null;
    }

    /**
     * 保存关系
     *
     * @param data
     * @param roleId
     */
    @BusinessLogAop("保存关系")
    @ResponseBody
    @RequestMapping("/save")
    public CommonResponse save(String data, String roleId) {
        CommonResponse commonResponse = new CommonResponse();
        String[] dataS = null;
        try {
            if (null != data && !"".equals(data) && null != roleId && !"".equals(roleId)) {
                dataS = data.split(",");
            }
            authService.saveRoleAuth(dataS, roleId);
            commonResponse.setMessage("保存成功！");
        } catch (Exception e) {
            commonResponse.setMessage("保存失败！");
            log.error("auth.save", e);
        }
        return commonResponse;
    }
}
