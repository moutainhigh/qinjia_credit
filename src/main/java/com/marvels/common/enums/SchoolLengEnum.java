package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 学制枚举类
 * 10、受薪人士 （如果选择受薪人士，则下面标黄色且必输项为O的字段为必输字段）
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum SchoolLengEnum {
    school_leng_2Y("2Y", "2年"),
    school_leng_3Y("31", "3年"),
    school_leng_4Y("41", "4年"),
    school_leng_5Y("51", "5年"),
    school_leng_OTH("OTH", "其他"),
    school_leng_UNK("UNK", "未知");

    private String code;
    private String desc;


    private SchoolLengEnum(String code, String desc) {
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
