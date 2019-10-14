package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 商户授信结果信息接收
 * @author houyl
 * @date 2019/10/14 17:38
 */
@Setter
@Getter
public class Jf100173Req {
    /** 状态 */
    private String status;
    /** 报错信息 */
    private String message;
    /** 授信请求结果集 Map */
    private Map result;
    /** 请求唯一编号 */
    private String flowId;
    /** 额度 */
    private Double creditQuota;
    /** 授信审核状态 */
    private String creditStatus;

}
