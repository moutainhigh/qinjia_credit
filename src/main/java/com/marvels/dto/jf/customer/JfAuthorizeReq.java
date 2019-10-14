package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * 信用卡授权
 * @author houyl
 * @date 2019/10/14 12:00
 */
@Setter
@Getter
public class JfAuthorizeReq {

    /** 客户号 */
    private String customerId;
    /** 用户自定义协议URL */
    private String agreementUrl;
    /** 授权的信用卡号 */
    private String authKey;
    /** 页面跳转 Url */
    private String backUrl;
    /** H5 页面主体颜色 */
    private String themeColor;
    /** 商户的回调地址 */
    private String tenantCallback;

}
