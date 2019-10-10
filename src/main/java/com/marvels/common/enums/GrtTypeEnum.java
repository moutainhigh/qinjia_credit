package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 担保方式枚举类
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum GrtTypeEnum {
    GUTR_TYP_10("10", "信用"),
    GUTR_TYP_20("10", "合作机构担保"),
    GUTR_TYP_30("10", "商户担保");

    private String code;
    private String desc;


    private GrtTypeEnum(String code, String desc) {
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
