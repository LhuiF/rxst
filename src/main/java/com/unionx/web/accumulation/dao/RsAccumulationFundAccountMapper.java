package com.unionx.web.accumulation.dao;

import com.unionx.web.accumulation.vo.RsAccumulationFundAccount;
import com.unionx.web.accumulation.vo.RsAccumulationFundAccountCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface RsAccumulationFundAccountMapper {
    long countByExample(RsAccumulationFundAccountCriteria example);

    int deleteByExample(RsAccumulationFundAccountCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(RsAccumulationFundAccount record);

    int insertSelective(RsAccumulationFundAccount record);

    List<RsAccumulationFundAccount> selectByExample(RsAccumulationFundAccountCriteria example);

    RsAccumulationFundAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RsAccumulationFundAccount record, @Param("example") RsAccumulationFundAccountCriteria example);

    int updateByExample(@Param("record") RsAccumulationFundAccount record, @Param("example") RsAccumulationFundAccountCriteria example);

    int updateByPrimaryKeySelective(RsAccumulationFundAccount record);

    int updateByPrimaryKey(RsAccumulationFundAccount record);
}