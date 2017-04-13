package com.unionx.web.archive.service;

import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unionx.core.security.shiro.UserDetails;
import com.unionx.sys.enterprise.dao.RsEnterpriseMapper;
import com.unionx.sys.enterprise.vo.RsEnterprise;
import com.unionx.web.archive.dao.RsCertificateManagementMapper;
import com.unionx.web.archive.vo.RsCertificateManagement;

@Service
public class RsCertificateService {

	@Autowired
	RsCertificateManagementMapper sCertificateMapper;
	
    @Autowired
    private RsEnterpriseMapper enterpriseMapper;

	public PageInfo<RsCertificateManagement> getCertificateList(
			RsCertificateManagement certificate, int page, int rows) {
			PageHelper.startPage(page, rows);
			List<RsCertificateManagement> list = this.sCertificateMapper.getCertificateList(certificate);
        return new PageInfo(list);
	}
	/**
	 * 修改
	 * @param record
	 */
	public void update(RsCertificateManagement record) {
		Subject subject = SecurityUtils.getSubject();
		UserDetails userDetails = (UserDetails) subject.getPrincipal();
		record.setUpdateName(userDetails.getLoginName());
		record.setUpdateDate(new Date());
		if(record.getBusinessType().equals("001")){
			record.setBusinessType("社保");
		}else{
			record.setBusinessType("公积金");
		}
		sCertificateMapper.updateByPrimaryKey(record);	
	}
	/**
	 * 保存
	 * @param record
	 */
	public void save(RsCertificateManagement record) {
		Subject subject = SecurityUtils.getSubject();
		UserDetails userDetails = (UserDetails) subject.getPrincipal();
		record.setCreateName(userDetails.getLoginName());
		record.setCreateDate(new Date());
		record.setUpdateDate(new Date());
		record.setIsdel("0");
		if(record.getBusinessType().equals("001")){
			record.setBusinessType("社保");
		}else{
			record.setBusinessType("公积金");
		}
		sCertificateMapper.insert(record);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Integer id) {
		sCertificateMapper.deleteById(id);
	}
	public List<RsCertificateManagement> getCertificateById(int id) {
		return sCertificateMapper.getCertificateById(id);
	}
	/**
	 * 获取企业信息
	 * @return
	 */
	public List<RsEnterprise> getCertificate() {
		return enterpriseMapper.getCertificate();
	}
	/**
	 * 根据id获取企业信息
	 * @param id
	 * @return
	 */
	public List<RsEnterprise> getRsCertificateById(String id) {
		return enterpriseMapper.getRsCertificateById(id);
	}
	
	
}
