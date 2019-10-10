package com.marvels.common.util.hexj.dto;

import java.util.List;

import com.marvels.common.annatation.Required;

/**
 * 
 * @author jason
 *
 */
public class CallbackRequestBodyProduct {

	@Required(desc = "贷款品种")
	private String typCde;
	/**
	 * 标识贷款品种顺序号
	 */
	private String typSeq;
	/**
	 * 单笔最小贷款金额
	 */
	private String minAmt;
	/**
	 * 单笔最大贷款金额
	 */
	private String maxAmt;
	/**
	 * 贷款期限
	 */
	private String tnrOpt;
	/**
	 * 最大天数
	 */
	private String tnrMaxDays;
	/**
	 * 还款方式代码
	 */
	private String mtdCde;
	/**
	 * 还款方式描述
	 */
	private String mtdDesc;
	/**
	 * 进件通路
	 */
	private String docChannel;
	/**
	 * 每期还款日
	 */
	private String dueDayOpt;
	/**
	 * 还款日
	 */
	private String dueDay;
	/**
	 * 还款间隔
	 */
	private String typFreq;
	/**
	 * 贷款类型
	 */
	private String typGrp;
	/**
	 * 还款方式代码
	 */
	private String mtdTypeCde;

	/**
	 * 利息,利率相关信息
	 */
	private List<CallbackRequestBodyProductRate> intRatList;

	public String getTypCde() {
		return typCde;
	}

	public void setTypCde(String typCde) {
		this.typCde = typCde;
	}

	public String getTypSeq() {
		return typSeq;
	}

	public void setTypSeq(String typSeq) {
		this.typSeq = typSeq;
	}

	public String getMinAmt() {
		return minAmt;
	}

	public void setMinAmt(String minAmt) {
		this.minAmt = minAmt;
	}

	public String getMaxAmt() {
		return maxAmt;
	}

	public void setMaxAmt(String maxAmt) {
		this.maxAmt = maxAmt;
	}

	public String getTnrOpt() {
		return tnrOpt;
	}

	public void setTnrOpt(String tnrOpt) {
		this.tnrOpt = tnrOpt;
	}

	public String getTnrMaxDays() {
		return tnrMaxDays;
	}

	public void setTnrMaxDays(String tnrMaxDays) {
		this.tnrMaxDays = tnrMaxDays;
	}

	public String getMtdCde() {
		return mtdCde;
	}

	public void setMtdCde(String mtdCde) {
		this.mtdCde = mtdCde;
	}

	public String getMtdDesc() {
		return mtdDesc;
	}

	public void setMtdDesc(String mtdDesc) {
		this.mtdDesc = mtdDesc;
	}

	public String getDocChannel() {
		return docChannel;
	}

	public void setDocChannel(String docChannel) {
		this.docChannel = docChannel;
	}

	public String getDueDayOpt() {
		return dueDayOpt;
	}

	public void setDueDayOpt(String dueDayOpt) {
		this.dueDayOpt = dueDayOpt;
	}

	public String getDueDay() {
		return dueDay;
	}

	public void setDueDay(String dueDay) {
		this.dueDay = dueDay;
	}

	public String getTypFreq() {
		return typFreq;
	}

	public void setTypFreq(String typFreq) {
		this.typFreq = typFreq;
	}

	public String getTypGrp() {
		return typGrp;
	}

	public void setTypGrp(String typGrp) {
		this.typGrp = typGrp;
	}

	public String getMtdTypeCde() {
		return mtdTypeCde;
	}

	public void setMtdTypeCde(String mtdTypeCde) {
		this.mtdTypeCde = mtdTypeCde;
	}

	public List<CallbackRequestBodyProductRate> getIntRatList() {
		return intRatList;
	}

	public void setIntRatList(List<CallbackRequestBodyProductRate> intRatList) {
		this.intRatList = intRatList;
	}

}
