package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @ClassName JfLoanTrialResRepaymentFee
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/14 17:42
 * @Version 1.0
 **/
@Getter
@Setter
public class JfLoanTrialResRepaymentFee {
    /** 期数 */
    private int period;
    /** 还款日 */
    private Date repaymentDate;
    /** 期供金额 */
    private double repaymentAmt;
    /** 本金 （当期归还本金） */
    private String feeCode;
}
