package com.unionx.web.proxy.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.unionx.web.proxy.vo.ProxyInfo;
import com.unionx.web.proxy.po.ProxyInfoCriteria;
@Repository
public interface ProxyInfoMapper {
    long countByExample(ProxyInfoCriteria example);

    int deleteByExample(ProxyInfoCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(ProxyInfo record);

    int insertSelective(ProxyInfo record);

    List<ProxyInfo> selectByExample(ProxyInfoCriteria example);

    ProxyInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProxyInfo record, @Param("example") ProxyInfoCriteria example);

    int updateByExample(@Param("record") ProxyInfo record, @Param("example") ProxyInfoCriteria example);

    int updateByPrimaryKeySelective(ProxyInfo record);

    int updateByPrimaryKey(ProxyInfo record);
    
    void deleByid(String id);
}