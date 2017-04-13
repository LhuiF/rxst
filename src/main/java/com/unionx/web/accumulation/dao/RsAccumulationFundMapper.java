package com.unionx.web.accumulation.dao;

import com.unionx.sys.dict.vo.DictItem;
import com.unionx.web.accumulation.vo.RsAccumulationFund;
import com.unionx.web.accumulation.vo.RsAccumulationFundCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface RsAccumulationFundMapper {
    long countByExample(RsAccumulationFundCriteria example);

    int deleteByExample(RsAccumulationFundCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(RsAccumulationFund record);

    int insertSelective(RsAccumulationFund record);

    List<RsAccumulationFund> selectByExample(RsAccumulationFundCriteria example);

    RsAccumulationFund selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RsAccumulationFund record, @Param("example") RsAccumulationFundCriteria example);

    int updateByExample(@Param("record") RsAccumulationFund record, @Param("example") RsAccumulationFundCriteria example);

    int updateByPrimaryKeySelective(RsAccumulationFund record);

    int updateByPrimaryKey(RsAccumulationFund record);

	List<DictItem> getdictBycode(String code);

	List getgAccumulationById(String id);

	List<RsAccumulationFund> getProportion();

	List<RsAccumulationFund> getAccumByProp();
}