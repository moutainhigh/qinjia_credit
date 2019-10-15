package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @ClassName JfLoanResultReq
 * @Description 放款结果通知接口回调参数
 * @Author renyz
 * @Date 2019/10/15 13:54
 * @Version 1.0
 **/
@Getter
@Setter
public class JfLoanResultReq {
    /** 工单号 */
    private String orderId;
    /** 商户编号 */
    private String merchNo;
    /** 资产端商户流水号 */
    private String merchTransNo;
    /** 资金机构编号 */
    private String instNo;
    /** 客户编号 */
    private String custNo;
    /** 申请金额 */
    private BigDecimal applyAmt;
    /** 合同金额 */
    private String contractAmt;
    /** 放款金额 */
    private BigDecimal drawnAmt;
    /** 放款流水编号 */
    private String jfApplyId;
    /** 放款时间 */
    private String loanDate;
    /** 放款状态 */
    private String dealResult;
    /** 大保费 */
    private BigDecimal premiumAmt;
    /** 放款卡号 */
    private String accountNo;
    /** 工单状态 */
    private String orderStatus;
    /** 流程节点 */
    private String processNode;
    /** 节点状态 */
    private String processStatus;
}
