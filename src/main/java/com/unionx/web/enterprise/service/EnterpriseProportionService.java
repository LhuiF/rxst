package com.unionx.web.enterprise.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unionx.core.security.shiro.UserDetails;
import com.unionx.sys.enterprise.dao.RsEnterpriseMapper;
import com.unionx.sys.enterprise.po.RsEnterpriseCriteria;
import com.unionx.sys.enterprise.po.RsEnterpriseCriteria.Criteria;
import com.unionx.sys.enterprise.vo.RsEnterprise;
import com.unionx.web.enterprise.dao.RsEnterpriseProportionMapper;
import com.unionx.web.enterprise.po.AccumulationPo;
import com.unionx.web.enterprise.po.EnterpriseSubmit;
import com.unionx.web.enterprise.vo.RsEnterpriseProportion;
import com.unionx.web.enterprise.vo.RsEnterpriseProportionCriteria;

@Service
public class EnterpriseProportionService {
	
	@Autowired
	RsEnterpriseProportionMapper proportionMapper;
	
	@Autowired
	RsEnterpriseMapper enterpriseMapper;

	//获得企业
	public List<RsEnterprise> getEnterprise() {
		RsEnterpriseCriteria example = new RsEnterpriseCriteria();
		Criteria criteria =  example.createCriteria();
		criteria.andIsdelEqualTo("0");
		
		return enterpriseMapper.selectByExample(example);
	}

	/**
	 * 根据参数查询列表页
	 * @Description: TODO 
	 * @throws
	 * @author zhaoyubo
	 * @date 2016-11-15
	 */
	public PageInfo<RsEnterpriseProportion> getEnterpriseByParameter(RsEnterpriseProportion fund, int page, int rows) {
		//组装查询参数
		Map<String,String> parMap = new HashMap<String,String>();

		if (StringUtils.isNotEmpty(fund.getEnterpriseName()))
			parMap.put("enterpriseName", fund.getEnterpriseName());
		if (StringUtils.isNotEmpty(fund.getYearCity()))
			parMap.put("yearCity", fund.getYearCity());

		PageHelper.startPage(page, rows);
		List<RsEnterpriseProportion> list = proportionMapper.queryByExample(parMap);
		return new PageInfo<RsEnterpriseProportion>(list);

	}

	public List<AccumulationPo> getEnterpriseByAdd(String id) {
		return proportionMapper.getEnterpriseByAdd(id);
	}

	/**
	 * 保存
	 * @Description: TODO 
	 * @throws
	 * @author zhaoyubo
	 * @date 2016-11-16
	 */
	public void saveOrUpdate(EnterpriseSubmit submit) {
		Subject subject = SecurityUtils.getSubject();
		UserDetails userDetails = (UserDetails) subject.getPrincipal();
		
		String[] ids = submit.getIds();
		if (ids != null && ids.length > 0) {
			//更新
			for (int i = 0; i < ids.length; i++) {
				RsEnterpriseProportion proportion = new RsEnterpriseProportion();
				proportion.setId(Integer.parseInt(submit.getIds()[i]));
				proportion.setAccumulationFundUuid(submit.getUuid());
				proportion.setCode(submit.getCodes()[i]);
				proportion.setName(submit.getNames()[i]);
				proportion.setEnterpriseName(submit.getEnterpriseName());
				proportion.setEnterpriseId(submit.getEnterpriseId());
				proportion.setStartTime(submit.getStartTime());
				proportion.setEndTime(submit.getEndTime());
				proportion.setYearCity(submit.getYearCity());
				proportion.setEnterprise(submit.getEnterprises()[i]);
				proportion.setPersonalFloor(submit.getPersonalFloors()[i]);
				proportion.setPersonalNotFloor(submit.getPersonalNotFloors()[i]);
				proportion.setUpdateDate(new Date());
				proportion.setUpdateName(userDetails.getLoginName());
				
				proportionMapper.updateByPrimaryKeySelective(proportion);
			}
			
		}else{
			for (int i = 0; i < submit.getCodes().length; i++) {
				RsEnterpriseProportion proportion = new RsEnterpriseProportion();
				proportion.setAccumulationFundUuid(submit.getUuid());
				proportion.setCode(submit.getCodes()[i]);
				proportion.setName(submit.getNames()[i]);
				proportion.setEnterpriseName(submit.getEnterpriseName());
				proportion.setEnterpriseId(submit.getEnterpriseId());
				proportion.setStartTime(submit.getStartTime());
				proportion.setEndTime(submit.getEndTime());
				proportion.setYearCity(submit.getYearCity());
				proportion.setEnterprise(submit.getEnterprises()[i]);
				proportion.setPersonalFloor(submit.getPersonalFloors()[i]);
				proportion.setPersonalNotFloor(submit.getPersonalNotFloors()[i]);
				proportion.setIsdel(false);
				proportion.setCreateDate(new Date());
				proportion.setCreateName(userDetails.getLoginName());
				
				proportionMapper.insert(proportion);
			}
		}
	}

	/**
	 * 根据ID页面回显(编辑)
	 * @Description: TODO 
	 * @throws
	 * @author zhaoyubo
	 * @date 2016-11-16
	 */
	public List<RsEnterpriseProportion> getProportionById(String id) {
		RsEnterpriseProportionCriteria example = new RsEnterpriseProportionCriteria();
		com.unionx.web.enterprise.vo.RsEnterpriseProportionCriteria.Criteria criteria =  example.createCriteria();
		criteria.andEnterpriseIdEqualTo(id);
		criteria.andIsdelEqualTo(false);
		return proportionMapper.selectByExample(example);
	}

	/**
	 * 删除
	 * @Description: TODO 
	 * @throws
	 * @author zhaoyubo
	 * @date 2016-11-16
	 */
	public void deleteById(String id) {
		proportionMapper.deleteById(id);
	}
	
}
