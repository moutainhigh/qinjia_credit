package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 还款类型 枚举类
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum SetlModeEnum {
    SETLMODE_FS("FS", "全部还款"),
    SETLMODE_NM("NM", "归还欠款"),
    SETLMODE_NF("NF", "指定期数还款,不适用于整笔逾期数据和非应计数据"),
    SETLMODE_ER("ER", "提前部分还款");

    private String code;
    private String desc;


    private SetlModeEnum(String code, String desc) {
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
