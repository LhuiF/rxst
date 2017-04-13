package com.unionx.core.enums;

import com.unionx.core.util.JsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 一龄博士非医疗检测类型枚举
 * @author Yang Yanli
 */
public enum YlbsNonMedicineEnum {

    NON_CLASSIFIED("1","未分类"),ICT_INSPECTION("2","ICT检测"),IRIDOLOGY("3","虹膜检测"),
    GYNECOLOGICAL_EXAMINATION("4","妇科检测"), A_BLOOD_TEST("5","一滴血检测"),
    ROUTINE_BIOCHEMICAL_TEST("6","常规生化检测"),DETECTOR_3D("7","3D检测仪");

    private String code;
    private String name;

    private static final Map MAP = new HashMap();
    private static final List<Map> list = new ArrayList();

    static {
        for (YlbsNonMedicineEnum e : YlbsNonMedicineEnum.values()) {
            MAP.put(e.getCode(), e.getName());
            Map<String,String> map = new HashMap();
            map.put("code", e.getCode());
            map.put("name", e.getName());
            list.add(map);
        }
    }

    private YlbsNonMedicineEnum(String code, String name) {
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
        for (YlbsNonMedicineEnum e : YlbsNonMedicineEnum.values()) {
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
