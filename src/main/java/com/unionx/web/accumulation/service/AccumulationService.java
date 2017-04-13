package com.unionx.web.accumulation.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unionx.core.security.shiro.UserDetails;
import com.unionx.core.util.Identities;
import com.unionx.sys.dict.vo.DictItem;
import com.unionx.web.accumulation.dao.RsAccumulationFundAccountMapper;
import com.unionx.web.accumulation.dao.RsAccumulationFundMapper;
import com.unionx.web.accumulation.po.RsAccumulationFundVo;
import com.unionx.web.accumulation.vo.RsAccumulationFund;
import com.unionx.web.accumulation.vo.RsAccumulationFundAccount;
import com.unionx.web.accumulation.vo.RsAccumulationFundCriteria;
import com.unionx.web.accumulation.vo.RsAccumulationFundCriteria.Criteria;

@Service
public class AccumulationService {

	@Autowired
	private RsAccumulationFundMapper accumulationFundMapper;
	
	@Autowired
	private RsAccumulationFundAccountMapper accumulationFundAccountMapper;
	
	/**
	 * 保存
	 * @throws ParseException 
	 * @Description: TODO 
	 * @throws
	 * @author zhaoyubo
	 * @date 2016-11-2
	 */
	@Transactional
	public void saveOrUpdate(RsAccumulationFundVo accumulationFund) throws ParseException{
		Subject subject = SecurityUtils.getSubject();
		UserDetails userDetails = (UserDetails) subject.getPrincipal();
		
		RsAccumulationFundCriteria example = new RsAccumulationFundCriteria();
		Criteria criteria = example.createCriteria();
		
		if (accumulationFund.getId() != null) {
			accumulationFund.setUpdateDate(new Date());
			accumulationFund.setUpdateName(userDetails.getLoginName());
			accumulationFundMapper.updateByPrimaryKeySelective(accumulationFund);
			
			// 配置对应户口
			for (int i = 0; i < accumulationFund.getCode().length; i++) {
				RsAccumulationFundAccount account = new RsAccumulationFundAccount();
				account.setId(Integer.parseInt(accumulationFund.getFundIds()[i]));
				account.setDictCode(accumulationFund.getCode()[i]);
				account.setDictName(accumulationFund.getName()[i]);
				account.setStartTime(new SimpleDateFormat("yyyy-MM-dd").parse(accumulationFund.getStart()[i]));
				account.setEndTime(new SimpleDateFormat("yyyy-MM-dd").parse(accumulationFund.getEnd()[i]));

				accumulationFundAccountMapper.updateByPrimaryKeySelective(account);
			}

		} else {
			criteria.andFundYearEqualTo(accumulationFund.getFundYear());
			criteria.andDictCodeEqualTo(accumulationFund.getDictCode());
			criteria.andIsdelEqualTo(false);
			List list = accumulationFundMapper.selectByExample(example);
			
			if (list != null && list.size() > 0) 
				throw new RuntimeException(accumulationFund.getDictName()+accumulationFund.getFundYear()+" 已存在");
			
			// 生成逻辑主键
			String uuid = Identities.uuid();
			accumulationFund.setCreateName(userDetails.getLoginName());
			accumulationFund.setUuid(uuid);
			accumulationFund.setIsdel(false);
			accumulationFund.setCreateDate(new Date());
			accumulationFund.setYearCity(accumulationFund.getFundYear()+accumulationFund.getDictName());

			accumulationFundMapper.insert(accumulationFund);
			// 配置对应户口
			for (int i = 0; i < accumulationFund.getCode().length; i++) {
				RsAccumulationFundAccount account = new RsAccumulationFundAccount();
				account.setAccumulationFundUuid(uuid);
				account.setDictCode(accumulationFund.getCode()[i]);
				account.setDictName(accumulationFund.getName()[i]);
				account.setStartTime(new SimpleDateFormat("yyyy-MM-dd").parse(accumulationFund.getStart()[i]));
				account.setEndTime(new SimpleDateFormat("yyyy-MM-dd").parse(accumulationFund.getEnd()[i]));

				accumulationFundAccountMapper.insert(account);
			}
		}
	}

	/**
	 * 公积金基本参数设置列表
	 * @Description: TODO 
	 * @throws
	 * @author zhaoyubo
	 * @date 2016-11-2
	 */
	public PageInfo<RsAccumulationFund> getAccumulationList(RsAccumulationFund fund,int page, int rows) {
		
		RsAccumulationFundCriteria example = new RsAccumulationFundCriteria();
		Criteria criteria = example.createCriteria();
		if(StringUtils.isNotEmpty(fund.getDictCode())){
			criteria.andDictCodeEqualTo(fund.getDictCode());
		}
		if(StringUtils.isNotEmpty(fund.getFundYear())){
			criteria.andFundYearEqualTo(fund.getFundYear());
		}
		criteria.andIsdelEqualTo(false);
		
		PageHelper.startPage(page, rows);
		List<RsAccumulationFund> accumulationList = accumulationFundMapper.selectByExample(example);
		
		return new PageInfo(accumulationList);
	}

	public List<DictItem> getDict(String code) {
		List<DictItem> list = accumulationFundMapper.getdictBycode(code);
		return list;
	}

	public List<RsAccumulationFundVo> getgAccumulationById(String id) {
		return accumulationFundMapper.getgAccumulationById(id);
		
	}

	public void deleteAccumulationById(Integer id) {
		RsAccumulationFund fund = new RsAccumulationFund();
		fund.setId(id);
		fund.setIsdel(true);
		accumulationFundMapper.updateByPrimaryKeySelective(fund);
		
	}

	public List<RsAccumulationFund> getProportion() {
		return accumulationFundMapper.getProportion();
	}

	public List<RsAccumulationFund> getAccumulationByUuid(String id) {
		RsAccumulationFundCriteria criteria = new RsAccumulationFundCriteria();
    	Criteria criteria1 =  criteria.createCriteria();
    	criteria1.andUuidEqualTo(id);
    	
    	return accumulationFundMapper.selectByExample(criteria);
	}
	
}
