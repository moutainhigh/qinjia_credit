package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @ClassName JfRepayResultReq
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/15 14:07
 * @Version 1.0
 **/
@Getter
@Setter
public class JfRepayResultReq {
    /** 商户编号*/
    private String merchNo;
    /** 平台流水号*/
    private String transNo;
    /** 工单*/
    private List<JfRepayResultReqOrderNos> orderNos;
    /** 客户编号*/
    private String custNo;
    /** 平台交易时间*/
    private String transTime;
    /** 还款类型*/
    private String repayType;
    /** 商户端流水号*/
    private String merchTransNo;
    /** 资产端产品编号*/
    private String assetProductId;
    /** 交易金额*/
    private String transAmt;
    /** 状态*/
    private String status;
    /** 还款发起方*/
    private String repayMode;
    /** 失败原因*/
    private String errorMsg;
    /** 交易成功金额*/
    private String successAmt;
    /** 使用账户金额*/
    private String useAccAmt;
}
