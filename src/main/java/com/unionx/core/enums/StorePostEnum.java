package com.unionx.core.enums;

/**
 * Created by Administrator on 2016/6/1.
 */
public enum StorePostEnum {
    STOREDEAN("51", "会所院长", "storedean"), SHOPOWNER("52", "会所店长", "shopowner"),ADVISER("53", "会所顾问", "adviser"), HOUSEKEEPER("54","会所管家","housekeeper");

    private String code;
    private String name;
    private String memberInfoField;

    private StorePostEnum(String code, String name,String memberInfoField) {
        this.code = code;
        this.name = name;
        this.memberInfoField = memberInfoField;
    }

    public static String getName(String code) {
        for (StorePostEnum e : StorePostEnum.values()) {
            if (e.getCode() == code) {
                return e.getName();
            }
        }
        return null;
    }

    public static String getField(String code) {
        for (StorePostEnum e : StorePostEnum.values()) {
            if (e.getCode().equals(code)) {
                return e.getMemberInfoField();
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

    public String getMemberInfoField() {
        return memberInfoField;
    }
}
