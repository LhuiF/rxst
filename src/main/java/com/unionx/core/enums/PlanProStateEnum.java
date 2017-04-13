package com.unionx.core.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 计划书审批状态枚举
 * autor xuanYin
 * date :2016/6/6
 */
public enum PlanProStateEnum {
    APPROVALPENDING("0","待审批"),CHECKED("1","审核通过"),REJECT("2","驳回");

    private String code;
    private String name;

    private static final Map MAP = new HashMap();
    private static final List<Map> list = new ArrayList();

    static {
        for (PlanProStateEnum e : PlanProStateEnum.values()) {
            MAP.put(e.getCode(), e.getName());
        }
    }

    private PlanProStateEnum(String code, String name) {
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

    public static String getName(String code) {
        for (PlanProStateEnum e : PlanProStateEnum.values()) {
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
        for (PlanProStateEnum e : PlanProStateEnum.values()) {
            Map<String,String> map= new HashMap<>();
            map.put("code", e.getCode());
            map.put("name", e.getName());
            list.add(map);
        }
    }
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
