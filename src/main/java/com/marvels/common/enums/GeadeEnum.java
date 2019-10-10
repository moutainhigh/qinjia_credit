package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 年级枚举类
 * 10、受薪人士 （如果选择受薪人士，则下面标黄色且必输项为O的字段为必输字段）
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum GeadeEnum {
    geade_1("1", "1"),
    geade_2("2", "2"),
    geade_3("3", "3"),
    geade_4("4", "4"),
    geade_5("5", "5"),
    school_leng_OTH("OTH", "其他"),
    school_leng_UNK("UNK", "未知");

    private String code;
    private String desc;


    private GeadeEnum(String code, String desc) {
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
