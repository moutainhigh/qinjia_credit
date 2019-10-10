package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 学制枚举类
 * 10、受薪人士 （如果选择受薪人士，则下面标黄色且必输项为O的字段为必输字段）
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum ManageTypEnum {
    JYSTLX_OPT_01("01", "生产型"),
    JYSTLX_OPT_02("02", "贸易型"),
    JYSTLX_OPT_03("03", "服务型"),
    JYSTLX_OPT_04("04", "其他");

    private String code;
    private String desc;


    private ManageTypEnum(String code, String desc) {
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
