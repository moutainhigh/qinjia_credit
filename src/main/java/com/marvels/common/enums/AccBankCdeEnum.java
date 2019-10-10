package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 贷款类型枚举类
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum AccBankCdeEnum {
    ACC_BANK_BEIJING("04031000", "北京银行"),
    ACC_BANK_GUANGFA("306", "广发银行"),
    ACC_BANK_HUAXIA("304", "华夏银行"),
    ACC_BANK_COMMUNICATIONS("301", "交通银行"),
    ACC_BANK_PINGAN("307", "平安银行"),
    ACC_BANK_PUFA("310", "上海浦东发展银行"),
    ACC_BANK_SHANGHAI("04012900", "上海银行"),
    ACC_BANK_XINGYE("309", "兴业银行"),
    ACC_BANK_ZHAOSHANG("308", "招商银行"),
    ACC_BANK_GONGSHANG("102", "中国工商银行"),
    ACC_BANK_GUANGDA("303", "中国光大银行"),
    ACC_BANK_JIANSHE("105", "中国建设银行"),
    ACC_BANK_NONGYE("103", "中国农业银行"),
    ACC_BANK_CN("104", "中国银行"),
    ACC_BANK_EMS("403", "中国邮政储蓄银行");

    private String code;
    private String desc;


    private AccBankCdeEnum(String code, String desc) {
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
