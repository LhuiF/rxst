package com.unionx.core.web.function;


import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.unionx.core.util.JsonUtils;
import com.unionx.core.util.SpringContextUtil;
import com.unionx.sys.dict.service.DictService;
import com.unionx.sys.dict.vo.DictItem;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 返回岗位
 *
 * @author songjunjie
 */
@Slf4j
public class PostFunction {

    /**
     * 获取店家岗位和一龄用户岗位
     *
     * @return
     */
    public static List<Map> findPost() {
        String dictCode = "1010";
        List<Map> stations = new ArrayList<>();
        try {
            DictService dictService = SpringContextUtil.getBean("dictService", DictService.class);
            List<DictItem> stationList = dictService.findDictItem(dictCode, null);
            if (!CollectionUtils.isEmpty(stationList)) {
                for (DictItem temp : stationList) {
                    Map<String, Object> rtnMap = new HashMap<>();
                    rtnMap.put("id", temp.getCode() + "");
                    rtnMap.put("text", temp.getName() + "");
                    rtnMap.put("group", "店家岗位");
                    rtnMap.put("groupId", "2");
                    stations.add(rtnMap);
                }
            }
            String dataDictCode = "1003";
            List<DictItem> stationList1 = dictService.findDictItem(dataDictCode, null);
            if (!CollectionUtils.isEmpty(stationList1)) {
                for (DictItem temp : stationList1) {
                    Map<String, Object> rtnMap = new HashMap<String, Object>();
                    rtnMap.put("id", temp.getCode() + "");
                    rtnMap.put("text", temp.getName() + "");
                    rtnMap.put("group", "一龄用户岗位");
                    rtnMap.put("groupId", "1");
                    stations.add(rtnMap);
                }
            }
                return stations;
        } catch (Exception e) {
            log.error("", e);
        }
        return null;
    }

    /**
     * 获取店家岗位和一龄用户岗位
     *
     * @return
     */
    public static String findPostJsonMap() {
        String dictCode = "1010";
        Map map = new HashMap<>();
        try {
            DictService dictService = SpringContextUtil.getBean("dictService", DictService.class);
            List<DictItem> stationList = dictService.findDictItem(dictCode, null);
            if (!CollectionUtils.isEmpty(stationList)) {
                for (DictItem temp : stationList) {
                    map.put(temp.getCode(), temp.getName());
                }
            }
            String dataDictCode = "1003";
            List<DictItem> stationList1 = dictService.findDictItem(dataDictCode, null);
            if (!CollectionUtils.isEmpty(stationList1)) {
                for (DictItem temp : stationList1) {
                    map.put(temp.getCode(), temp.getName());
                }
            }
        } catch (Exception e) {
            log.error("", e);
        }
        return JsonUtils.writeValueAsString(map);
    }
}
