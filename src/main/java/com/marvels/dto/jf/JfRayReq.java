package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfQueryRepayAmtReq
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/14 14:31
 * @Version 1.0
 **/
@Getter
@Setter
public class JfRayReq {
    /** 借据编号*/
    private String iouId;
    /** 期数区间*/
    private String period;
    /** 还款金额*/
    private String repayAmt;
    /** 资产端商户编号*/
    private String merchNo;
    /** 商户流水号*/
    private String merchTransNo;
    /** 交易时间*/
    private String transTime;
    /** 还款类型*/
    private String repayType;
    /** 计划类型*/
    private String planType;
}
