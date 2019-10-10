package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 贷款类型枚举类
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum IndivEduEnum {
    EDU_TYP_00("00", "硕士及以上"),
    EDU_TYP_10("10", "本科"),
    EDU_TYP_20("20", "大专"),
    EDU_TYP_30("30", "高中"),
    EDU_TYP_40("40", "初中及以下"),
    EDU_TYP_50("50", "未知");

    private String code;
    private String desc;


    private IndivEduEnum(String code, String desc) {
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
