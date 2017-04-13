package com.unionx.sys.enterprise.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unionx.core.security.shiro.UserDetails;
import com.unionx.core.util.Identities;
import com.unionx.sys.enterprise.dao.RsEnterpriseMapper;
import com.unionx.sys.enterprise.po.RsEnterpriseCriteria;
import com.unionx.sys.enterprise.po.RsEnterpriseCriteria.Criteria;
import com.unionx.sys.enterprise.vo.RsEnterprise;
import com.unionx.web.proxy.dao.RsLinkpeopleMapper;
import com.unionx.web.proxy.po.RsLinkpeopleCriteria;
import com.unionx.web.proxy.vo.RsLinkpeople;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author lhf
 *
 */
@Service
public class EnterpriseService {
    @Autowired
    private RsEnterpriseMapper enterpriseMapper;
    @Autowired
	private RsLinkpeopleMapper rsLinkpeopleMapper;
    
    /**
     * 查询 企业信息
     * @param rsEnterprise
     * @param page
     * @param rows
     * @return
     */
    @Transactional
    public  PageInfo<RsEnterprise> getEnterpriseList (RsEnterprise rsEnterprise,Integer page,Integer rows){
    	RsEnterpriseCriteria rsEnterpriseCriteria = new RsEnterpriseCriteria();
    	Criteria criteria = rsEnterpriseCriteria.createCriteria();
    	if(StringUtils.isNotBlank(rsEnterprise.getAngencyId())){
    		criteria.andAngencyIdEqualTo(rsEnterprise.getAngencyId());
    	}
    	if(StringUtils.isNotBlank(rsEnterprise.getName())){
    		criteria.andNameLike(rsEnterprise.getName());
    	}
    	if(StringUtils.isNotBlank(rsEnterprise.getInsuranceAccount())){
    		criteria.andInsuranceAccountEqualTo(rsEnterprise.getInsuranceAccount());
    	}
    	if(StringUtils.isNotBlank(rsEnterprise.getOrgCode())){
    		criteria.andOrgCodeEqualTo(rsEnterprise.getOrgCode());
    	}
    	if(StringUtils.isNotBlank(rsEnterprise.getInsureanceArea())){
    		criteria.andInsureanceAreaEqualTo(rsEnterprise.getInsureanceArea());
    	}
    	if(StringUtils.isNotBlank(rsEnterprise.getAccumulationArea())){
    		criteria.andAccumulationAreaEqualTo(rsEnterprise.getAccumulationArea());
    	}
    	if(rsEnterprise.getId()!= null){
    		criteria.andIdEqualTo(rsEnterprise.getId());
    	}
    	criteria.andIsdelEqualTo("0");
    	PageHelper.startPage(page, rows);
    	List<RsEnterprise> rsEnterprises = enterpriseMapper.selectByExample(rsEnterpriseCriteria);
    	return new PageInfo<RsEnterprise>(rsEnterprises);
    }
    @Transactional
    public List<RsEnterprise> getEnterpriseListByAngencyId(String angencyId){
    	return enterpriseMapper.getEnterpriseListByAngencyId(angencyId);
    }
    @Transactional
	public void saveEnterprise(RsEnterprise rsEnterprise) {
		Subject subject = SecurityUtils.getSubject();
		UserDetails userDetails = (UserDetails) subject.getPrincipal();
		String uuid = Identities.uuid();
		rsEnterprise.setId(uuid);
		Date now = new Date();
		rsEnterprise.setCreateDate(now);
		rsEnterprise.setIsdel("0");
		rsEnterprise.setCreateName(userDetails.getLoginName());
		enterpriseMapper.insertSelective(rsEnterprise);
		List<RsLinkpeople> rsLinkpeoples = rsEnterprise.getList();
		if(rsLinkpeoples != null)
		for (RsLinkpeople rsLinkpeople : rsLinkpeoples) {
			rsLinkpeople.setAssociationId(uuid);
			rsLinkpeople.setCreateDate(now);
			rsLinkpeople.setCreatePeo(userDetails.getLoginName());
			rsLinkpeopleMapper.insertSelective(rsLinkpeople);
		}
	}
	@Transactional
	public RsEnterprise getEnterpriseById(String id) {
		RsEnterprise rsEnterprises = enterpriseMapper.selectByPrimaryKey(id);
		RsLinkpeopleCriteria rsLinkpeopleCriteria = new RsLinkpeopleCriteria();
		com.unionx.web.proxy.po.RsLinkpeopleCriteria.Criteria criteria = rsLinkpeopleCriteria.createCriteria();
		criteria.andAssociationIdEqualTo(id);
		rsEnterprises.setList(rsLinkpeopleMapper.selectByExample(rsLinkpeopleCriteria));
		return rsEnterprises;
	}
    
	@Transactional
	public void updateEnterprise(RsEnterprise enterprise) {
		//添加更新时间
		enterprise.setUpdateDate(new Date());
		//添加更新人
		Subject subject = SecurityUtils.getSubject();
		UserDetails userDetails = (UserDetails) subject.getPrincipal();
		enterprise.setUpdateName(userDetails.getLoginName());
		enterpriseMapper.updateByPrimaryKeySelective(enterprise);
		//删除原有联系人
		RsLinkpeopleCriteria rsLinkpeopleCriteria = new RsLinkpeopleCriteria();
		com.unionx.web.proxy.po.RsLinkpeopleCriteria.Criteria criteria = rsLinkpeopleCriteria.createCriteria();
		criteria.andAssociationIdEqualTo(enterprise.getId());
		rsLinkpeopleMapper.deleteByExample(rsLinkpeopleCriteria);
		//添加新的联系人
		List<RsLinkpeople> list = enterprise.getList();
		if(list != null)
		for (RsLinkpeople rsLinkpeople : list) {
			rsLinkpeople.setAssociationId(enterprise.getId());
			rsLinkpeopleMapper.insertSelective(rsLinkpeople);
		}
	}
	@Transactional
	public void deleteEnterprise(String id) {
		enterpriseMapper.deleByid(id);
	}
}
