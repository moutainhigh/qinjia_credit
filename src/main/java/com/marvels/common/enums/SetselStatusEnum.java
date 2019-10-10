package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 学制枚举类
 * 10、受薪人士 （如果选择受薪人士，则下面标黄色且必输项为O的字段为必输字段）
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum SetselStatusEnum {
    SEL_STATUS_01("01", "还款处理中"),
    SEL_STATUS_02("02", "还款成功"),
    SEL_STATUS_03("03", "还款失败");

    private String code;
    private String desc;


    private SetselStatusEnum(String code, String desc) {
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
