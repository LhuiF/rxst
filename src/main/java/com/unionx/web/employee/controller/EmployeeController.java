package com.unionx.web.employee.controller;

import com.github.pagehelper.PageInfo;
import com.unionx.core.vo.CommonResponse;
import com.unionx.core.vo.DataGridData;
import com.unionx.web.common.BaseController;
import com.unionx.web.employee.service.EmployeeService;
import com.unionx.web.employee.vo.Employee;
import com.unionx.web.employee.vo.EmployeeInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;


/**
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/employeeController")
@Slf4j
public class EmployeeController extends BaseController{
		 
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ServletContext servletContext;
	
	
    @RequestMapping("/toemployeePage")
	public ModelAndView toemployeePage(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dict", servletContext.getAttribute("dict"));
		modelAndView.setViewName("employee/employee");
		return modelAndView;
	}
	
	/**
	 * 
	 * @throws ParseException 
	 * @Description: 增加代理人
	 * @throws
	 * @author zhaoyubo
	 * @date 2016-11-1
	 */
	@RequestMapping("/saveEmployee")
	@ResponseBody
	public CommonResponse saveEmployee(@RequestBody Employee vo){
		CommonResponse commonResponse = new CommonResponse();
		try {
			employeeService.addEmployee(vo);
			commonResponse.setSuccess(true);
			commonResponse.setMessage("增加成功");
		} catch (Exception e) {
			commonResponse.setSuccess(false);
			commonResponse.setMessage("增加失败");
			log.error("", e);
			e.printStackTrace();
		}
		return commonResponse;
	}
	
	/**
	 * 
	 * @throws ParseException 
	 * @Description: 修改代理人
	 * @throws
	 * @author zy
	 * @date 2016-11-1
	 */
	@RequestMapping("/updateEmployee")
	@ResponseBody
	public CommonResponse updateEmployee(@RequestBody Employee vo){
		CommonResponse commonResponse = new CommonResponse();
		try {
			employeeService.update(vo);
			commonResponse.setSuccess(true);
			commonResponse.setMessage("修改成功");
		} catch (Exception e) {
			commonResponse.setSuccess(false);
			commonResponse.setMessage("修改失败");
			log.error("", e);
			e.printStackTrace();
		}
		return commonResponse;
	}
	
	/**
	 * @throws
	 * @author zy
	 * @date 2016-11-1
	 */
    @ResponseBody
    @RequestMapping("/getEmployee")
    public DataGridData<EmployeeInfo> getAccumulationList( Employee fund, Integer page, Integer rows){
        if(page ==null){
        	page=1;
        }
        if(rows ==null){
        	rows=10;
        }
    	DataGridData<EmployeeInfo> data = new DataGridData<EmployeeInfo>();
        try {
           PageInfo<EmployeeInfo> accumulationFundPage = employeeService.getEmployeeList(fund,page,rows);
           data.setRows(accumulationFundPage.getList());
           data.setTotal(accumulationFundPage.getTotal());
        }catch (Exception e){
           e.printStackTrace();
           log.error("",e);
        }
        return data;
    }
	
    /**
     * 根据ID查询公积金基数回显至页面
     * @param id
     * @return
     */
    @RequestMapping("/getEmployeeById/{id}")
    @ResponseBody
	public Employee getEmployeeById(@PathVariable String id) {
    	return employeeService.getEmployeeByid(id);
    }
	
    
    /**
     * 根据ID删除
     * @param id
     * @return
     * @date 2016-11-4
     */
    @RequestMapping("/deleteEmployeeById/{id}")
    @ResponseBody
    public CommonResponse deleteEmployeeById(@PathVariable String id){
    	CommonResponse commonResponse = new CommonResponse();
    	try {
    		employeeService.dele(id);
    		commonResponse.setSuccess(true);
    		commonResponse.setMessage("删除成功");
		} catch (Exception e) {
			commonResponse.setSuccess(false);
			commonResponse.setMessage("删除失败");
			e.printStackTrace();
			log.error("",e);
		}
		return commonResponse;
    }
    
  
}
