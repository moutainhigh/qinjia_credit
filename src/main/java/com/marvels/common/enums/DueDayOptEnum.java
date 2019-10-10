package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 贷款类型枚举类
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum DueDayOptEnum {
    DUE_DAYOPT_1("1", "放款日对日"),
    DUE_DAYOPT_2("2", "固定日"),
    DUE_DAYOPT_4("4", "主动还款日");

    private String code;
    private String desc;


    private DueDayOptEnum(String code, String desc) {
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
