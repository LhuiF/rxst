package com.unionx.web.calculator.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unionx.core.util.JacksonMapper;
import com.unionx.web.accumulation.vo.RsAccumulationFund;
import com.unionx.web.accumulation.vo.RsAccumulationFundProportion;
import com.unionx.web.calculator.dao.CalculatorMapper;
import com.unionx.web.calculator.vo.Base;
import com.unionx.web.calculator.vo.RequestVo;
import com.unionx.web.calculator.vo.ResultAccumulation;
import com.unionx.web.calculator.vo.ResultInsuranceVo;
import com.unionx.web.calculator.vo.ResultVo;
import com.unionx.web.insurance.po.InsuranceProportionDetail;
import com.unionx.web.insurance.vo.RsInsuranceProportion;

@Service
public class CalculatorService {
	
	@Autowired
	CalculatorMapper calculatorMapper;

	/**
	 * 计算
	 * @Description: TODO 
	 * @throws
	 * @author zhaoyubo
	 * @date 2016-11-17
	 */
	public ResultVo calculator(RequestVo vo) throws Exception {
		//社保申报工资
		Double insurance = vo.getInsurance();
		//公积金申报工资
		Double fund = vo.getAccumulationFund();
		
		//1.根据城市、日期查出对应的上下限基数计算出神保申报工资
		List<Base> list = calculatorMapper.getBase(vo);
		
		Map<String,Double> baseMap = new HashMap<String, Double>();
		String uuid = list.get(0).getUuid();
		
		for(Base s : list){
			//大于上限,取上限
			if (insurance > s.getCeilingBase()) {
				baseMap.put(s.getDictCode(), s.getCeilingBase());
			//小于下限、取下限 
			}else if(insurance < s.getFloorBase()){
				baseMap.put(s.getDictCode(), s.getFloorBase());
			}else {
				baseMap.put(s.getDictCode(), insurance);
			}
		}
		/**
		 *  001	养老
			002	失业
			003	工伤
			004	生育
			005	医疗
		 */
		//2.取缴费比例
		List<RsInsuranceProportion> protion = calculatorMapper.getInsuranceProportionByUuid(uuid);
		List<ResultInsuranceVo> resultinsurance = new ArrayList<ResultInsuranceVo>();
		for(RsInsuranceProportion s : protion){
			ResultInsuranceVo rs = new ResultInsuranceVo();
			rs.setName(s.getDictName());
			InsuranceProportionDetail detail = JacksonMapper.getInstance().readValue(s.getProportionDetail(), InsuranceProportionDetail.class);
			//养老
			rs.setPensionsEnterprise(detail.getPensionsEnterprise() * baseMap.get("001") / 100);
			rs.setPensionsPersonal(detail.getPensionsPersonal()	* baseMap.get("001") / 100);
			//失业
			rs.setUnemploymentEnterprise(detail.getUnemploymentEnterprise() * baseMap.get("002") /100);
			rs.setUnemploymentPersonal(detail.getUnemploymentPersonal() * baseMap.get("002") /100);
			//工伤
			rs.setInjuriesEnterprise(detail.getInjuriesEnterprise() * baseMap.get("003") /100);
			rs.setInjuriesPersonal(detail.getInjuriesPersonal() * baseMap.get("003") /100);
			//生育
			rs.setBirthEnterprise(detail.getBirthEnterprise() * baseMap.get("004") /100);
			rs.setBirthPersonal(detail.getBirthPersonal() * baseMap.get("004") /100);
			//医疗
			rs.setMedicalEnterprise(detail.getMedicalEnterprise() * baseMap.get("005") /100 );
			rs.setMedicalPersonal(detail.getMedicalPersonal() * baseMap.get("005") /100 );
			
			rs.setEnterpriseSum();
			rs.setPersonalSum();
			rs.setTotal();
			resultinsurance.add(rs);
		}
		
		//计算公积金上下限基数
		RsAccumulationFund accumulationFund =  calculatorMapper.getFundBase(vo);
		Double ceiling =  Double.parseDouble(accumulationFund.getCeilingBase());
		Double floor =  Double.parseDouble(accumulationFund.getFloorBase());
		if(fund > ceiling){
			fund = ceiling;
		}else if(fund < floor){
			fund = floor;
		}
		List<RsAccumulationFundProportion> fundProportion= calculatorMapper.getAccumulationFundProportion(accumulationFund.getUuid());
		List<ResultAccumulation> accumulationList = new ArrayList<ResultAccumulation>();
		for(RsAccumulationFundProportion s: fundProportion){
			ResultAccumulation accumulation = new ResultAccumulation();
			accumulation.setName(s.getName());
			accumulation.setEnterprise(Double.parseDouble(s.getEnterprise()) * fund/100);
			accumulation.setPersonal(Double.parseDouble(s.getPersonalNotFloor()) * fund/100);
			accumulation.setTotal();
			accumulationList.add(accumulation);
		}
		
		ResultVo result = new ResultVo();
		result.setInsurance(resultinsurance);
		result.setAccumulation(accumulationList);
		return result;
	}

	public List<Map<String, String>> getCity() {
		
		return calculatorMapper.getCity();
	}

}
