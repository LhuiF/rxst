package com.unionx.sys.dict.service;


import com.alibaba.dubbo.common.json.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unionx.core.util.Identities;
import com.unionx.sys.dict.dao.DictItemMapper;
import com.unionx.sys.dict.dao.DictMapper;
import com.unionx.sys.dict.vo.Dict;
import com.unionx.sys.dict.vo.DictItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoActionOperation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletContext;

/**
 * 功能：数据字典实现类
 * @Author: Yanli Yang
 */

@Service
public class DictService {

    @Autowired
    private DictMapper dictMapper;
    @Autowired
    private DictItemMapper dictItemMapper;
    @Autowired
	private ServletContext servletContext;

    /**
     * 根据主键查询
     */
    public Dict getDictById(String dictCode){
        return this.dictMapper.getDictById(dictCode);
    }
    /**
     * 查询出所有记录
     */
    public List<Dict> findAllDict(){
        return this.dictMapper.findAllDict();
    }

    /**
     * 保存
     */
    public int saveDict(Dict dict){
        int saveDict = this.dictMapper.saveDict(dict);
        servletContext.setAttribute("dict",  findAllBygroup());
        return saveDict;
    }

    /**
     * 根据主键更新（参数对象中的主键将作为更新条件）
     */
    public int updateDict(Dict dict){
        return this.dictMapper.updateDict(dict);
    }

    /**
     * 根据主键删除
     */
    public int deleteDict(@Param("dictCode") String dictCode){
         int deleteDict = this.dictMapper.deleteDict(dictCode);
        servletContext.setAttribute("dict",  findAllBygroup());
        return deleteDict;
    }

    /**
     * 根据主键查询
     */
    public DictItem getDictItemById(@Param("id") String id){
        return this.dictItemMapper.getDictItemById(id);
    }
     /**
     * 根据条件查询记录列表
     */
    public PageInfo getDictItemList(DictItem dictItem,int currentPage,int pageSize){
        PageHelper.startPage(currentPage, pageSize);
        List<DictItem> dictItemList = this.dictItemMapper.getDictItemList(dictItem);
        return new PageInfo(dictItemList);
    }
    /**
     * 查询出所有记录
     */
    public List<DictItem> findAllDictItem(){
        return this.dictItemMapper.findAllDictItem();
    }

    /**
     * 保存
     */
    @Transactional
    public int saveDictItem(DictItem dictItem){
        dictItem.setId(Identities.uuid());
         int saveDictItem = this.dictItemMapper.saveDictItem(dictItem);
        servletContext.setAttribute("dict",  findAllBygroup());
        return saveDictItem;
    }

    /**
     * 根据主键更新（参数对象中的主键将作为更新条件）
     */
    public int updateDictItem(DictItem dictItem){
         int updateDictItem = this.dictItemMapper.updateDictItem(dictItem);
        servletContext.setAttribute("dict",  findAllBygroup());
        return updateDictItem;
    }

    /**
     * 根据主键删除
     */
    public int deleteDictItem(@Param("id") String id){
        int deleteDictItem = this.dictItemMapper.deleteDictItem(id);
        servletContext.setAttribute("dict",  findAllBygroup());
        return deleteDictItem;
    }


    /**
     * 根据data_dict_code 查询字典项列表
     * @param dictCode
     * @return List<DictItem>
     */
    public List<DictItem> findDictItem(String dictCode,String itemName){
        return this.dictItemMapper.findDictItem(dictCode,itemName);
    }

    /**
     * 校验名称
     * @param dictCode
     * @param itemName
     * @return
     */
    public List<DictItem> validName(String id,String dictCode,String itemName){
        return this.dictItemMapper.validName(id,dictCode, itemName);
    }

    /**
     *  查询根据字典id查询信息
     */
    public List<DictItem> findByDictItem(String dataDictCode) {
        return this.dictItemMapper.findByDictItem(dataDictCode);
    }

    public DictItem findByDictItemName(String dataDictCode , String code) {
        return this.dictItemMapper.findByDictItemName(dataDictCode,code);
    }

    /**
     * 获取店家岗位和一龄岗位
     * @return
     */
    public List<Map> getByCodeName() {
        List<Map> list = new ArrayList<Map>();
        List<DictItem> pstList = this.dictItemMapper.getPost();
        for (DictItem dict: pstList){
            Map<String, Object> pstMap = new HashMap<String, Object>();
            pstMap.put("code", dict.getCode());
            pstMap.put("name", dict.getName());
            list.add(pstMap);
        }
        return list;
    }

    /**
     * 获取店家岗位和一龄岗位 返回map
     *
     * @return
     */
    public Map getDictMap() {
        Map map = new HashMap();
        List<DictItem> pstList = this.dictItemMapper.getPost();
        for (DictItem dict : pstList) {
            map.put(dict.getCode(), dict.getName());
        }
        return map;
    }
    /**
     * 获取字典表跟踪频率
     * @return
     */
    public List<Map> getByFrequency() {
        List<Map> list = new ArrayList<Map>();
        List<DictItem> frequencyList = this.dictItemMapper.getByFrequency();
        for (DictItem dict : frequencyList) {
            Map<String, Object> frequencyMap = new HashMap<String, Object>();
            frequencyMap.put("code", dict.getCode());
            frequencyMap.put("name", dict.getName());
            list.add(frequencyMap);
        }
        return list;
    }
    
   public Map<Long,String> findAllBygroup(){
	   //所有字典项
    	List<Map<String, String>> dicts = dictItemMapper.findAllBygroup();
    	Map<Long,List<Map<String,String>>>  returndata=new HashMap();
    	
    	for (Map<String, String> dict : dicts) {
    		Long dictCode=Long.valueOf(dict.get("data_dict_code"));
    		if(returndata.get(dictCode) == null){
    			List<Map<String, String>> dictList = new ArrayList<Map<String,String>>();
    			dictList.add(dict);
    			returndata.put(dictCode, dictList);
    		}else{
    			returndata.get(dictCode).add(dict);
    		}
    		dict.remove("data_dict_code");
		}	
    	Map<Long,String>  returnmap=new HashMap();
    	try {
	    	for (Entry<Long, List<Map<String, String>>> tem: returndata.entrySet()) {
	    		returnmap.put(tem.getKey(), JSON.json(tem.getValue()));
			}
	    	returndata=null;
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return returnmap;
    }
}
