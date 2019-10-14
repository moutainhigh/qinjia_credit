package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @ClassName JfLoanTrialReq
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/14 17:26
 * @Version 1.0
 **/
@Getter
@Setter
public class JfLoanTrialReq {
    /**  客户中心编号 */
    private String custNo;
    /**  资产端商户编号 */
    private String merchNo;
    /** 资产端产品编号 */
    private String assetProductId;
    /** 资金机构编号 */
    private String instNo;
    /** 资金产品编号 */
    private String fundProductId;
    /** 期数 */
    private Integer periods;
    /** 借款金额 */
    private BigDecimal applyAmt;
    /** 客户标签 */
    private String customLable;
}
