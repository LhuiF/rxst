package com.unionx.core.enums;

import com.unionx.core.util.JsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统枚举
 * @author Yang Yanli
 */
public enum SystemEnum {

    OPERATION_MAINTENANCE("1","运维系统"),CUSTOM_SERVICE("2","客服系统"),STORE("3","店家系统"),
    KEFU_MOBILE("4", "客服手机后台系统"), STORE_MOBILE("5", "店家手机后台系统");

    private String code;
    private String name;

    private static final Map MAP = new HashMap();
    private static final List<Map> list = new ArrayList();

    static {
        for (SystemEnum e : SystemEnum.values()) {
            MAP.put(e.getCode(), e.getName());
            Map<String,String> map = new HashMap();
            map.put("code", e.getCode());
            map.put("name", e.getName());
            list.add(map);
        }
    }

    private SystemEnum(String code, String name) {
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

    public static String toListJson() {
        return JsonUtils.writeValueAsString(list);
    }

    /**
     * 转换成json格式的字符串
     * @return
     */
    public static String toJson() {
        return JsonUtils.writeValueAsString(MAP);
    }

    public static String getName(String code) {
        for (SystemEnum e : SystemEnum.values()) {
            if (e.getCode() == code) {
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
