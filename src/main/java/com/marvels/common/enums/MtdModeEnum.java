package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 利率模式
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum MtdModeEnum {
    Mtd_Cde_LT001("FX", "零利率还款"),
    Mtd_Cde_LT002("RV", "一次性还本付息");

    private String code;
    private String desc;

    private MtdModeEnum(String code, String desc) {
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
