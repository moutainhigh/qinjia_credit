package com.marvels.dto.jf;

import lombok.Getter;
import lombok.Setter;

/**
 * 2.1	 借据编号查询借据接口返回
 *
 * @author renyz
 * @date 2019年10月14日11:24:22
 */
@Getter
@Setter
public class JfGetIouRes {
    /**
     * 借据编号
     */
    private String iouId;

    /**
     * 工单编号
     */
    private String orderId;

    /**
     * 资产端商户编号
     */
    private String merchNo;

    /**
     * 资产端产品编号
     */
    private String assetProductId;

    /**
     * 客户编号
     */
    private String custNo;

    /**
     * 客户手机号
     */
    private String custPhone;

    /**
     * 资金机构编号
     */
    private String fundInstNo;

    /**
     * 资金机构贷款编号
     */
    private String fundProductId;

    /**
     * 保单编号
     */
    private String insureId;

    /**
     * 保险机构编号
     */
    private String insureCode;

    /**
     * 债权方
     */
    private String creditor;

    /**
     * 理赔状态
     */
    private String claimStatus;

    /**
     * 借款金额
     */
    private String loanAmt;

    /**
     * 还款开始时间
     */
    private String loanStartDate;

    /**
     * 还款结束时间
     */
    private String loanEndDate;

    /**
     * 合同编号
     */
    private String contractId;

    /**
     * 借据状态
     */
    private String iouStatus;

    /**
     * 是否逾过期
     */
    private String isOverdue;

    /**
     * 还款银行卡号
     */
    private String repayCardNo;

    /**
     * 结清时间
     */
    private String settleTime;

    /**
     * 结清方式
     */
    private String settleType;

    /**
     * 借款用途
     */
    private String loanUsage;

    /**
     * 放款时间
     */
    private String lendingTime;

    /**
     * 首次还款日
     */
    private String firstRepayDate;

    /**
     * 收款人
     */
    private String payee;

    /**
     * 贷款人
     */
    private String lender;

    /**
     * 主借据编号
     */
    private String mainIouId;

    /**
     * 辅借据编号
     */
    private String supportIouId;

    /**
     * 借款总期数
     */
    private String loanPerido;

    /**
     * 合同金额
     */
    private String contractAmt;

    /**
     * 还款银行编号
     */
    private String repayBankno;

    /**
     * 还款卡姓名
     */
    private String repayCardName;

    /**
     * 还款卡身份证号码
     */
    private String repayCardIdno;

    /**
     * 利率版本
     */
    private String rateVersion;


    /**
     * 放款银行编号
     */
    private String payeeBankNo;

    /**
     * 放款银行卡号
     */
    private String payeeCardNo;

    /**
     * 放款卡人或者 单位的名称
     */
    private String payeeCardName;

    /**
     * 放款卡手机号
     */
    private String payeePhonoe;

    /**
     * 逾期天数
     */
    private String exceeDay;
}
