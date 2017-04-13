package com.unionx.core.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author  xuanYin
 * date :2016/5/31
 * time :${time}
 */
public enum PlanBookStatusEnum {

    //0 作废 1作废中 2保存 3 提交审核中 4审核完成
    CANCLE("0","已作废"),CANCLING("1","作废中"),SAVED("2","保存"),CHECKING("3","审核中"),CHECKED("4","审核完成");

    private String code;
    private String name;

    private static final Map MAP = new HashMap();
    private static final List<Map> list = new ArrayList();

    static {
        for (PlanBookStatusEnum e : PlanBookStatusEnum.values()) {
            MAP.put(e.getCode(), e.getName());
        }
    }

    private PlanBookStatusEnum(String code, String name) {
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
        for (PlanBookStatusEnum e : PlanBookStatusEnum.values()) {
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
        for (PlanBookStatusEnum e : PlanBookStatusEnum.values()) {
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
