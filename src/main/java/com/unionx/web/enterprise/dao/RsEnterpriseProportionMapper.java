package com.unionx.web.enterprise.dao;

import com.unionx.web.enterprise.po.AccumulationPo;
import com.unionx.web.enterprise.vo.RsEnterpriseProportion;
import com.unionx.web.enterprise.vo.RsEnterpriseProportionCriteria;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface RsEnterpriseProportionMapper {
    long countByExample(RsEnterpriseProportionCriteria example);

    int deleteByExample(RsEnterpriseProportionCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(RsEnterpriseProportion record);

    int insertSelective(RsEnterpriseProportion record);

    List<RsEnterpriseProportion> selectByExample(RsEnterpriseProportionCriteria example);

    RsEnterpriseProportion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RsEnterpriseProportion record, @Param("example") RsEnterpriseProportionCriteria example);

    int updateByExample(@Param("record") RsEnterpriseProportion record, @Param("example") RsEnterpriseProportionCriteria example);

    int updateByPrimaryKeySelective(RsEnterpriseProportion record);

    int updateByPrimaryKey(RsEnterpriseProportion record);

	List<AccumulationPo> getEnterpriseByAdd(String id);

	List<RsEnterpriseProportion> queryByExample(Map<String, String> parMap);

	void deleteById(String id);
}