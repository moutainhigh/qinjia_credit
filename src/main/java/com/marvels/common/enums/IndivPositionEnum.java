package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 学制枚举类
 * 10、受薪人士 （如果选择受薪人士，则下面标黄色且必输项为O的字段为必输字段）
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum IndivPositionEnum {
    POSITION_01("01", "高层"),
    POSITION_02("02", "中层"),
    POSITION_03("03", "基层"),
    POSITION_08("08", "未知"),
    POSITION_09("09", "未知（用于贷款展期）");

    private String code;
    private String desc;


    private IndivPositionEnum(String code, String desc) {
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
