package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * 授信项状态查询
 * @author houyl
 * @date 2019/10/14 12:08
 */
@Setter
@Getter
public class JfCreditStatusReq {
    /** 客户号 */
    private String customerId;
    /** 产品号 */
    private String productId;
}
