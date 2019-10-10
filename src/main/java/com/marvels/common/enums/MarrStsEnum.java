package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 贷款类型枚举类
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum MarrStsEnum {
    MARR_STS_10("10", "未婚"),
    MARR_STS_20("20", "已婚"),
    MARR_STS_40("10", "离异"),
    MARR_STS_50("10", "丧偶"),
    MARR_STS_60("10", "未知");

    private String code;
    private String desc;


    private MarrStsEnum(String code, String desc) {
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
