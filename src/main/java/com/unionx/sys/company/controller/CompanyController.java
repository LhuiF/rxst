package com.unionx.sys.company.controller;

import com.unionx.core.aop.business.BusinessLogAop;
import com.unionx.core.vo.CommonResponse;
import com.unionx.sys.company.service.CompanyService;
import com.unionx.sys.company.vo.Company;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yl on 2016/10/31.
 */

@Controller
@RequestMapping("/companyController")
@Slf4j
public class CompanyController {



    @Autowired
    private CompanyService companyService;


    @RequestMapping("/company")
    public String initStoreRole(){
        return "company/company";
    }
    /**
     * 保存信息
     * @param company
     * @return
     */
    @BusinessLogAop("删除保存信息company.save")
    @ResponseBody
    @RequestMapping("/save")
    public CommonResponse save(Company company) {
        CommonResponse commonResponse = new CommonResponse();
        try{
            companyService.save(company);
            commonResponse.setSuccess(true);
            commonResponse.setMessage(CommonResponse.SAVE_SUCCESS);
        }catch (Exception e){
            log.error("",e);
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);

        }

        return commonResponse;
    }


    @BusinessLogAop("修改公司信息company.update")
    @ResponseBody
    @RequestMapping("/update")
    public CommonResponse update(Company company){

        CommonResponse commonResponse = new CommonResponse();

        try{
            companyService.update(company);
            commonResponse.setSuccess(true);
            commonResponse.setMessage(CommonResponse.SAVE_SUCCESS);
        }catch (Exception e){
            log.error("",e);
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
        }

        return commonResponse;

    }

    /**
     * 验证公司名称是否存在
     * */

    @ResponseBody
    @RequestMapping("/validate")
    public Boolean validate(String name){
        Boolean b = false;
        try{
            //数据库没此数据 true
            //有数据false
            b = companyService.validate(name);
        }catch (Exception e){
            log.error("",e);
        }
        return b;
    }


    @BusinessLogAop("删除根据id删除company")
    @ResponseBody
    @RequestMapping("/delete")
    public CommonResponse delete(String id ){
        CommonResponse commonResponse = new CommonResponse();

        try {
           companyService.deleteById(id);
            commonResponse.setSuccess(true);
            commonResponse.setMessage(CommonResponse.SAVE_SUCCESS);

        } catch (Exception e) {
            log.error("",e);
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
        }
        return commonResponse;
    }

    @ResponseBody
    @RequestMapping("/getById")
    public CommonResponse getById(String id){
        CommonResponse commonResponse = new CommonResponse();
        Company company = null;
        try {
                company = companyService.getById(id);
                commonResponse.setSuccess(true);
                commonResponse.setData(company);
        } catch (Exception e) {
            log.error("",e);
            commonResponse.setSuccess(false);
        }
        return commonResponse;
    }






}
