package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 联系人与申请人关系枚举类
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum RelRelationEnum {
    REL_RELATION_01("01", "父母"),
    REL_RELATION_02("02", "子女及兄弟姐妹"),
    REL_RELATION_99("99", "其他");

    private String code;
    private String desc;


    private RelRelationEnum(String code, String desc) {
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
