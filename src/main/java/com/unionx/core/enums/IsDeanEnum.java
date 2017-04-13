package com.unionx.core.enums;

/**
 * 是否院长
 * @author abner
 */
public enum IsDeanEnum {

    ISDEAN("1","dean_logname",true);

    private String code;
    private String name;
    private boolean is;

    private IsDeanEnum(String code, String name,boolean is) {
        this.code = code;
        this.name = name;
        this.is = is;
    }

    public static String getName(String code) {
        for (IsDeanEnum e : IsDeanEnum.values()) {
            if (e.getCode().equals(code)) {
                return e.getName();
            }
        }
        return "id";
    }

    public static boolean getIs(String code) {
        for (IsDeanEnum e : IsDeanEnum.values()) {
            if (e.getCode().equals(code)) {
                return e.getIs();
            }
        }
        return false;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public boolean getIs() {
        return is;
    }
}
