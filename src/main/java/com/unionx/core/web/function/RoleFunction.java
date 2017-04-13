package com.unionx.core.web.function;

import com.unionx.core.util.JsonUtils;
import com.unionx.core.util.SpringContextUtil;
import com.unionx.sys.produce.service.SysProductService;
import com.unionx.sys.produce.vo.SysProduct;
import com.unionx.sys.role.service.RoleService;
import com.unionx.sys.role.vo.Role;
import com.unionx.web.archive.service.RsMaterialArchiveService;
import com.unionx.web.archive.vo.RsMaterialArchive;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 返回角色数据
 *
 * @author songjunjie
 */
@Slf4j
public class RoleFunction {

    /**
     * 返回角色的json列表
     * @return
     */
    public static String allRole() {

        try {
            RoleService roleService = SpringContextUtil.getBean("roleService", RoleService.class);
            List<Role> allRole = roleService.findAllSysRole();
            if (allRole != null) {
                return JsonUtils.writeValueAsString(allRole);
            } else {
                return "[]";
            }
        } catch (Exception e) {
            return "[]";
        }
    }
    
    
    /**
     * 返回产品的json列表
     * @return
     */
    public static String getAllProductName() {

        try {
        	SysProductService sysProductService =SpringContextUtil.getBean("sysProductService", SysProductService.class);
            List<SysProduct> allSysProduct = sysProductService.findAllSysProduct();
            if (allSysProduct != null) {
                return JsonUtils.writeValueAsString(allSysProduct);
            } else {
                return "[]";
            }
        } catch (Exception e) {
            return "[]";
        }
    }
    
    /**
     * 返回材料的json列表
     * @return
     */
    public static String allCaiLiao() {

        try {
        	RsMaterialArchiveService rsMaterialArchiveService = SpringContextUtil.getBean("rsMaterialArchiveService", RsMaterialArchiveService.class);
        	List<RsMaterialArchive> allCaiLiao = rsMaterialArchiveService.getAll();
            if (allCaiLiao != null) {
                return JsonUtils.writeValueAsString(allCaiLiao);
            } else {
                return "[]";
    
            }
        } catch (Exception e) {
            return "[]";
        }
    }
    
    
   
    
    


}
