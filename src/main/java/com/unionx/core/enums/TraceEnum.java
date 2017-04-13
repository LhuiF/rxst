package com.unionx.core.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 跟踪状态
 * @author abner
 */
public enum TraceEnum {

    NOTRACE("1", "未跟踪"), TRACKING("2", "已跟踪"),TRACECOMPLETE("3", "跟踪完成"), STOP("4", "停用");

    private String code;
    private String name;
    private static final Map MAP = new HashMap();
    private static final List<Map> list = new ArrayList();

    TraceEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    static {
        for (TraceEnum e : TraceEnum.values()) {
            MAP.put(e.getCode(), e.getName());
        }
    }

    /**
     * 将枚举数据转换成map
     *
     * @return
     */
    public static Map toMap() {
        return MAP;
    }

    public static List getList() {
        return list;
    }

    static {
        for (TraceEnum e : TraceEnum.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("code", e.getCode());
            map.put("name", e.getName());
            list.add(map);
        }
    }

    public static String getName(String code) {
        for (TraceEnum e : TraceEnum.values()) {
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
