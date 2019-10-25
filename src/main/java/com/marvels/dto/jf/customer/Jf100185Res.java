package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * 查询用户已绑定的银行卡列表
 * @author houyl
 * @date 2019/10/25 09:46
 */
@Setter
@Getter
public class Jf100185Res {
    /** 银行卡号 */
    private String bankCardNo;
    /** 银行编码 */
    private String bankCode;
    /** 姓名 */
    private String bankCustomerName;
    /** 银行预留手机号 */
    private String bankPhoneNo;
    /** 证件号 */
    private String certId;
    /** 证件类型 */
    private String certType;
    /** 机构编号 */
    private String orgCode;
    /** 机构类型 */
    private String orgType;
    /** 绑卡类型 */
    private String tradeType;
    /** 银行卡类型 */
    private String cardType;
    /** 商编 */
    private String instCode;
    /** 签约产品 */
    private String productId;
    /** 绑卡时间 */
    private String transTime;
}
