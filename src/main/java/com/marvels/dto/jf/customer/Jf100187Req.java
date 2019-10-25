package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * 客户注册接口 (实名 )
 * @author houyl
 * @date 2019/10/25 10:04
 */
@Getter
@Setter
public class Jf100187Req {
    /** 用户手机号 */
    private String phoneNo;
    /** 用户姓名 */
    private String name;
    /** 身份证号 */
    private String certId;
    /** 证件类型 */
    private String certType;
}
