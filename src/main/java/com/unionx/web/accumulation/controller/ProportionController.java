package com.unionx.web.accumulation.controller;

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
import com.unionx.web.accumulation.po.RsAccumulationFundProportionVo;
import com.unionx.web.accumulation.service.AccumulationService;
import com.unionx.web.accumulation.service.ProportionService;
import com.unionx.web.accumulation.vo.RsAccumulationFund;
import com.unionx.web.common.BaseController;

/**
 * 公积金缴费比例
 * @author Administrator
 *
 */
@Controller
@RequestMapping("ProportionController")
public class ProportionController extends BaseController{

	@Autowired
	AccumulationService accumulationService;
	
	@Autowired
	ProportionService proportionService;
	
	 /**
     * 公积金缴费比例页面
     * @param request
     * @return
     */
    @RequestMapping("proportion")
    public String proportion(HttpServletRequest request){
    	request.setAttribute("huokou", accumulationService.getDict("20005"));
    	request.setAttribute("proportion", accumulationService.getProportion());
    	
        return "canshu/gongjijinPropt";
    }
    
    /**
     * 获取公积金参数
     * @param request
     * @return
     */
    @RequestMapping("getAccumulation")
    @ResponseBody
    public List<RsAccumulationFund> getAccumulation(HttpServletRequest request){
    	return accumulationService.getProportion();
    }
    
    /**
     * 根据年度ID获取政策有效期
     * @param id
     * @return
     */
    @RequestMapping("getAccumulationByUuid")
    @ResponseBody
    public List<RsAccumulationFund> getAccumulationByUuid(String id){
    	return accumulationService.getAccumulationByUuid(id);
    }
    
    /**
     * 列表页
     * @param fund
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("getAccumByProp")
    @ResponseBody
    public DataGridData<RsAccumulationFund> getAccumByProp (RsAccumulationFund fund, int page, int rows){
    	  DataGridData<RsAccumulationFund> data = new DataGridData<RsAccumulationFund>();
          try {
              PageInfo<RsAccumulationFund> accumulationFundPage = proportionService.getAccumulationList(fund,page,rows);
              data.setRows(accumulationFundPage.getList());
              data.setTotal(accumulationFundPage.getTotal());
              
          }catch (Exception e){
             e.printStackTrace();
          }
          return data;
    	
    }
    
    /**
     * 保存
     * @param vo
     * @return
     */
    @RequestMapping("saveProportion")
    @ResponseBody
    public CommonResponse saveProportion(RsAccumulationFundProportionVo vo){
		CommonResponse commonResponse = new CommonResponse();
		try {
			Assert.hasLength(vo.getAccumulationFundUuid());

			proportionService.saveOrUpdate(vo);

		} catch (IllegalArgumentException e) {
			commonResponse.setSuccess(false);
			commonResponse.setMessage("id不能为空");
			return commonResponse;
		} catch (Exception e) {
			e.printStackTrace();
			commonResponse.setSuccess(false);
			commonResponse.setMessage(e.getMessage());
			return commonResponse;
		}

		commonResponse.setSuccess(true);
		commonResponse.setMessage("保存成功");
		return commonResponse;

	}
    
    /**
     * 根据ID查询回显到编辑页面
     * @Description: TODO 
     * @throws
     * @author zhaoyubo
     * @date 2016-11-8
     */
    @RequestMapping("getProportionById")
    public ModelAndView getProportionById(String id){
    	ModelAndView modelAndView = new ModelAndView("canshu/gongjijinProptEdit");
    	
    	modelAndView.addObject("Proportion", proportionService.getProportionById(id));
    	return modelAndView;
    	
    }
    
    @RequestMapping("deleteById")
    @ResponseBody
    public CommonResponse deleteById(String id){
    	CommonResponse response = new CommonResponse();
    	
		try {
			Assert.hasLength(id, "ID不能为空");
			
			proportionService.deleteById(id);
		} catch (IllegalArgumentException e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setMessage("删除失败");
			return response;
		}
		response.setSuccess(true);
		response.setMessage("删除成功");
		return response;
    }
}
