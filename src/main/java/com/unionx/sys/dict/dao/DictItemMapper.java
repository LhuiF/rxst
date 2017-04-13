package com.unionx.sys.dict.dao;

import java.util.List;
import java.util.Map;

import com.unionx.sys.dict.vo.Dict;
import org.springframework.stereotype.Repository;
import com.unionx.sys.dict.vo.DictItem;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author Yanli Yang
 */
 @Repository
public interface DictItemMapper{
    /**
     * 根据主键查询
     */
    public DictItem getDictItemById(@Param("id") String id);

    /**
     * 根据条件查询记录列表
     */
    public List<DictItem> getDictItemList(DictItem dictItem);

    /**
     * 查询出所有记录
     */
    public List<DictItem> findAllDictItem();

    /**
     * 保存
     */
    public int saveDictItem(DictItem dictItem);

    /**
     * 根据主键更新（参数对象中的主键将作为更新条件）
     */
    public int updateDictItem(DictItem dictItem);

    /**
     * 根据主键删除
     */
    public int deleteDictItem(@Param("id") String id);

    /**
     * 根据data_dict_code 查询字典项列表
     *
     * @param dictCode
     * @return List<DictItem>
     * @author abner
     */
    public List<DictItem> findDictItem(@Param("dictCode") String dictCode,@Param("itemName") String itemName);

    /**
     * 校验名称
     * @param id
     * @param dictCode
     * @param itemName
     * @return
     */
    public List<DictItem> validName(@Param("id") String id,@Param("dictCode") String dictCode,@Param("itemName") String itemName);

    List<DictItem> findByDictItem(String dataDictCode);

    DictItem findByDictItemName(@Param("dataDictCode") String dataDictCode, @Param("code") String code);

    /**
     * 获取店家岗位和一龄岗位
     * @return
     */
    List<DictItem> getPost();

    /**
     * 获取字典表跟踪频率
     * @return
     */
    List<DictItem> getByFrequency();
    
    List<Map<String,String>> findAllBygroup();
}

