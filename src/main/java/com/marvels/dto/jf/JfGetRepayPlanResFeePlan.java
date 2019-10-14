package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfGetIouByCustNoResFeePlan
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/14 14:11
 * @Version 1.0
 **/
@Getter
@Setter
public class JfGetRepayPlanResFeePlan {
    /** 期数*/
    private String period;
    /** 计划还款日期*/
    private String planRepayDate;
    /** 费用类型*/
    private String feeType;
    /** 费用金额*/
    private String feeAmt;
    /** 已还费用金额*/
    private String repayFeeAmt;
    /** 结清时间*/
    private String settleTime;
    /** 结清方式*/
    private String settleType;
}
