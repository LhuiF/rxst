package com.unionx.web.enterprise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.unionx.core.vo.CommonResponse;
import com.unionx.core.vo.DataGridData;
import com.unionx.sys.enterprise.vo.RsEnterprise;
import com.unionx.web.accumulation.service.AccumulationService;
import com.unionx.web.accumulation.vo.RsAccumulationFund;
import com.unionx.web.common.BaseController;
import com.unionx.web.enterprise.po.AccumulationPo;
import com.unionx.web.enterprise.po.EnterpriseSubmit;
import com.unionx.web.enterprise.service.EnterpriseProportionService;
import com.unionx.web.enterprise.vo.RsEnterpriseProportion;

@Controller
@RequestMapping("EnterpriseProportionController")
public class EnterpriseProportionController extends BaseController {

	@Autowired
	EnterpriseProportionService proportionService;
	
	@Autowired
	AccumulationService accumulationService;
	
	
	/**
	 * 跳转到企业公积金缴费比例
	 * @Description: TODO 
	 * @throws
	 * @author zhaoyubo
	 * @date 2016-11-14
	 */
	@RequestMapping("enterpriseProportion")
	public ModelAndView enterpriseProportion(){
		ModelAndView modelAndView = new ModelAndView("canshu/companyGongjijinPropt");
		//公积金参数
		modelAndView.addObject("proportion", accumulationService.getProportion());
		modelAndView.addObject("enterprise", proportionService.getEnterprise());
		modelAndView.addObject("huokou", accumulationService.getDict("20005"));
		return modelAndView;
	}
	
	@RequestMapping("accumulationEnterprise")
	@ResponseBody
	public List<RsAccumulationFund> accumulationEnterprise(){
		return accumulationService.getProportion();
	}
	
	@RequestMapping("enterprise")
	@ResponseBody
	public List<RsEnterprise> enterprise(){
		return proportionService.getEnterprise();
	}
	
	 /**
     * 列表页
     * @param fund
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("getEnterpriseByParameter")
    @ResponseBody
    public DataGridData<RsEnterpriseProportion> getEnterpriseByParameter (RsEnterpriseProportion fund, int page, int rows){
    	  DataGridData<RsEnterpriseProportion> data = new DataGridData<RsEnterpriseProportion>();
          try {
              PageInfo<RsEnterpriseProportion> accumulationFundPage = proportionService.getEnterpriseByParameter(fund, page, rows);
              data.setRows(accumulationFundPage.getList());
              data.setTotal(accumulationFundPage.getTotal());
              
          }catch (Exception e){
             e.printStackTrace();
          }
          return data;
    }
    
    /**
     * 增加页面(回显)
     * @Description: TODO 
     * @throws
     * @author zhaoyubo
     * @date 2016-11-15
     */
    @RequestMapping("getEnterpriseByAdd")
    @ResponseBody
    public List<AccumulationPo> getEnterpriseByAdd(String id){
    	return proportionService.getEnterpriseByAdd(id);
    	
    }
    
    /**
     * 保存
     * @Description: TODO 
     * @throws
     * @author zhaoyubo
     * @date 2016-11-15
     */
    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public CommonResponse saveOrUpdate(EnterpriseSubmit submit){
    	CommonResponse response = new CommonResponse();
    	Assert.hasLength(submit.getUuid(), "ID不能为空");
    	
    	try {
    		proportionService.saveOrUpdate(submit);
    		
		} catch (IllegalArgumentException e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
    	
    	response.setSuccess(true);
    	response.setMessage("成功");
    	return response;
    }
	
    /**
     * 根据ID查询数据到页面进行回显(修改)
     * @Description: TODO 
     * @throws
     * @author zhaoyubo
     * @date 2016-11-16
     */
    @RequestMapping("getProportionById")
    public ModelAndView getProportionById(String id){
    	ModelAndView modelAndView = new ModelAndView("canshu/companyGongjijinProptEdit");
    	List<RsEnterpriseProportion> list = proportionService.getProportionById(id);
    	modelAndView.addObject("fund", accumulationService.getProportion());
		modelAndView.addObject("enterprise", proportionService.getEnterprise());
    	modelAndView.addObject("proportion", list);
    	return modelAndView;
    }
    
    /**
     * 删除
     * @Description: TODO 
     * @throws
     * @author zhaoyubo
     * @date 2016-11-16
     */
    @RequestMapping("deleteById")
    @ResponseBody
    public CommonResponse deleteById(String id){
    	CommonResponse response = new CommonResponse();
    	proportionService.deleteById(id);
    	
    	response.setSuccess(true);
    	response.setMessage("删除成功");
    	return response;
    }
}
