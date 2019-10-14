package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @ClassName JfGetIouByCustNoRes
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/14 12:10
 * @Version 1.0
 **/
@Getter
@Setter
public class JfGetRepayPlanRes {
    /** 工单编号 */
    private String orderId;
    /** 借据编号 */
    private String iouId;
    /** 资产端商户编号 */
    private String merchNo;
    /** 资产端产品编号 */
    private String asseProductId;
    /** 还款计划 */
    private List<JfGetRepayPlanResRepayPlan> repayPlanList;
    /**  费用计划 */
    private List<JfGetRepayPlanResFeePlan> feePlanList;


}
