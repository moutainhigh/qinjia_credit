package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfPlaceOrderResOrderInfo
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/14 17:55
 * @Version 1.0
 **/
@Getter
@Setter
public class JfPlaceOrderResOrderInfo {
    /** 工单号 */
    private String orderId;
    /**  主辅单标识 */
    private String businessFlag;
}
