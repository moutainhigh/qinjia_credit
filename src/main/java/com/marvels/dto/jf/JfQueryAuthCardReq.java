package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * 2.3鉴权查询接口请求参数
 */
@Getter
@Setter
public class JfQueryAuthCardReq {
    //请求流水号(业务标志（4位)5095+时间戳（17）+自增序号（7）)
    private String querySerialNo;
    //商户号
    private String merchNo;
    //鉴权类型
    private String verifyType;
    //持卡人姓名
    private String custName;
    //身份证号码
    private String certId;
    //银行卡号
    private String cardNo;
    //预留手机号（四要素必填）
    private String phone;
}
