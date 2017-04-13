package com.unionx.sys.company.service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.unionx.core.util.Identities;
import com.unionx.sys.company.dao.CompanyMapper;
import com.unionx.sys.company.vo.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yl on 2016/10/31.
 */

@Service
public class CompanyService {

    @Autowired
    private CompanyMapper mapper;


    public void save(Company company){
        company.setId(Identities.uuid());
        mapper.save(company);
    }

    public void deleteById(String id){
        mapper.deleteById(id);

    }

    public void update(Company company){
        mapper.update(company);
    }

    public boolean validate(String name){
        Boolean b = false;
        List<Company> companyList = mapper.validate(name);
        if(CollectionUtils.isEmpty(companyList)){
            b = true;
        }
        return b;

    }

    public Company update(String id){
         return mapper.findById(id);
    }


    public Company getById(String id) {
        return mapper.findById(id);
    }
}
