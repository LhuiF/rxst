package com.unionx.web.insurance.dao;

import com.unionx.web.insurance.vo.RsInsurance;
import com.unionx.web.insurance.vo.RsInsuranceCriteria;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface RsInsuranceMapper {
    long countByExample(RsInsuranceCriteria example);

    int deleteByExample(RsInsuranceCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(RsInsurance record);

    int insertSelective(RsInsurance record);

    List<RsInsurance> selectByExample(RsInsuranceCriteria example);

    RsInsurance selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RsInsurance record, @Param("example") RsInsuranceCriteria example);

    int updateByExample(@Param("record") RsInsurance record, @Param("example") RsInsuranceCriteria example);

    int updateByPrimaryKeySelective(RsInsurance record);

    int updateByPrimaryKey(RsInsurance record);
    
    long countByCityyear(HashMap<String,String>map );
}