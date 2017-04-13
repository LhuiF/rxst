package com.unionx.core.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 性别枚举
 * @author songjunjie
 */
public enum SexEnum {

    MALE("男"), FEMALE("女"),UNKNOWN("未知");

    private String name;

    private static List list = new ArrayList();

    private SexEnum(String name) {
        this.name = name;
    }

    static {
        for (SexEnum e : SexEnum.values()) {
            list.add(e.getName());
        }
    }

    public static List getList() {
        return list;
    }

    public static void setList(List list) {
        SexEnum.list = list;
    }

    public String getName() {
        return name;
    }

}
