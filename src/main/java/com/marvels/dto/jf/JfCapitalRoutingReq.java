package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfCapitalRoutingReq
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/14 17:03
 * @Version 1.0
 **/
@Getter
@Setter
public class JfCapitalRoutingReq {
    /**  客户中心编号 */
    private String custNo;
    /**  资产端商户编号 */
    private String merchNo;
    /** 资产端产品编号 */
    private String assetProductId;
    /** 保费支付方式 */
    private String premiumPayWay;
    /** 借款金额 */
    private Double applyAmt;
    /** 借款期限 */
    private Integer periods;
    /** 借款用途 */
    private String purpose;
}
