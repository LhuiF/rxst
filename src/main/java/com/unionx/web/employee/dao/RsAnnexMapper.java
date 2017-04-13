package com.unionx.web.employee.dao;

import com.unionx.web.employee.vo.Annex;
import com.unionx.web.employee.po.RsAnnexCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface RsAnnexMapper {
    long countByExample(RsAnnexCriteria example);

    int deleteByExample(RsAnnexCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Annex record);

    int insertSelective(Annex record);

    List<Annex> selectByExample(RsAnnexCriteria example);

    Annex selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Annex record, @Param("example") RsAnnexCriteria example);

    int updateByExample(@Param("record") Annex record, @Param("example") RsAnnexCriteria example);

    int updateByPrimaryKeySelective(Annex record);

    int updateByPrimaryKey(Annex record);
    
    int deleByKey(String id);
}