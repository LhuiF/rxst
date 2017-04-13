package com.unionx.sys.dict.controller;

import com.unionx.core.aop.business.BusinessLogAop;
import com.unionx.core.vo.CommonResponse;
import com.unionx.core.vo.DataGridData;
import com.unionx.sys.dict.service.DictService;
import com.unionx.sys.dict.vo.Dict;
import com.unionx.sys.dict.vo.DictItem;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 功能：字典类型
 * Date:2016/3/14
 * Time:14:09
 * Author:Yanli Yang
 */
@Controller
@RequestMapping("dictController")
@Slf4j
public class DictController {

    @Autowired
    private DictService dictService;

    /**
     * 跳转页面接口
     * @return
     */
    @RequestMapping("/redirectDataDict")
    public String redirectDataDict(HttpServletRequest request){
        request.getParameter("code");
        return "/pages/dict/DataDict";
    }

    /**
     * 功能：查询字典列表
     * @Author: Yanli Yang
     * @Date:2016/3/15 11:53
     */
    @ResponseBody
    @RequestMapping("/getDictList")
    public List<Dict> getDictList(){
        List<Dict> dictList = null;
        try {
            dictList = this.dictService.findAllDict();
        }catch (Exception e){
            log.error("查询字典列表 getDictList",e);
        }
        return dictList;
    }

     /**
     * 功能：查询字典明细列表
     * @Author: Yanli Yang
     * @Date:2016/3/15 13:44
     */
    @ResponseBody
    @RequestMapping("/findDictItem")
    public DataGridData<DictItem> findDictItem(String dictCode,String name){
        DataGridData<DictItem> dataGridData = new DataGridData<>();
        DictItem dictItem = new DictItem();
        dictItem.setDataDictCode(dictCode);
        try {
            List<DictItem> dictItems = this.dictService.findDictItem(dictCode,name);
            if(!CollectionUtils.isEmpty(dictItems)){
                dataGridData.setRows(dictItems);
                dataGridData.setSuccess(true);
                dataGridData.setMessage(CommonResponse.QUERY_SUCCESS);
            }else{
                dataGridData.setSuccess(false);
                dataGridData.setMessage(CommonResponse.SYS_EXCEPTION);
            }
        }catch (Exception e){
            log.error("查询字典明细列表 findDictItem",e);
            dataGridData.setSuccess(false);
        }

        return dataGridData;
    }

    /**
     * 功能：校验新增字典的编码是否重复
     * @Author: Yanli Yang
     */
    @ResponseBody
    @RequestMapping("/validateItemCode")
    public boolean validateItemCode(String dictCode,String code){
        try {
            //通过字典编码查询字典项
            List<DictItem> itemList = this.dictService.findDictItem(dictCode, null);
            if(!CollectionUtils.isEmpty(itemList)){
                for(DictItem temp: itemList){
                    String itemCode = temp.getCode();
                    if(code.equals(itemCode)){
                        return false;
                    }
                }
            }
        }catch (Exception e){
            log.error("校验新增字典的编码是否重复 validateItemCode",e);
            return false;
        }
        return true;
    }
    /**
     * 功能：校验新增字典名称是否重复
     * @Author: Yanli Yang
     */
    @ResponseBody
    @RequestMapping("/validateItemName")
    public boolean validateItemName(String id,String dictCode,String name){
        try {
            //校验新增和编辑时的字典名称
            if(StringUtils.isEmpty(id)){//新增
                List<DictItem> dictItems = this.dictService.validName(null, dictCode, name);
                if(CollectionUtils.isEmpty(dictItems)){
                    return true;
                }
            }else{//编辑时校验
                DictItem dictItem = this.dictService.getDictItemById(id);
                if(null != dictItem){
                    String dictItemName = dictItem.getName();
                    if(dictItemName.equals(name)){//如果传过来的名称和查出来的名称一样，则说明不修改名称
                        return true;
                    }else{
                        //通过字典编码和字典项名称查询
                        List<DictItem> itemList = this.dictService.validName(null,dictCode, name);
                        if(CollectionUtils.isEmpty(itemList)){
                            return true;
                        }
                    }
                }
            }
        }catch (Exception e){
            log.error("校验新增字典名称是否重复 validateItemName",e);
            return false;
        }
        return false;
    }

    /**
     * 功能：新增字典明细信息
     * @Author: Yanli Yang
     */
    @BusinessLogAop("新增字典明细信息")
    @ResponseBody
    @RequestMapping("/saveDictItem")
    public CommonResponse saveDictItem(DictItem dictItem){
        CommonResponse commonResponse = new CommonResponse();
        try {
            String dictItemId = dictItem.getId();
            if (StringUtils.isNotBlank(dictItemId)) {
                dictItem.setUpdateDatatime(new Date());
                this.dictService.updateDictItem(dictItem);
            } else {
                this.dictService.saveDictItem(dictItem);
            }
            commonResponse.setSuccess(true);
            commonResponse.setMessage(CommonResponse.SAVE_SUCCESS);
        } catch (Exception e) {
            log.error("新增字典明细信息 saveDictItem", e);
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
        }
        return commonResponse;
    }

    /**
     * 功能：通过数据字典id查询详细信息
     * @Author: Yanli Yang
     * @Date:2016/3/17 15:04
     */
    @ResponseBody
    @RequestMapping("/getDictItemById")
    public CommonResponse getDictItemById(String itemId){
        CommonResponse commonResponse = new CommonResponse();
        try {
            DictItem dataDictItem = this.dictService.getDictItemById(itemId);
            commonResponse.setSuccess(true);
            commonResponse.setData(dataDictItem);
        } catch (Exception e) {
            log.error("通过数据字典id查询详细信息 getDictItemById", e);
            commonResponse.setSuccess(false);
            commonResponse.setMessage(CommonResponse.SYS_EXCEPTION);
        }
        return commonResponse;
    }


}
