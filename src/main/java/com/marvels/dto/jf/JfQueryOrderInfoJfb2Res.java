package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @ClassName JfQueryOrderInfoJfb2Res
 * @Description 工单信息查询接口响应参数（JFB2）
 * @Author renyz
 * @Date 2019/10/14 18:16
 * @Version 1.0
 **/
@Getter
@Setter
public class JfQueryOrderInfoJfb2Res {
    /** 工单号 */
    private String orderId;
    /** 客户号 */
    private String custNo;
    /** 资产端商户流水号 */
    private String merchTransNo;
    /** 资产端产品编号 */
    private String assetProductId;
    /** 资金方渠道编号 */
    private String instNo;
    /** 机构编号 */
    private String instName;
    /** 资金端产品编号 */
    private String fundProductId;
    /** 资金产品名称 */
    private String fundProductName;
    /** 借款金额 */
    private BigDecimal applyAmt;
    /** 合同金额 */
    private BigDecimal contractAmt;
    /** （大）保费 */
    private BigDecimal premiumAmt;
    /** 放款金额 */
    private BigDecimal drawnAmt;
    /** 借款期限 */
    private Integer periods;
    /** 借款时间 */
    private String applyDate;
    /** 审批时间 */
    private String approveTime;
    /** 放款时间 */
    private String loanDate;
    /** 工单状态 */
    private String orderStatus;
    /** 流程节点 */
    private String processNode;
    /** 节点状态 */
    private String processStatus;
    /** 保障方式 */
    private String safeguardType;
    /** 保费支付方式 */
    private String premiumPayWay;
    /** 借款用途 */
    private String purpose;
    /** 放款方式 */
    private String loanMethod;
    /** 主辅单标示 */
    private String businessFlag;
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
    /** 放款银行卡号 */
    private String loanAccountNo;
    /** 放款开户行编码 */
    private String loanAccountBankCode;
    /** 还款银行卡号 */
    private String repayAccountNo;
    /** 还款开户行编码 */
    private String repayAccountBankCode;
}
