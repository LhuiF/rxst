package com.unionx.sys.company.dao;

import com.unionx.sys.company.vo.Company;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yl on 2016/10/31.
 */
@Repository
public interface CompanyMapper {

    int save(Company company);

    int deleteById(@Param("id" ) String id);

    int update(Company company);
    Company findById(@Param("id" ) String id);

    List<Company> validate(@Param("name") String name);
}
