package com.unionx.base.material.dao;

import com.unionx.base.material.vo.SysMaterial;
import com.unionx.base.material.vo.SysMaterialCriteria;
import com.unionx.base.material.vo.SysMaterialVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface SysMaterialMapper {
    long countByExample(SysMaterialCriteria example);

    int deleteByExample(SysMaterialCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(SysMaterial record);

    int insertSelective(SysMaterial record);

    List<SysMaterial> selectByExample(SysMaterialCriteria example);

    SysMaterial selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysMaterial record, @Param("example") SysMaterialCriteria example);

    int updateByExample(@Param("record") SysMaterial record, @Param("example") SysMaterialCriteria example);

    int updateByPrimaryKeySelective(SysMaterial record);

    int updateByPrimaryKey(SysMaterial record);
	 int deleteByUuid(String id);

    List<SysMaterialVo> findByUuid(@Param("id") String id);

	List<SysMaterial> getAll();

	List<SysMaterial> getMaterialList(SysMaterial sysMaterial);
	SysMaterial findById(String id);

}