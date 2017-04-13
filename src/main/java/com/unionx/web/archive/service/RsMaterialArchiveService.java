package com.unionx.web.archive.service;

import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unionx.core.security.shiro.UserDetails;
import com.unionx.core.util.Identities;
import com.unionx.web.archive.dao.RsMaterialArchiveMapper;
import com.unionx.web.archive.vo.RsMaterialArchive;

@Service
public class RsMaterialArchiveService {

	@Autowired
	RsMaterialArchiveMapper rsMaterialArchiveMapper;
	
	/**
	 * 保存材料档案
	 * @param record
	 */
	public void save(RsMaterialArchive record) {
		// TODO Auto-generated method stub
		
		Subject subject = SecurityUtils.getSubject();
		UserDetails userDetails = (UserDetails) subject.getPrincipal();
		record.setUuid(Identities.uuid());
		record.setCreateName(userDetails.getLoginName());
		record.setCreateDate(new Date());
		record.setUpdateDate(new Date());
		record.setIsdel("0");
		rsMaterialArchiveMapper.insert(record);
	}

	/**
	 * 获取材料档案列表
	 * @param record
	 * @param page
	 * @param rows
	 * @return
	 */
	public PageInfo<RsMaterialArchive> getArchiveList(RsMaterialArchive record,
			int page, int rows) {
		PageHelper.startPage(page, rows);
        List<RsMaterialArchive> archiveList = this.rsMaterialArchiveMapper.getArchiveList(record);
        return new PageInfo(archiveList);
		
	}
	/**
	 * 根据材料名称获取材料档案
	 * @param materialName
	 * @return
	 */
	public List<RsMaterialArchive> getArchiveByName(String materialName) {
		return rsMaterialArchiveMapper.getArchiveByName(materialName);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Integer id) {
		rsMaterialArchiveMapper.deleteById(id);
	}
	/**
	 * 修改
	 * @param record
	 */
	public void updateArchive(RsMaterialArchive record) {
		record.setUpdateDate(new Date());
		rsMaterialArchiveMapper.updateByPrimaryKeySelective(record);
	}

	public List<RsMaterialArchive> getArchiveById(int id) {
		return rsMaterialArchiveMapper.getArchiveById(id);
	}
	public List<RsMaterialArchive> getAll(){
		return rsMaterialArchiveMapper.getArchiveList(null);
	}

}
