package com.marvels.common.util.hexj.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.marvels.common.util.PropertiesLoadUtil;
import com.marvels.common.util.hexj.utils.ReqNoUtil;

public class ReqToHaierHeader {
	@JSONField(ordinal = 0)
	private String serno;
	@JSONField(ordinal = 1)
	private String tradeCode;
	@JSONField(ordinal = 2)
	private String sysFlag;
	@JSONField(ordinal = 3)
	private String tradeDate;
	@JSONField(ordinal = 4)
	private String tradeTime;
	@JSONField(ordinal = 5)
	private String channelNo;
	@JSONField(ordinal = 6)
	private String cooprCode;
	@JSONField(ordinal = 6)
	private String applCde;

	public ReqToHaierHeader(){}
	
	public ReqToHaierHeader(String tradeCode){
		this.tradeCode = tradeCode;
		this.channelNo = PropertiesLoadUtil.getPropertiesValue("xyqb.haier.channelno","forms-openapi.properties");
		this.serno = ReqNoUtil.generateSerno();
		this.sysFlag = "11";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = format.format(new Date());
		this.tradeDate = dateStr.substring(0, 10);
		this.tradeTime = dateStr.substring(11);
		this.cooprCode = "";
	}
	
	public String getSerno() {
		return serno;
	}
	public void setSerno(String serno) {
		this.serno = serno;
	}
	public String getTradeCode() {
		return tradeCode;
	}
	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}
	public String getSysFlag() {
		return sysFlag;
	}
	public void setSysFlag(String sysFlag) {
		this.sysFlag = sysFlag;
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
