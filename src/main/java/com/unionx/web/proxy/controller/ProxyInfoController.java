package com.unionx.web.proxy.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.unionx.core.security.shiro.UserDetails;
import com.unionx.core.vo.CommonResponse;
import com.unionx.core.vo.DataGridData;
import com.unionx.web.common.BaseController;
import com.unionx.web.proxy.service.ProxyInfoService;
import com.unionx.web.proxy.vo.ProxyInfo;


/**
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/proxyInfoController")
@Slf4j
public class ProxyInfoController extends BaseController{
	
	@Autowired
	ProxyInfoService service;
		
    @RequestMapping("/toProxyInfoPage")
	public ModelAndView toProxyInfoPage() {
    	Subject subject = SecurityUtils.getSubject();
		UserDetails userDetails = (UserDetails) subject.getPrincipal();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("username", userDetails.getLoginName());
		modelAndView.setViewName("proxyInfo/proxyInfo");
		return modelAndView;
	}
	
	/**
	 * 
	 * @throws ParseException 
	 * @Description: 增加代理人
	 * @throws
	 * @author zhaoyubo
	 * @date 2016-11-1
	 */
	@RequestMapping("/saveProxyInfo")
	@ResponseBody
	public CommonResponse saveProxyInfo(@RequestBody ProxyInfo vo){
		CommonResponse commonResponse = new CommonResponse();
		try {
			service.save(vo);
			commonResponse.setSuccess(true);
			commonResponse.setMessage("增加成功");
		} catch (Exception e) {
			commonResponse.setSuccess(false);
			commonResponse.setMessage("增加失败");
			log.error("", e);
			e.printStackTrace();
		}
		return commonResponse;
	}
	
	/**
	 * 
	 * @throws ParseException 
	 * @Description: 修改代理人
	 * @throws
	 * @author zy
	 * @date 2016-11-1
	 */
	@RequestMapping("/updateProxyInfo")
	@ResponseBody
	public CommonResponse updateProxyInfo(@RequestBody ProxyInfo vo){
		CommonResponse commonResponse = new CommonResponse();
		try {
			service.update(vo);
			commonResponse.setSuccess(true);
			commonResponse.setMessage("修改成功");
		} catch (Exception e) {
			commonResponse.setSuccess(false);
			commonResponse.setMessage("修改失败");
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
    @RequestMapping("/getProxyInfo")
    public DataGridData<ProxyInfo> getAccumulationList(ProxyInfo fund, Integer page, Integer rows){
        if(page ==null){
        	page=1;
        }
        if(rows ==null){
        	rows=10;
        }
    	DataGridData<ProxyInfo> data = new DataGridData<ProxyInfo>();
        try {
           PageInfo<ProxyInfo> accumulationFundPage = service.getProxyInfoList(fund,page,rows);
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
    @RequestMapping("/getProxyInfoById/{id}")
    @ResponseBody
	public ProxyInfo getProxyInfoById(@PathVariable String id) {
		return service.getProxyInfoByid(id);
	}
	
    
    /**
     * 根据ID删除
     * @param id
     * @return
     * @date 2016-11-4
     */
    @RequestMapping("/deleteProxyInfoById/{id}")
    @ResponseBody
    public CommonResponse deleteProxyInfoById(@PathVariable String id){
    	CommonResponse commonResponse = new CommonResponse();
    	try {
    		service.deleteById(id);
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
