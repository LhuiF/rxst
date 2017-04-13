package com.unionx.web.insurance.dao;

import com.unionx.web.insurance.vo.RsInsuranceAccount;
import com.unionx.web.insurance.vo.RsInsuranceAccountCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface RsInsuranceAccountMapper {
    long countByExample(RsInsuranceAccountCriteria example);

    int deleteByExample(RsInsuranceAccountCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(RsInsuranceAccount record);

    int insertSelective(RsInsuranceAccount record);

    List<RsInsuranceAccount> selectByExample(RsInsuranceAccountCriteria example);

    RsInsuranceAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RsInsuranceAccount record, @Param("example") RsInsuranceAccountCriteria example);

    int updateByExample(@Param("record") RsInsuranceAccount record, @Param("example") RsInsuranceAccountCriteria example);

    int updateByPrimaryKeySelective(RsInsuranceAccount record);

    int updateByPrimaryKey(RsInsuranceAccount record);
}