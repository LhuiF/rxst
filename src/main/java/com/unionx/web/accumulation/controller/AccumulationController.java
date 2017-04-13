package com.unionx.web.accumulation.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.unionx.core.vo.CommonResponse;
import com.unionx.core.vo.DataGridData;
import com.unionx.web.accumulation.po.RsAccumulationFundVo;
import com.unionx.web.accumulation.service.AccumulationService;
import com.unionx.web.accumulation.vo.RsAccumulationFund;
import com.unionx.web.common.BaseController;


/**
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("AccumulationController")
@Slf4j
public class AccumulationController extends BaseController{
	
	@Autowired
	AccumulationService service;
	
	 /**
     * 返回公积金基本参数页面
     * @param request
     * @return
     */
    @RequestMapping("accumulation")
    public String accumulation(HttpServletRequest request){
    	request.setAttribute("huokou", service.getDict("20005"));
        return "preferences/accumulation";
    }
	
	/**
	 * 
	 * @throws ParseException 
	 * @Description: 增加公积金 
	 * @throws
	 * @author zhaoyubo
	 * @date 2016-11-1
	 */
	@RequestMapping("/saveAccumulation")
	@ResponseBody
	public CommonResponse saveAccumulation(RsAccumulationFundVo vo,HttpServletRequest request){
		CommonResponse commonResponse = new CommonResponse();
		try {
			service.saveOrUpdate(vo);
			commonResponse.setSuccess(true);
			commonResponse.setMessage("增加成功");
		} catch (ParseException e) {
			commonResponse.setSuccess(false);
			commonResponse.setMessage("增加失败");
			log.error("", e);
			e.printStackTrace();
		} catch (Exception e) {
			commonResponse.setSuccess(false);
			commonResponse.setMessage(e.getMessage());
			log.error("", e);
			e.printStackTrace();
		}
		return commonResponse;
	}
	
	
	/**
	 * 公积金基本参数设置列表
	 * @Description: TODO 
	 * @throws
	 * @author zhaoyubo
	 * @date 2016-11-1
	 */
    @ResponseBody
    @RequestMapping("/getAccumulationList")
    public DataGridData<RsAccumulationFund> getAccumulationList(RsAccumulationFund fund, int page, int rows){
        DataGridData<RsAccumulationFund> data = new DataGridData<RsAccumulationFund>();
        try {
            PageInfo<RsAccumulationFund> accumulationFundPage = service.getAccumulationList(fund,page,rows);
            data.setRows(accumulationFundPage.getList());
            data.setTotal(accumulationFundPage.getTotal());
            
        }catch (Exception e){
           e.printStackTrace();
           log.error("",e);
        }
        return data;
    }
	
    /**
     * 根据ID查询公积金基数回显至页面
     * @param id
     * @return
     */
    @RequestMapping("/getgAccumulationById")
	public ModelAndView getgAccumulationById(String id) {
		List<RsAccumulationFundVo> list = service.getgAccumulationById(id);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("data", list);
		modelAndView.setViewName("preferences/accumulationEdit");
		return modelAndView;

	}
	
    
    /**
     * 根据ID删除
     * @param id
     * @return
     * @date 2016-11-4
     */
    @RequestMapping("deleteAccumulationById")
    @ResponseBody
    public CommonResponse deleteAccumulationById(Integer id){
    	CommonResponse commonResponse = new CommonResponse();
    	try {
    		service.deleteAccumulationById(id);
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
}
