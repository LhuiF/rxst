package com.unionx.base.material.dao;

import com.unionx.base.material.vo1.SysCailiao;
import com.unionx.base.material.vo1.SysCailiaoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface SysCailiaoMapper {
    long countByExample(SysCailiaoCriteria example);

    int deleteByExample(SysCailiaoCriteria example);

    int deleteByPrimaryKey(String uuid);

    int insert(SysCailiao record);

    int insertSelective(SysCailiao record);

    List<SysCailiao> selectByExample(SysCailiaoCriteria example);

    SysCailiao selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") SysCailiao record, @Param("example") SysCailiaoCriteria example);

    int updateByExample(@Param("record") SysCailiao record, @Param("example") SysCailiaoCriteria example);

    int updateByPrimaryKeySelective(SysCailiao record);

    int updateByPrimaryKey(SysCailiao record);

	List<SysCailiao> getByTjId(String tjId);

	void deleteByTjId(String tjUuid);
}