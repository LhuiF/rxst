package com.unionx.core.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 帐号类型枚举
 * @author abner
 */
public enum AccountTypeEnum {

    YLUSER("1","一龄用户"),STOREUSER("2","店家用户"),MEMBER("3","会员");

    private String code;
    private String name;

    private static final Map MAP = new HashMap();

    static {
        for (AccountTypeEnum e : AccountTypeEnum.values()) {
            MAP.put(e.getCode(), e.getName());
        }
    }

    private AccountTypeEnum(String code, String name) {
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
        for (AccountTypeEnum e : AccountTypeEnum.values()) {
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
