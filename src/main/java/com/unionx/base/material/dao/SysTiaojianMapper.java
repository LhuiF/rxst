package com.unionx.base.material.dao;

import com.unionx.base.material.vo1.SysTiaojian;
import com.unionx.base.material.vo1.SysTiaojianCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface SysTiaojianMapper {
    long countByExample(SysTiaojianCriteria example);

    int deleteByExample(SysTiaojianCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(SysTiaojian record);

    int insertSelective(SysTiaojian record);

    List<SysTiaojian> selectByExample(SysTiaojianCriteria example);

    SysTiaojian selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysTiaojian record, @Param("example") SysTiaojianCriteria example);

    int updateByExample(@Param("record") SysTiaojian record, @Param("example") SysTiaojianCriteria example);

    int updateByPrimaryKeySelective(SysTiaojian record);

    int updateByPrimaryKey(SysTiaojian record);

	List<SysTiaojian> getByMalId(String id);

	void deleteByMatId(String materialId);
}