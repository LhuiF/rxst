package com.unionx.web.archive.dao;

import com.unionx.web.archive.vo.RsMaterialArchive;
import com.unionx.web.archive.vo.RsMaterialArchiveCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RsMaterialArchiveMapper {
    long countByExample(RsMaterialArchiveCriteria example);

    int deleteByExample(RsMaterialArchiveCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(RsMaterialArchive record);

    int insertSelective(RsMaterialArchive record);

    List<RsMaterialArchive> selectByExample(RsMaterialArchiveCriteria example);

    RsMaterialArchive selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RsMaterialArchive record, @Param("example") RsMaterialArchiveCriteria example);

    int updateByExample(@Param("record") RsMaterialArchive record, @Param("example") RsMaterialArchiveCriteria example);

    int updateByPrimaryKeySelective(RsMaterialArchive record);

    int updateByPrimaryKey(RsMaterialArchive record);

	void save(RsMaterialArchive record);

	List<RsMaterialArchive> getArchiveList(RsMaterialArchive record);

	List<RsMaterialArchive> getArchiveByName(String materialName);

	Object update(RsMaterialArchive record);

	void deleteById(Integer id);

	List<RsMaterialArchive> getArchiveById(int id);

}