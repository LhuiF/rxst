package com.unionx.sys.enterprise.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.unionx.sys.enterprise.po.RsEnterpriseCriteria;
import com.unionx.sys.enterprise.vo.RsEnterprise;
@Repository
public interface RsEnterpriseMapper {
    long countByExample(RsEnterpriseCriteria example);

    int deleteByExample(RsEnterpriseCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(RsEnterprise record);

    int insertSelective(RsEnterprise record);

    List<RsEnterprise> selectByExample(RsEnterpriseCriteria example);

    RsEnterprise selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RsEnterprise record, @Param("example") RsEnterpriseCriteria example);

    int updateByExample(@Param("record") RsEnterprise record, @Param("example") RsEnterpriseCriteria example);

    int updateByPrimaryKeySelective(RsEnterprise record);

    int updateByPrimaryKey(RsEnterprise record);

    void deleByid(String id);
    
	List<RsEnterprise> getEnterpriseListByAngencyId(String angencyId);

	List<RsEnterprise> getCertificate();

	List<RsEnterprise> getRsCertificateById(String id);

}