package com.unionx.sys.produce.controller;



import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.github.pagehelper.PageInfo;

import com.unionx.core.aop.business.BusinessLogAop;
import com.unionx.core.security.shiro.UserDetails;
import com.unionx.core.util.DateUtils;
import com.unionx.core.vo.CommonResponse;
import com.unionx.core.vo.DataGridData;
import com.unionx.sys.produce.service.SysProductService;
import com.unionx.sys.produce.vo.SysProduct;
import com.unionx.sys.user.vo.User;
import com.unionx.web.common.BaseController;

@Controller
@RequestMapping("/sysProductController")
@Slf4j
public class SysProductController extends BaseController{
	
	@Autowired 
	private  SysProductService sysProductService;
	
	/**
     * 返回产品信息
     * @return
     */
    @RequestMapping("/produce")
    public String returnPersonUserUrl() {
        return "produce/produce";
    }
    
    
    /**
     * 产品列表查询
     * @param produce
     * @return
     */
    @ResponseBody
    @RequestMapping("/getProduceList")
    public DataGridData getProduceList(SysProduct produce, int page, int rows){//城市，业务类型
    	DataGridData data = new DataGridData();
        
    	try {
            PageInfo<User> producePage = this.sysProductService.getProduceList(produce,page,rows);
            data.setRows(producePage.getList());
            data.setTotal(producePage.getTotal());
        }catch (Exception e){
            log.error("获取产品列表",e);
        }
        return data;
 
    }
    
    
    /**
     * 保存用户信息或者修改用户
     * @param produce
     * @return
     */
    @BusinessLogAop("保存用户信息或者修改用户")
    @ResponseBody
    @RequestMapping("/saveProduceOrUpdate")
    public CommonResponse saveProduceOrUpdate(SysProduct produce){
    	
    	CommonResponse commonResponse = new CommonResponse();
        try {
        	Subject subject = SecurityUtils.getSubject();
    		UserDetails userDetails = (UserDetails) subject.getPrincipal();
        	String id = produce.getId();
        	produce.setCreateUserId(userDetails.getLoginName());
        
           if(StringUtils.isNotEmpty(id)){//不为空，修改
        	   sysProductService.update(produce);
           
           }else{//保存
        	   sysProductService.save(produce);
      
           }
 
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
     * 根据id获得produce对象
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getProduceById")
    public CommonResponse getProduceById(String id){
    	CommonResponse commonResponse = new CommonResponse();
    	SysProduct produce = null;
        try {
        	produce = sysProductService.getProduceById(id);
            if(produce != null){
                commonResponse.setSuccess(true);
                commonResponse.setData(produce);
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
     * 根据id删除
     * @param id
     * @return
     */
    @BusinessLogAop("根据id删除sysProduce")
    @ResponseBody
    @RequestMapping("/deleteById")
    public CommonResponse deleteById(String id ){
        CommonResponse commonResponse = new CommonResponse();
        
        try {
            
           sysProductService.deleteRById(id);
           commonResponse.setSuccess(true);
           commonResponse.setMessage(CommonResponse.SAVE_SUCCESS);
            

        } catch (Exception e) {
            log.error("",e);
            commonResponse.setSuccess(false);
        }
        return commonResponse;
    }
    
    /**
     * 验证产品名称号否重复
     * @param produce
     * @return
     */
    @ResponseBody
    @RequestMapping("/validName")
    public boolean validName(SysProduct produce){
    	Boolean b = false;
    	try {
    		 //数据库没此数据 true
            //有数据false
    		b = sysProductService.validName(produce);
        }catch (Exception e){
            log.error("",e);
        }
        return b;
    }

    
    
    
    
    
    
  

}
