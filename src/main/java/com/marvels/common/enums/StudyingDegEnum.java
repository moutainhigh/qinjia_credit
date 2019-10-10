package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 在读学历枚举类
 * 10、受薪人士 （如果选择受薪人士，则下面标黄色且必输项为O的字段为必输字段）
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum StudyingDegEnum {
    STUDYING_DEG_01("01", "专科"),
    STUDYING_DEG_02("02", "本科"),
    STUDYING_DEG_03("03", "硕士研究生"),
    STUDYING_DEG_04("04", "博士研究生"),
    STUDYING_DEG_05("05", "未知");

    private String code;
    private String desc;


    private StudyingDegEnum(String code, String desc) {
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
