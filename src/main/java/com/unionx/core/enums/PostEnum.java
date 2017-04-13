package com.unionx.core.enums;

/**
 * 一龄用户岗位枚举
 * @author abner
 */
public enum PostEnum {

    QUYUJINGLI("14","区域经理","area_manager"),YILINGCAIWU("11", "一龄财务", "finance"), MEILIDUDAO("09", "美丽督导", "b_supervisor"), JIANKANGDUDAO("10", "健康督导", "h_supervisor"), SHOUHOUFUWU("06", "售后服务课员", "serve_manager"), YUNPINGTAIKEZHANG("07", "云平台课长", "cloud_employee"), YUNPINGTAIKEYUAN("08", "云平台课员", "cloud_manager");

    private String code;
    private String name;
    private String storeInfoField;

    private PostEnum(String code, String name,String storeInfoField) {
        this.code = code;
        this.name = name;
        this.storeInfoField =storeInfoField;
    }

    public static String getName(String code) {
        for (PostEnum e : PostEnum.values()) {
            if (e.getCode() == code) {
                return e.getName();
            }
        }
        return null;
    }

    public static String getField(String code) {
        for (PostEnum e : PostEnum.values()) {
            if (e.getCode().equals(code)) {
                return e.getStoreInfoField();
            }
        }
        return "store_name";
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getStoreInfoField() {
        return storeInfoField;
    }
}
