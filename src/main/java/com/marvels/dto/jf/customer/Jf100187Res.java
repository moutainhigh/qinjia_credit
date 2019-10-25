package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * 客户注册接口 (实名 )
 * @author houyl
 * @date 2019/10/25 10:05
 */
@Getter
@Setter
public class Jf100187Res {
    /** 客户号 */
    private String customerId;
    /** 第三方错误码 */
    private String errorCode;
    /** 第三方错误信息 */
    private String errorMsg;
}
