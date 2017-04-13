package com.unionx.core.web.function;

import com.unionx.core.util.JsonUtils;
import com.unionx.core.util.SpringContextUtil;
import com.unionx.core.vo.TreeNode;
import com.unionx.core.vo.ZtreeNode;
import com.unionx.sys.module.service.ModuleService;
import com.unionx.sys.module.vo.Module;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回json格式的模块数据。将简单格式转换成嵌套格式
 * @author song junjie
 */
@Slf4j
public class ModuleTreeFunction {
    /**
     * 返回easyui tree 的数据结构
     * @return
     */
    public static String getTreeData() {
        String json = "[]";
        List<TreeNode> organTree = new ArrayList<>();
        try {
            ModuleService moduleService = SpringContextUtil.getBean("moduleService", ModuleService.class);
            List<Module> allModule = moduleService.findAllModule();
            if (allModule == null) {
                return "[]";
            }
            List<TreeNode> treeNodeList = new ArrayList<>();
            //将organ对象数据转换成tree的节点数据
            for (Module module : allModule) {
                TreeNode treeNode = new TreeNode();
                treeNode.setId(module.getCode());
                treeNode.setText(module.getName());
                treeNode.setChecked(false);
                treeNode.setState("open");
                treeNode.setParentId(module.getParentCode());
                treeNodeList.add(treeNode);
            }
            for (TreeNode treeNode : treeNodeList) {
                boolean isFindParent = false;//是否找到父节点
                //从列表找查找是否有当前节点的父节点，如果有将当前节点加到父节点的children中。
                for (TreeNode treeNodeTemp : treeNodeList) {
                    if (treeNode.getParentId() != null && treeNode.getParentId().equals(treeNodeTemp.getId())) {
                        isFindParent = true;
                        if (treeNodeTemp.getChildren() == null) {
                            treeNodeTemp.setChildren(new ArrayList<TreeNode>());
                        }
                        treeNodeTemp.getChildren().add(treeNode);
                        break;
                    }
                }
                if (!isFindParent) {//没有找到父节点，说明是顶级节点
                    organTree.add(treeNode);
                }
            }
            json = JsonUtils.writeValueAsString(organTree);
        } catch (Exception e) {
            log.error("", e);
        }
        return json;
    }

    /**
     * 返回标准的ztree的数据结构
     * flg 系统类型  1：运维系统  2：客服系统  3：店家系统
     * @return
     */
    public static String getZtreeData(String flg) {
        String json = "[]";
        List<ZtreeNode> organTree = new ArrayList<>();
        try {
            ModuleService moduleService = SpringContextUtil.getBean("moduleService", ModuleService.class);
            List<Module> allModule = moduleService.findAllModuleBySystem(flg);
            if (allModule == null) {
                return "[]";
            }
            List<ZtreeNode> ztreeNodeList = new ArrayList<>();
            //将organ对象数据转换成tree的节点数据
            for (Module module : allModule) {
                ZtreeNode ztreeNode = new ZtreeNode();
                ztreeNode.setId(module.getCode());
                ztreeNode.setName(module.getName());
                ztreeNode.setParentId(module.getParentCode());
                ztreeNode.setOpen(true);
                ztreeNodeList.add(ztreeNode);
            }

            for (ZtreeNode ztreeNode : ztreeNodeList) {
                boolean isFindParent = false;//是否找到父节点
                //从列表找查找是否有当前节点的父节点，如果有将当前节点加到父节点的children中。
                for (ZtreeNode ztreeNodeTemp : ztreeNodeList) {
                    if (ztreeNode.getParentId() != null && ztreeNode.getParentId().equals(ztreeNodeTemp.getId())) {
                        isFindParent = true;
                        if (ztreeNodeTemp.getChildren() == null) {
                            ztreeNodeTemp.setChildren(new ArrayList<ZtreeNode>());
                        }
                        ztreeNodeTemp.getChildren().add(ztreeNode);
                        break;
                    }
                }
                if (!isFindParent) {//没有找到父节点，说明是顶级节点
                    organTree.add(ztreeNode);
                }
            }
            json = JsonUtils.writeValueAsString(organTree);
        } catch (Exception e) {
            log.error("", e);
        }
        return json;
    }
}
