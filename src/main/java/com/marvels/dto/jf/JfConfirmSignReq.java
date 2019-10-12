package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 签约申请接口请求参数
 */
@Getter
@Setter
public class JfConfirmSignReq {
    //客户号
    private String custNo;
    //商户号
    private String merchNo;
    //绑卡流水号
    private String bindSno;
    //确认流水号
    private String confirmSno;
    //手机短信验证码
    private String validCode;
    //交易时间
    private Date tranTime;
}
