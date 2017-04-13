package com.unionx.web.calculator.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.unionx.web.accumulation.vo.RsAccumulationFund;
import com.unionx.web.accumulation.vo.RsAccumulationFundProportion;
import com.unionx.web.calculator.vo.Base;
import com.unionx.web.calculator.vo.RequestVo;
import com.unionx.web.insurance.vo.RsInsuranceProportion;

@Repository
public interface CalculatorMapper {

	List<Base> getBase(RequestVo vo);

	List<RsInsuranceProportion> getInsuranceProportionByUuid(String uuid);

	RsAccumulationFund getFundBase(RequestVo vo);

	List<RsAccumulationFundProportion> getAccumulationFundProportion(String uuid);

	List<Map<String, String>> getCity();
	
}
