package com.unionx.web.archive.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
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
import com.unionx.base.material.vo.SysMaterial;
import com.unionx.core.security.shiro.UserDetails;
import com.unionx.core.vo.CommonResponse;
import com.unionx.core.vo.DataGridData;
import com.unionx.sys.enterprise.vo.RsEnterprise;
import com.unionx.sys.produce.service.SysProductService;
import com.unionx.sys.produce.vo.SysProduct;
import com.unionx.web.archive.service.RsConditionArchiveService;
import com.unionx.web.archive.vo.RsCondition;
import com.unionx.web.archive.vo.RsConditionArchive;
import com.unionx.web.archive.vo.RsMaterialArchive;
import com.unionx.web.common.BaseController;

@Controller
@RequestMapping("/rsConditionArchiveController")
public class RsConditionArchiveController extends BaseController {

	private static Logger log = Logger
			.getLogger(RsMaterialArchiveController.class);

	@Autowired
	private RsConditionArchiveService rsConditionArchiveService;
	
	/**
	 * 返回条件档案页面参数
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/conditionArchive")
	public ModelAndView returnUrl(HttpServletRequest request,
			Map<String, Object> model) {
		ModelAndView mav = null;
		Subject subject = SecurityUtils.getSubject();
		UserDetails userDetails = (UserDetails) subject.getPrincipal();
		String  createName = userDetails.getLoginName();	
		mav = new ModelAndView("/archive/condition", model);
		mav.addObject("createName", createName);
		return mav;

	}
	
	/**
	 * 查询企业信息
	 * @return
	 */
    @RequestMapping("/condition")
    @ResponseBody
    public List<SysProduct> condition(){
    	List<SysProduct> list = null;
    	list = rsConditionArchiveService.getCondition();
    	return list;
    }

    @RequestMapping("getConditionById")
    @ResponseBody
    public List<SysProduct> getConditionById(String id){
    	List<SysProduct> CList = rsConditionArchiveService.getConditionById(id);
    	return CList;
    }
	/**
	 * 获取条件档案列表
	 * @param record
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getArchiveList")
	public DataGridData<RsConditionArchive> getConditionArchiveList(RsConditionArchive record, int page, int rows) {
		DataGridData<RsConditionArchive> data = new DataGridData<RsConditionArchive>();
		try {
			PageInfo<RsConditionArchive> conditionPage = this.rsConditionArchiveService.getConditionArchiveList(record,page,rows);
			data.setRows(conditionPage.getList());
			data.setTotal(conditionPage.getTotal());
		} catch (Exception e) {
			log.error("获取材料档案列表", e);
		}
		
		return data;
	}
	
	/**
	 * 根据产品名称.是否网申查询条件档案信息
	 * 
	 * @param materialName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getByName")
	public DataGridData getArchiveByName(HttpServletRequest request,RsConditionArchive record) {
		DataGridData data = new DataGridData<>();		
		record.getProdutName();
		record.getIsOnlineApply();
		List<RsConditionArchive> list = this.rsConditionArchiveService.getArchiveByName(record);

		PageInfo<RsConditionArchive> page = new PageInfo<>(list);
		data.setRows(page.getList());
		data.setTotal(page.getTotal());
		data.setMessage("成功");
		data.setSuccess(true);
		return data;

	}
	
	
    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public CommonResponse saveOrUpdate(@RequestBody RsConditionArchive record){
    	CommonResponse commonResponse = new CommonResponse();
    	try {
    		
    		if (record !=null&&record.getId()!=null) {
    			this.rsConditionArchiveService.update(record);
			} else {				
				this.rsConditionArchiveService.save(record);
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
    		this.rsConditionArchiveService.deleteById(id);
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
	 * 获取登陆人信息
	 * 
	 * @param materialName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toAdd")
	public RsConditionArchive toAdd(HttpServletRequest request,
			HttpServletResponse response) {
		RsConditionArchive record = new RsConditionArchive();
		Subject subject = SecurityUtils.getSubject();
		UserDetails userDetails = (UserDetails) subject.getPrincipal();
		record.setCreateName(userDetails.getLoginName());

		Date credate = new Date();
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//String format = sdf.format(credate);

		record.setCreateDate(credate);
		//record.setCreateDateStr(format);

		return record;
	}
	
	/**
	 * 根据ID查询公积金基数回显至页面
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getArchiveById/{id}")
	public RsConditionArchive getArchiveById(@PathVariable int id) {
		return rsConditionArchiveService.getArchiveById(id);
	}
	/**
	 * 根据id删除符合条件内容
	 * @param id
	 * @return
	 */	
	@RequestMapping("/deleteConditionById")
    @ResponseBody
    public CommonResponse deleteConditionById(String id){
    	CommonResponse commonResponse = new CommonResponse();
    	try {
    		this.rsConditionArchiveService.deleteConditionById(id);
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



