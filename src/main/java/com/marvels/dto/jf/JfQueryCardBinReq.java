package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * 卡bin查询接口请求参数
 */
@Getter
@Setter
public class JfQueryCardBinReq {
    //请求流水号(业务标志（4位)5095+时间戳（17）+自增序号（7）)
    private String querySerialNo;
    //商户号
    private String merchNo;
    //银行卡号
    private String bankCardNo;
}
