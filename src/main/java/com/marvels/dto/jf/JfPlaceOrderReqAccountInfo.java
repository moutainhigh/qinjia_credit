package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfPlaceOrderReqAccountInfo
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/14 17:50
 * @Version 1.0
 **/
@Getter
@Setter
public class JfPlaceOrderReqAccountInfo {
    /** 账户类型 */
    private String accountType;
    /** 银行卡号 */
    private String accountNo;
    /** 开户名称 */
    private String accountName;
    /** 预留手机号 */
    private String accountPhone;
    /** 开户行-省 */
    private String accountBankProvince;
    /** 开户行-市 */
    private String accountBankCity;
    /** 开户行编码 */
    private String accountBankCode;
    /** 开户行名称 */
    private String accountBankName;
    /** 对公对私账户 */
    private String privatePublicAccount;
}
