package com.unionx.web.archive.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.unionx.core.security.shiro.UserDetails;
import com.unionx.core.vo.CommonResponse;
import com.unionx.core.vo.DataGridData;
import com.unionx.web.archive.service.RsMaterialArchiveService;
import com.unionx.web.archive.vo.RsMaterialArchive;
import com.unionx.web.common.BaseController;

@Controller
@RequestMapping("/rsMaterialArchiveController")
public class RsMaterialArchiveController extends BaseController {

	private static Logger log = Logger
			.getLogger(RsMaterialArchiveController.class);

	@Autowired
	RsMaterialArchiveService rsMaterialArchiveService;

	/**
	 * 返回材料档案页面参数
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/materialArchive")
	public ModelAndView returnUrl(HttpServletRequest request,
			Map<String, Object> model) {
		ModelAndView mav = null;
		Subject subject = SecurityUtils.getSubject();
		UserDetails userDetails = (UserDetails) subject.getPrincipal();
		String  createName = userDetails.getLoginName();
		mav = new ModelAndView("/archive/material", model);
		mav.addObject("createName", createName);
		return mav;

	}

	/**
	 * 获取材料档案列表
	 * 
	 * @param record
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getArchiveList")
	public DataGridData<RsMaterialArchive> getArchiveList(
			RsMaterialArchive record, int page, int rows) {
		DataGridData<RsMaterialArchive> data = new DataGridData<RsMaterialArchive>();
		try {
			PageInfo<RsMaterialArchive> archivePage = this.rsMaterialArchiveService
					.getArchiveList(record, page, rows);
			data.setRows(archivePage.getList());
			data.setTotal(archivePage.getTotal());
		} catch (Exception e) {
			log.error("获取材料档案列表", e);
		}

		return data;
	}

	/**
	 * 保存
	 * 
	 * @param record
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/save")
	public CommonResponse save(RsMaterialArchive record,
			HttpServletRequest request) {
		CommonResponse commonResponse = new CommonResponse();
		try {
			rsMaterialArchiveService.save(record);
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
	 * 根据ID查询公积金基数回显至页面
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getArchiveById")
	public RsMaterialArchive getArchiveById(int id) {
		List<RsMaterialArchive> list = rsMaterialArchiveService
				.getArchiveById(id);
		RsMaterialArchive r = null;
		if (list != null && list.size() > 0) {
			r = list.get(0);
		}
		return r;
	}

	/**
	 * 修改
	 * 
	 * @param record
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateArchive")
	@ResponseBody
	public CommonResponse updateArchive(RsMaterialArchive record) {
		CommonResponse commonResponse = new CommonResponse();
		try {
			rsMaterialArchiveService.updateArchive(record);
			commonResponse.setSuccess(true);
			commonResponse.setMessage("修改成功");
		} catch (Exception e) {
			commonResponse.setSuccess(false);
			commonResponse.setMessage("修改失败");
			e.printStackTrace();
			log.error("", e);
		}
		return commonResponse;
	}

	/**
	 * 根据ID删除
	 * 
	 * @param id
	 * @return
	 * @date 2016-11-4
	 */
	@RequestMapping("/deleteById")
	@ResponseBody
	public CommonResponse deleteById(Integer id) {
		CommonResponse commonResponse = new CommonResponse();
		try {
			rsMaterialArchiveService.deleteById(id);
			commonResponse.setSuccess(true);
			commonResponse.setMessage("删除成功");
		} catch (Exception e) {
			commonResponse.setSuccess(false);
			commonResponse.setMessage("删除失败");
			e.printStackTrace();
			log.error("", e);
		}
		return commonResponse;
	}

	/**
	 * 根据材料名称查询档案信息
	 * 
	 * @param materialName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getByName")
	public DataGridData getArchiveByName(HttpServletRequest request) {
		DataGridData data = new DataGridData<>();
		String materialName = request.getParameter("name");
		List<RsMaterialArchive> list = rsMaterialArchiveService
				.getArchiveByName(materialName);

		PageInfo<RsMaterialArchive> page = new PageInfo<>(list);
		data.setRows(page.getList());
		data.setTotal(page.getTotal());
		data.setMessage("成功");
		data.setSuccess(true);
		return data;

	}

	/**
	 * 获取登陆人信息
	 * 
	 * @param materialName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toAdd")
	public RsMaterialArchive toAdd(HttpServletRequest request,
			HttpServletResponse response) {
		RsMaterialArchive record = new RsMaterialArchive();
		Subject subject = SecurityUtils.getSubject();
		UserDetails userDetails = (UserDetails) subject.getPrincipal();
		record.setCreateName(userDetails.getLoginName());

		Date credate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String format = sdf.format(credate);

		record.setCreateDate(credate);
		record.setCreateDateStr(format);

		return record;
	}

}
