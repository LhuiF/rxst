package com.unionx.web.insurance.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionx.core.util.Identities;

import com.unionx.sys.user.vo.User;
import com.unionx.web.insurance.dao.RsInsuranceAccountMapper;
import com.unionx.web.insurance.dao.RsInsuranceBaseMapper;
import com.unionx.web.insurance.dao.RsInsuranceMapper;
import com.unionx.web.insurance.vo.RsInsurance;
import com.unionx.web.insurance.vo.RsInsuranceAccount;
import com.unionx.web.insurance.vo.RsInsuranceAccountCriteria;
import com.unionx.web.insurance.vo.RsInsuranceBase;
import com.unionx.web.insurance.vo.RsInsuranceCriteria;
import com.unionx.web.insurance.vo.RsInsuranceMainPage;
import com.unionx.web.insurance.vo.RsInsuranceCriteria.Criteria;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author yl
 *
 */
@Service
public class RsInsuranceService {
	
	@Autowired
	private RsInsuranceMapper rsInsuranceMapper;
	
	@Autowired
	private RsInsuranceBaseMapper rsInsuranceBaseMapper;//险种
	@Autowired
	private RsInsuranceAccountMapper rsInsuranceAccountMapper;//缴费人员类别
	
	
	public PageInfo<RsInsurance> getPageRsinsuranceList(RsInsurance vo,int page,int rows){
		
		RsInsuranceCriteria example=new RsInsuranceCriteria();
		Criteria criteria = example.createCriteria();
		List<RsInsurance> RsInsuranceList=new ArrayList<RsInsurance>();
		try{
		//城市
		if(StringUtils.isNotEmpty(vo.getDictCode())){
			criteria.andDictCodeEqualTo(vo.getDictCode());
		}
		//年度
		if(StringUtils.isNotEmpty(vo.getInsuranceYear())){
			criteria.andInsuranceYearEqualTo(vo.getInsuranceYear());
		}
		criteria.andIsdelEqualTo(false);
		//分页
		PageHelper.startPage(page, rows);
		
		 RsInsuranceList = rsInsuranceMapper.selectByExample(example);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return new PageInfo(RsInsuranceList);
	}
	
	/*
	 * 保存社保参数设置的主表数据
	 * 
	 */
	
	@Transactional
	public void saveMainRsInsurance(RsInsurance vo,RsInsuranceMainPage MainPage){
		
		User userDetails = (User) SecurityUtils.getSubject().getPrincipal();
        String uuid = Identities.uuid19();
        String yearCity=vo.getInsuranceYear()+" " +vo.getDictName();
        
        vo.setUuid(uuid);
        vo.setCreateName(userDetails.getLoginName());
        vo.setUuid(uuid);
        vo.setIsdel(false);
        vo.setCreateDate(new Date());
        vo.setYearCity(yearCity);
        rsInsuranceMapper.insert(vo);
        
        /*缴费人员类别实体*/
		 List<RsInsuranceAccount> rsInsuranceAccountList=MainPage.getRsInsuranceAccountList();
		 for(RsInsuranceAccount vorytype:rsInsuranceAccountList){
			 vorytype.setInsuranceUuid(uuid);
			 rsInsuranceAccountMapper.insert(vorytype);
			 
		 }
			/*险种基数实体*/
		 List<RsInsuranceBase> rsInsuranceBaseList=MainPage.getRsInsuranceBaseList();
		 for(RsInsuranceBase ryxz:rsInsuranceBaseList){
			 ryxz.setInsuranceUuid(uuid);
			 rsInsuranceBaseMapper.insert(ryxz);
		 }
 	
	}
	
	public void deleteAccumulationById(Integer id) {
		RsInsurance fund = new RsInsurance();
		fund.setId(id);
		fund.setIsdel(true);
		rsInsuranceMapper.updateByPrimaryKeySelective(fund);
		
	}
	//根据id主机获得社保参数主体 
	public RsInsurance getById(int id){
		return rsInsuranceMapper.selectByPrimaryKey(id);
		
	}
	/*
	 * 修改社保参数
	 * 
	 */
	@Transactional
	public void updateMainRsInsurance(RsInsurance vo,RsInsuranceMainPage MainPage){
		
		
		RsInsurance oldVO=getById(vo.getId());
		
		User userDetails = (User) SecurityUtils.getSubject().getPrincipal();
		vo.setUpdateName(userDetails.getLoginName());
		vo.setIsdel(oldVO.getIsdel());
		vo.setCreateDate(oldVO.getCreateDate());
		vo.setCreateName(oldVO.getCreateName());
		
		String yearCity=vo.getInsuranceYear()+" " +vo.getDictName();
		vo.setYearCity(yearCity);
		vo.setUpdateDate(new Date());
		rsInsuranceMapper.updateByPrimaryKey(vo);
		
		/*缴费人员类别实体*/
		 List<RsInsuranceAccount> rsInsuranceAccountList=MainPage.getRsInsuranceAccountList();
		 for(RsInsuranceAccount vorytype:rsInsuranceAccountList){
				 rsInsuranceAccountMapper.updateByPrimaryKeySelective(vorytype);
		 }
			/*修改险种基数实体*/
		 List<RsInsuranceBase> rsInsuranceBaseList=MainPage.getRsInsuranceBaseList();
		 for(RsInsuranceBase ryxz:rsInsuranceBaseList){
				 rsInsuranceBaseMapper.updateByPrimaryKeySelective(ryxz);
		 }
		
		
	}
	
	public boolean validateDictcodeYear(RsInsurance vo){
		
		RsInsuranceCriteria example=new RsInsuranceCriteria();
		Criteria criteria = example.createCriteria();
		
		criteria.andDictCodeEqualTo(vo.getDictCode());
		criteria.andInsuranceYearEqualTo(vo.getInsuranceYear());
		criteria.andIsdelEqualTo(false);
		
		long l=rsInsuranceMapper.countByExample(example);
		if(l>0){
		  return false;
		}else{
			return true;
		}
	}
	/*
	 * 跟据dictCode城市code字典项值和年度只判断社保参数维护是否完成
	 */
	public boolean validateDictcodeYear(HashMap<String,String> map){
		
		long l=rsInsuranceMapper.countByCityyear(map);
		
		if(l>0){
			  return false;
			}else{
				return true;
			}
		}
		
		
		
	}
	

