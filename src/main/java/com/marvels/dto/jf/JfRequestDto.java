package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * 接口请求参数
 */
@Setter
@Getter
public class JfRequestDto<T> {
    //接口请求头
    private JfHttpInterfaceHander head;
    //接口请求体
    private T body;
    /**
     * 接口请求参数头
     */
    @Getter
    @Setter
    public static class JfHttpInterfaceHander {
        //交易类型(交易类型（T:交易，Q:查询）)
        private String transType;
        //交易日期(yyyyMMdd)
        private String transDate;
        //交易时间(HHmmss)
        private String transTime;
        //交易流水号(通信请求流水号)
        private String transSerialNo;
        //系统编号(金融云平台发布的系统编号，对于商户来说，商户编号同系统编号一样)
        private String sysCode;
    }
}