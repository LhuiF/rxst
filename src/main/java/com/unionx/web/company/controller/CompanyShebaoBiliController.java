package com.unionx.web.company.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.unionx.core.vo.CommonResponse;
import com.unionx.core.vo.DataGridData;
import com.unionx.sys.dict.service.DictService;
import com.unionx.sys.dict.vo.DictItem;
import com.unionx.web.common.BaseController;
import com.unionx.web.company.service.CompanyShebaoBiliService;
import com.unionx.web.company.vo.CompanyShebaoBili;
import com.unionx.web.company.vo.CompanyShebaoMainbili;
import com.unionx.web.company.vo.EntermainBean;
import com.unionx.web.enterprise.service.EnterpriseProportionService;
import com.unionx.web.insurance.po.InsuranceProportionDetail;
import com.unionx.web.insurance.po.InsuranceResult;
import com.unionx.web.insurance.service.RsInsuranceProportionService;
import com.unionx.web.insurance.vo.RsInsurance;

/**
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("companyshebaoController")
@Slf4j
public class CompanyShebaoBiliController extends BaseController {
	
	@Autowired
	private CompanyShebaoBiliService companyShebaoBiliService;
	@Autowired
	private DictService dictService;
	
	@Autowired
	EnterpriseProportionService enterpriseService;//企业信息
	
	@Autowired
	RsInsuranceProportionService proportionService;//社保参数
	
	/*
	 * 
	 * 企业社保比例维护列表页
	 */
	 @RequestMapping("/companyshebaoList")
     public String returnUrl(HttpServletRequest request){
		
		request.setAttribute("enterprise",enterpriseService.getEnterprise());//企业信息
		request.setAttribute("insurance",proportionService.getInsurance());//社保参数
		
		return "canshu/companyshebaoList";
	   }
	 /*
	  * 企业社保缴费比例新增页面
	  */
	 @RequestMapping("/companyshebaoAdd")
     public String returnAddUrl(HttpServletRequest request){
		 
		 List<CompanyShebaoBili> rsInsuranceBaseList=new ArrayList<CompanyShebaoBili>();
		 List<DictItem>xzList= dictService.findByDictItem("20003");
		 
		 for(DictItem xztype:xzList){
			 CompanyShebaoBili insuranceBase=new CompanyShebaoBili();
			 
			 insuranceBase.setPayPersonType(xztype.getCode());
			 insuranceBase.setPayPersonName(xztype.getName());
			 
			 rsInsuranceBaseList.add(insuranceBase);
		 }
		 request.setAttribute("enterprise",enterpriseService.getEnterprise());//企业信息
		 request.setAttribute("rsInsuranceAccountList", rsInsuranceBaseList);//险种信息
		 return "canshu/companyshebaoAdd";
	   }
	 
	 
	 @RequestMapping("getInsuranceByUuid")
	 @ResponseBody
	 public EntermainBean getInsuranceByUuid(String id){
		 
		 EntermainBean entermainBean=null;
		 
		 try{
			 entermainBean=new EntermainBean();
			 List <CompanyShebaoBili>rsInsuranceAccountList=new ArrayList();
			 
			 List<RsInsurance> rsInsuranceList=proportionService.getInsuranceByUuid(id);
			 
			 /*rsInsuranceList.get(0).getDictCode();
			 rsInsuranceList.get(0).getDictName();
			 rsInsuranceList.get(0).getAveragePay();
			 rsInsuranceList.get(0).getStartTime();
			 rsInsuranceList.get(0).getEndTime();
			 rsInsuranceList.get(0).getYearCity();*/
			 
			 
			 
			 List<InsuranceResult> data=proportionService.getProportionById(id);
			 if(data!=null && data.size()>0){
				 for(InsuranceResult result:data){
					 
					 InsuranceProportionDetail detail=new InsuranceProportionDetail();
					 CompanyShebaoBili companysbVO=new CompanyShebaoBili();
					 
					 result.getId();
					 companysbVO.setPayPersonType(result.getDictCode());//险种对应的字典编码
					 companysbVO.setPayPersonName(result.getName());//险种对应的字典名称
					 companysbVO.setShebaoCanshuUuid(result.getUuid());//社保参数的uuid
					 
					 
					 detail=result.getDetail();
					 
					 
					 companysbVO.setCompanyEndowment(detail.getPensionsEnterprise());// 养老企业
					 companysbVO.setPersonEndowment(detail.getPensionsPersonal());// 养老个人
					 
					 companysbVO.setCompanyUnemployment(detail.getUnemploymentEnterprise());//失业企业
					 companysbVO.setPersonUnemployment(detail.getUnemploymentPersonal());//失业个人
					
					 companysbVO.setCompanyInjury(detail.getInjuriesEnterprise());//工伤企业
					 companysbVO.setPersonInjury(detail.getInjuriesPersonal());//工伤个人
					
					 companysbVO.setCompanyMaternity(detail.getBirthEnterprise());//生育企业
					 companysbVO.setPersonMaternity(detail.getBirthPersonal());//生育个人
						
					 companysbVO.setCompanyMedical(detail.getMedicalEnterprise());//医疗企业
					 companysbVO.setPersonMedical(detail.getMedicalPersonal());// 医疗个人
					 companysbVO.setPersonMedicalDb(detail.getPersonalIllness());//// 个人大病
						
					 rsInsuranceAccountList.add(companysbVO);
					 
				 }
			 }
			 
			 entermainBean.setDept( rsInsuranceList.get(0).getYearCity());
			 
			 entermainBean.setEnterprisestartTime(rsInsuranceList.get(0).getStartTime());
			 entermainBean.setEnterpriseendTime(rsInsuranceList.get(0).getEndTime());
			 
			 entermainBean.setRsInsuranceAccountList(rsInsuranceAccountList);
			 
			 //entermainBean.setEnterpriseName(enterpriseName);
			// entermainBean.setEnterpriseUUid(enterpriseUUid);
			 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 
	    	return entermainBean;
	    }
	 
	 
	/**
	 * 
	 * @param fund 社保参数对象
	 * @param page 页码
	 * @param rows 页的大小
	 * @return
	 */
	
	@ResponseBody
    @RequestMapping("/geCompanyShebaoList")
	public DataGridData<CompanyShebaoMainbili> getCompanyShebaoBiliList(CompanyShebaoMainbili fund, int page, int rows){
		DataGridData<CompanyShebaoMainbili> data = new DataGridData<CompanyShebaoMainbili>();
		
		try{
			PageInfo<CompanyShebaoMainbili> accumulationFundPage = companyShebaoBiliService.getPageCompanyShebaoBili(fund,page,rows);
            data.setRows(accumulationFundPage.getList());
            data.setTotal(accumulationFundPage.getTotal());
		}catch(Exception e){
			e.printStackTrace();
		}
		return data;
		
	}
	/**
     * 保存
     * @Description: TODO 
     * @throws
     * @author 
      */
	 @RequestMapping("saveEnterpriseSB")
	 @ResponseBody
	 public CommonResponse saveEnterpriseSbbili(EntermainBean enterpriseMain) {
		 CommonResponse response = new CommonResponse();
		 
		 try{
			 
			 companyShebaoBiliService.saveEnterpriseSB(enterpriseMain);
			 response.setMessage("");
			 response.setSuccess(true);
		 }catch(Exception e){
			 log.error("新增信息 saveEnterpriseSB错误", e);
			 response.setSuccess(false);
			 response.setMessage(CommonResponse.SYS_EXCEPTION);
		 }
		 return response;
		 
	 }

	 /**
	   * 企业社保缴费比例修改
	   * 
	   */
 @RequestMapping(params ="companyShebaocanshuEdit")
 public ModelAndView addorupdate(HttpServletRequest req) {
	 int id=Integer.parseInt(req.getParameter("id"));
	 
	 ModelAndView mv=new ModelAndView("canshu/companyshebaoEdit");
	 
	 CompanyShebaoMainbili mainBili=companyShebaoBiliService.getMainEnterprise(id);
	 
	 List <CompanyShebaoBili>rsInsuranceAccountList=new ArrayList();
	 String uuid=mainBili.getMainUuid();
	 
	 rsInsuranceAccountList=companyShebaoBiliService.selectByExample(uuid);
	 
	 mv.addObject("mainBili", mainBili);
	 mv.addObject("rsInsuranceAccountList", rsInsuranceAccountList);

	 return mv;
	 }
    
    /*
	 * 修改企业社保缴费比例
	 * 
	 */
	@RequestMapping("/updateCompanysb")
	@ResponseBody
	public CommonResponse update(EntermainBean enterpriseMain,HttpServletRequest request){
		CommonResponse commonResponse = new CommonResponse();
		 try{
			 companyShebaoBiliService.updateEnterpriseSB(enterpriseMain);
			 commonResponse.setSuccess(true);
	         commonResponse.setMessage(CommonResponse.SAVE_SUCCESS);
		 }catch(Exception e){
			 log.error("修改信息 updateCompanysb错误", e);
			 commonResponse.setSuccess(false);
	         commonResponse.setMessage(CommonResponse.SYS_EXCEPTION); 
		 }
		 return commonResponse;
	}
	 /**
     * 根据ID删除
     * @param id
     * @return
     * @date 2016-11-4
     */
    @RequestMapping("delObjById/{id}")
    @ResponseBody
    public CommonResponse deleteCompanysbById(@PathVariable("id") Integer id){
    	CommonResponse commonResponse = new CommonResponse();
    	try {
    		companyShebaoBiliService.deleteCompanysbById(id);
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
    /**
     * 功能：校验新增时某个企业社保参数时企业和社保参数年度是否设置
     * @Author: 
     */
    @ResponseBody
    @RequestMapping("/validateEnterpriseSB")
	public boolean valivalidDictcodeYear(HttpServletRequest req){
		
		String dictCode=req.getParameter("dictCode");
		String enterpriseUuid=req.getParameter("enterpriseUuid");
		
		CommonResponse commonResponse = new CommonResponse();
		
		HashMap map=new HashMap();
		map.put("dictCode", dictCode);
		map.put("enterpriseUuid", enterpriseUuid);
		
		return companyShebaoBiliService.validateEnterpriseSB(map);
		

	}
}
