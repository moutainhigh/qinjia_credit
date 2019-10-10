package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 申请人类型枚举类
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum ApptTypEnum {
    APPT_TYP_01("01", "主申请人"),
    APPT_TYP_02("02", "共同申请人"),
    APPT_TYP_03("03", "保证人"),
    APPT_TYP_04("04", "委托人");

    private String code;
    private String desc;


    private ApptTypEnum(String code, String desc) {
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
