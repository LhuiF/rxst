package com.unionx.sys.injuryrate.controller;


import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.unionx.core.aop.business.BusinessLogAop;
import com.unionx.core.vo.CommonResponse;
import com.unionx.core.vo.DataGridData;
import com.unionx.sys.injuryrate.service.RsInjuryrateService;
import com.unionx.sys.injuryrate.vo.RsInjuryrate;
import com.unionx.web.common.BaseController;

/**
 * @author lhf
 */
@Slf4j
@Controller
@RequestMapping("/rsInjuryrateController")
public class RsInjuryrateController extends BaseController{
	
    @Autowired
   private RsInjuryrateService rsInjuryrateService;

    /**
     * 返回工伤费率页面
     * @return
     */
    @RequestMapping("/initInjuryrate")
    public String injuryRate(HttpServletRequest request){
    	return "basicRecord/injuryRate";
    }
    
    /**
     * 获取工伤费率
     * @return
     */
    @BusinessLogAop("获取信息")
    @ResponseBody
    @RequestMapping("/getInjuryList")
    public DataGridData<RsInjuryrate> getInjuryList(RsInjuryrate injuryrate,int page,int rows){
    	 DataGridData<RsInjuryrate> data = new DataGridData<RsInjuryrate>();
         try {
             PageInfo<RsInjuryrate> injury = this.rsInjuryrateService.getAllInjuryrate(injuryrate, page, rows);
             data.setRows(injury.getList());
             data.setTotal(injury.getTotal());
         }catch (Exception e){
             log.error("获取列表",e);
         }
         return data;
    }
    
    /**
     * 保存工伤费率信息或者修改工伤费率
     * @param RsInjuryrate
     * @return
     */
    @BusinessLogAop("保存工伤费率信息")
    @ResponseBody
    @RequestMapping("/saveInjuryrate")
    public CommonResponse saveInjuryrate(RsInjuryrate injuryrate) {
        CommonResponse commonResponse = new CommonResponse();
        try {
        	rsInjuryrateService.saveInjuryrate(injuryrate);
		 commonResponse.setSuccess(true);
            commonResponse.setMessage(CommonResponse.SAVE_SUCCESS);
        } catch (Exception e) {
            log.error("",e);
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
        }
        return commonResponse;
    }
    /**
     * 查询费率
     * @param id
     * @return
     */
    @BusinessLogAop("查询")
    @ResponseBody
    @RequestMapping("/showInjuryrate")
    public RsInjuryrate getOneInjuryrate(int id) {
       return rsInjuryrateService.getInjuryrateById(id);
     }
    
   /* @RequestMapping("/getgAccumulationById")
	public ModelAndView getgAccumulationById(String id) {
		List<RsAccumulationFundVo> list = service.getgAccumulationById(id);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("data", list);
		modelAndView.setViewName("preferences/accumulationEdit");
		return modelAndView;

	}*/
	
    /**
     * 保存工伤费率信息或者修改工伤费率
     * @param RsInjuryrate
     * @return
     */
    @BusinessLogAop("修改工伤费率")
    @ResponseBody
    @RequestMapping("/update")
    public CommonResponse updateInjuryrate(RsInjuryrate injuryrate) {
        CommonResponse commonResponse = new CommonResponse();
        try {
        	rsInjuryrateService.updateInjuryrate(injuryrate);
           commonResponse.setSuccess(true);
            commonResponse.setMessage(CommonResponse.SAVE_SUCCESS);
        } catch (Exception e) {
            log.error("",e);
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
        }
        return commonResponse;
    }
    /**
     * 冻结信息，表示已删除
     * @param RsInjuryrate
     * @return
     */
    @BusinessLogAop("冻结信息，")
    @ResponseBody
    @RequestMapping("/deleteInjuryRate")
    public CommonResponse deleteInjuryRate(int id) {
        CommonResponse commonResponse = new CommonResponse();
         try {
        	 rsInjuryrateService.deleteInjuryrate(id);
			commonResponse.setSuccess(true);
            commonResponse.setMessage(CommonResponse.SAVE_SUCCESS);
        } catch (Exception e) {
        	log.error("",e);
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
        }
        return commonResponse;
    }
}
