package com.unionx.web.insurance.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.unionx.core.vo.CommonResponse;
import com.unionx.core.vo.DataGridData;
import com.unionx.web.accumulation.service.AccumulationService;
import com.unionx.web.common.BaseController;
import com.unionx.web.insurance.po.InsurancePage;
import com.unionx.web.insurance.service.RsInsuranceProportionService;
import com.unionx.web.insurance.vo.RsInsurance;

/**
 * 社保缴费比例
 * @author Administrator
 *
 */
@Controller
@RequestMapping("RsInsuranceProportionController")
public class RsInsuranceProportionController extends BaseController{

	@Autowired
	RsInsuranceProportionService proportionService;
	
	@Autowired
	AccumulationService accumulationService;
	
	/**
     * 返回社保缴费比例页面
     * @param request
     * @return
     */
    @RequestMapping("insuranceProportion")
    public String insuranceProportion(HttpServletRequest request){
    	request.setAttribute("category", accumulationService.getDict("20003"));
    	request.setAttribute("insurance", proportionService.getInsurance());
        return "canshu/shebaoProportion";
    }
    
    @RequestMapping("insurance")
    @ResponseBody
    public List<RsInsurance> insurance(){
    	return proportionService.getInsurance();
    	
    }
    
    @RequestMapping("getInsuranceByUuid")
    @ResponseBody
    public List<RsInsurance> getInsuranceByUuid(String id){
    	return proportionService.getInsuranceByUuid(id);
    }
    
    /**
     * 保存
     * @Description: TODO 
     * @throws
     * @author zhaoyubo
     * @date 2016-11-10
     */
    @RequestMapping("saveOrUpdate")
    @ResponseBody
	public CommonResponse saveOrUpdate(InsurancePage page) {
		CommonResponse response = new CommonResponse();
		try {
			Assert.hasLength(page.getUuid(), "Id不能为空");
			proportionService.saveOrUpdate(page);
			
		} catch (IllegalArgumentException e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setMessage(e.getMessage());
			return response;
		}

		response.setSuccess(true);
		response.setMessage("成功");
		return response;

	}
    
    /**
     * 根据ID查询记录返回页面回显
     * @Description: TODO 
     * @throws
     * @author zhaoyubo
     * @date 2016-11-10
     */
    @RequestMapping("getProportionById")
    public ModelAndView getProportionById(String id){
    	
    	ModelAndView modelAndView = new ModelAndView("canshu/shebaoProportionEdit");
    	modelAndView.addObject("data", proportionService.getProportionById(id));
    	modelAndView.addObject("Insurance", proportionService.getInsuranceByUuid(id));
    	
    	return modelAndView;
    }
    
    /**
     * 列表页
     * @param fund
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("getInsuranceByProp")
    @ResponseBody
    public DataGridData<RsInsurance> getInsuranceByProp (RsInsurance fund, int page, int rows){
    	  DataGridData<RsInsurance> data = new DataGridData<RsInsurance>();
          try {
              PageInfo<RsInsurance> accumulationFundPage = proportionService.getInsuranceByProp(fund,page,rows);
              data.setRows(accumulationFundPage.getList());
              data.setTotal(accumulationFundPage.getTotal());
              
          }catch (Exception e){
             e.printStackTrace();
          }
          return data;
    }
    
    /**
     * 根据ID删除
     * @Description: TODO 
     * @throws
     * @author zhaoyubo
     * @date 2016-11-14
     */
    @RequestMapping("deleteById")
    @ResponseBody
    public CommonResponse deleteById(String id){
    	CommonResponse response = new CommonResponse();
    	
    	proportionService.deleteById(id);
    	response.setSuccess(true);
    	response.setMessage("成功");
    	
    	return response;
    }
    
}
