package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfQueryOrderInfoReq
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/14 18:10
 * @Version 1.0
 **/
@Getter
@Setter
public class JfQueryOrderInfoReq {
    /** 工单号 */
    private String orderId;
    /** 资产端商户编号 */
    private String merchNo;
}
