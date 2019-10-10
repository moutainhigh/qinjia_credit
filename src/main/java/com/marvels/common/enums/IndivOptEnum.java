package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 学制枚举类
 * 10、受薪人士 （如果选择受薪人士，则下面标黄色且必输项为O的字段为必输字段）
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum IndivOptEnum {
    SQRSF_OPT_01("01", "法人代表"),
    SQRSF_OPT_02("02", "控股股东"),
    SQRSF_OPT_03("03", "未持股的实际控制人"),
    SQRSF_OPT_04("04", "无贷款卡");

    private String code;
    private String desc;


    private IndivOptEnum(String code, String desc) {
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
