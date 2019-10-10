package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 学习方式枚举类
 * 10、受薪人士 （如果选择受薪人士，则下面标黄色且必输项为O的字段为必输字段）
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum StudyMthEnum {
    STUDY_MTH_01("01", "全日制"),
    STUDY_MTH_02("02", "全日制"),
    STUDY_MTH_03("03", "未知");

    private String code;
    private String desc;


    private StudyMthEnum(String code, String desc) {
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
