package com.unionx.core.enums;

import com.unionx.core.util.JsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 预约单审批状态枚举
 * autor zhaihonghong
 * date :2016/6/6
 */
public enum RegistProStateEnum {
    APPROVALPENDING("0","待审批"),CHECKED("1","审核通过"),REJECT("2","驳回");

    private String code;
    private String name;

    private static final Map MAP = new HashMap();
    private static final List<Map> list = new ArrayList();

    static {
        for (RegistProStateEnum e : RegistProStateEnum.values()) {
            MAP.put(e.getCode(), e.getName());
        }
    }

    private RegistProStateEnum(String code, String name) {
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

    public static List toList() {
        return list;
    }

    public static String getName(String code) {
        for (RegistProStateEnum e : RegistProStateEnum.values()) {
            if (e.getCode() == code) {
                return e.getName();
            }
        }
        return null;
    }

    public static List getList() {
        return list;
    }
    static {
        for (RegistProStateEnum e : RegistProStateEnum.values()) {
            Map<String,String> map= new HashMap<>();
            map.put("code", e.getCode());
            map.put("name", e.getName());
            list.add(map);
        }
    }

    public static String toListJson() {
        return JsonUtils.writeValueAsString(list);
    }

    /**
     * 转换成json格式的字符串
     * @return
     */
    public static String toMapJson() {
        return JsonUtils.writeValueAsString(MAP);
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
