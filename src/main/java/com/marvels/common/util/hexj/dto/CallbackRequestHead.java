package com.marvels.common.util.hexj.dto;

import com.marvels.common.annatation.Required;

public class CallbackRequestHead {

	@Required(desc = "交易码")
	private String tradeCode;
	@Required(desc = "报文流水号")
	private String serno;
	@Required(desc = "系统标识")
	private String sysFlag;
	@Required(desc = "交易类型")
	private String tradeType;
	@Required(desc = "交易日期（yyyy-MM-dd）")
	private String tradeDate;
	@Required(desc = "交易时间（HH:mm:ss）")
	private String tradeTime;
	/**
	 * 渠道编码
	 */
	private String channelNo;
	/**
	 * cooprCode
	 */
	private String cooprCode;

	public String getTradeCode() {
		return tradeCode;
	}

	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}

	public String getSerno() {
		return serno;
	}

	public void setSerno(String serno) {
		this.serno = serno;
	}

	public String getSysFlag() {
		return sysFlag;
	}

	public void setSysFlag(String sysFlag) {
		this.sysFlag = sysFlag;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}

	public String getChannelNo() {
		return channelNo;
	}

	public void setChannelNo(String channelNo) {
		this.channelNo = channelNo;
	}

	public String getCooprCode() {
		return cooprCode;
	}

	public void setCooprCode(String cooprCode) {
		this.cooprCode = cooprCode;
	}

}
