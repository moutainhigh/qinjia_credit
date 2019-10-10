package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 贷款用途
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum GrpPurposeEnum {
    GREP_PURPOSE_COS("COS", "整形美容"),
    GREP_PURPOSE_DEC("DEC", "房屋装修"),
    GREP_PURPOSE_EDU("EDU", "教育培训"),
    GREP_PURPOSE_FLI("FLI", "手机数码"),
    GREP_PURPOSE_FMY("FMY", "日常消费"),
    GREP_PURPOSE_HEA("HEA", "健康医疗"),
    GREP_PURPOSE_MAR("MAR", "结婚庆典"),
    GREP_PURPOSE_SALE("SALE", "家用电器"),
    GREP_PURPOSE_STO("STO", "家具家居"),
    GREP_PURPOSE_TRA("TRA", "外出旅游"),
    GREP_PURPOSE_HOU("HOU", "房屋租赁");


    private String code;
    private String desc;

    GrpPurposeEnum(String code, String desc) {
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
