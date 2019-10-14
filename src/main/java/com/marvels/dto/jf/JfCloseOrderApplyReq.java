package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfCloseOrderApplyReq
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/14 17:57
 * @Version 1.0
 **/
@Getter
@Setter
public class JfCloseOrderApplyReq {
    /**  资产端商户编号 */
    private String merchNo;
    /**  工单号 */
    private String orderId;
    /** 关单原因 */
    private String endResson;
}
