package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 户口性质枚举类
 * 10、受薪人士 （如果选择受薪人士，则下面标黄色且必输项为O的字段为必输字段）
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum MailOptEnum {
    MAIL_ADDR_A("A", "现住房地址"),
    MAIL_ADDR_B("B", "现单位地址"),
    MAIL_ADDR_0("0", "其他地址");


    private String code;
    private String desc;


    private MailOptEnum(String code, String desc) {
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
