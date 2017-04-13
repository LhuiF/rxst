package com.unionx.web.calculator.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unionx.core.vo.CommonResponse;
import com.unionx.web.calculator.service.CalculatorService;
import com.unionx.web.calculator.vo.RequestVo;
import com.unionx.web.calculator.vo.ResultVo;
import com.unionx.web.common.BaseController;

@Controller
@RequestMapping("CalculatorController")
public class CalculatorController extends BaseController{
	
	@Autowired
	CalculatorService service;

	/**
	 * 计算器
	 * @Description: TODO 
	 * @throws
	 * @author zhaoyubo
	 * @date 2016-11-17
	 */
	@RequestMapping("calculatorInsurance")
	@ResponseBody
	public CommonResponse calculatorInsurance(@RequestBody RequestVo vo){
		CommonResponse response = new CommonResponse();
		
		try {
			Assert.hasLength(vo.getCityCode(), "城市ID不能为空");
			Assert.hasLength(vo.getPaymentDate(), "缴费日期不能为空");
			/*Assert.hasLength(vo.getAccumulationFund(), "公积金申报工资不能为空");
			Assert.hasLength(vo.getInsurance(), "社保申报工资不能为空");*/
			ResultVo resultVo = service.calculator(vo);
			response.setData(resultVo);
			
			response.setSuccess(true);
			response.setMessage("成功");
		} catch (IllegalArgumentException e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		} catch (Exception e){
			e.printStackTrace();
			response.setSuccess(false);
			response.setMessage("失败");
		}
		return response;
	}
	
	@RequestMapping("getCity")
	@ResponseBody
	public List<Map<String,String>> getCity(){
		return service.getCity();
	}
	
	@RequestMapping("/addcalculate")
    public String returnUrl(HttpServletRequest request){
	        return "calculator/addcalculate";
	   }
}
