package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 贷款类型枚举类
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum TypGrpEnum {
    DURABLE_CONSUMER_GOODS("01", "耐用消费品贷款（商品贷）"),
    GENERAL_CONSUMER_LOAN("02", "一般消费贷款（现金贷）"),
    UMBRELLA_SHOP("02", "伞下店");

    private String code;
    private String desc;


    private TypGrpEnum(String code, String desc) {
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
