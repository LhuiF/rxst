package com.unionx.core.enums;

import com.unionx.core.util.DateUtils;
import com.unionx.core.util.JsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 人工跟踪枚举.
 * @author abner
 */
public enum ArtificialTraceEnum {

    ONEDAYHEBDOMAD("1", "第一天到第七天", 7), FIFTEENDAYS("2", "每十五天", 15), THIRTYDAY("3", "每三十天", 30), SIXTYDAY("4", "每六十天", 60), NINETYDAY("5", "每九十天", 90);

    private String code;
    private String name;
    private int cron;

    private static final Map MAP = new HashMap();

    private static final List<Map> list = new ArrayList();

    static {
        for (ArtificialTraceEnum e : ArtificialTraceEnum.values()) {
            Map<String, String> map = new HashMap();
            map.put("code", e.getCode());
            map.put("name", e.getName());
            list.add(map);
        }
    }

    static {
        for (ArtificialTraceEnum e : ArtificialTraceEnum.values()) {
            MAP.put(e.getCode(), e.getName());
        }
    }

    private ArtificialTraceEnum(String code, String name, int cron) {
        this.code = code;
        this.name = name;
        this.cron = cron;
    }

    public static List<String> getCron(String code) {
        List<String> cron = new ArrayList<>();
        for (ArtificialTraceEnum e : ArtificialTraceEnum.values()) {
            if (e.getCode().equals(code)) {
                if (code.equals("1")) {
                    for (int i = 1; i < 8; i++) {
                        String addDay = DateUtils.addDay(i, "yyyy-MM-dd");
                        String[] strings = addDay.split("-");
                        cron.add("00 00 09 " + strings[2] + " " + strings[1] + " ? " + strings[0]);
                    }
                } else {
                    for (int i = e.getCron(); i < 91; i = i + e.getCron()) {
                        String addDay = DateUtils.addDay(i, "yyyy-MM-dd");
                        String[] strings = addDay.split("-");
                        cron.add("00 00 09 " + strings[2] + " " + strings[1] + " ? " + strings[0]);
                    }
                }
            }
        }
        return cron;
    }

    /**
     * 将枚举数据转换成map
     *
     * @return
     */
    public static Map toMap() {
        return MAP;
    }

    public static String toListJson() {
        return JsonUtils.writeValueAsString(list);
    }

    public static String getName(String code) {
        for (ArtificialTraceEnum e : ArtificialTraceEnum.values()) {
            if (e.getCode().equals(code)) {
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
