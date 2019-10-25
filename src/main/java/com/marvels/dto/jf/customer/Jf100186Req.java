package com.marvels.dto.jf.customer;

import lombok.Getter;
import lombok.Setter;

/**
 * 根据身份证号码查询客户基本信息
 * @author houyl
 * @date 2019/10/25 10:04
 */
@Getter
@Setter
public class Jf100186Req {
    /** 身份证号 */
    private String certId;
}
