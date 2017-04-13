package com.unionx.web.employee.dao;

import com.unionx.web.employee.vo.Employee;
import com.unionx.web.employee.vo.EmployeeInfo;
import com.unionx.web.employee.po.RsEmployeeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface RsEmployeeMapper {
    long countByExample(RsEmployeeCriteria example);

    int deleteByExample(RsEmployeeCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(RsEmployeeCriteria example);

    Employee selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") RsEmployeeCriteria example);

    int updateByExample(@Param("record") Employee record, @Param("example") RsEmployeeCriteria example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
    
    List<EmployeeInfo> selectByService (Employee record);
    
    int deleByKey(String id);
}