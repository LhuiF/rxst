package com.unionx.web.company.dao;

import com.unionx.web.company.vo.CompanyShebaoBili;
import com.unionx.web.company.vo.CompanyShebaoBiliCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface CompanyShebaoBiliMapper {
    long countByExample(CompanyShebaoBiliCriteria example);

    int deleteByExample(CompanyShebaoBiliCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(CompanyShebaoBili record);

    int insertSelective(CompanyShebaoBili record);

    List<CompanyShebaoBili> selectByExample(CompanyShebaoBiliCriteria example);

    CompanyShebaoBili selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CompanyShebaoBili record, @Param("example") CompanyShebaoBiliCriteria example);

    int updateByExample(@Param("record") CompanyShebaoBili record, @Param("example") CompanyShebaoBiliCriteria example);

    int updateByPrimaryKeySelective(CompanyShebaoBili record);

    int updateByPrimaryKey(CompanyShebaoBili record);
}