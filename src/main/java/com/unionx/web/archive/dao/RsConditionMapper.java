package com.unionx.web.archive.dao;

import com.unionx.web.archive.vo.RsCondition;
import com.unionx.web.archive.vo.RsConditionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface RsConditionMapper {
    long countByExample(RsConditionCriteria example);

    int deleteByExample(RsConditionCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(RsCondition record);

    int insertSelective(RsCondition record);

    List<RsCondition> selectByExample(RsConditionCriteria example);

    RsCondition selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RsCondition record, @Param("example") RsConditionCriteria example);

    int updateByExample(@Param("record") RsCondition record, @Param("example") RsConditionCriteria example);

    int updateByPrimaryKeySelective(RsCondition record);

    int updateByPrimaryKey(RsCondition record);

	void deleteById(String situationUuid);

	void deleteConditionById(String id);

	List<RsCondition> getRsConditionsByUUID(String situationUuid);

}