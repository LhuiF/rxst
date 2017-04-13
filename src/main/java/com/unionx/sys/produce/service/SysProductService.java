package com.unionx.sys.produce.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.unionx.core.util.Identities;
import com.unionx.sys.dict.dao.DictItemMapper;
import com.unionx.sys.dict.vo.DictItem;
import com.unionx.sys.produce.dao.SysProductMapper;
import com.unionx.sys.produce.vo.SysProduct;
import com.unionx.sys.user.vo.User;


@Service
public class SysProductService {

	@Autowired 
	private SysProductMapper sysProductMapper;
	
	@Autowired 
	private DictItemMapper dictItemMapper;
	
	
	
	/**
     * 编辑产品信息
     * @param produce
     */
	public void update(SysProduct produce) {
		
		sysProductMapper.updateByPrimaryKeySelective(produce);
		
	}
	
	
	/**
     * 编辑产品信息
     * @param produce
     */
	public void save(SysProduct produce) {
		produce.setId(Identities.uuid());
		produce.setCreateTime(new Date());
		sysProductMapper.insert(produce);
		
	}

	
	/**
     * 根据id获得产品信息
     * @param id
     */
	public SysProduct getProduceById(String id) {
		SysProduct vo = sysProductMapper.selectByPrimaryKey(id);
		DictItem item1 = dictItemMapper.findByDictItemName("20001",vo.getTypeId());
		DictItem item2 = dictItemMapper.findByDictItemName("20025",vo.getCityId());
		
		vo.setTypeName(item1.getName());
		vo.setCityName(item2.getName());
		
		return vo;
	}

	
	
	/**
     * 根据条件获得产品信息
     * @param produce
     */
	public PageInfo<User> getProduceList(SysProduct produce, int page, int rows) {
		 PageHelper.startPage(page,rows);
		 List<SysProduct> list = sysProductMapper.getProduceList(produce);
		
		 return new PageInfo(list);

	
	}


	public void deleteRById(String id) {
		sysProductMapper.deleteByPrimaryKey(id);
		
	}


	public boolean validName(SysProduct produce) {
		//数据库中没有为true   有为false
		boolean flag = false;
		SysProduct vo = new SysProduct();
		String id = "";
		if(produce != null){
			id = produce.getId();
		}
		
		//判断是新增验证还是修改验证
		if(!"".equals(id) && id != null){
            //编辑验证
            vo = sysProductMapper.validName(produce);
            if(vo != null){
                id = vo.getId();
                flag = produce.getId().equals(id);
            }else{
            	flag = true;
            }
        }else{
            //新增验证
            vo = sysProductMapper.validName(produce);
            if(vo == null){
                flag = true;
            }
        }
	
		
		
		return flag;
	}


	public List<SysProduct> findAllSysProduct() {
		List<SysProduct> list =sysProductMapper.findAllSysProduct();
		return list;
	}
	
	
	
	

}
