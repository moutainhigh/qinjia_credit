package com.marvels.common.util.hexj.dto;

import java.util.List;

/**
 * 
 * @author jason
 *
 */
public class CallbackRequestBodyProductRate {
	
	/**
	 * 收取方式
	 */
	private String comDesc;
	/**
	 * 费用描述
	 */
	private String feeDesc;
	/**
	 * 费用按期限收取类型,通用类型：
	 */
	private String feeTnrTyp;
	
	private String intRatMonth;
	/**
	 * 客户利率
	 */
	private String intRat;
	/**
	 * 贷款品种代码
	 */
	private String typCde;
	/**
	 * 费用比例
	 */
	private String feePct;
	/**
	 * 版本号
	 */
	private String typVer;
	/**
	 * 贷款品种状态
	 */
	private String typSts;
	/**
	 * 贷款品种描述
	 */
	private String typDesc;
	/**
	 * 标识贷款品种顺序号
	 */
	private String typSeq;
	/**
	 * 期限设定
	 */
	private String tnrOpt;
	
	/**
	 * 增值服务列表
	 */
	private List<CallbackRequestBodyProductRateResult> resultList;

	public String getComDesc() {
		return comDesc;
	}

	public void setComDesc(String comDesc) {
		this.comDesc = comDesc;
	}

	public String getFeeDesc() {
		return feeDesc;
	}

	public void setFeeDesc(String feeDesc) {
		this.feeDesc = feeDesc;
	}

	public String getFeeTnrTyp() {
		return feeTnrTyp;
	}

	public void setFeeTnrTyp(String feeTnrTyp) {
		this.feeTnrTyp = feeTnrTyp;
	}

	public String getIntRat() {
		return intRat;
	}

	public void setIntRat(String intRat) {
		this.intRat = intRat;
	}

	public String getTypCde() {
		return typCde;
	}

	public void setTypCde(String typCde) {
		this.typCde = typCde;
	}

	public String getFeePct() {
		return feePct;
	}

	public void setFeePct(String feePct) {
		this.feePct = feePct;
	}

	public String getTypVer() {
		return typVer;
	}

	public void setTypVer(String typVer) {
		this.typVer = typVer;
	}

	public String getTypSts() {
		return typSts;
	}

	public void setTypSts(String typSts) {
		this.typSts = typSts;
	}

	public String getTypDesc() {
		return typDesc;
	}

	public void setTypDesc(String typDesc) {
		this.typDesc = typDesc;
	}

	public String getTypSeq() {
		return typSeq;
	}

	public void setTypSeq(String typSeq) {
		this.typSeq = typSeq;
	}

	public String getTnrOpt() {
		return tnrOpt;
	}

	public void setTnrOpt(String tnrOpt) {
		this.tnrOpt = tnrOpt;
	}

	public List<CallbackRequestBodyProductRateResult> getResultList() {
		return resultList;
	}

	public void setResultList(List<CallbackRequestBodyProductRateResult> resultList) {
		this.resultList = resultList;
	}

	public String getIntRatMonth() {
		return intRatMonth;
	}

	public void setIntRatMonth(String intRatMonth) {
		this.intRatMonth = intRatMonth;
	} 
	
}
