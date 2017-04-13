package com.unionx.web.accumulation.service;

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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unionx.core.security.shiro.UserDetails;
import com.unionx.web.accumulation.dao.RsAccumulationFundMapper;
import com.unionx.web.accumulation.dao.RsAccumulationFundProportionMapper;
import com.unionx.web.accumulation.po.RsAccumulationFundProportionVo;
import com.unionx.web.accumulation.vo.RsAccumulationFund;
import com.unionx.web.accumulation.vo.RsAccumulationFundProportion;
import com.unionx.web.accumulation.vo.RsAccumulationFundProportionCriteria;
import com.unionx.web.accumulation.vo.RsAccumulationFundProportionCriteria.Criteria;

@Service
public class ProportionService {

	@Autowired
	RsAccumulationFundProportionMapper proportionMapper;
	
	@Autowired
	RsAccumulationFundMapper fundMapper;

	/**
	 * 保存方法,更新
	 * @param vo
	 */
	@Transactional
	public void saveOrUpdate(RsAccumulationFundProportionVo vo) {
		Subject subject = SecurityUtils.getSubject();
		UserDetails userDetails = (UserDetails) subject.getPrincipal();
		
		RsAccumulationFundProportionCriteria proportionCriteria = new RsAccumulationFundProportionCriteria();
		Criteria criteria = proportionCriteria.createCriteria();
		
		if (vo.getIds() != null && vo.getIds().length > 0) {
			//更新
			for (int i = 0; i < vo.getCompany().length; i++) {
				RsAccumulationFundProportion proportion = new RsAccumulationFundProportion();
				proportion.setId(vo.getIds()[i]);
				proportion.setEnterprise(vo.getCompany()[i]);
				proportion.setPersonalNotFloor(vo.getNotFloor()[i]);
				proportion.setPersonalFloor(vo.getFloor()[i]);
				proportion.setUpdateDate(new Date());
				proportion.setUpdateName(userDetails.getLoginName());
				
				proportionMapper.updateByPrimaryKeySelective(proportion);
			}
		}else{
			criteria.andAccumulationFundUuidEqualTo(vo.getAccumulationFundUuid());
			List list = proportionMapper.selectByExample(proportionCriteria);
			
			if (list != null && list.size() > 0)
				throw new RuntimeException("该缴费比例已存在");
			
			for (int i = 0; i < vo.getCodes().length; i++) {
				RsAccumulationFundProportion proportion = new RsAccumulationFundProportion();
				proportion.setAccumulationFundUuid(vo.getAccumulationFundUuid());
				proportion.setCode(vo.getCodes()[i]);
				proportion.setName(vo.getNames()[i]);
				proportion.setEnterprise(vo.getCompany()[i]);
				proportion.setPersonalNotFloor(vo.getNotFloor()[i]);
				proportion.setPersonalFloor(vo.getFloor()[i]);
				proportion.setCreateName(userDetails.getLoginName());
				proportion.setCreateDate(new Date());
				proportion.setIsdel(false);
				
				proportionMapper.insert(proportion);
			}
		}
		
		
	}

	/**
	 * 列表
	 * @param fund
	 * @param page
	 * @param rows
	 * @return
	 */
	public PageInfo<RsAccumulationFund> getAccumulationList(RsAccumulationFund fund, int page, int rows) {
		//封装查询参数
		Map<String,String> parMap = new HashMap<String,String>();
		
		if(StringUtils.isNotEmpty(fund.getYearCity())){
			parMap.put("yearCity", fund.getYearCity());
		}
		
		PageHelper.startPage(page, rows);
		List<RsAccumulationFund> list = fundMapper.getAccumByProp();
		return new PageInfo<RsAccumulationFund>(list);
	}

	
	public List<RsAccumulationFundProportionVo> getProportionById(String id) {
		return proportionMapper.getProportionById(id);
		
	}

	/**
	 * 根据Id删除
	 * @Description: TODO 
	 * @throws
	 * @author zhaoyubo
	 * @date 2016-11-9
	 */
	public void deleteById(String id) {
		proportionMapper.deleteById(id);
	}

	
}
