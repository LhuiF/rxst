package com.unionx.web.employee.dao;

import com.unionx.web.employee.vo.SsFundinfo;
import com.unionx.web.employee.po.RsSsFundinfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface RsSsFundinfoMapper {
    long countByExample(RsSsFundinfoCriteria example);

    int deleteByExample(RsSsFundinfoCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(SsFundinfo record);

    int insertSelective(SsFundinfo record);

    List<SsFundinfo> selectByExample(RsSsFundinfoCriteria example);

    SsFundinfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SsFundinfo record, @Param("example") RsSsFundinfoCriteria example);

    int updateByExample(@Param("record") SsFundinfo record, @Param("example") RsSsFundinfoCriteria example);

    int updateByPrimaryKeySelective(SsFundinfo record);

    int updateByPrimaryKey(SsFundinfo record);
    
    int deleByKey(String id);
}