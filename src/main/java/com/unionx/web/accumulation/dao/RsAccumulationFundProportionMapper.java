package com.unionx.web.accumulation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.unionx.web.accumulation.po.RsAccumulationFundProportionVo;
import com.unionx.web.accumulation.vo.RsAccumulationFundProportion;
import com.unionx.web.accumulation.vo.RsAccumulationFundProportionCriteria;
@Repository
public interface RsAccumulationFundProportionMapper {
    long countByExample(RsAccumulationFundProportionCriteria example);

    int deleteByExample(RsAccumulationFundProportionCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(RsAccumulationFundProportion record);

    int insertSelective(RsAccumulationFundProportion record);

    List<RsAccumulationFundProportion> selectByExample(RsAccumulationFundProportionCriteria example);

    RsAccumulationFundProportion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RsAccumulationFundProportion record, @Param("example") RsAccumulationFundProportionCriteria example);

    int updateByExample(@Param("record") RsAccumulationFundProportion record, @Param("example") RsAccumulationFundProportionCriteria example);

    int updateByPrimaryKeySelective(RsAccumulationFundProportion record);

    int updateByPrimaryKey(RsAccumulationFundProportion record);

	List<RsAccumulationFundProportionVo> getProportionById(String id);

	void deleteById(String id);
}