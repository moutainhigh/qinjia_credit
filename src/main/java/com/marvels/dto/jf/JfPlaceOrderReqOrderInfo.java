package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @ClassName JfPlaceOrderReqOrderInfo
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/14 17:48
 * @Version 1.0
 **/
@Getter
@Setter
public class JfPlaceOrderReqOrderInfo {
    /** 资金方渠道编号 */
    private String instNo;
    /** 资金方产品编号 */
    private String fundProductId;
    /** 借款金额 */
    private BigDecimal applyAmt;
    /** 借款用途 */
    private String purpose;
    /** 主辅单标识 */
    private String businessFlag;
    /** 资金路由流水号 */
    private String routeNo;
}
