package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfRayReq
 * @Description 还款结果查询接口请求参数
 * @Author renyz
 * @Date 2019/10/14 14:36
 * @Version 1.0
 **/
@Getter
@Setter
public class JfQueryRepayResultReq {
    /** 资产端商户编号*/
    private String merchNo;
    /** 商户流水号*/
    private String merchTransNo;
    /** 平台流水号*/
    private String transNo;
}
