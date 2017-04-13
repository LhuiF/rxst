package com.unionx.sys.dict.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.unionx.sys.dict.vo.Dict;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author Yanli Yang
 */
 @Repository
public interface DictMapper{
    /**
     * 根据主键查询
     */
    Dict getDictById(@Param("dictCode") String dictCode);
    /**
     * 查询出所有记录
     */
    List<Dict> findAllDict();

    /**
     * 保存
     */
    int saveDict(Dict dict);

    /**
     * 根据主键更新（参数对象中的主键将作为更新条件）
     */
    int updateDict(Dict dict);

    /**
     * 根据主键删除
     */
    int deleteDict(@Param("dictCode") String dictCode);
}

