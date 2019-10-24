package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName JfQueryOrderListReq
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/24 17:52
 * @Version 1.0
 **/
@Getter
@Setter
public class JfQueryOrderListResList {
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
    /** 借款期限 */
    private Integer periods;
    /** 借款时间 */
    private String applyDate;
    /** 工单状态 */
    private String orderStatus;
    /** 流程节点 */
    private String processNode;
    /** 节点状态 */
    private String processStatus;
    /** 逾期状态 */
    private String overdueStatus;
    /** 逾期天数 */
    private String overdueDays;
    /** 更新时间 */
    private String updateTime;

}
