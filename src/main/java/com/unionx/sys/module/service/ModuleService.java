package com.unionx.sys.module.service;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.unionx.sys.module.dao.ModuleMapper;
import com.unionx.sys.module.vo.Module;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 模块管理
 * @author song junjie
 */
@Service
public class ModuleService {
    @Resource
    private ModuleMapper moduleMapper;

    /**
     * 根据主键查询
     */
    public Module getModuleByCode(String code) {
        return this.moduleMapper.getModuleByCode(code);
    }

    /**
     * 查询出所有记录
     */
    public List<Module> findAllModule() {
        return this.moduleMapper.findAllModule();
    }

    /**
     * 保存
     */
    public void saveModule(Module module) {
        this.moduleMapper.saveModule(module);
    }

    /**
     * 根据主键更新（参数对象中的主键将作为更新条件）
     */
    public void updateModule(Module module) {
        this.moduleMapper.updateModule(module);
    }

    /**
     * 根据主键删除
     */
    public void deleteModule(String code) {
        this.moduleMapper.deleteModule(code);
    }

    /**
     * 判断就当前机构下是否有子模块
     * @Param id
     */
    public boolean isHaveChildren(String code) {
        //获取所有菜单
        List<Module> moduleList=this.moduleMapper.findAllModule();
        //for循环逻辑判断
        if(!CollectionUtils.isEmpty(moduleList)){
            for (int i=0;i<moduleList.size();i++){
                if (StringUtils.isNotBlank(moduleList.get(i).getParentCode()) && StringUtils.isNotBlank(code)){
                    if (moduleList.get(i).getParentCode().equals(code)){
                        return true;//表示有子节点
                    }
                }
            }
        }
        return false;
    }

    public List<Module> findAllModuleBySystem(String flg) {
        return this.moduleMapper.findAllModuleBySystem(flg);
    }
}
