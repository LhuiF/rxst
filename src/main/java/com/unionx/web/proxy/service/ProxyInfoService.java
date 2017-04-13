package com.unionx.web.proxy.service;

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
import com.unionx.web.proxy.dao.ProxyInfoMapper;
import com.unionx.web.proxy.dao.RsLinkpeopleMapper;
import com.unionx.web.proxy.po.ProxyInfoCriteria;
import com.unionx.web.proxy.vo.ProxyInfo;
import com.unionx.web.proxy.vo.RsLinkpeople;
import com.unionx.web.proxy.po.RsLinkpeopleCriteria;
import  com.unionx.web.proxy.po.ProxyInfoCriteria.Criteria;

@Service
public class ProxyInfoService {

	@Autowired
	private ProxyInfoMapper proxyInfoMapper;
	@Autowired
	private RsLinkpeopleMapper rsLinkpeopleMapper;
	
	/**
	 * 保存
	 * @throws ParseException 
	 * @Description: TODO 
	 * @throws
	 * @author zhaoyubo
	 * @date 2016-11-2
	 */
	@Transactional
	public void save(ProxyInfo proxyInfo) throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		proxyInfo.setAppointmentPaymentDate(dateFormat.parse(proxyInfo.getAppointmentPaymentString()));
		proxyInfo.setCreateDate(new Date());
		proxyInfo.setIsdel("0");
		String uuid = Identities.uuid();
		proxyInfo.setId(uuid);
		proxyInfoMapper.insertSelective(proxyInfo);
		List<RsLinkpeople> list = proxyInfo.getList();
		if(list != null)
		for (RsLinkpeople rsLinkpeople : list) {
			rsLinkpeople.setAssociationId(uuid);
			rsLinkpeopleMapper.insertSelective(rsLinkpeople);
		}

	}
	
	/**
	 * 修改
	 * @throws ParseException 
	 * @Description: TODO 
	 * @throws
	 * @author zhaoyubo
	 * @date 2016-11-2
	 */
	@Transactional
	public void update(ProxyInfo proxyInfo) throws ParseException{
		//修改代理信息
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		proxyInfo.setAppointmentPaymentDate(dateFormat.parse(proxyInfo.getAppointmentPaymentString()));
		proxyInfo.setUpdateDate(new Date());
		Subject subject = SecurityUtils.getSubject();
		UserDetails userDetails = (UserDetails) subject.getPrincipal();
		proxyInfo.setUpdateName(userDetails.getLoginName());
		proxyInfoMapper.updateByPrimaryKeySelective(proxyInfo);
		//修改联系人  
		RsLinkpeopleCriteria rsLinkpeopleCriteria = new RsLinkpeopleCriteria();
		com.unionx.web.proxy.po.RsLinkpeopleCriteria.Criteria criteria = rsLinkpeopleCriteria.createCriteria();
		criteria.andAssociationIdEqualTo(proxyInfo.getId());
		rsLinkpeopleMapper.deleteByExample(rsLinkpeopleCriteria);
		
		List<RsLinkpeople> list = proxyInfo.getList();
		if(list != null)
		for (RsLinkpeople rsLinkpeople : list) {
			rsLinkpeople.setAssociationId(proxyInfo.getId());
			rsLinkpeopleMapper.insertSelective(rsLinkpeople);
		}

	}
	
	public PageInfo<ProxyInfo> getProxyInfoList(ProxyInfo fund, int page,int rows) {
		ProxyInfoCriteria example = new ProxyInfoCriteria();
		Criteria criteria = example.createCriteria();
		if(StringUtils.isNotEmpty(fund.getProxyName())){
			criteria.andProxyNameLike(fund.getProxyName());
		}
		criteria.andIsdelEqualTo("0");
		PageHelper.startPage(page, rows);
		List<ProxyInfo> proxyInfoList = proxyInfoMapper.selectByExample(example);
		return new PageInfo(proxyInfoList);
	}
	
	public ProxyInfo getProxyInfoByid(String id) {
		ProxyInfo proxyInfo = proxyInfoMapper.selectByPrimaryKey(id);
		RsLinkpeopleCriteria rsLinkpeopleCriteria = new RsLinkpeopleCriteria();
		com.unionx.web.proxy.po.RsLinkpeopleCriteria.Criteria createCriteria = rsLinkpeopleCriteria.createCriteria();
		createCriteria.andAssociationIdEqualTo(id);
		proxyInfo.setList(rsLinkpeopleMapper.selectByExample(rsLinkpeopleCriteria));
		return proxyInfo;
	}
	
	public void deleteById(String id){
		//删除代理信息
		proxyInfoMapper.deleByid(id);	
	}
}
