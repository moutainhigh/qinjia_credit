package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * 授信项状态查询 data:Object[]
 * @author houyl
 * @date 2019/10/14 12:10
 */
@Setter
@Getter
public class JfCreditStatusRes {

    /** 授权项类型 */
    private String type;
    /** 第三方 taskId */
    private String taskId;
    /** 授权时间 */
    private String authorizationTime;
    /** 是否必授权项 */
    private String label;
    /** 授权状态 */
    private String status;
    /** 第三方错误状态 */
    private String errorCode;
    /** 第三方错误描述 */
    private String errorMsg;

}
