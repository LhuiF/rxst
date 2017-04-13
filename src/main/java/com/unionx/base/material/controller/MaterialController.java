package com.unionx.base.material.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.github.pagehelper.PageInfo;
import com.unionx.base.material.service.MaterialService;
import com.unionx.base.material.vo.CailaoBean;
import com.unionx.base.material.vo.CailaoTiaojianBean;
import com.unionx.base.material.vo.MaterialVo;
import com.unionx.base.material.vo.SysMaterial;
import com.unionx.base.material.vo.SysMaterialVo;
import com.unionx.core.aop.business.BusinessLogAop;
import com.unionx.core.enums.SexEnum;
import com.unionx.core.util.JsonUtils;
import com.unionx.core.util.ResponseUtils;
import com.unionx.core.vo.CommonResponse;
import com.unionx.core.vo.DataGridData;
import com.unionx.sys.produce.service.SysProductService;
import com.unionx.sys.produce.vo.SysProduct;
import com.unionx.web.archive.service.RsMaterialArchiveService;

import com.unionx.web.common.BaseController;

import net.sf.json.JSONArray;  
import net.sf.json.JSONObject;  


@Controller
@RequestMapping("materialController")
@Slf4j
public class MaterialController extends BaseController {
	
	@Autowired
	private MaterialService materialService; 
	
	 @Autowired    
	 private RsMaterialArchiveService rsMaterialArchiveService;
	 
	 @Autowired    
	 private SysProductService sysProductService;
	/**
     * 返回业务材料信息
     * @return
     */
    @RequestMapping("/material")
    public String returnMaterial(HttpServletRequest request) {
    	
        return "material/material";
    }
    
  
    /**
     * 用户管理列表查询
     * @param sysMaterial
     * @param page
     * @param rows
     * @return
     */
    @ResponseBody
    @RequestMapping("/getMaterialList")
    public DataGridData getMaterialList(SysMaterial sysMaterial, int page, int rows){
        DataGridData data = new DataGridData();
        try {
        
            PageInfo<SysMaterial> materialPage = this.materialService.getMaterialList(sysMaterial,page,rows);
            data.setRows(materialPage.getList());
            data.setTotal(materialPage.getTotal());
        }catch (Exception e){
            log.error("获取业务材料列表",e);
        }
        return data;
    }
    
    
    /**
     * 保存业务材料信息或者修改业务材料
     * @param sysMaterial
     * @return
     */
    @BusinessLogAop("保存业务材料信息或者修改业务材料")
    @ResponseBody
    @RequestMapping("/saveMaterialOrUpdate")
    public CommonResponse saveMaterialOrUpdate(MaterialVo vo){
    	CommonResponse commonResponse = new CommonResponse();
    	try {
    	
    		if (vo.getId() != null && !vo.getId().equals("")) {//更新  一条一条更新   			
    			
    			materialService.updateMaterial(vo);

			} else {
	
    			materialService.saveMaterial(vo);
			}
    		commonResponse.setSuccess(true);
            commonResponse.setMessage(CommonResponse.SAVE_SUCCESS);		
		} catch (Exception e) {
			log.error("", e);
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
		}
    	return commonResponse;
    	
    	
    }
    
    

    /**
     * 删除业务材料信息
     * @param id
     * @return
     */
    @BusinessLogAop("删除业务材料信息")
    @ResponseBody
    @RequestMapping("/deleteMaterial")
    public CommonResponse deleteMaterial(String id){
    	CommonResponse commonResponse = new CommonResponse();
    	try {			

    		materialService.delByMaterialId(id);
    		 commonResponse.setSuccess(true);
             commonResponse.setMessage(CommonResponse.DEL_SUCCESS);
		} catch (Exception e) {
			 log.error("",e);
	         commonResponse.setSuccess(false);
	         commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
		}
    	
    	return commonResponse;
    }
	
	
    /**
     * 通过业务材料id查询业务材料信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getMaterialById")
    public ModelAndView getMaterialById(HttpServletRequest request,String id){
    	
    	//String id=request.getParameter("id");
    	ModelAndView modelAndView = new ModelAndView("material/materialEdit");
    	MaterialVo vo = materialService.getById(id);
    	List<CailaoTiaojianBean> tjList = vo.getTJ();
    	modelAndView.addObject("tjList", tjList);
    	modelAndView.addObject("materialVo", vo);
    	modelAndView.addObject("id", id);
    	String uuid = vo.getUuid();
    	String productId = vo.getProductName();
    	SysProduct produceById = sysProductService.getProduceById(productId);
    	String productName =  produceById.getName();
    	modelAndView.addObject("uuid", vo.getUuid());
    	modelAndView.addObject("productName", productName);
    	
    	
    	
    	return modelAndView;
    }
    
    /**
     * 导出登录日志Excel表格
     * @param response
     * @param sysMaterial
    
     */
    @RequestMapping("exportMaterialExcel")
    @ResponseBody
    public void exportMaterialExcel(HttpServletResponse response,String typeId ,String isMaterial ,String qu ,String isApply ){
        List<SysMaterial> sysMaterialList = materialService.getMaterialList01(typeId,isMaterial,qu,isApply);
        //设置导出Excel的内容
        ExportParams exportParams = new ExportParams();
        exportParams.setTitle("业务材料");
        exportParams.setSheetName("业务材料");
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, SysMaterial.class, sysMaterialList);
        //将数据写到输出流中
        try {
            ResponseUtils.writeExcel(response, workbook, "业务材料.xls");
        } catch (IOException e) {
            log.error("",e);
        }
    }
 
    
    /**
   	 * 根据产品名称获取所有的条件  然后将所有的条件放在request域中
   	 * 
   	 * @param productId
   	 * @return
   	 */
   	@ResponseBody
   	@RequestMapping("/getConditions")
   	public CommonResponse getConditions(String productId,HttpServletRequest request) {
   		CommonResponse commonResponse = new CommonResponse();
   		
 		List<String> conditionList = materialService.getConditions(productId);//json字符串
 		commonResponse.setData(conditionList);
 		commonResponse.setSuccess(true);
        commonResponse.setMessage(CommonResponse.DEL_SUCCESS);
 		request.setAttribute("tiaojianList",conditionList );
   		
   		
    	
    	return commonResponse;
   		
   		
   	}
   	
   	
   	
   	
    
    
	

}
