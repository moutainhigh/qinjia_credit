package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 贷款类型枚举类
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum LiveInfoEnum {
    CURR_SITUATION_10("10", "自购现无贷款"),
    CURR_SITUATION_20("20", "自购现有贷款"),
    CURR_SITUATION_30("30", "与父母同住"),
    CURR_SITUATION_40("40", "宅基地房"),
    CURR_SITUATION_50("50", "租房"),
    CURR_SITUATION_60("60", "军产房"),
    CURR_SITUATION_70("70", "小产权"),
    CURR_SITUATION_80("80", "单位宿舍"),
    CURR_SITUATION_90("90", "未知"),
    CURR_SITUATION_99("99", "其他");

    private String code;
    private String desc;


    private LiveInfoEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
