package com.unionx.core.enums;

import com.unionx.core.util.DateUtils;
import com.unionx.core.util.JsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 健康提醒枚举
 * @author abner
 */
public enum HealthRemindEnum {

    NOTREMIND("0","不提醒",0),EVERYDAY("1","每天",1),EVERYTHREEDAYS("2","每三天",3), EVERYFIVEDAYS("3","每五天",5);

    private String code;
    private String name;
    private int cron;

    private static final Map MAP = new HashMap();

    private static final List<Map> list = new ArrayList();

    static {
        for (HealthRemindEnum e : HealthRemindEnum.values()) {
            Map<String, String> map = new HashMap();
            map.put("code", e.getCode());
            map.put("name", e.getName());
            list.add(map);
        }
    }
    static {
        for (HealthRemindEnum e : HealthRemindEnum.values()) {
            MAP.put(e.getCode(), e.getName());
        }
    }

    private HealthRemindEnum(String code, String name,int cron) {
        this.code = code;
        this.name = name;
        this.cron = cron;
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
        for (HealthRemindEnum e : HealthRemindEnum.values()) {
            if (e.getCode() == code) {
                return e.getName();
            }
        }
        return null;
    }

    public static List<String> getCron(String code,String remindDate) {
        List<String> cron = new ArrayList<>();
        String[] split = remindDate.split(":");
        for (HealthRemindEnum e : HealthRemindEnum.values()) {
            if (e.getCode().equals(code)) {
                for(int i = e.getCron() ; i < 91 ; i = i + e.getCron()){
                    String addDay = DateUtils.addDay(i, "yyyy-MM-dd");
                    String[] strings = addDay.split("-");
                    cron.add("0 " + split[1] + " " + split[0] + " " + strings[2] + " " + strings[1] + " ? " + strings[0]);
                }
            }
        }
        return cron;
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
