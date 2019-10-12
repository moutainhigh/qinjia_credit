package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * 支持银行卡查询列表入参
 */
@Getter
@Setter
public class JfQueryBankListReq {
    //场景(selfPay:保费   selfRepay:还款（代偿前）   guaranteePay :担保   instRepay:还款 (代偿后）)
    private String bizType;
    //机构编码
    private String instNo;

}
