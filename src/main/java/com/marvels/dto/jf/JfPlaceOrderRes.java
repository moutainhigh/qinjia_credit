package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @ClassName JfPlaceOrderRes
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/14 17:27
 * @Version 1.0
 **/
@Getter
@Setter
public class JfPlaceOrderRes {
    /** 资产端商户请求流水号 */
    private String merchTransNo;
    /**  工单信息 */
    private List<JfPlaceOrderResOrderInfo> orderInfo;
}
