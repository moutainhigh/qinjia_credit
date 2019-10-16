package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName JfRayRes
 * @Description 还款结果查询接口响应参数
 * @Author renyz
 * @Date 2019/10/14 14:38
 * @Version 1.0
 **/
@Getter
@Setter
public class JfQueryRepayResultRes {
    /** 扣款状态*/
    private String status;
    /** 商户端流水号*/
    private String merchTransNo;
    /** 平台流水号*/
    private String transNo;
    /** 平台交易时间*/
    private String transTime;
    /** 还款金额*/
    private String repayAmt;
    /** 客户编号*/
    private String custNo;
    /** 银行编号*/
    private String bankNo;
    /** 银行卡号*/
    private String bankCardNo;
    /** 名称*/
    private String name;
    /** 手机号*/
    private String phone;
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
