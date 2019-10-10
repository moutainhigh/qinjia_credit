package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 还款方式
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum MtdCdeEnum {
    Mtd_Cde_LT001("FX", "零利率还款"),
    Mtd_Cde_LT002("LT002", "一次性还本付息"),
    Mtd_Cde_LT003("LT003", "按期付息到期还本"),
    Mtd_Cde_LT004("LT004", "按半年还本"),
    Mtd_Cde_LT005("LT005", "按年还本"),
    Mtd_Cde_M0002("M0002", "等额本息"),
    Mtd_Cde_SYS001("SYS001", "系统设置-利随本清");

    private String code;
    private String desc;

    private MtdCdeEnum(String code, String desc) {
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
