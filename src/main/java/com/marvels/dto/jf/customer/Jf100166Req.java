package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * 借记卡授权
 * @author houyl
 * @date 2019/10/14 17:30
 */
@Setter
@Getter
public class Jf100166Req {
    /** 客户号 */
    private String customerId;
    /** 银行卡号 */
    private String bankCardNo;
    /** 银行编码 */
    private String bankCode;
    /** 手机号 */
    private String bankPhoneNo;

}
