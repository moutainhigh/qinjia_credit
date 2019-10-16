package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfRepayResultReqOrderNos
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/15 14:12
 * @Version 1.0
 **/
@Getter
@Setter
public class JfRepayResultReqOrderNos {
    /** 工单编号*/
    private String orderId;
    /** 借据编号*/
    private String iouId;
}
