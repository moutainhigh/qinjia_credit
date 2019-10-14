package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * 额度查询
 * @author houyl
 * @date 2019/10/14 17:43
 */
@Getter
@Setter
public class Jf100184Req {
    /** 操作日期 */
    private String transDate;
    /** 操作日期 */
    private Long time;
    /** 业务流水号 */
    private String transSerialNo;
    /** 应用标识 */
    private String sysCode;
    /** 商户编码 */
    private String code;
    /** 客户号 */
    private String customerId;

}
