package com.unionx.web.archive.dao;

import com.unionx.web.archive.vo.RsCertificateManagement;
import com.unionx.web.archive.vo.RsCertificateManagementCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RsCertificateManagementMapper {
    long countByExample(RsCertificateManagementCriteria example);

    int deleteByExample(RsCertificateManagementCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(RsCertificateManagement record);

    int insertSelective(RsCertificateManagement record);

    List<RsCertificateManagement> selectByExample(RsCertificateManagementCriteria example);

    RsCertificateManagement selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RsCertificateManagement record, @Param("example") RsCertificateManagementCriteria example);

    int updateByExample(@Param("record") RsCertificateManagement record, @Param("example") RsCertificateManagementCriteria example);

    int updateByPrimaryKeySelective(RsCertificateManagement record);

    int updateByPrimaryKey(RsCertificateManagement record);
	
	List<RsCertificateManagement> getCertificateList(RsCertificateManagement certificate);

	void deleteById(Integer id);

	List<RsCertificateManagement> getCertificateById(int id);
}