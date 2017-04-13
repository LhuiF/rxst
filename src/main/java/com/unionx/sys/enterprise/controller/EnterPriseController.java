package com.unionx.sys.enterprise.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.unionx.core.aop.business.BusinessLogAop;
import com.unionx.core.vo.CommonResponse;
import com.unionx.core.vo.DataGridData;
import com.unionx.sys.enterprise.service.EnterpriseService;
import com.unionx.sys.enterprise.vo.RsEnterprise;
import com.unionx.web.common.BaseController;

/**
 * @author lhf
 */
@Slf4j
@Controller
@RequestMapping("/enterpriseController")
public class EnterPriseController extends BaseController{
	
    @Autowired
   private EnterpriseService enterpriseService;

    /**
     * 访问页面
     * @return
     */
    @RequestMapping("/enterprise")
    public String enterprise(HttpServletRequest request){
        return "basicRecord/enterprise";
    }
    
    /**
     * 分页获取企业信息
     * @return
     */
    @BusinessLogAop("获取信息")
    @ResponseBody
    @RequestMapping("/getEnterpriseList")
    public DataGridData<RsEnterprise> getEnterpriseList(RsEnterprise rsEnterprise,Integer page,Integer rows){
    	 DataGridData<RsEnterprise> data = new DataGridData<RsEnterprise>();
    	 if(page == null){
    		 page=1;
    	 }
    	 if(rows == null){
    		 rows=10;
    	 }
    	 try {
        	 PageInfo<RsEnterprise> enterprise = enterpriseService.getEnterpriseList(rsEnterprise, page, rows);
             data.setRows(enterprise.getList());
             data.setTotal(enterprise.getTotal());
         }catch (Exception e){
             log.error("获取列表",e);
         }
         return data;
    }
    @BusinessLogAop("获取信息")
    @ResponseBody
    @RequestMapping("/getEnterpriseListByOne")
    public List<RsEnterprise> getEnterpriseListByOne(String angencyId){
    	 try {
        	return enterpriseService.getEnterpriseListByAngencyId(angencyId);
         }catch (RuntimeException e){
             log.error("获取列表",e);
         }
    	 return null;
    }
    
    /**
     * 保存企业信息
     * @param RsEnterprise
     * @return
     */
    @BusinessLogAop("保存企业信息")
    @ResponseBody
    @RequestMapping("/saveEnterprise")
    public CommonResponse saveEnterprise(@RequestBody RsEnterprise rsEnterprise) {
        CommonResponse commonResponse = new CommonResponse();
        try {
        	enterpriseService.saveEnterprise(rsEnterprise);
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
     * 根据ID获得企业信息
     * @param id
     * @return
     */
    @BusinessLogAop("根据ID获得企业信息")
    @ResponseBody
    @RequestMapping("/showEnterprise/{id}")
    public RsEnterprise getOneEnterprise(@PathVariable String id) {
    	return enterpriseService.getEnterpriseById(id);
     }
    
    /**
     * 修改企业信息
     * @param RsEnterprise
     * @return
     */
    @BusinessLogAop("修改企业信息")
    @ResponseBody
    @RequestMapping("/updateEnterprise")
    public CommonResponse updateEnterprise(@RequestBody RsEnterprise enterprise) {
        CommonResponse commonResponse = new CommonResponse();
        try {
        	enterpriseService.updateEnterprise(enterprise);
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
     * 冻结信息，表示已删除
     * @param id
     * @return
     */
    @BusinessLogAop("冻结信息，")
    @ResponseBody
    @RequestMapping("/deleteEnterprise/{id}")
    public CommonResponse deleteEnterprise(@PathVariable String id) {
        CommonResponse commonResponse = new CommonResponse();
         try {
        	enterpriseService.deleteEnterprise(id);
			commonResponse.setSuccess(true);
            commonResponse.setMessage(CommonResponse.SAVE_SUCCESS);
        } catch (Exception e) {
        	log.error("",e);
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
        }
        return commonResponse;
    }
}
