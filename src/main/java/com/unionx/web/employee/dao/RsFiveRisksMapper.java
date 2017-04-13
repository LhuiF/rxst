package com.unionx.web.employee.dao;

import com.unionx.web.employee.vo.FiveRisks;
import com.unionx.web.employee.po.RsFiveRisksCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface RsFiveRisksMapper {
    long countByExample(RsFiveRisksCriteria example);

    int deleteByExample(RsFiveRisksCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(FiveRisks record);

    int insertSelective(FiveRisks record);

    List<FiveRisks> selectByExample(RsFiveRisksCriteria example);

    FiveRisks selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FiveRisks record, @Param("example") RsFiveRisksCriteria example);

    int updateByExample(@Param("record") FiveRisks record, @Param("example") RsFiveRisksCriteria example);

    int updateByPrimaryKeySelective(FiveRisks record);

    int updateByPrimaryKey(FiveRisks record);
    
    int deleByKey(String id);
}