package com.unionx.web.proxy.dao;

import com.unionx.web.proxy.vo.RsLinkpeople;
import com.unionx.web.proxy.po.RsLinkpeopleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface RsLinkpeopleMapper {
    long countByExample(RsLinkpeopleCriteria example);

    int deleteByExample(RsLinkpeopleCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(RsLinkpeople record);

    int insertSelective(RsLinkpeople record);

    List<RsLinkpeople> selectByExample(RsLinkpeopleCriteria example);

    RsLinkpeople selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RsLinkpeople record, @Param("example") RsLinkpeopleCriteria example);

    int updateByExample(@Param("record") RsLinkpeople record, @Param("example") RsLinkpeopleCriteria example);

    int updateByPrimaryKeySelective(RsLinkpeople record);

    int updateByPrimaryKey(RsLinkpeople record);
}