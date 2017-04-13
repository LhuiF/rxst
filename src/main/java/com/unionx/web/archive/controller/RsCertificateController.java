package com.unionx.web.archive.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.unionx.core.security.shiro.UserDetails;
import com.unionx.core.vo.CommonResponse;
import com.unionx.core.vo.DataGridData;
import com.unionx.sys.enterprise.vo.RsEnterprise;
import com.unionx.web.archive.service.RsCertificateService;
import com.unionx.web.archive.vo.RsCertificateManagement;
import com.unionx.web.archive.vo.RsConditionArchive;
import com.unionx.web.common.BaseController;
import com.unionx.web.insurance.service.RsInsuranceProportionService;
import com.unionx.web.insurance.vo.RsInsurance;

@Controller
@RequestMapping("/rsCertificateController")
public class RsCertificateController extends BaseController {
	
	@Autowired
	RsCertificateService rsCertificateService;
	
	private static Logger log = Logger
			.getLogger(RsMaterialArchiveController.class);

	/**
	 * 返回条件档案页面参数
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/certificate")
	public ModelAndView returnUrl(HttpServletRequest request,
			Map<String, Object> model) {
		ModelAndView mav = null;
		Subject subject = SecurityUtils.getSubject();
		UserDetails userDetails = (UserDetails) subject.getPrincipal();
		String  createName = userDetails.getLoginName();	
		mav = new ModelAndView("/basicRecord/certificate", model);
		mav.addObject("createName", createName);
		return mav;

	}
	/**
	 * 查询企业信息
	 * @return
	 */
    @RequestMapping("rsCertificate")
    @ResponseBody
    public List<RsEnterprise> certificate(){
    	List<RsEnterprise> list = null;
    	list = rsCertificateService.getCertificate();
    	return list;
    	
    }
    
    @RequestMapping("getRsCertificateById")
    @ResponseBody
    public List<RsEnterprise> getRsCertificateById(String id){
    	return rsCertificateService.getRsCertificateById(id);
    }
    
	/**
	 * 获取条件档案列表
	 * @param record
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCertificateList")
	public DataGridData<RsCertificateManagement> getCertificateList(RsCertificateManagement certificate, int page, int rows) {
		DataGridData<RsCertificateManagement> data = new DataGridData<RsCertificateManagement>();
		try {
			PageInfo<RsCertificateManagement> certificatePage = this.rsCertificateService.getCertificateList(certificate,page,rows);
			data.setRows(certificatePage.getList());
			data.setTotal(certificatePage.getTotal());
		} catch (Exception e) {
			log.error("获取证书列表", e);
		}
		
		return data;
	}
	/**
	 * 新增.编辑
	 * @param record
	 * @param request
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/saveOrUpdate")
    public CommonResponse saveOrUpdate(RsCertificateManagement record,HttpServletRequest request){
    	CommonResponse commonResponse = new CommonResponse();
    	try {
    		
    		if (record !=null&&record.getId()!=null) {
    			this.rsCertificateService.update(record);
			} else {				
				this.rsCertificateService.save(record);
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
     * 根据ID删除
     * @param id
     * @return
     * @date 2016-11-4
     */
    @RequestMapping("/deleteById")
    @ResponseBody
    public CommonResponse deleteById(Integer id){
    	CommonResponse commonResponse = new CommonResponse();
    	try {
    		this.rsCertificateService.deleteById(id);
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
	 * 根据ID查询公积金基数回显至页面
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCertificateById")
	public RsCertificateManagement getCertificateById(int id) {
		List<RsCertificateManagement> list = rsCertificateService.getCertificateById(id);
		RsCertificateManagement r = null;
		if (list != null && list.size() > 0) {
			r = list.get(0);
		}
		return r;
	}
}
