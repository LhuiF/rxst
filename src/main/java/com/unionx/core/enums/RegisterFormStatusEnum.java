package com.unionx.core.enums;

import com.unionx.core.util.JsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/7.
 */
public enum RegisterFormStatusEnum {
    //  0 作废 1保存 2 提交审核中 3审核完成
    CANCEL("0","已作废"),SAVE("1","待提交"),SUBMIT("2","审核中"),COMPLETE("3","审核完成"),CANCELING("4","作废中");

    private String code;
    private String name;

    private RegisterFormStatusEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    private static final Map MAP = new HashMap();
    private static final List<Map> list = new ArrayList();

    static {
        for (RegisterFormStatusEnum e : RegisterFormStatusEnum.values()) {
            MAP.put(e.getCode(), e.getName());
            Map<String,String> map = new HashMap();
            map.put("code", e.getCode());
            map.put("name", e.getName());
            list.add(map);
        }
    }

    /**
     * 将枚举数据转换成list
     *
     * @return
     */
    public static List toList() {
        return list;
    }
    /**
     * 将枚举数据转换成map
     * @return
     */
    public static Map toMap() {
        return MAP;
    }

    public static String toListJson() {
        return JsonUtils.writeValueAsString(list);
    }

    /**
     * 转换成json格式的字符串
     * @return
     */
    public static String toMapJson() {
        return JsonUtils.writeValueAsString(MAP);
    }

    public static String getName(String code) {
        for (RegisterFormStatusEnum e : RegisterFormStatusEnum.values()) {
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
