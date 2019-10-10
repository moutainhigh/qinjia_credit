package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 户口性质枚举类
 * 10、受薪人士 （如果选择受薪人士，则下面标黄色且必输项为O的字段为必输字段）
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum PositionOptEnum {
    POSITION_OPT_10("10", "受薪人士"),
    POSITION_OPT_20("20", "自雇人士"),
    POSITION_OPT_40("40", "学生"),
    POSITION_OPT_50("50", "其他"),
    POSITION_OPT_60("60", "未知");


    private String code;
    private String desc;


    private PositionOptEnum(String code, String desc) {
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
