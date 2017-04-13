package com.unionx.web.insurance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unionx.web.insurance.dao.RsInsuranceBaseMapper;
import com.unionx.web.insurance.vo.RsInsuranceBase;
import com.unionx.web.insurance.vo.RsInsuranceBaseCriteria;
import com.unionx.web.insurance.vo.RsInsuranceBaseCriteria.Criteria;

import org.springframework.beans.factory.annotation.Autowired;

/*
 * 
 * 险种
 */
@Service
public class RsInsuranceBaseService {
	
	@Autowired
	private RsInsuranceBaseMapper mp;
	
	public List<RsInsuranceBase> getRsInsuranceBaseByUuid(String id) {
		RsInsuranceBaseCriteria criteria = new RsInsuranceBaseCriteria();
    	Criteria criteria1 =  criteria.createCriteria();
    	criteria1.andInsuranceUuidEqualTo(id);
    	return mp.selectByExample(criteria);
	}

}
