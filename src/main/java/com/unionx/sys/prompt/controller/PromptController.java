package com.unionx.sys.prompt.controller;

import com.github.pagehelper.PageInfo;
import com.unionx.core.aop.business.BusinessLogAop;
import com.unionx.core.vo.CommonResponse;
import com.unionx.core.vo.DataGridData;
import com.unionx.sys.prompt.service.PromptServiceImpl;
import com.unionx.sys.prompt.vo.Prompt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author rjm
 */
@Slf4j
@Controller()
@RequestMapping("/prompt")
public class PromptController {
    @Autowired
    private PromptServiceImpl promptService;

    /**
     * 访问页面
     * @return
     */
    @RequestMapping("page")
    public String page(){
        return "prompt/prompt";
    }
    /**
     * 获取所有消息分页
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllPrompt")
    public DataGridData getAllPrompt(Prompt prompt, int page, int rows){
        DataGridData dataGridData = new DataGridData();
        try {
            PageInfo<Prompt> pageInfo  =promptService.getAllPrompt(prompt,page,rows);
            dataGridData.setTotal(pageInfo.getTotal());
            dataGridData.setRows(pageInfo.getList());
        }catch (Exception e){
            log.error("prompt.getAllPrompt",e);
        }
        return dataGridData;
    }

    /**
     * 根据id获取
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getPromptById")
    public CommonResponse getPromptById(String id){
        CommonResponse commonResponse =new CommonResponse();
        if(null != id && !"".equals(id)){
            Prompt prompt =promptService.getPromptById(id);
            commonResponse.setSuccess(true);
            commonResponse.setData(prompt);
        }else{
            commonResponse.setSuccess(false);
        }
        return commonResponse;
    }

    /**
     * 保存信息
     * @param prompt
     * @return
     */
    @BusinessLogAop("删除保存信息save")
    @ResponseBody
    @RequestMapping("/save")
    public CommonResponse saveRole(Prompt prompt){
        CommonResponse commonResponse = new CommonResponse();
        try {
            int x =promptService.savePrompt(prompt);
            commonResponse.setSuccess(true);
            commonResponse.setMessage(CommonResponse.SAVE_SUCCESS);
        } catch (Exception e) {
            log.error("prompt.save",e);
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
        }
        return commonResponse;
    }

    /**
     * 根据条件获得role
     * @param prompt
     * @return
     */
    @ResponseBody
    @RequestMapping("/validate")
    public Boolean validate(Prompt prompt,String flg){
        Boolean b = false;
        try{
            //数据库没此数据 true，有数据false
            b = promptService.validate(prompt,flg);
        }catch (Exception e){
            log.error("prompt.validate",e);
        }
        return b;
    }
    /**
     * 修改信息
     * @param prompt
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public CommonResponse updateRole(Prompt prompt){
        CommonResponse commonResponse = new CommonResponse();
        try {
            promptService.updatePrompt(prompt);
            commonResponse.setSuccess(true);
            commonResponse.setMessage(CommonResponse.SAVE_SUCCESS);
        } catch (Exception e) {
            log.error("prompt.update",e);
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
        }
        return commonResponse;
    }
}
