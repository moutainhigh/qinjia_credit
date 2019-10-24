package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfQueryOrderInfoJfb2Req
 * @Description 工单信息查询接口（JFB2）
 * @Author renyz
 * @Date 2019/10/14 18:10
 * @Version 1.0
 **/
@Getter
@Setter
public class JfQueryOrderInfoJfb2Req {
    /** 工单号 */
    private String orderId;
    /** 资产端商户编号 */
    private String merchNo;
    /** 资产端商户流水号 */
    private String merchTransNo;
}
