package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * 玖富请求头
 */
@Getter
@Setter
public class JfHttpHeader {
    //接口编号(每个接口的编号)
    private String intfCode;
    //商户编码(金融云平台给各商户分配的编码)
    private String code;
    //资金机构编号(本次业务请求对应的资金机构编号)
    private String orgCode;
    //请求时间戳(请求时间对应的毫秒数)
    private String time;
    //请求签名(md5(code+time+secret)，其中，secret为金融云平台分配给商户的密钥)
    private String sign;
}
