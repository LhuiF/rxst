package com.unionx.core.enums;

import com.unionx.core.util.JsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 健康类型
 * @author Yang Yanli
 */
public enum HealthTypeEnum {

    HEALTH_STATEMENT("1","健康自述表"),EXCRETORY_LIVER("2","肝排报名表"),HEALTH_EDUCATION ("3","健康游学会"),
    UKRAINE_HEALTH_SURVEY("4","乌克兰细胞疗法中心健康调查"),UKRAINE_TOUR("5","乌克兰之旅申请表"),
    YLBS_CUSTOMER_INFO("6","一龄博士赴海南顾客信息单"),
    MEDITATION_CAMP ("7","禅修营"),HAINAN_MEDICAL_INSPECTION ("8","一龄医疗海南预检中心报名表");

    private String code;
    private String name;

    private static final Map MAP = new HashMap();
    private static final List<Map> list = new ArrayList();

    static {
        for (HealthTypeEnum e : HealthTypeEnum.values()) {
            MAP.put(e.getCode(), e.getName());
            Map<String,String> map = new HashMap();
            map.put("code", e.getCode());
            map.put("name", e.getName());
            list.add(map);
        }
    }

    private HealthTypeEnum(String code, String name) {
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
     * 将枚举数据转换成list
     *
     * @return
     */
    public static List toList() {
        return list;
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
        for (HealthTypeEnum e : HealthTypeEnum.values()) {
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
