package com.unionx.core.web.function;

import com.unionx.sys.dict.service.DictService;
import com.unionx.core.util.JsonUtils;
import com.unionx.core.util.SpringContextUtil;
import com.unionx.sys.dict.vo.DictItem;
import lombok.extern.slf4j.Slf4j;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author songjunjie HouShuangYang
 */
@Slf4j
public class DataDictFunction {

    /**
     * 根据字典代码返回字典项列表
     * @param dictCode 字典代码
     * @return
     */
    public static List getDictItem(String dictCode) {
        List<DictItem> list = null;
        try {
            DictService dictService = SpringContextUtil.getBean("dictService", DictService.class);
            list = dictService.findDictItem(dictCode,null);
        } catch (Exception e) {
            log.error("", e);
            return null;
        }
        return list;
    }

    /**
     * 根据字典code，返回一个json字符串.例如：{"1":"男","2":"女"}
     * @param dictCode
     * @return
     */
    public static String getJsonMap(String dictCode) {
        List<DictItem> list = null;
        Map map = new HashMap<>();
        try {
            DictService dictService = SpringContextUtil.getBean("dictService", DictService.class);
            list = dictService.findDictItem(dictCode,null);
            for (DictItem dictItem : list) {
                map.put(dictItem.getCode(), dictItem.getName());
            }
        } catch (Exception e) {
            log.error("", e);
            return "{}";
        }
        return JsonUtils.writeValueAsString(map);
    }

    /**
     * 根据字典code，返回一个json数组。例如:[{"code":"1","name":"男"},{"code":"2","name":"女"}]
     * @param dictCode
     * @return
     */
    public static String getJsonArray(String dictCode) {
        List<DictItem> list = null;
        try {
            DictService dictService = SpringContextUtil.getBean("dictService", DictService.class);
            list = dictService.findDictItem(dictCode,null);
        } catch (Exception e) {
            log.error("", e);
            return "[]";
        }
        if (list == null) {
            return "[]";
        }
        return JsonUtils.writeValueAsString(list);
    }

}
