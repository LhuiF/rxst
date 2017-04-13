package com.unionx.web.insurance.dao;

import com.unionx.web.insurance.vo.RsInsurance;
import com.unionx.web.insurance.vo.RsInsuranceProportion;
import com.unionx.web.insurance.vo.RsInsuranceProportionCriteria;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface RsInsuranceProportionMapper {
    long countByExample(RsInsuranceProportionCriteria example);

    int deleteByExample(RsInsuranceProportionCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(RsInsuranceProportion record);

    int insertSelective(RsInsuranceProportion record);

    List<RsInsuranceProportion> selectByExample(RsInsuranceProportionCriteria example);

    RsInsuranceProportion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RsInsuranceProportion record, @Param("example") RsInsuranceProportionCriteria example);

    int updateByExample(@Param("record") RsInsuranceProportion record, @Param("example") RsInsuranceProportionCriteria example);

    int updateByPrimaryKeySelective(RsInsuranceProportion record);

    int updateByPrimaryKey(RsInsuranceProportion record);

	List<RsInsurance> getInsurance();

	List<RsInsurance> getInsuranceByUuid(String id);

	void deleteById(String id);

	List<RsInsurance> getInsuranceByProp(Map<String, String> parMap);

}