package com.unionx.core.enums;

import com.unionx.core.util.DateUtils;
import com.unionx.core.util.JsonUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 美丽提醒枚举
 * @author xuchengbin
 */
public enum BeautyRemindEnum {

    EVERYDAY("0", "每天",0),ONEDAY("1","第一天",1), THREEDAY("2","第三天",3),PENTADDY("3","第五天",5),  HEBDOMAD("4","第七天",7),
    FIFTEENDAYS("5", "第十五天",15),THIRTYDAY("6", "第三十天",30), SIXTYDAY("7", "第六十天",60),NINETYDAY("8", "第九十天",90);

    private String code;
    private String name;
    private int cron;

    private static final Map MAP = new HashMap();

    private static final List<Map> list = new ArrayList();

    static {
        for (BeautyRemindEnum e : BeautyRemindEnum.values()) {
            Map<String, String> map = new HashMap();
            map.put("code", e.getCode());
            map.put("name", e.getName());
            list.add(map);
        }
    }
    static {
        for (BeautyRemindEnum e : BeautyRemindEnum.values()) {
            MAP.put(e.getCode(), e.getName());
        }
    }

    private BeautyRemindEnum(String code, String name,int cron) {
        this.code = code;
        this.name = name;
        this.cron = cron;
    }

    public static List<String> getCron(String code, String remindDate) {
        List<String> cron = new ArrayList<>();
        String[] split = remindDate.split(":");
        for (BeautyRemindEnum e : BeautyRemindEnum.values()) {
            if(e.getCode().equals(code)){
                if (code.equals("0")) {
                    for (int i = 1; i < 91; i++) {
                        String addDay = DateUtils.addDay(i, "yyyy-MM-dd");
                        String[] strings = addDay.split("-");
                        cron.add("0 " + split[1] + " " + split[0] + " " + strings[2] + " " + strings[1] + " ? " + strings[0]);
                    }
                } else {
                    String addDay = DateUtils.addDay(e.getCron(), "yyyy-MM-dd");
                    String[] strings = addDay.split("-");
                    cron.add("0 " + split[1] + " " + split[0] + " " + strings[2] + " " + strings[1] + " ? " + strings[0]);
                }
            }
        }
        return cron;
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

    public static String getName(String code) {
        for (BeautyRemindEnum e : BeautyRemindEnum.values()) {
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

    public int getCron() {
        return cron;
    }
}
