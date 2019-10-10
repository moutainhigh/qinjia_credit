package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 贷款类型枚举类
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum ApptRelationEnum {
    APPT_RELATION_01("01", "父母"),
    APPT_RELATION_02("02", "子女及兄弟姐妹"),
    APPT_RELATION_03("03", "夫妻"),
    APPT_RELATION_99("99", "其它");

    private String code;
    private String desc;


    private ApptRelationEnum(String code, String desc) {
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
