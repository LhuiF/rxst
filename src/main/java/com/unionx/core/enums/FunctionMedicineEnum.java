package com.unionx.core.enums;

import com.unionx.core.util.JsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Sambicg-功能医学报告枚举
 * @author Yang Yanli
 */
public enum FunctionMedicineEnum {

    ANTIFADING("3","抗衰"),HORMONE("4","男女荷尔蒙"),CARDIAC_VESSELS("5","心脑血管"),TUMOUR("6","肿瘤"),ORGANIC_METABOLISM("7","尿的有机酸代谢");

    private String code;
    private String name;

    private static final Map MAP = new HashMap();
    private static final List<Map> list = new ArrayList();

    static {
        for (FunctionMedicineEnum e : FunctionMedicineEnum.values()) {
            MAP.put(e.getCode(), e.getName());
            Map<String,String> map = new HashMap();
            map.put("code", e.getCode());
            map.put("name", e.getName());
            list.add(map);
        }
    }

    private FunctionMedicineEnum(String code, String name) {
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
        for (FunctionMedicineEnum e : FunctionMedicineEnum.values()) {
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
