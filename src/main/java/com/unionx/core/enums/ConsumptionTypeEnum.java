package com.unionx.core.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rjm on 2016/5/26.
 */
public enum ConsumptionTypeEnum {
    DX("1","店销"),WD("2","外带"),SL("3","沙龙");
    private String code;
    private String name;
    private static final Map MAP = new HashMap();
    private static final List<Map> list = new ArrayList();
    ConsumptionTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
    public Map<String,String> getMap(){
        MAP.put("code",code);
        MAP.put("name",name);
        return MAP;
    }
    /**
     * 将枚举数据转换成map
     * @return
     */
    public static Map toMap() {
        return MAP;
    }
    public static List getList() {
        return list;
    }
    static {
        for (ConsumptionTypeEnum e : ConsumptionTypeEnum.values()) {
            Map<String,String> map= new HashMap<>();
            map.put("code", e.getCode());
            map.put("name", e.getName());
            list.add(map);
        }
    }
    public static String getName(String code) {
        for (ConsumptionTypeEnum e : ConsumptionTypeEnum.values()) {
            if (e.getCode().equals(code)) {
                return e.getName();
            }
        }
        return null;
    }
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }


}
