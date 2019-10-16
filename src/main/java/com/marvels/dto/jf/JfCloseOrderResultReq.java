package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfCloseOrderResultReq
 * @Description 关单结果通知接口回调参数
 * @Author renyz
 * @Date 2019/10/15 14:03
 * @Version 1.0
 **/
@Getter
@Setter
public class JfCloseOrderResultReq {
    /** 资产端商户编号 */
    private String merchNo;
    /** 资金机构编号 */
    private String instNo;
    /** 工单号 */
    private String orderId;
    /** 关单原因 */
    private String endResson;
    /** 受理流水号 */
    private String closeNo;
    /** 处理结果 */
    private String dealResult;
}
