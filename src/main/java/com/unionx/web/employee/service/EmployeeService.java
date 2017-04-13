package com.unionx.web.employee.service;

import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unionx.core.security.shiro.UserDetails;
import com.unionx.core.util.Identities;
import com.unionx.web.employee.dao.RsAnnexMapper;
import com.unionx.web.employee.dao.RsEmployeeMapper;
import com.unionx.web.employee.dao.RsFiveRisksMapper;
import com.unionx.web.employee.dao.RsSsFundinfoMapper;
import com.unionx.web.employee.po.RsAnnexCriteria;
import com.unionx.web.employee.po.RsFiveRisksCriteria;
import com.unionx.web.employee.po.RsSsFundinfoCriteria;
import com.unionx.web.employee.po.RsSsFundinfoCriteria.Criteria;
import com.unionx.web.employee.vo.Annex;
import com.unionx.web.employee.vo.Employee;
import com.unionx.web.employee.vo.EmployeeInfo;
import com.unionx.web.employee.vo.FiveRisks;
import com.unionx.web.employee.vo.SsFundinfo;

@Service
public class EmployeeService {
    @Autowired
	private RsEmployeeMapper employeeMapper;
    @Autowired
	private RsSsFundinfoMapper rsSsFundinfoMapper;
    @Autowired
    private RsFiveRisksMapper fiveRisksMapper;
    @Autowired
    private RsAnnexMapper annexMapper;
    
    /**
     * 添加用户信息和公积金信息
     * @param employee
     */
    @Transactional
    public void addEmployee(Employee employee){
    	Subject subject = SecurityUtils.getSubject();
		UserDetails userDetails = (UserDetails) subject.getPrincipal();
    	String employeeid = Identities.uuid();
    	Date now = new Date();
    	String loginName = userDetails.getLoginName();
    	employee.setId(employeeid);
    	employee.setCreateDate(now);
    	employee.setCreateName(loginName);
    	employeeMapper.insertSelective(employee);
    	//社保 和公积金信息
    	SsFundinfo ssFundinfo = employee.getSsFundinfo();
    	if(ssFundinfo != null){
    		ssFundinfo.setEmployeeId(employeeid);
    		ssFundinfo.setId(Identities.uuid());
    		ssFundinfo.setCreateDate(now);
    		ssFundinfo.setCreateName(loginName);
    		ssFundinfo.setCitizenIdCode(employee.getCitizenIdCode());
    		rsSsFundinfoMapper.insertSelective(ssFundinfo);
    	}
    	//五险一金信息
    	FiveRisks fiveRisks = employee.getFiveRisks();
    	if(fiveRisks != null){
    		fiveRisks.setId(Identities.uuid());
    		fiveRisks.setEmployeeId(employeeid);
    		fiveRisks.setCreateDate(now);
    		fiveRisks.setCreateName(loginName);
    		fiveRisksMapper.insertSelective(fiveRisks);
    	}
    	//附件信息
    	Annex annex = employee.getAnnex();
    	if(annex != null){
    		annex.setId(Identities.uuid());
    		annex.setEmployeeId(employeeid);
    		annex.setCreateDate(now);
    		annex.setCreateName(loginName);
    		annexMapper.insertSelective(annex);
    	}
    }
    
    /**
     * 获取
     * @param employee
     */
    public PageInfo<EmployeeInfo> getEmployeeList(Employee vo, int page,int rows){
    	PageHelper.startPage(page, rows);
    	 List<EmployeeInfo> selectByService = employeeMapper.selectByService(vo);
         return  new  PageInfo<EmployeeInfo>(selectByService);
    }

	public Employee getEmployeeByid(String id) {
		Employee employee = employeeMapper.selectByPrimaryKey(id);
		//公积金
		RsSsFundinfoCriteria rsSsFundinfoCriteria = new RsSsFundinfoCriteria();
		com.unionx.web.employee.po.RsSsFundinfoCriteria.Criteria criteria1 = 
				rsSsFundinfoCriteria.createCriteria();
		criteria1.andEmployeeIdEqualTo(id);
		List<SsFundinfo> ssFundinfos = rsSsFundinfoMapper.selectByExample(rsSsFundinfoCriteria);
        if(ssFundinfos != null){
        	employee.setSsFundinfo(ssFundinfos.get(0));
        }
        
        //五险
        RsFiveRisksCriteria rsFiveRisksCriteria = new RsFiveRisksCriteria();
        com.unionx.web.employee.po.RsFiveRisksCriteria.Criteria criteria2 = 
        		rsFiveRisksCriteria.createCriteria();
        criteria2.andEmployeeIdEqualTo(id);
        List<FiveRisks> fiveRisks = fiveRisksMapper.selectByExample(rsFiveRisksCriteria);
        if(fiveRisks!= null){
        	employee.setFiveRisks(fiveRisks.get(0));
        }
        //附件
        RsAnnexCriteria rsAnnexCriteria = new RsAnnexCriteria();
        com.unionx.web.employee.po.RsAnnexCriteria.Criteria criteria3 = 
        		rsAnnexCriteria.createCriteria();
        criteria3.andEmployeeIdEqualTo(id);
        List<Annex> annexs = annexMapper.selectByExample(rsAnnexCriteria);
        if(annexs != null){
        	employee.setAnnex(annexs.get(0));
        }
        return employee;
	}

	public void update(Employee employee) {
		Subject subject = SecurityUtils.getSubject();
		UserDetails userDetails = (UserDetails) subject.getPrincipal();
    	Date now = new Date();
    	String loginName = userDetails.getLoginName();
    	employee.setUpdateDate(now);
    	employee.setUpdateName(loginName);
    	employeeMapper.updateByPrimaryKeySelective(employee);
    	//社保 和公积金信息
    	SsFundinfo ssFundinfo = employee.getSsFundinfo();
    	if(ssFundinfo != null){
    		ssFundinfo.setUpdateDate(now);
    		ssFundinfo.setUpdateName(loginName);
    		rsSsFundinfoMapper.updateByPrimaryKeySelective(ssFundinfo);
    	}
    	//五险一金信息
    	FiveRisks fiveRisks = employee.getFiveRisks();
    	if(fiveRisks != null){
    		fiveRisks.setUpdateDate(now);
    		fiveRisks.setUpdateName(loginName);
    		fiveRisksMapper.updateByPrimaryKeySelective(fiveRisks);
    	}
    	//附件信息
    	Annex annex = employee.getAnnex();
    	if(annex != null){
    		annex.setUpdateDate(now);
    		annex.setUpdateName(loginName);
    		annexMapper.updateByPrimaryKeySelective(annex);
    	}
	}
	public void dele(String id) {
		annexMapper.deleByKey(id);
		fiveRisksMapper.deleByKey(id);
		rsSsFundinfoMapper.deleByKey(id);
		employeeMapper.deleByKey(id);
	}
}
