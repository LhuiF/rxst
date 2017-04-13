package com.unionx.core.enums;

import com.unionx.core.util.JsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanYin
 * date :2016/5/27
 * time :${time}
 */
public enum ServiceTypeEnum {


    BEAUTY("1","美丽"),HEALTH("2","健康");

    private String code;
    private String name;

    private static final Map MAP = new HashMap();
    private static final List<Map> list = new ArrayList();

    static {
        for (ServiceTypeEnum e : ServiceTypeEnum.values()) {
            MAP.put(e.getCode(), e.getName());
        }
    }

    public static List getList() {
        return list;
    }
    static {
        for (ServiceTypeEnum e : ServiceTypeEnum.values()) {
            Map<String,String> map= new HashMap<>();
            map.put("code", e.getCode());
            map.put("name", e.getName());
            list.add(map);
        }
    }
    private ServiceTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 将枚举数据转换成map
     * @return
     */
    public static Map toMap() {
        return MAP;
    }

    /**
     * 转换成json格式的字符串
     * @return
     */
    public static String toJson() {
        return JsonUtils.writeValueAsString(MAP);
    }
     public static String toListJson() {
        return JsonUtils.writeValueAsString(list);
    }

    public static String getName(String code) {
        for (ServiceTypeEnum e : ServiceTypeEnum.values()) {
            if (e.getCode() .equals(code) ) {
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
