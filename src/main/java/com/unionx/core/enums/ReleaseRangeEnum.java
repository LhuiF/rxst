package com.unionx.core.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 发布范围
 * @author xuanYin
 * date :2016/5/25
 * time :${time}
 */
public enum ReleaseRangeEnum {
        //0运维用户 1 一龄用户 2店家用户 3会员
        ALL("0","全体人员"),STOREUSER("2","所有店家"),MEMBER("3","所有会员"),TUTOR("4","所有美容师");

        private String code;
        private String name;

        private static final Map MAP = new HashMap();
        private static final List<Map> list = new ArrayList();

        private ReleaseRangeEnum(String code, String name) {
        this.code = code;
        this.name = name;
        }
        static {
            for (ReleaseRangeEnum e : ReleaseRangeEnum.values()) {
                MAP.put(e.getCode(), e.getName());
            }
        }
        /**
         * 将枚举数据转换成map
         * @return
         */
        public static Map toMap() {
            return MAP;
        }
        public static List getList() {
            return list;
        }
        static {
            for (ReleaseRangeEnum e : ReleaseRangeEnum.values()) {
                Map<String,String> map= new HashMap<>();
                map.put("code", e.getCode());
                map.put("name", e.getName());
                list.add(map);
            }
        }

    public static String getName(String code) {
        for (ReleaseRangeEnum e : ReleaseRangeEnum.values()) {
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
