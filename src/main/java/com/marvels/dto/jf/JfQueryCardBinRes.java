package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * 卡bin查询接口返回参数
 */
@Getter
@Setter
public class JfQueryCardBinRes {
    //请求流水号(业务标志（4位)5095+时间戳（17）+自增序号（7）)
    private String querySerialNo;
    //商户号
    private String merchNo;
    //银行卡号
    private String bankCardNo;
    //银行描述
    private String bankDescription;
    //银行代码
    private String bankCode;
    //卡类型
    private String cardType;
    //卡描述
    private String cardDescription;
    //卡bin
    private String cardBin;

}
