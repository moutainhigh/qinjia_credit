package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfQueryRepayRecourdDetail
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/14 15:25
 * @Version 1.0
 **/
@Getter
@Setter
public class JfQueryRepayRecourdResDetail {
    /** 平台流水号*/
    private String transNo;
    /** 客户编号*/
    private String custNo;
    /** 平台交易时间*/
    private String transTime;
    /**  资产端商户编号*/
    private String merchNo;
    /** 商户端流水号*/
    private String merchTransNo;
    /** 还款金额*/
    private String repayAmt;
    /** 状态*/
    private String status;
    /** 支付手机号*/
    private String phone;
    /** 支付银行卡号*/
    private String bankCardNo;
    /** 支付人姓名*/
    private String name;
    /**  支付卡银行编号*/
    private String bankNo;
    /** 交易成功金额*/
    private String successAmt;
    /** 错误描述*/
    private String errorMsg;
    /** 交易完成时间*/
    private String transCompleteTime;
    /** 还款类型*/
    private String repayType;
    /** 还款发起方*/
    private String repayMode;
}
