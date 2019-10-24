package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfQueryOrderListReq
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/24 17:52
 * @Version 1.0
 **/
@Getter
@Setter
public class JfQueryOrderListReq {
    /** 工单号 */
    private String orderId;
    /** 资产端商户编号 */
    private String merchNo;
    /** 开始行号 */
    private String pageNo;
    /** 每页行数 */
    private String pageSize;

}
