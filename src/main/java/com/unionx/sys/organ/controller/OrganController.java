package com.unionx.sys.organ.controller;

import com.unionx.core.aop.business.BusinessLogAop;
import com.unionx.core.util.JsonUtils;
import com.unionx.core.vo.CommonResponse;
import com.unionx.core.web.function.OrganTreeFunction;
import com.unionx.sys.organ.service.OrganService;
import com.unionx.sys.organ.vo.Organ;
import com.unionx.sys.user.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanYin
 * date :2016/5/16
 * 组织机构控制层
 */
@Slf4j
@Controller
@RequestMapping("organ")
public class OrganController {

    @Autowired
    private OrganService organService;
   /**
    * @Author xuanYin
    * @Param
    * @Date 2016/5/16 17:11
    * 首次进入页面
    */
    @RequestMapping("/index")
    public String index(){
        return "organ/organ";
    }

    /**
     * 根据机构名称模糊查询机构列表
     * @Author xuanYin
     * @Param name
     * @Date 2016/5/16 19:08
     */
    @ResponseBody
    @RequestMapping("/findOrganTree")
    public CommonResponse findOrganTree(Organ organ){
        CommonResponse commonResponse=new CommonResponse();
        try {
            List<Organ> list = this.organService.findOrganTree(organ);
            //转化成树形结构
            list=this.getOrganTreeNote(list);
            commonResponse.setData(list);
            commonResponse.setSuccess(true);
        }catch (Exception e){
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
            log.error("根据机构名称模糊查询组织机构列表",e);
        }
        return commonResponse;
    }

     /**
      * 组织机构验证表单数据唯一性
      * @Author xuanYin
      * @Param organ
      * @Date 2016/5/17 9:59
      */
     @RequestMapping("/validateOrgan")
     @ResponseBody
    public boolean validateOrgan(Organ organ){
         boolean  flag=true;
        try {
            flag=this.organService.validateOrgan(organ);
        }catch (Exception e){
            log.error("组织机构表单验证",e);
        }
        return flag;
    }

    /**
     * 保存组织机构
     * @Author xuanYin
     * @Param organ
     * @Date 2016/5/17 10:09
     */
    @BusinessLogAop("保存组织机构")
    @RequestMapping("/saveOrgan")
    @ResponseBody
    public CommonResponse saveOrgan(Organ organ){
        CommonResponse commonResponse =new CommonResponse();
        try {
            if (StringUtils.isNotBlank(organ.getId())){
                this.organService.updateOrgan(organ);
            }else{
                this.organService.saveOrgan(organ);
            }
            commonResponse.setSuccess(true);
            commonResponse.setMessage(CommonResponse.SAVE_SUCCESS);
        } catch (Exception e) {
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.OPT_FAILED);
            log.error("保存组织机构",e);
        }
        return commonResponse;
    }

    /**List<Organ>
     * 将机构list转化成树形结构
     * @param allOrgan
     * @author xuanYin;
     * @date 2016/05/16
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private List<Organ> getOrganTreeNote(List<Organ> allOrgan) throws InvocationTargetException, IllegalAccessException {
        List<Organ> organTree = new ArrayList<>();
        for (Organ organ : allOrgan) {
            boolean isFindParent = false;//是否找到父节点
            //从列表找查找是否有当前节点的父节点，如果有将当前节点加到父节点的children中。
            for (Organ organTemp : allOrgan) {
                if (organ.getParentId() != null && organ.getParentId().equals(organTemp.getId())) {
                    isFindParent = true;
                    if (organTemp.getChildren() == null) {
                        organTemp.setChildren(new ArrayList<Organ>());
                    }
                    organTemp.getChildren().add(organ);
                    break;
                }
            }
            if (!isFindParent) {//没有找到父节点，说明是顶级节点
                organTree.add(organ);
            }
        }
        return organTree;
    }
    /**
     * 根据id查询组织机构对象
     * @Author xuanYin
     * @Param
     * @Date 2016/5/17 20:11
     */
    @RequestMapping("/findOrganById")
    @ResponseBody
    public CommonResponse findOrganById(String id){
        CommonResponse commonResponse =new CommonResponse();
        try {
            Organ organ=this.organService.getOrganById(id);
            commonResponse.setSuccess(true);
            commonResponse.setData(organ);
        } catch (Exception e) {
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
            commonResponse.setData(false);
            log.error("",e);
        }
        return commonResponse;
    }

    /**
     * 验证是否能删除
     * @Author xuanYin
     * @Param
     * @Date 2016/5/18 10:58
     */
    @RequestMapping("/validateDelete")
    @ResponseBody
    public CommonResponse validateDelete(String id){
        CommonResponse commonResponse=new CommonResponse();
        try {
            if(StringUtils.isNotBlank(id)){
                //查询当前机构下的用户
                List<User> userList=this.organService.findUserListByOrgan(id);
                if(userList.size()>0){
                    commonResponse.setSuccess(false);
                    commonResponse.setMessage("该机构下有用户存在，不允许删除");
                    return  commonResponse;
                }
                //查询当前机构下是否有子机构
                if (this.organService.isHaveChildren(id)){
                commonResponse.setSuccess(false);
                commonResponse.setMessage("该机构下有子机构，不允许删除");
                return  commonResponse;
                }
            }else{
                commonResponse.setSuccess(false);
                commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
            }
            commonResponse.setSuccess(true);
        } catch (Exception e) {
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
            log.error("验证是否能删除组织机构",e);
        }
        return commonResponse;
    }
    /**
     * 删除组织机构
     * @Author xuanYin
     * @Param
     * @Date 2016/5/18 10:07
     */
    @BusinessLogAop("删除组织机构")
    @RequestMapping("/deleteOrgan")
    @ResponseBody
    public CommonResponse deleteOrgan(String id){
        CommonResponse commonResponse=new CommonResponse();
        try {
            Organ organ=new Organ();
            if(StringUtils.isNotBlank(id)){
                organ.setId(id);
            }
            organ.setDeleted(1);
            this.organService.updateOrgan(organ);
            commonResponse.setMessage(CommonResponse.DEL_SUCCESS);
            commonResponse.setSuccess(true);
        } catch (Exception e) {
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
            log.error("删除组织机构",e);
        }
        return commonResponse;
    }

    /**
     * 查询comboTree数据
     * @Author xuanYin
     * @Param
     * @Date 2016/6/17 18:16
     */
    @RequestMapping("findComboOrganTree")
    @ResponseBody
    public String findComboOrganTree(Organ organ){
        //CommonResponse commonResponse=new CommonResponse();
        String organTreeJson =null;
        try {
            organTreeJson= OrganTreeFunction.getTreeData();
            /*commonResponse.setData(organTreeJson);
            commonResponse.setSuccess(true);*/
        }catch (Exception e){
            /*commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);*/
            log.error("根据机构名称模糊查询组织机构树形",e);
        }
        return organTreeJson;
    }

    /**
     * 验证所属机构
     * @Author xuanYin
     * @Param
     * @Date 2016/6/28 10:50
     */
    @RequestMapping("validateOrganTree")
    @ResponseBody
    public boolean validateOrganTree(Organ organ){
        boolean  flag=true;
        try {
            flag=this.organService.validateOrganTree(organ);
        }catch (Exception e){
            log.error("组织机构表单验证",e);
        }
        return flag;
    }
}
