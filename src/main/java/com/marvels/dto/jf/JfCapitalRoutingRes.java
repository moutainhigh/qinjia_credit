package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @ClassName JfCapitalRoutingRes
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/14 17:14
 * @Version 1.0
 **/
@Getter
@Setter
public class JfCapitalRoutingRes {
    /**  资金路由流水号 */
    private String routeNo;
    /**   资金方渠道编号 */
    private String instNo;
    /**  资金机构名称 */
    private String instName;
    /**  资金方产品编号 */
    private String fundProductId;
    /** 资金产品名称 */
    private String fundProductName;
    /**  合同金额 */
    private BigDecimal contractAmt;
    /**  保费 */
    private BigDecimal premiumAmt;
    /**  保障方式 */
    private String safeguardType;
    /**  保费支付方式 */
    private String premiumPayWay;
    /**  主辅单标识 */
    private String businessFlag;
}
