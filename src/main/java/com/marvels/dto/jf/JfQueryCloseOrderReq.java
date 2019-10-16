package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfQueryCloseOrderResReq
 * @Description 资产端关单结果查询接口请求参数
 * @Author renyz
 * @Date 2019/10/14 18:03
 * @Version 1.0
 **/
@Getter
@Setter
public class JfQueryCloseOrderReq {
    /** 受理流水号 */
    private String closeNo;
}
