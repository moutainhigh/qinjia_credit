package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfQueryRepayAmtRes
 * @Description 主动还款接口响应参数
 * @Author renyz
 * @Date 2019/10/14 14:34
 * @Version 1.0
 **/
@Getter
@Setter
public class JfRayRes {
    /** 扣款状态*/
    private String status;
    /** 商户端流水号*/
    private String merchTransNo;
    /** 平台流水号*/
    private String transNo;
    /** 平台交易时间*/
    private String transTime;
}
