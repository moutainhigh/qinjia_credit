package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 2.3鉴权查询接口请求参数
 */
@Getter
@Setter
public class JfSignApplyReq {
    //客户号
    private String custNo;
    //商户号
    private String merchNo;
    //场景
    private String bizType;
    //机构编码
    private String instNo;
    //交易时间
    private Date tranTime;
    //绑卡流水号
    private String bindSno;
    //账户名称
    private String acctName;
    //银行编码
    private String bankNo;
    //银行卡号
    private String cardNo;
    //证件类型(证件类型身份证 : 1)
    private String certType;
    //证件号码
    private String certId;
    //银行预留手机号
    private String phone;
    //省市代码
    private String provCode;
    //终端
    private String terminalType;
    //设备token
    private String token;
}
