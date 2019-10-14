package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName JfLoanTrialRes
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/14 17:25
 * @Version 1.0
 **/
@Getter
@Setter
public class JfLoanTrialRes {
    /** 客户号 */
    private String custNo;
    /** 年利率 */
    private String yearRate;
    /** 审批金额 */
    private BigDecimal applyAmt;
    /** 合同金额 */
    private BigDecimal contractAmt;
    /** 放款金额 */
    private BigDecimal loanAmt;
    /**  还款计划列表 */
    private List<JfLoanTrialResRepayment> repaymentList;
    /**  费用列表 */
    private List<JfLoanTrialResFeeInfo> feeInfoList;
    /**   费用计划列表 */
    private List<JfLoanTrialResRepaymentFee> repaymentFeeList;
}
