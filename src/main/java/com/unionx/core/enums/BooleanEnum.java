package com.unionx.core.enums;

import com.unionx.core.util.JsonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 布尔值枚举
 * @author songjunjie
 */
public enum BooleanEnum {

    TRUE(1), FALSE(0);

    private int value;

    private static List list = new ArrayList();

    private BooleanEnum(int value) {
        this.value = value;
    }

    static {
        for (BooleanEnum e : BooleanEnum.values()) {
            list.add(e.getValue());
        }
    }

    public static List getList() {
        return list;
    }

    public static String getListJson() {
        return JsonUtils.writeValueAsString(list);
    }

    public static void setList(List list) {
        BooleanEnum.list = list;
    }

    public int getValue() {
        return value;
    }

}
