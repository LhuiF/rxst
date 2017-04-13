package com.unionx.web.insurance.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageInfo;
import com.unionx.core.vo.CommonResponse;
import com.unionx.core.vo.DataGridData;
import com.unionx.sys.dict.service.DictService;
import com.unionx.sys.dict.vo.DictItem;
import com.unionx.web.common.BaseController;

import com.unionx.web.insurance.service.RsInsuranceAccountService;
import com.unionx.web.insurance.service.RsInsuranceBaseService;
import com.unionx.web.insurance.service.RsInsuranceService;
import com.unionx.web.insurance.vo.RsInsurance;
import com.unionx.web.insurance.vo.RsInsuranceAccount;
import com.unionx.web.insurance.vo.RsInsuranceBase;
import com.unionx.web.insurance.vo.RsInsuranceMainPage;

import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("sheBaoMainListController")
@Slf4j
public class RsInsuranceController extends BaseController {
	
	@Autowired
	private RsInsuranceService rsInsuranceService;
	@Autowired
	private DictService dictService;
	@Autowired
	private RsInsuranceBaseService rsInsuranceBaseService;
	@Autowired
	private RsInsuranceAccountService rsInsuranceAccountService;
	
	 @RequestMapping("/shebaoList")
     public String returnUrl(HttpServletRequest request){
	    	//request.setAttribute("huokou", service.getDict("20005"));
	        return "canshu/shebaoList";
	   }
	 
	 /*
	  * 社保增加参数跳转页面
	  */
	 @RequestMapping("/shebaoCanshuAdd")
     public String returnShebaoAddUrl(HttpServletRequest request){
		 /*缴费人员类别实体*/
		 List<RsInsuranceAccount> rsInsuranceAccountList=new ArrayList<RsInsuranceAccount>();
		 /*险种基数实体*/
		 List<RsInsuranceBase> rsInsuranceBaseList=new ArrayList<RsInsuranceBase>();
	    //缴费人员类别	
		 List<DictItem>rytypeList=dictService.findByDictItem("20003");
		 //险种信息
		 List<DictItem>xzList= dictService.findByDictItem("20009");
		 int rytypenumber=0;
		 int xzbasenumber=0;
		 
		 for(DictItem dictrytype:rytypeList){
			 RsInsuranceAccount account=new RsInsuranceAccount();
			 account.setDictCode(dictrytype.getCode());
			 account.setDictName(dictrytype.getName());
			 
			 rsInsuranceAccountList.add(account);
		 }
		 for(DictItem xztype:xzList){
			 RsInsuranceBase insuranceBase=new RsInsuranceBase();
			 
			 insuranceBase.setDictCode(xztype.getCode());
			 insuranceBase.setDictName(xztype.getName());
			 
			 rsInsuranceBaseList.add(insuranceBase);
		 }
		 rytypenumber=rsInsuranceAccountList.size();
		 xzbasenumber=rsInsuranceBaseList.size();
		 
		 request.setAttribute("rsInsuranceAccountList", rsInsuranceAccountList);//缴费人员类别
		 request.setAttribute("rsInsuranceBaseList", rsInsuranceBaseList);//险种数量
		 request.setAttribute("rytypenumber",rytypenumber);//
		 request.setAttribute("xzbasenumber",xzbasenumber);//
		
	     return "canshu/shebaoAdd";
	   }
	/**
	 * 
	 * @param fund 社保参数对象
	 * @param page 页码
	 * @param rows 页的大小
	 * @return
	 */
	
	@ResponseBody
    @RequestMapping("/geRsInsuranceList")
    public DataGridData<RsInsurance> getAccumulationList(RsInsurance fund, int page, int rows){
        DataGridData<RsInsurance> data = new DataGridData<RsInsurance>();
        try {
        	
            PageInfo<RsInsurance> accumulationFundPage = rsInsuranceService.getPageRsinsuranceList(fund,page,rows);
            data.setRows(accumulationFundPage.getList());
            data.setTotal(accumulationFundPage.getTotal());
            
        }catch (Exception e){
           e.printStackTrace();
           log.error("",e);
        }
        return data;
    }
	
	/*
	 * 新增社保参数
	 * 
	 */
	@RequestMapping("/saveRsInsurance")
	@ResponseBody
	public CommonResponse save(RsInsurance suranceMain ,RsInsuranceMainPage MainPage,	
			HttpServletRequest request){
		
		CommonResponse commonResponse = new CommonResponse();
		
		
		 try{
			 /*缴费人员类别实体*/
			 List<RsInsuranceAccount> rsInsuranceAccountList=MainPage.getRsInsuranceAccountList();
				/*险种基数实体*/
			 List<RsInsuranceBase> rsInsuranceBaseList=MainPage.getRsInsuranceBaseList();
			 
			 if(rsInsuranceService.validateDictcodeYear(suranceMain)){
				 rsInsuranceService.saveMainRsInsurance(suranceMain,MainPage);
			 
			 commonResponse.setSuccess(true);
	         commonResponse.setMessage(CommonResponse.SAVE_SUCCESS);
			 }else{
				 commonResponse.setSuccess(false);
				 commonResponse.setMessage("本年度社保参数已设置"); 
			 }
		 }catch(Exception e){
			 log.error("新增信息 saveRsInsurance错误", e);
			 commonResponse.setSuccess(false);
	         commonResponse.setMessage(CommonResponse.SYS_EXCEPTION); 
		 }
		
		 return commonResponse;
	}
	/*
	 * 新增社保参数
	 * 
	 */
	@RequestMapping("/updateRsInsurance")
	@ResponseBody
	public CommonResponse update(RsInsurance suranceMain ,RsInsuranceMainPage MainPage,	
			HttpServletRequest request){
		
		CommonResponse commonResponse = new CommonResponse();
		
		
		 try{
			 /*缴费人员类别实体*/
			 List<RsInsuranceAccount> rsInsuranceAccountList=MainPage.getRsInsuranceAccountList();
				/*险种基数实体*/
			 List<RsInsuranceBase> rsInsuranceBaseList=MainPage.getRsInsuranceBaseList();
			 
			 rsInsuranceService.updateMainRsInsurance(suranceMain,MainPage);
			 
			 commonResponse.setSuccess(true);
	         commonResponse.setMessage(CommonResponse.SAVE_SUCCESS);
		 }catch(Exception e){
			 log.error("修改信息 saveRsInsurance错误", e);
			 commonResponse.setSuccess(false);
	         commonResponse.setMessage(CommonResponse.SYS_EXCEPTION); 
		 }
		
		 return commonResponse;
	}


	 /**
     * 根据ID删除
     * @param id
     * @return
     * @date 2016-11-4
     */
    @RequestMapping("delObjById/{id}")
    @ResponseBody
    public CommonResponse deleteAccumulationById(@PathVariable("id") Integer id){
    	CommonResponse commonResponse = new CommonResponse();
    	try {
    		rsInsuranceService.deleteAccumulationById(id);
    		commonResponse.setSuccess(true);
    		commonResponse.setMessage("删除成功");
		} catch (Exception e) {
			commonResponse.setSuccess(false);
			commonResponse.setMessage("删除失败");
			e.printStackTrace();
			log.error("",e);
		}
		return commonResponse;
    }
    /**
	 * 
	 * 社保参数维护字段
	 * 
	 */
	@RequestMapping(params ="ShebaocanshuEdit")
	public ModelAndView addorupdate(HttpServletRequest req) {
		
		int id=Integer.parseInt(req.getParameter("id"));
		RsInsurance rsInsurance=rsInsuranceService.getById(id);
		String uuid= rsInsurance.getUuid();
		
		req.setAttribute("rsInsuranceMain", rsInsurance);
		/*缴费人员类别实体*/
		 List<RsInsuranceAccount> rsInsuranceAccountList=new ArrayList<RsInsuranceAccount>();
		 rsInsuranceAccountList=rsInsuranceAccountService.getRsInsuranceAccountByUuid(uuid);
		 /*险种基数实体*/
		 List<RsInsuranceBase> rsInsuranceBaseList=new ArrayList<RsInsuranceBase>();
		 
		 rsInsuranceBaseList=rsInsuranceBaseService.getRsInsuranceBaseByUuid(uuid);
			
		 req.setAttribute("rsInsuranceAccountList", rsInsuranceAccountList);
		 req.setAttribute("rsInsuranceBaseList", rsInsuranceBaseList);
			
		
		return new ModelAndView("canshu/shebaoEdit");
		
	}
	/**
     * 功能：校验新增时某个城市和年度是否设置
     * @Author: 
     */
    @ResponseBody
    @RequestMapping("/validateCityyear")
	public boolean valivalidDictcodeYear(HttpServletRequest req){
		
		String dictCode=req.getParameter("dictCode");
		String year=req.getParameter("year");
		
		CommonResponse commonResponse = new CommonResponse();
		
		HashMap map=new HashMap();
		map.put("dictCode", dictCode);
		map.put("insuranceYear", year);
		
		return rsInsuranceService.validateDictcodeYear(map);
		

	}
}
