package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfQueryCloseOrderResRes
 * @Description 资产端关单结果查询接口响应参数
 * @Author renyz
 * @Date 2019/10/14 18:12
 * @Version 1.0
 **/
@Getter
@Setter
public class JfQueryCloseOrderRes {
    /**  资产端商户编号 */
    private String merchNo;
    /** 资金机构编号 */
    private String instNo;
    /**  工单号 */
    private String orderId;
    /** 关单原因 */
    private String endResson;
    /** 关单结果 */
    private String dealResult;
}
