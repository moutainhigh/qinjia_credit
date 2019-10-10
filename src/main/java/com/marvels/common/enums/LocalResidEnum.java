package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 户口性质枚举类
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum LocalResidEnum {
    LOCAL_RESID_10("10", "本地城镇"),
    LOCAL_RESID_20("20", "本地农村"),
    LOCAL_RESID_30("30", "外地城镇"),
    LOCAL_RESID_40("40", "外地农村"),
    LOCAL_RESID_50("50", "未知");

    private String code;
    private String desc;


    private LocalResidEnum(String code, String desc) {
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
