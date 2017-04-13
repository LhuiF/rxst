package com.unionx.web.archive.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.ParseException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unionx.core.security.shiro.UserDetails;
import com.unionx.core.util.Identities;
import com.unionx.sys.enterprise.vo.RsEnterprise;
import com.unionx.sys.produce.dao.SysProductMapper;
import com.unionx.sys.produce.vo.SysProduct;
import com.unionx.web.archive.dao.RsConditionArchiveMapper;
import com.unionx.web.archive.dao.RsConditionMapper;
import com.unionx.web.archive.vo.RsCondition;
import com.unionx.web.archive.vo.RsConditionArchive;
import com.unionx.web.archive.vo.RsConditionCriteria;
import com.unionx.web.archive.vo.RsConditionCriteria.Criteria;
import com.unionx.web.archive.vo.RsMaterialArchive;

@Service
public class RsConditionArchiveService {

	@Autowired
	private RsConditionArchiveMapper rsConditionArchiveMapper;
	@Autowired
	private RsConditionMapper rsConditionMapper;
	
	@Autowired 
	private SysProductMapper sysProductMapper;
	
	/**
	 * 获取数据列表信息
	 * @param record
	 * @param page
	 * @param rows
	 * @return
	 */
	public PageInfo<RsConditionArchive> getConditionArchiveList(
		RsConditionArchive record, int page, int rows) {
			PageHelper.startPage(page, rows);
			List<RsConditionArchive> list = this.rsConditionArchiveMapper.getConditionArchiveList(record);
			
			if (list != null && list.size() > 0) {
				for (RsConditionArchive rs : list) {
					List<RsCondition> conditions = rsConditionMapper.getRsConditionsByUUID(String.valueOf(rs.getId()));
					StringBuilder sb = new StringBuilder();
					if (conditions != null && conditions.size() > 0) {
						for (RsCondition rsCondition : conditions) {
							sb.append("条件:").append(rsCondition.getCondition()).append("-");
						}
					}else{
						continue;
					}
					String cons = sb.toString().substring(0, sb.toString().length() - 1);
					rs.setSituation(cons);
				}
			}
			return new PageInfo(list);
	}
	/**
	 * 根据产品名称.是否网申查询信息
	 * @param record
	 * @return
	 */
	public List<RsConditionArchive> getArchiveByName(RsConditionArchive record) {
		return rsConditionArchiveMapper.getArchiveByName(record);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Integer id) {
		rsConditionArchiveMapper.deleteById(id);
		String situationUuid = id.toString();
		rsConditionMapper.deleteById(situationUuid);
		
	}
	/**
	 * 修改
	 * @param record
	 */
	public void update(RsConditionArchive record) {
		Date now = new Date();
		Subject subject = SecurityUtils.getSubject();
		UserDetails userDetails = (UserDetails) subject.getPrincipal();
		String loginName = userDetails.getLoginName();
		record.setUpdateDate(now);
		record.setUpdateName(loginName);
		rsConditionArchiveMapper.updateByPrimaryKeySelective(record);
		List<RsCondition> conditions = record.getConditions();
		for (RsCondition rsCondition : conditions) {
			if(rsCondition.getId()!=null&&rsCondition.getId()!=""){
				rsCondition.setUpdateDate(now);
				rsCondition.setUpdateName(loginName);
				rsConditionMapper.updateByPrimaryKeySelective(rsCondition);
			}else{
	        	rsCondition.setId(Identities.uuid());
	        	rsCondition.setSituationUuid(record.getId().toString());
	        	rsCondition.setCreateDate(now);
	        	rsCondition.setCreateName(loginName);
	        	rsCondition.setIsdel("0");
	        	rsConditionMapper.insertSelective(rsCondition);
			}
		}
	}
	/**
	 * 保存
	 * @param record
	 * @throws ParseException 
	 */
	public void save(RsConditionArchive record) throws ParseException {
		Date now = new Date();
		Subject subject = SecurityUtils.getSubject();
		UserDetails userDetails = (UserDetails) subject.getPrincipal();
		String loginName = userDetails.getLoginName();
		record.setCreateName(loginName); 
		record.setCreateDate(now);
		record.setIsdel("0");
		rsConditionArchiveMapper.insertSelective(record);
	    List<RsCondition> conditions = record.getConditions();
     	for (RsCondition rsCondition : conditions) {
     		if(StringUtils.isNotBlank(rsCondition.getCondition())){
     			rsCondition.setId(Identities.uuid());
     			rsCondition.setSituationUuid(record.getId().toString());
     			rsCondition.setCreateDate(now);
     			rsCondition.setCreateName(loginName);
     			rsCondition.setIsdel("0");
				rsConditionMapper.insertSelective(rsCondition);
        	}
		}
			
	}

	public RsConditionArchive getArchiveById(int id) {
		RsConditionArchive conditionArchive = rsConditionArchiveMapper.selectByPrimaryKey(id);
		RsConditionCriteria rsConditionCriteria = new RsConditionCriteria();
		Criteria criteria = rsConditionCriteria.createCriteria();
		criteria.andSituationUuidEqualTo(id+"");
		conditionArchive.setConditions(rsConditionMapper.selectByExample(rsConditionCriteria));
		return conditionArchive;
	}
	public List<SysProduct> getCondition() {
		return sysProductMapper.getCondition();
	}
	public List<SysProduct> getConditionById(String id) {
		return sysProductMapper.getConditionById(id);
	}
	public void deleteConditionById(String id) {
		rsConditionMapper.deleteConditionById(id);
	}
}
