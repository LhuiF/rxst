package com.unionx.base.material.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unionx.base.material.dao.SysCailiaoMapper;
import com.unionx.base.material.dao.SysMaterialMapper;
import com.unionx.base.material.dao.SysTiaojianMapper;
import com.unionx.base.material.vo.CailaoBean;
import com.unionx.base.material.vo.CailaoTiaojianBean;
import com.unionx.base.material.vo.MaterialVo;
import com.unionx.base.material.vo.SysMaterial;
import com.unionx.base.material.vo.SysMaterialVo;
import com.unionx.base.material.vo1.SysCailiao;
import com.unionx.base.material.vo1.SysTiaojian;
import com.unionx.core.util.Identities;
import com.unionx.sys.dict.service.DictService;
import com.unionx.sys.dict.vo.DictItem;
import com.unionx.sys.produce.service.SysProductService;
import com.unionx.sys.produce.vo.SysProduct;
import com.unionx.sys.user.vo.User;
import com.unionx.web.archive.dao.RsConditionArchiveMapper;

@Service
public class MaterialService {
	
	@Autowired
	private SysMaterialMapper sysMaterialMapper;
	
	@Autowired	
	private RsConditionArchiveMapper rsConditionArchiveMapper;
	
	@Autowired	
	private SysCailiaoMapper sysCailiaoMapper;
	
	@Autowired
	private SysTiaojianMapper sysTiaojianMapper;
	@Autowired
	private SysProductService sysProductService;
	@Autowired
	private DictService dictService;
	
	

	public PageInfo<SysMaterial> getMaterialList(SysMaterial sysMaterial,
			int page, int rows) {		
		    PageHelper.startPage(page, rows);
		    //查出所有的业务材料
	        List<SysMaterial> sysMaterialList = this.sysMaterialMapper.getMaterialList(sysMaterial);   
	        List<SysMaterial> newSysmalList = new ArrayList<SysMaterial>();
	        for (SysMaterial sysMaterial2 : sysMaterialList) {
	        	Set<String> clList = new HashSet<String>();//存放所有的材料名
	        	Set<String> codsList = new HashSet<String>();//存放所有的条件
	        	 //查出所有的条件 根据业务材料id找到所有的条件
	        	String malId = sysMaterial2.getId();
	        	List<SysTiaojian> tiaojianList = sysTiaojianMapper.getByMalId(malId);
	         	
	    	   	//查出所有的材料 根据条件id找到所有的材料
	        	if(tiaojianList != null && tiaojianList.size()>0){
	        		for (SysTiaojian sysTiaojian : tiaojianList) {
	        			
	        			//得到所有的条件内容
	        			codsList.add(sysTiaojian.getTjcontent());
	        			String tiaojianId = sysTiaojian.getId();
	        			List<SysCailiao> cailiaoList = sysCailiaoMapper.getByTjId(tiaojianId);
	        			if(cailiaoList != null && cailiaoList.size()>0){
	        				for (SysCailiao sysCailiao : cailiaoList) {
	        					
	        					clList.add(sysCailiao.getClname());
	        				}
	        				
	        			}
	        		}
	        		
	        	}
	        	String tjStr = codsList.toString();
	        	String clStr = clList.toString();
	        	sysMaterial2.setCondition01(tjStr.substring(tjStr.indexOf("[") + 1,tjStr.lastIndexOf("]")));//设置条件
	        	sysMaterial2.setConditon01(clStr.substring(clStr.indexOf("[") + 1,clStr.lastIndexOf("]")));//设置材料
	        	newSysmalList.add(sysMaterial2);
	        	String productId = sysMaterial2.getProductName();
	        	SysProduct produceById = sysProductService.getProduceById(productId);
	        	String productName =  produceById.getName();
	        	sysMaterial2.setProName(productName);
	        	String quCode = sysMaterial2.getQu();
	       	
	        	DictItem findByDictItemName = dictService.findByDictItemName("20027",quCode);
	        	String quName = findByDictItemName.getName();
	        	sysMaterial2.setQuName(quName);
	        	
	        	
	        	
	        }
	
	        return new PageInfo(newSysmalList);
	}
	
	
	public List<SysMaterial> getAll() {		
		List<SysMaterial> list = sysMaterialMapper.getAll();
	        return list;
	}
	
	public List<SysMaterial> getMaterialList01(String typeId ,String isMaterial ,String qu ,String isApply){
		
			SysMaterial sysMaterial = new SysMaterial();
			sysMaterial.setTypeId(typeId);
			if(StringUtils.isNotEmpty(isApply) && StringUtils.isNotEmpty(isMaterial)){
				sysMaterial.setIsApply(Integer.valueOf(isApply));
				sysMaterial.setIsMaterial(Integer.valueOf(isMaterial));
			}
			
			sysMaterial.setQu(qu);
			
			//List<SysMaterial> list = sysMaterialMapper.getMaterialList(sysMaterial);
			PageInfo<SysMaterial> materialList = this.getMaterialList(sysMaterial,1,10);
			List<SysMaterial> list = materialList.getList();
			return list;
		
		
	}
	
	//保存
	public void saveMaterial(MaterialVo vo) {	
		 User us = (User) SecurityUtils.getSubject().getPrincipal();
		 SysMaterial sysMaterial = new SysMaterial();
		 String maUuid = Identities.uuid19();
		 	sysMaterial.setId(maUuid);
			sysMaterial.setUuid(vo.getUuid());
			sysMaterial.setQu(vo.getQu());
			sysMaterial.setProductName(vo.getProductName());
			sysMaterial.setRemark(vo.getRemark());
			sysMaterial.setTypeId(vo.getTypeId());											
			sysMaterial.setIsApply(vo.getIsApply());
			sysMaterial.setIsMaterial(vo.getIsMaterial());
			//sysMaterial.setCreateUserName(createUserName);
			List<CailaoTiaojianBean> tj = vo.getTJ();
			if(tj != null && tj.size()>0){
				for (CailaoTiaojianBean cailaoTiaojianBean : tj) {
					 SysTiaojian tjVo = new SysTiaojian();
					 String tjUuid = Identities.uuid19();				 
					String tjContent = cailaoTiaojianBean.getCondition01s();//条件
					tjVo.setTjcontent(tjContent);//条件内容
					tjVo.setMatlUuid(maUuid);//材料的id
					tjVo.setId(tjUuid);
					sysTiaojianMapper.insert(tjVo);
					
					List<CailaoBean> cl = cailaoTiaojianBean.getCL();//所有的材料	
					if(cl != null && cl.size() > 0){
						for (CailaoBean cailaoBean : cl) {
							SysCailiao clVo = new SysCailiao();
							String clUuid = Identities.uuid19();
							clVo.setUuid(clUuid);
							clVo.setClname(cailaoBean.getClName());//材料名称
							clVo.setClnum(cailaoBean.getClNum());//分数
							clVo.setClrqst(cailaoBean.getClRqst());//材料要求
							clVo.setTjUuid(tjUuid);//条件id
							sysCailiaoMapper.insert(clVo);
						}
						
					}
		
				}
	}
	
	     sysMaterial.setCreateUserId(us.getName());
	     sysMaterial.setCreateTime(new Date());
		sysMaterialMapper.insertSelective(sysMaterial);
		
	}

	//修改
	public void updateMaterial(MaterialVo vo) {//更新时，先把原来条件表和材料表的
		//更新  一条一条更新   			
		User us = (User) SecurityUtils.getSubject().getPrincipal();
		SysMaterial sysMaterial = new SysMaterial();
		String matId = vo.getId();//得到材料的id
		sysMaterial.setId(matId);
		sysMaterial.setQu(vo.getQu());
		sysMaterial.setUuid(vo.getUuid());
		sysMaterial.setProductName(vo.getProductName());
		sysMaterial.setRemark(vo.getRemark());
		sysMaterial.setTypeId(vo.getTypeId());											
		sysMaterial.setIsApply(vo.getIsApply());
		sysMaterial.setIsMaterial(vo.getIsMaterial());
		sysMaterial.setUuid(vo.getUuid());
		sysMaterial.setCreateTime(new Date());
		sysMaterial.setCreateUserId(us.getId());
		List<CailaoTiaojianBean> tj = vo.getTJ();
		if(tj != null && tj.size()>0){
		for (CailaoTiaojianBean cailaoTiaojianBean : tj) {		
			String tjUuid = cailaoTiaojianBean.getId();//得到条件对象的id
				SysTiaojian tjVo = new SysTiaojian();				
				String tjid = cailaoTiaojianBean.getId();
				sysTiaojianMapper.deleteByPrimaryKey(cailaoTiaojianBean.getId());
				//在重新保存一下
				String TjUuid = Identities.uuid19();
				tjVo.setTjcontent(cailaoTiaojianBean.getCondition01s());
				tjVo.setMatlUuid(matId);
				tjVo.setId(TjUuid);				
				sysTiaojianMapper.insert(tjVo);
			
			List<CailaoBean> cl = cailaoTiaojianBean.getCL();//所有的材料
			if(cl != null && cl.size()>0){
				for (CailaoBean cailaoBean : cl) {				
					sysCailiaoMapper.deleteByPrimaryKey(cailaoBean.getUuid());
					SysCailiao clVo = new SysCailiao();	
					String clUuid = Identities.uuid19();
					clVo.setClname(cailaoBean.getClName());//材料名称
					clVo.setClnum(cailaoBean.getClNum());//分数
					clVo.setClrqst(cailaoBean.getClRqst());//材料要求
					clVo.setTjUuid(TjUuid);//条件id
					clVo.setUuid(clUuid);
					
					sysCailiaoMapper.insert(clVo);
				}
				
			}
				

		  }
		}

		sysMaterialMapper.updateByPrimaryKey(sysMaterial);
		
	}

	
	


	public List<SysMaterialVo> getMaterialById(String id) {
		List<SysMaterialVo> voList =  sysMaterialMapper.findByUuid(id);
		return voList;
	}
	


	public List<String> getConditions(String productId) {
		 List<String> conditionsList = rsConditionArchiveMapper.getConditions(productId);
		return conditionsList;
	}
	
	
	
	
	public MaterialVo getById(String id){
		MaterialVo vo = new MaterialVo();
		List<CailaoTiaojianBean> tjList = new ArrayList<CailaoTiaojianBean>();
		
		//根据业务材料id找到所有的条件  然后保存到业务材料对象的条件集合
		List<SysTiaojian> sysTjList = sysTiaojianMapper.getByMalId(id);
		String tjId = "";
		
		if(sysTjList != null && sysTjList.size()>0){
			for (SysTiaojian sysTiaojian : sysTjList) {
				CailaoTiaojianBean tjVO = new CailaoTiaojianBean();
				tjVO.setCondition01s(sysTiaojian.getTjcontent());
				tjId = sysTiaojian.getId();
				tjVO.setId(tjId);
				//根据条件id找到所有的材料  保存到业务材料的材料集合
				List<SysCailiao> sysClList = sysCailiaoMapper.getByTjId(tjId);
				List<CailaoBean> caiList = new ArrayList<CailaoBean>();
				if(sysClList != null && sysClList.size()>0){
					for (SysCailiao sysCailiao : sysClList) {
						CailaoBean clVo = new CailaoBean();
						clVo.setClName(sysCailiao.getClname());
						clVo.setClNum(sysCailiao.getClnum());
						clVo.setClRqst(sysCailiao.getClrqst());
						clVo.setUuid(sysCailiao.getUuid());
						caiList.add(clVo);
					}
					tjVO.setCL(caiList);
					
				}
	
				tjList.add(tjVO);
			}
		}
		vo.setTJ(tjList);
		
		SysMaterial sysMaterial = sysMaterialMapper.findById(id);
		vo.setIsApply(Integer.valueOf(sysMaterial.getIsApply()));
		vo.setIsMaterial(Integer.valueOf(sysMaterial.getIsMaterial()));
		vo.setCreateTime(sysMaterial.getCreateTime());
		vo.setProductName(sysMaterial.getProductName());
		vo.setId(id);
		vo.setUuid(sysMaterial.getUuid());		
		vo.setQu(sysMaterial.getQu());		
		vo.setTypeId(sysMaterial.getTypeId());
	
		return vo;
	}
	
	public void delByMaterialId(String id){
		//删掉业务材料表
		sysMaterialMapper.deleteByPrimaryKey(id);
		//根据业务材料id找到所有的条件id
		List<SysTiaojian> byMalId = sysTiaojianMapper.getByMalId(id);
		for (SysTiaojian sysTiaojian : byMalId) {
			String tjId = sysTiaojian.getId();
			sysTiaojianMapper.deleteByPrimaryKey(tjId);			
			List<SysCailiao> byTjId = sysCailiaoMapper.getByTjId(tjId);
			for (SysCailiao sysCailiao : byTjId) {
				String clId = sysCailiao.getUuid();
				sysCailiaoMapper.deleteByPrimaryKey(clId);
			}
		}
		

	}


}
