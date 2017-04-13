package com.unionx.sys.produce.dao;


import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.unionx.sys.enterprise.vo.RsEnterprise;
import com.unionx.sys.produce.vo.SysProduct;
import com.unionx.sys.produce.vo.SysProductCriteria;

@Repository
public interface SysProductMapper {
    long countByExample(SysProductCriteria example);

    int deleteByExample(SysProductCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(SysProduct record);

    int insertSelective(SysProduct record);

    List<SysProduct> selectByExample(SysProductCriteria example);

    SysProduct selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysProduct record, @Param("example") SysProductCriteria example);

    int updateByExample(@Param("record") SysProduct record, @Param("example") SysProductCriteria example);

    int updateByPrimaryKeySelective(SysProduct record);

    int updateByPrimaryKey(SysProduct record);

	List<SysProduct> getProduceList(SysProduct produce);

	SysProduct validName(SysProduct produce);

	List<SysProduct> findAllSysProduct();

	List<SysProduct> getCondition();

	List<SysProduct> getConditionById(String id);
}