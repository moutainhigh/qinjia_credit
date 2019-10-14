package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfGetIouByCustNoResRepayPlan
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/14 14:09
 * @Version 1.0
 **/
@Getter
@Setter
public class JfGetRepayPlanResRepayPlan {
    /** 还款人*/
    private String payer;
    /** 收款人*/
    private String payee;
    /** 债权方*/
    private String creditor;
    /** 期数*/
    private String period;
    /** 计划还款日期*/
    private String planRepayDate;
    /** 应还本金*/
    private String planRepayAmt;
    /** 应还利息*/
    private String planRepayInt;
    /** 已还本金*/
    private String repayAmt;
    /** 已还利息*/
    private String repayInt;
    /** 罚息金额*/
    private String penaIntAmt;
    /** 已还罚息金额*/
    private String repayPenaIntAmt;
    /** 结清状态*/
    private String iouStatus;
    /** 结清时间*/
    private String settleTime;
    /**  结清方式*/
    private String settleType;
    /** 是否逾过期*/
    private String isOverdue;
    /** 最近还款时间*/
    private String lastRepayTime;
}
