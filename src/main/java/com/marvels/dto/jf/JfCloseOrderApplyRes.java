package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @ClassName JfCloseOrderApplyRes
 * @Description TODO
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
