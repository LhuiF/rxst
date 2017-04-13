package com.unionx.web.company.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unionx.core.util.Identities;
import com.unionx.sys.user.vo.User;
import com.unionx.web.company.dao.CompanyShebaoBiliMapper;
import com.unionx.web.company.dao.CompanyShebaoMainbiliMapper;
import com.unionx.web.company.vo.CompanyShebaoBili;
import com.unionx.web.company.vo.CompanyShebaoBiliCriteria;
import com.unionx.web.company.vo.CompanyShebaoMainbili;
import com.unionx.web.company.vo.CompanyShebaoMainbiliCriteria;
import com.unionx.web.company.vo.EntermainBean;
import com.unionx.web.company.vo.CompanyShebaoBiliCriteria;
import com.unionx.web.company.vo.CompanyShebaoBiliCriteria.Criteria;

/**
 * 
 * @author yl
 *
 */
@Service
public class CompanyShebaoBiliService {
	@Autowired
	private CompanyShebaoBiliMapper mp;
	@Autowired
	private CompanyShebaoMainbiliMapper mainmp;
	
	public PageInfo <CompanyShebaoMainbili> getPageCompanyShebaoBili(CompanyShebaoMainbili vo,int page,int rows){
		
		CompanyShebaoMainbiliCriteria example=new CompanyShebaoMainbiliCriteria();
		CompanyShebaoMainbiliCriteria.Criteria criteria = example.createCriteria();
		List<CompanyShebaoMainbili> companysbList=new ArrayList<CompanyShebaoMainbili>();
		try{
		//企业名称
		if(StringUtils.isNotEmpty(vo.getCompanyUuid())){
			
			criteria.andCompanyUuidEqualTo(vo.getCompanyUuid());
		}
		//社保参数
		if(StringUtils.isNotEmpty(vo.getShebaoCanshuUuid())){
			criteria.andShebaoCanshuUuidEqualTo(vo.getShebaoCanshuUuid());
		}
		criteria.andIsdelEqualTo(false);
		//分页
		PageHelper.startPage(page, rows);
		
		companysbList=mainmp.selectByExample(example);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return new PageInfo(companysbList);
	}
	//保持企业社保比例数据
	@Transactional
	public void saveEnterpriseSB(EntermainBean bean){
		List<CompanyShebaoBili> enterpriseList =new ArrayList();
		try{
			
			User userDetails = (User) SecurityUtils.getSubject().getPrincipal();
			enterpriseList=bean.getRsInsuranceAccountList();
			String dept=bean.getDept();
			String uuid = Identities.uuid19();
			Date shebaoStarttime=bean.getEnterprisestartTime();
			Date shebaoEndtime=bean.getEnterpriseendTime();
			String enterpriseUuid=bean.getEnterpriseUUid();
			String enterpriseName=bean.getEnterpriseName();
			Date currentDate=new Date();
			String loginName=userDetails.getLoginName();
			
			CompanyShebaoMainbili record=new CompanyShebaoMainbili();
			record.setCompanyUuid(enterpriseUuid);
			record.setCompanyName(enterpriseName);
			record.setIsdel(false);
			record.setCreateDate(currentDate);
			record.setShebaoCanshuUuid(dept);
			record.setMainUuid(uuid);
			record.setShebaoCanshuStarttime(shebaoStarttime);
			record.setShebaoCanshuEndtime(shebaoEndtime);
			record.setShebaoCanshuYearcity(bean.getShebaoCanshuYearcity());
			record.setCreateName(loginName);
			
			mainmp.insert(record);
			for(CompanyShebaoBili vo:enterpriseList){
				//补充信息
				vo.setUuid(uuid);
				vo.setShebaoCanshuYearcity(dept);
				vo.setCompanyUuid(enterpriseUuid);
				vo.setCompanyName(enterpriseName);
				vo.setShebaoCanshuStarttime(shebaoStarttime);
				vo.setShebaoCanshuEndtime(shebaoEndtime);
				vo.setIsdel(false);
				vo.setCreateDate(currentDate);
				vo.setCreateName(loginName);
				//补充信息结束
				mp.insert(vo);//插入数据库记录
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	/*
	 * 根据id获取企业参数缴费比例对象
	 * 
	 */
	public CompanyShebaoMainbili getMainEnterprise(int id){
		return mainmp.selectByPrimaryKey(id);
	}
	
	public List<CompanyShebaoBili> selectByExample(String id){
		
		CompanyShebaoBiliCriteria criteria=new CompanyShebaoBiliCriteria();
		Criteria criteria1 =  criteria.createCriteria();
		criteria1.andUuidEqualTo(id);
		criteria1.andIsdelEqualTo(false);
		
		return mp.selectByExample(criteria);

	}
	//修改企业社保比例数据
	@Transactional
	public void updateEnterpriseSB(EntermainBean bean){
		try{
			User userDetails = (User) SecurityUtils.getSubject().getPrincipal();
			String loginName=userDetails.getLoginName();
			Date currentDate=new Date();
			List <CompanyShebaoBili>rsInsuranceAccountList=bean.getRsInsuranceAccountList();
			for(CompanyShebaoBili vo:rsInsuranceAccountList){
				vo.setUpdateDate(currentDate);
				vo.setUpdateName(loginName);
				mp.updateByPrimaryKeySelective(vo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//删除企业社保比例数据
	public void deleteCompanysbById(Integer id) {
		CompanyShebaoMainbili fund = new CompanyShebaoMainbili();
		fund.setId(id);
		fund.setIsdel(true);
		mainmp.updateByPrimaryKeySelective(fund);
		
	}
	
	/*
	 * 跟据社保参数UUId企业code值判断企业社保缴费比例是否存在
	 */
	public boolean validateEnterpriseSB(HashMap<String,String> map){
		
		long l=mainmp.countByEnterpriseSB(map);
		
		if(l>0){
			  return false;
			}else{
				return true;
			}
	}
	
}
