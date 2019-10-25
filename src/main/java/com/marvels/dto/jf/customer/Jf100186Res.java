package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * 根据身份证号码查询客户基本信息
 * @author houyl
 * @date 2019/10/25 10:04
 */
@Getter
@Setter
public class Jf100186Res {
    /** 客户号 */
    private String customerId;
    /** 商户编码 */
    private String tenantCode;
    /** 证件号 */
    private String certId;
    /** 证件类型 */
    private String certType;
    /** 客户姓名 */
    private String customerName;
    /** 手机号 */
    private String phoneNo;
    /** 注册渠道 */
    private String registChannel;

}
