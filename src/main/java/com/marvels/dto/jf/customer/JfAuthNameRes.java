package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * 实名认证
 * @author houyl
 * @date 2019/10/12 11:07
 */
@Setter
@Getter
public class JfAuthNameRes {

    /** 客户号 */
    private String customerId;
    /** 第三方错误码 */
    private String errorCode;
    /** 第三方错误信息 */
    private String errorMsg;

}
