package com.unionx.web.insurance.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unionx.core.security.shiro.UserDetails;
import com.unionx.core.util.JacksonMapper;
import com.unionx.web.insurance.dao.RsInsuranceProportionMapper;
import com.unionx.web.insurance.po.InsurancePage;
import com.unionx.web.insurance.po.InsuranceProportionDetail;
import com.unionx.web.insurance.po.InsuranceResult;
import com.unionx.web.insurance.vo.RsInsurance;
import com.unionx.web.insurance.vo.RsInsuranceProportion;
import com.unionx.web.insurance.vo.RsInsuranceProportionCriteria;
import com.unionx.web.insurance.vo.RsInsuranceProportionCriteria.Criteria;


@Service
public class RsInsuranceProportionService {

	@Autowired
	RsInsuranceProportionMapper proportionMapper;

	public List<RsInsurance> getInsurance() {
		return proportionMapper.getInsurance();
	}

	public List<RsInsurance> getInsuranceByUuid(String id) {
		return proportionMapper.getInsuranceByUuid(id);
	}

	/**
	 * 保存
	 * @throws JsonProcessingException 
	 * @Description: TODO 
	 * @throws
	 * @author zhaoyubo
	 * @date 2016-11-10
	 */
	@Transactional
	public void saveOrUpdate(InsurancePage page) throws JsonProcessingException {
		Subject subject = SecurityUtils.getSubject();
		UserDetails userDetails = (UserDetails) subject.getPrincipal();
		
		List<InsuranceProportionDetail> list = page.getList();
		
		//判断是新增还是修改
		if (page.getId() != null && page.getId().length > 0) {
			//修改
			for (int i = 0; i < page.getId().length; i++) {
				RsInsuranceProportion proportion = new RsInsuranceProportion();
				proportion.setUpdateDate(new Date());
				proportion.setUpdateName(userDetails.getLoginName());
				proportion.setId(Integer.parseInt(page.getId()[i]));
				proportion.setProportionDetail(JacksonMapper.getInstance().writeValueAsString(list.get(i)));
				
				proportionMapper.updateByPrimaryKeySelective(proportion);
			}
		} else {
			RsInsuranceProportionCriteria example = new RsInsuranceProportionCriteria();
			Criteria criteria = example.createCriteria();
			criteria.andInsuranceUuidEqualTo(page.getUuid());
			
			List<RsInsuranceProportion> l = proportionMapper.selectByExample(example);
			if (l != null && l.size() > 0)
				throw new RuntimeException("该社保缴费比例已存在");
			
			for (int i = 0; i < list.size(); i++) {
				RsInsuranceProportion proportion = new RsInsuranceProportion();
				proportion.setInsuranceUuid(page.getUuid());
				proportion.setDictCode(page.getCodes()[i]);
				proportion.setDictName(page.getNames()[i]);
				proportion.setCreateName(userDetails.getLoginName());
				proportion.setCreateDate(new Date());
				proportion.setIsdel(false);
				proportion.setProportionDetail(JacksonMapper.getInstance().writeValueAsString(list.get(i)));
				
				proportionMapper.insert(proportion);
				
			}
		}

	}

	/**
	 * 根据ID进行回显
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * @Description: TODO 
	 * @throws
	 * @author zhaoyubo
	 * @date 2016-11-10
	 */
	public List<InsuranceResult> getProportionById(String id) {
			List<InsuranceResult> resultList = new ArrayList<InsuranceResult>();
		try {
			RsInsuranceProportionCriteria example = new RsInsuranceProportionCriteria();
			Criteria criteria = example.createCriteria();
			criteria.andInsuranceUuidEqualTo(id);
			criteria.andIsdelEqualTo(false);
			
			List<RsInsuranceProportion> list = proportionMapper.selectByExample(example);
			for(RsInsuranceProportion p : list){
				InsuranceResult result = new InsuranceResult();
				result.setDetail(JacksonMapper.getInstance().readValue(p.getProportionDetail(), InsuranceProportionDetail.class));
				result.setId(p.getId()+"");
				result.setUuid(p.getInsuranceUuid());
				result.setName(p.getDictName());
				resultList.add(result);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
		
		//return proportionMapper.getProportionById(id);
		
	}

	/**
	 * 列表页
	 * @Description: TODO 
	 * @throws
	 * @author zhaoyubo
	 * @date 2016-11-10
	 */
	public PageInfo<RsInsurance> getInsuranceByProp(RsInsurance fund,int page, int rows) {
		//封装查询参数
		Map<String,String> parMap = new HashMap<String,String>();
		
		if(StringUtils.isNotEmpty(fund.getUuid())){
			parMap.put("uuid", fund.getUuid());
		}
		
		PageHelper.startPage(page, rows);
		List<RsInsurance> list = proportionMapper.getInsuranceByProp(parMap);
		return new PageInfo<RsInsurance>(list);
	}

	public void deleteById(String id) {
		proportionMapper.deleteById(id);
	}

	
	
}
