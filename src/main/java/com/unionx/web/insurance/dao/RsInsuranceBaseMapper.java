package com.unionx.web.insurance.dao;

import com.unionx.web.insurance.vo.RsInsuranceBase;
import com.unionx.web.insurance.vo.RsInsuranceBaseCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface RsInsuranceBaseMapper {
    long countByExample(RsInsuranceBaseCriteria example);

    int deleteByExample(RsInsuranceBaseCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(RsInsuranceBase record);

    int insertSelective(RsInsuranceBase record);

    List<RsInsuranceBase> selectByExample(RsInsuranceBaseCriteria example);

    RsInsuranceBase selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RsInsuranceBase record, @Param("example") RsInsuranceBaseCriteria example);

    int updateByExample(@Param("record") RsInsuranceBase record, @Param("example") RsInsuranceBaseCriteria example);

    int updateByPrimaryKeySelective(RsInsuranceBase record);

    int updateByPrimaryKey(RsInsuranceBase record);
}