package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 还款间隔枚举
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum LoanFreqEnum {
    LOAN_FREQ_12M("12M", "12个月"),
    GREP_PURPOSE_1M("1M", "1个月"),
    GREP_PURPOSE_1Q("1Q", "1个季度"),
    GREP_PURPOSE_1Y("1Y", "1年"),
    GREP_PURPOSE_2W("2W", "2周"),
    GREP_PURPOSE_6M("6M", "6个月");

    private String code;
    private String desc;

    LoanFreqEnum(String code, String desc) {
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
