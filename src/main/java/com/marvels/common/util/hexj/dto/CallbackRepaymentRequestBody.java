package com.marvels.common.util.hexj.dto;

import com.marvels.common.annatation.Required;

/**
 * LP30005 主动还款 回调消息结构body部分
 * @author jason
 *
 */
public class CallbackRepaymentRequestBody {
	
	/**
	 * 04-主动还款推送
	 */
	@Required(desc="消息类型")
	private String msgTyp;
	@Required(desc="客户编号")
	private String custNo;
	@Required(desc="还款主键")
	private String repaySeq;
	@Required(desc="贷款申请流水号")
	private String applSeq;
	@Required(desc="借据号")
	private String loanNo;
	@Required(desc="历史请求参数的serno")
	private String serno;
	/**
	 * 优惠券类型 1：固定天数 2：固定金额 3：折扣券
	 */
	private String coupKind;
	/**
	 * 应支付金额
	 */
	private String realPayAmt;
	@Required(desc="还款卡号")
	private String acCardNo;
	/**
	 * FS（全部还款） NM（归还欠款）ER（提前还款）
	 */
	@Required(desc="还款类型")
	private String setlMode;
	/**
	 * 优惠券号
	 */
	private String coupNo;
	/**
	 * 是否使用优惠券 Y：使用 N：不使用
	 */
	private String useCoup;
	/**
	 * 优惠券减免金额
	 */
	private String coupUseAmt;
	/**
	 * 贷款品种代码
	 */
	private String loanTyp;
	/**
	 * 优惠券面值
	 */
	private String coupValue;
	@Required(desc="还款期号")
	private String psPerdNo;
	/**
	 * 还款状态 01：还款处理中 02：还款成功 03：还款失败
	 */
	@Required(desc="还款状态")
	private String setlSts;
	@Required(desc="交易日期")
	private String tradeDt;
	/**
	 * 贷款品种还款方式 SYS001：随借随还  其他值：其他
	 */
	private String mtdCde;
	@Required(desc="还款金额")
	private String repayAmt;
	@Required(desc="还款方式")
	private String setlTyp;
	/**
	 * 还款失败原因
	 */
	private String failReason;
	/**
	 * 贷款品种流水号
	 */
	private String typSeq;
	/**
	 * 总期数
	 */
	private String apprvTnr;
	@Required(desc="创建（申请）时间")
	private String crtDt;
	/**
	 * 支付流水号
	 */
	private String payNo;
	/**
	 * 是否需要支付流水号 Y：是  N或空：否
	 */
	private String isNeedPayNo;
	@Required(desc="更新时间")
	private String updDt;
	/**
	 * 映射后的错误码
	 * REPE001  系统异常
REPE002  还款信息有误
REPE003  非营业时间
REPE004  传输字段信息不正确
REPE005  已还款,不允许重复还款
REPE006  其他原因
REPE026	余额不足
REPE025	通信异常
REPE024	重复交易
REPE023	密码错误次数超限
REPE022	银行维护中
REPE021	渠道不支持
REPE020	余额不足次数超限
REPE019	超用户设置交易金额限制
REPE018	单卡超过年度累计交易金额上限
REPE017	用户预留信息变更，请重新绑卡
REPE016	银行卡信息异常
REPE015	用户银行卡状态异常
REPE014	需开通相关业务
REPE013	单卡超银行交易笔数限制
REPE012	单卡超过单日累计交易金额上限
REPE011	交易金额超限
REPE010	用户未签约
REPE009	属于渠道路由未配置的问题
REPE008	渠道系统异常
REPE007	渠道不支持该银行卡扣款
	 */
	private String refFlag;
	/**
	 * 映射后的错误原因
	 * REPE001  系统异常
REPE002  还款信息有误
REPE003  非营业时间
REPE004  传输字段信息不正确
REPE005  已还款,不允许重复还款
REPE006  其他原因
REPE026	余额不足
REPE025	通信异常
REPE024	重复交易
REPE023	密码错误次数超限
REPE022	银行维护中
REPE021	渠道不支持
REPE020	余额不足次数超限
REPE019	超用户设置交易金额限制
REPE018	单卡超过年度累计交易金额上限
REPE017	用户预留信息变更，请重新绑卡
REPE016	银行卡信息异常
REPE015	用户银行卡状态异常
REPE014	需开通相关业务
REPE013	单卡超银行交易笔数限制
REPE012	单卡超过单日累计交易金额上限
REPE011	交易金额超限
REPE010	用户未签约
REPE009	属于渠道路由未配置的问题
REPE008	渠道系统异常
REPE007	渠道不支持该银行卡扣款

	 */
	private String refMsg;
	public String getCustNo() {
		return custNo;
	}
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	public String getRepaySeq() {
		return repaySeq;
	}
	public void setRepaySeq(String repaySeq) {
		this.repaySeq = repaySeq;
	}
	public String getApplSeq() {
		return applSeq;
	}
	public void setApplSeq(String applSeq) {
		this.applSeq = applSeq;
	}
	public String getLoanNo() {
		return loanNo;
	}
	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}
	public String getSerno() {
		return serno;
	}
	public void setSerno(String serno) {
		this.serno = serno;
	}
	public String getCoupKind() {
		return coupKind;
	}
	public void setCoupKind(String coupKind) {
		this.coupKind = coupKind;
	}
	public String getRealPayAmt() {
		return realPayAmt;
	}
	public void setRealPayAmt(String realPayAmt) {
		this.realPayAmt = realPayAmt;
	}
	public String getAcCardNo() {
		return acCardNo;
	}
	public void setAcCardNo(String acCardNo) {
		this.acCardNo = acCardNo;
	}
	public String getSetlMode() {
		return setlMode;
	}
	public void setSetlMode(String setlMode) {
		this.setlMode = setlMode;
	}
	public String getCoupNo() {
		return coupNo;
	}
	public void setCoupNo(String coupNo) {
		this.coupNo = coupNo;
	}
	public String getUseCoup() {
		return useCoup;
	}
	public void setUseCoup(String useCoup) {
		this.useCoup = useCoup;
	}
	public String getCoupUseAmt() {
		return coupUseAmt;
	}
	public void setCoupUseAmt(String coupUseAmt) {
		this.coupUseAmt = coupUseAmt;
	}
	public String getLoanTyp() {
		return loanTyp;
	}
	public void setLoanTyp(String loanTyp) {
		this.loanTyp = loanTyp;
	}
	public String getCoupValue() {
		return coupValue;
	}
	public void setCoupValue(String coupValue) {
		this.coupValue = coupValue;
	}
	public String getPsPerdNo() {
		return psPerdNo;
	}
	public void setPsPerdNo(String psPerdNo) {
		this.psPerdNo = psPerdNo;
	}
	public String getSetlSts() {
		return setlSts;
	}
	public void setSetlSts(String setlSts) {
		this.setlSts = setlSts;
	}
	public String getTradeDt() {
		return tradeDt;
	}
	public void setTradeDt(String tradeDt) {
		this.tradeDt = tradeDt;
	}
	public String getMtdCde() {
		return mtdCde;
	}
	public void setMtdCde(String mtdCde) {
		this.mtdCde = mtdCde;
	}
	public String getRepayAmt() {
		return repayAmt;
	}
	public void setRepayAmt(String repayAmt) {
		this.repayAmt = repayAmt;
	}
	public String getSetlTyp() {
		return setlTyp;
	}
	public void setSetlTyp(String setlTyp) {
		this.setlTyp = setlTyp;
	}
	public String getFailReason() {
		return failReason;
	}
	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}
	public String getTypSeq() {
		return typSeq;
	}
	public void setTypSeq(String typSeq) {
		this.typSeq = typSeq;
	}
	public String getApprvTnr() {
		return apprvTnr;
	}
	public void setApprvTnr(String apprvTnr) {
		this.apprvTnr = apprvTnr;
	}
	public String getCrtDt() {
		return crtDt;
	}
	public void setCrtDt(String crtDt) {
		this.crtDt = crtDt;
	}
	public String getPayNo() {
		return payNo;
	}
	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}
	public String getIsNeedPayNo() {
		return isNeedPayNo;
	}
	public void setIsNeedPayNo(String isNeedPayNo) {
		this.isNeedPayNo = isNeedPayNo;
	}
	public String getUpdDt() {
		return updDt;
	}
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	public String getMsgTyp() {
		return msgTyp;
	}
	public void setMsgTyp(String msgTyp) {
		this.msgTyp = msgTyp;
	}
	public String getRefFlag() {
		return refFlag;
	}
	public void setRefFlag(String refFlag) {
		this.refFlag = refFlag;
	}
	public String getRefMsg() {
		return refMsg;
	}
	public void setRefMsg(String refMsg) {
		this.refMsg = refMsg;
	}
	
}
