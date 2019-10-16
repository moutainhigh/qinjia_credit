package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @ClassName JfCloseOrderApplyRes
 * @Description 资产端关单申请接口响应参数
 * @Author renyz
 * @Date 2019/10/14 18:00
 * @Version 1.0
 **/
@Getter
@Setter
public class JfCloseOrderApplyRes {
    /** 受理流水号 */
    private String closeNo;
    /**  工单信息 */
    private List<JfPlaceOrderResOrderInfo> orderInfo;
}
