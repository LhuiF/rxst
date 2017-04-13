package com.unionx.core.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuanYin
 * date :2016/6/29
 * time :${time}
 */
public enum PlanBookVoidedAuditStatusEnum {
    //审核结果. 0未审核 1审核通过 2 审核未通过 3取消作废
    UNCHECK("0","未审核"),CHECKED("1","审核通过"),REJECT("2","驳回"),CANCLE("3","取消作废");

    private String code;
    private String name;

    private static final Map MAP = new HashMap();
    private static final List<Map> list = new ArrayList();

    static {
        for (PlanBookVoidedAuditStatusEnum e : PlanBookVoidedAuditStatusEnum.values()) {
            MAP.put(e.getCode(), e.getName());
        }
    }

    private PlanBookVoidedAuditStatusEnum(String code, String name) {
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
        for (PlanBookVoidedAuditStatusEnum e : PlanBookVoidedAuditStatusEnum.values()) {
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
        for (PlanBookVoidedAuditStatusEnum e : PlanBookVoidedAuditStatusEnum.values()) {
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
