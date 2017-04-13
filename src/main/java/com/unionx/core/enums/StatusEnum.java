package com.unionx.core.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 状态枚举
 * @author abner
 */
public enum StatusEnum {

    SUCCESS("0","成功"),FAILED("1","失败"),FUNCTIONEXCEPTION("2","方法异常");

    private String code;
    private String name;

    private static final Map MAP = new HashMap();

    static {
        for (StatusEnum e : StatusEnum.values()) {
            MAP.put(e.getCode(), e.getName());
        }
    }

    private StatusEnum(String code, String name) {
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
        for (StatusEnum e : StatusEnum.values()) {
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
