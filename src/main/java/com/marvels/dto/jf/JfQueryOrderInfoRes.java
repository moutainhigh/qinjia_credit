package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @ClassName JfQueryOrderInfoRes
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/14 18:16
 * @Version 1.0
 **/
@Getter
@Setter
public class JfQueryOrderInfoRes {
    /** 工单号 */
    private String orderId;
    /** 客户号 */
    private String custNo;
    /** 客户标签 */
    private String custLabel;
    /** 客户风险等级 */
    private String riskGrade;
    /** 资产端商户流水号 */
    private String merchTransNo;
    /** 资产端产品编号 */
    private String assetProductId;
    /** 资金端产品编号 */
    private String fundProductId;
    /** 借款金额 */
    private BigDecimal applyAmt;
    /** 借款期限 */
    private Integer periods;
    /** 借款时间 */
    private String applyDate;
    /** 保障方式 */
    private String safeguardType;
    /** 保费支付方式 */
    private String premiumPayWay;
    /** 借款用途 */
    private String purpose;
    /** 放款方式 */
    private String loanMethod;
    /** 合同金额 */
    private BigDecimal contractAmt;
    /** 合同编号 */
    private String contractNo;
    /** （大）保费 */
    private BigDecimal premiumAmt;
    /** 主辅单标示 */
    private String businessFlag;
    /** 工单状态 */
    private String orderStatus;
    /** 结束原因 */
    private String endReason;
    /** 借据编号 */
    private String iouId;
    /** 客户姓名 */
    private String custName;
    /** 客户身份证号码 */
    private String custCertId;
    /** 客户手机号 */
    private String custPhone;
    /** 平台编号 */
    private String platform;
    /** 渠道编号 */
    private String merchChannelId;
}
