package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfLoanTrialResFeeInfo
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/14 17:41
 * @Version 1.0
 **/
@Getter
@Setter
public class JfLoanTrialResFeeInfo {
    /** 费用类型 */
    private String feeType;
    /**  费用金额 */
    private double feeAmt;
}
