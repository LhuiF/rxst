package com.unionx.web.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unionx.web.insurance.dao.RsInsuranceAccountMapper;
import com.unionx.web.insurance.vo.RsInsuranceAccount;
import com.unionx.web.insurance.vo.RsInsuranceAccountCriteria;
import com.unionx.web.insurance.vo.RsInsuranceAccountCriteria.Criteria;
/*
 * 社保参数缴费人员类别service
 */
@Service
public class RsInsuranceAccountService {
	
	@Autowired
	private RsInsuranceAccountMapper  mp;

	 public List<RsInsuranceAccount> getRsInsuranceAccountByUuid(String id) {
			RsInsuranceAccountCriteria criteria = new RsInsuranceAccountCriteria();
	    	Criteria criteria1 =  criteria.createCriteria();
	    	criteria1.andInsuranceUuidEqualTo(id);
	    	
	    return	mp.selectByExample(criteria);
	}
}
