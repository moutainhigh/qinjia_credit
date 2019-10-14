package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * 运营商授权
 * @author houyl
 * @date 2019/10/14 11:51
 */
@Setter
@Getter
public class JfAuthOperatorReq {

    /** 客户号 */
    private String customerId;
    /** 是否显示用户协议 */
    private String agreement;
    /** 页面跳转 Url */
    private String backUrl;
    /** 授权失败后是否跳转 backUrl */
    private String defeatSkip;
    /** 是否显示返回按钮 */
    private String hasBack;
    /** H5 页面主体颜色 */
    private String themeColor;
    /** 授权的手机号 */
    private String authKey;
    /** 商户的回调地址 */
    private String tenantCallback;

}
