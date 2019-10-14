package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @ClassName JfLoanTrialResRepayment
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/14 17:34
 * @Version 1.0
 **/
@Getter
@Setter
public class JfLoanTrialResRepayment {
    /** 期数 */
    private int period;
    /** 还款日 */
    private Date repaymentDate;
    /** 期供金额 */
    private double repaymentAmt;
    /** 本金 （当期归还本金） */
    private double principalAmt;
    /** 利息（当期利息） */
    private double interestAmt;
    /** 剩余本金 */
    private double surplusPrincipal;
}
