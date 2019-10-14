package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * 商户接收授权结果
 * @author houyl
 * @date 2019/10/14 12:05
 */
@Setter
@Getter
public class JfCallBackAuthReq {

    /** 客户号 */
    private String customerId;
    /** 任务号 */
    private String transNo;
    /** 授权状态 */
    private String authStatus;
    /** 登录状态 */
    private String loginStatus;
    /** 授权类型 */
    private String authType;
    /** 授权时间 */
    private String authTime;
    /** 授权的 key */
    private String authKey;
    /** 任务状态码 */
    private String errorCode;
    /** 任务错误信息 */
    private String errorMsg;

}
