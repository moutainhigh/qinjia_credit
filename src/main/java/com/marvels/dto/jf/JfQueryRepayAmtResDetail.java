package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfGetRepayPlanResDetail
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/14 14:27
 * @Version 1.0
 **/
@Getter
@Setter
public class JfQueryRepayAmtResDetail {
    /** 期数*/
    private String period;
    /** 计划还款日期*/
    private String planRepayDate;
    /** 结清金额*/
    private String settleAmt;
    /**  应还本金*/
    private String repayAmt;
    /** 应还利息*/
    private String repayInt;
    /** 罚息金额*/
    private String repaPenaInt;
    /** 应还费用*/
    private String repayFee;
}
