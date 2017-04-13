package com.unionx.core.web.function;

import com.unionx.base.material.service.MaterialService;
import com.unionx.base.material.vo.SysMaterial;
import com.unionx.core.util.JsonUtils;
import com.unionx.core.util.SpringContextUtil;
import com.unionx.core.vo.TreeNode;
import com.unionx.core.vo.ZtreeNode;
import com.unionx.sys.organ.service.OrganService;
import com.unionx.sys.organ.vo.Organ;
import com.unionx.sys.produce.service.SysProductService;
import com.unionx.sys.produce.vo.SysProduct;
import com.unionx.sys.user.service.UserService;
import com.unionx.sys.user.vo.User;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;

import java.util.*;

/**
 * 返回机构的json数据。将简单结构的格式，转换成嵌套结构的。
 *
 * @author songjunjie
 */
@Slf4j
public class OrganTreeFunction {

    /**
     * 返回机构id和名字的映射表
     * @return
     */
    public static String idToNameMap() {
        Map organMap = new HashMap();
        try {
            OrganService organService = SpringContextUtil.getBean("organService", OrganService.class);
            List<Organ> allOrgan = organService.findAllOrgan();
            for (Organ organ : allOrgan) {
                organMap.put(organ.getId(), organ.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtils.writeValueAsString(organMap);
    }
    
    
    
    /**
     * 返回用户id和名字的映射表
     * @return
     */
    public static String userIdToName() {
        Map userMap = new HashMap();
        try {
        	UserService userService = SpringContextUtil.getBean("userService", UserService.class);
        	List<User> userList = userService.findAllUser();
        	for(User user:userList){
        		userMap.put(user.getId(), user.getName());
        	}
   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtils.writeValueAsString(userMap);
    }
    
    
    /**
     * 返回用户id和名字的映射表
     * @return
     */
    public static String produceIdToName() {
        Map productMap = new HashMap();
        try {
        	SysProductService sysProductService = SpringContextUtil.getBean("sysProductService", SysProductService.class);
        	List<SysProduct> list = sysProductService.findAllSysProduct();
        	for(SysProduct vo:list){
        		productMap.put(vo.getId(), vo.getName());
        	}
   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtils.writeValueAsString(productMap);
    }
    
    /**
     * 返回用户id和名字的映射表
     * @return
     */
    public static String toApply() {
        Map materialMap = new HashMap();
        try {
        	MaterialService materialService = SpringContextUtil.getBean("materialService",MaterialService.class);
        	List<SysMaterial> list =  materialService.getAll();
        	for(SysMaterial vo:list){
        		Integer isApply =  vo.getIsApply();
        		
        		
        			
        		if(isApply == 1){
        			materialMap.put(1,"是") ;
        		}else if(isApply == 2){
        			materialMap.put(2,"否") ;
        		}
        		
        	}
     
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtils.writeValueAsString(materialMap);
    }

    
    /**
     * 返回用户id和名字的映射表
     * @return
     */
    public static String toMaterial() {
        Map materialMap = new HashMap();
        try {
        	MaterialService materialService = SpringContextUtil.getBean("materialService",MaterialService.class);
        	List<SysMaterial> list =  materialService.getAll();
        	for(SysMaterial vo:list){
        		Integer isMaterial =  vo.getIsMaterial();
       		
        		if(isMaterial == 1){
        			materialMap.put(1,"需要") ;
        		}else if(isMaterial == 2){
        			materialMap.put(2,"不需要") ;
        		}
        		
        	}
     
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtils.writeValueAsString(materialMap);
    }
    
    
    /**
     * 是否包月
     * @return
     */
    public static String toBaoYue() {
        Map materialMap = new HashMap();
        try {
        	SysProductService sysProductService = SpringContextUtil.getBean("sysProductService",SysProductService.class);
        	List<SysProduct> list = sysProductService.findAllSysProduct();
        	for(SysProduct vo:list){
        		Integer isBaoYue =  vo.getMouthService();
	       		if(isBaoYue != null){
	       			if(isBaoYue == 1){
	       				materialMap.put(1,"是") ;
	       			}else if(isBaoYue == 0){
	       				materialMap.put(0,"否") ;
	       			}
	       			
	       		}
        		
        	}
     
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtils.writeValueAsString(materialMap);
    }
    
    
    /**
     * 报增，报减
     * @return
     */
    public static String toAssign() {
        Map materialMap = new HashMap();
        try {
        	SysProductService sysProductService = SpringContextUtil.getBean("sysProductService",SysProductService.class);
        	List<SysProduct> list = sysProductService.findAllSysProduct();
        	for(SysProduct vo:list){
        		Integer isBaoYue =  vo.getTaskList();
        		if(isBaoYue != null){
        			if(isBaoYue == 1){
        				materialMap.put(1,"社保报减单") ;
        			}else if(isBaoYue == 0){
        				materialMap.put(0,"社保报增单") ;
        			}
        			
        		}
        		
        	}
     
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtils.writeValueAsString(materialMap);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * 返回easyui tree 的数据结构
     * @return
     */
    public static String getTreeData() {
        String json = "[]";
        List<TreeNode> organTree = new ArrayList<>();
        try {
            OrganService organService = SpringContextUtil.getBean("organService", OrganService.class);
            List<Organ> allOrgan = organService.findAllOrgan();
            if (null==allOrgan) {
                return "[]";
            }
            List<TreeNode> treeNodeList = new ArrayList<>();
            //将organ对象数据转换成tree的节点数据
            for (Organ organ : allOrgan) {
                TreeNode treeNode = new TreeNode();
                BeanUtils.copyProperties(treeNode,organ);
                treeNode.setId(organ.getId());
                treeNode.setText(organ.getName());
                treeNode.setChecked(false);
                treeNode.setState("open");
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
     * @return
     */
    public static String getZtreeData() {
        String json = "[]";
        List<ZtreeNode> organTree = new ArrayList<>();
        try {
            OrganService organService = SpringContextUtil.getBean("organService", OrganService.class);
            List<Organ> allOrgan = organService.findAllOrgan();
            if (null==allOrgan) {
                return "[]";
            }
            List<ZtreeNode> ztreeNodeList = new ArrayList<>();
            //将organ对象数据转换成tree的节点数据
            for (Organ organ : allOrgan) {
                ZtreeNode ztreeNode = new ZtreeNode();
                ztreeNode.setId(organ.getId());
                ztreeNode.setName(organ.getName());
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
