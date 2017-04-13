package com.unionx.sys.module.controller;

import com.unionx.core.aop.business.BusinessLogAop;
import com.unionx.core.vo.CommonResponse;
import com.unionx.core.vo.DataGridData;
import com.unionx.sys.module.service.ModuleService;
import com.unionx.sys.module.vo.Module;
import com.unionx.sys.organ.vo.Organ;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能：模块管理
 * Date:2016/5/19
 * Author:Yanli Yang
 */
@Slf4j
@Controller
@RequestMapping("module")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    /**
     * 查询模块列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/getModuleTree")
    public CommonResponse getModuleTree() {
        CommonResponse commonResponse = new CommonResponse();
        try {
            List<Module> moduleList = this.moduleService.findAllModule();
            commonResponse.setSuccess(true);
            if (!CollectionUtils.isEmpty(moduleList)) {
                List<Module> tree = convertToTree(moduleList);
                commonResponse.setMessage(CommonResponse.QUERY_SUCCESS);
                commonResponse.setData(tree);
                return commonResponse;
            } else {
                commonResponse.setData(new ArrayList<>());
                return commonResponse;
            }
        } catch (Exception e) {
            log.error("查询模块列表 getModuleTree", e);
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
            return commonResponse;
        }
    }

    /**
     * 将模块list转化成树形结构
     * @param moduleList
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @author yang yanli
     */
    private List<Module> convertToTree(List<Module> moduleList) throws InvocationTargetException, IllegalAccessException {
        List<Module> organTree = new ArrayList<>();
        for (Module module : moduleList) {
            boolean isFindParent = false;//是否找到父节点
            //从列表找查找是否有当前节点的父节点，如果有将当前节点加到父节点的children中。
            for (Module moduleTemp : moduleList) {
                if (module.getParentCode() != null && module.getParentCode().equals(moduleTemp.getCode())) {
                    isFindParent = true;
                    if (moduleTemp.getChildren() == null) {
                        moduleTemp.setChildren(new ArrayList<Module>());
                    }
                    moduleTemp.getChildren().add(module);
                    break;
                }
            }
            if (!isFindParent) {//没有找到父节点，说明是顶级节点
                organTree.add(module);
            }
        }
        return organTree;
    }

    /**
     * 通过code查询功能模块详情
     * @return
     */
    @ResponseBody
    @RequestMapping("/getModuleByCode")
    public CommonResponse getModuleByCode(String code) {
        CommonResponse commonResponse = new CommonResponse();
        try {
            if(StringUtils.isNotEmpty(code)){
                Module module = this.moduleService.getModuleByCode(code);
                commonResponse.setData(module);
                commonResponse.setSuccess(true);
                commonResponse.setMessage(CommonResponse.SAVE_SUCCESS);
            }
        } catch (Exception e) {
            log.error("通过code查询功能模块详情 getModuleByCode", e);
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
        }
        return commonResponse;
    }

    /**
     * 添加功能模块
     * @return
     */
    @BusinessLogAop("添加功能模块")
    @ResponseBody
    @RequestMapping("/saveModule")
    public boolean saveModule(Module module) {
        try {
            String code = module.getCode();
            if(StringUtils.isNotEmpty(code)){
                Module moduleTemp = this.moduleService.getModuleByCode(code);
                if(null != moduleTemp){
                    this.moduleService.updateModule(module);
                    return true;
                }else {
                    this.moduleService.saveModule(module);
                    return true;
                }
            }
        } catch (Exception e) {
            log.error("添加功能模块 saveModule", e);
            return false;
        }
        return false;
    }
    /**
     * 修改功能模块
     * @return
     */
    @BusinessLogAop("修改功能模块")
    @ResponseBody
    @RequestMapping("/updateModule")
    public boolean updateModule(Module module) {
        try {
            String code = module.getCode();
            if(StringUtils.isNotEmpty(code)){
                this.moduleService.updateModule(module);
                return true;
            }
        } catch (Exception e) {
            log.error("修改功能模块 updateModule", e);
            return false;
        }
        return false;
    }
    /**
     * 校验编码是否可用
     * @return
     */
    @ResponseBody
    @RequestMapping("/validateModuleCode")
    public boolean validateModuleCode(String code) {
        try {
            if(StringUtils.isNotEmpty(code)){
                Module module = this.moduleService.getModuleByCode(code);
                if(null == module){
                    return true;
                }else{
                    return false;
                }
            }
        } catch (Exception e) {
            log.error("校验编码是否可用 validateModuleCode", e);
            return false;
        }
        return false;
    }

     /**
     * 验证是否能删除
     * @Param
     * @Date 2016/5/18 10:58
     */
    @ResponseBody
    @RequestMapping("/validateDelete")
    public CommonResponse validateDelete(String code){
        CommonResponse commonResponse=new CommonResponse();
        try {
            if(StringUtils.isNotBlank(code)){
                //查询当前模块下是否有子模块
                if (this.moduleService.isHaveChildren(code)){
                    commonResponse.setSuccess(false);
                    commonResponse.setMessage("该模块下有子模块，不允许被删除！");
                }else {
                    commonResponse.setSuccess(true);
                    commonResponse.setMessage("该模块允许被删除！");
                }
            }else{
                commonResponse.setSuccess(false);
                commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
            }
        } catch (Exception e) {
            log.error("验证是否能删除 validateDelete",e);
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
        }
        return commonResponse;
    }
    /**
     * 删除模块
     * @return
     */
    @BusinessLogAop("删除模块")
    @ResponseBody
    @RequestMapping("/deleteModule")
    public boolean deleteModule(String code) {
    try {
        if(StringUtils.isNotEmpty(code)){
            this.moduleService.deleteModule(code);
            return true;
        }
    } catch (Exception e) {
        log.error("删除模块 deleteModule", e);
        return false;
    }
    return false;
    }
}
