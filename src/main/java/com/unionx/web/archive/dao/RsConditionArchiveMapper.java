package com.unionx.web.archive.dao;

import com.unionx.web.archive.vo.RsConditionArchive;
import com.unionx.web.archive.vo.RsConditionArchiveCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RsConditionArchiveMapper {
    long countByExample(RsConditionArchiveCriteria example);

    int deleteByExample(RsConditionArchiveCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(RsConditionArchive record);

    int insertSelective(RsConditionArchive record);

    List<RsConditionArchive> selectByExample(RsConditionArchiveCriteria example);

    RsConditionArchive selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RsConditionArchive record, @Param("example") RsConditionArchiveCriteria example);

    int updateByExample(@Param("record") RsConditionArchive record, @Param("example") RsConditionArchiveCriteria example);

    int updateByPrimaryKeySelective(RsConditionArchive record);

    int updateByPrimaryKey(RsConditionArchive record);
    
  	List<RsConditionArchive> getConditionArchiveList(RsConditionArchive record);

	List<RsConditionArchive> getArchiveByName(RsConditionArchive record);

	void deleteById(Integer id);

	List<RsConditionArchive> getArchiveById(int id);	
	List<String> getConditions(@Param("productId") String productId);

}