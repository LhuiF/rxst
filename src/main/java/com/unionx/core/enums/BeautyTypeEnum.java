package com.unionx.core.enums;

import com.unionx.core.util.JsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 美丽类型枚举
 * @author Yang Yanli
 */
public enum BeautyTypeEnum {

    SEXY_TRAINING_CAMP("9","性感训练营"),LIFE_STYLE("10","格调人生"),YLBS_INTERNATIONAL ("11","一龄博士美丽国际医疗预约表"),
    BEIJING_MEDICAL("12","一龄博士美丽北京医疗预约表"),MEDITATION_CAMP("13","禅修营"),
    HAINAN_MEDICAL_INSPECTION("14","一龄医疗海南预检中心报名表");

    private String code;
    private String name;

    private static final Map MAP = new HashMap();
    private static final List<Map> list = new ArrayList();

    static {
        for (BeautyTypeEnum e : BeautyTypeEnum.values()) {
            MAP.put(e.getCode(), e.getName());
            Map<String,String> map = new HashMap();
            map.put("code", e.getCode());
            map.put("name", e.getName());
            list.add(map);
        }
    }

    private BeautyTypeEnum(String code, String name) {
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
        for (BeautyTypeEnum e : BeautyTypeEnum.values()) {
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
