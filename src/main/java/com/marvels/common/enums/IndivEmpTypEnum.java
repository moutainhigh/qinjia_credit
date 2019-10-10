package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 学制枚举类
 * 10、受薪人士 （如果选择受薪人士，则下面标黄色且必输项为O的字段为必输字段）
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum IndivEmpTypEnum {
    COM_KIND_A("A", "政府机关/事业单位"),
    COM_KIND_B("B", "政府机关/事业单位"),
    COM_KIND_C("C", "政府机关/事业单位"),
    COM_KIND_D("D", "政府机关/事业单位"),
    COM_KIND_E("E", "政府机关/事业单位"),
    COM_KIND_Z("Z", "政府机关/事业单位");

    private String code;
    private String desc;


    private IndivEmpTypEnum(String code, String desc) {
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
