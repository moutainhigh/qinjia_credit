package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @ClassName JfPlaceOrderReq
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/14 17:43
 * @Version 1.0
 **/
@Getter
@Setter
public class JfPlaceOrderReq {
    /** 借款期限 */
    private Integer periods;
    /** 借款时间 */
    private String applyData;
    /**  工单信息 */
    private List<JfPlaceOrderReqOrderInfo> orderInfo;
    /**  账户信息 */
    private List<JfPlaceOrderReqAccountInfo> accountInfo;
}
