package com.marvels.common.enums;

/**
 * @program: marvels-open-plateform
 * @description: 采购产品种类 枚举
 * @author: xiaohai
 * @create: 2019-08-18 04:04
 **/
public enum OperGoodsTypEnum {
    OPE_RGOODSTYP_A("A", "冰箱"),
    OPE_RGOODSTYP_B("B", "洗衣机"),
    OPE_RGOODSTYP_C("C", "空调"),
    OPE_RGOODSTYP_D("D", "彩电"),
    OPE_RGOODSTYP_E("E", "热水器"),
    OPE_RGOODSTYP_F("F", "冷柜"),
    OPE_RGOODSTYP_G("G", "电脑"),
    OPE_RGOODSTYP_Y("Y", "其他");

    private String code;
    private String desc;


    private OperGoodsTypEnum(String code, String desc) {
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
