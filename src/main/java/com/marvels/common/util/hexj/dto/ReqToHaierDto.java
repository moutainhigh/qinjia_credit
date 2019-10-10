package com.marvels.common.util.hexj.dto;

import com.marvels.common.util.PropertiesLoadUtil;

public class ReqToHaierDto {
	
	private String applyNo;
	
	private String tradeCode;
	
	private String channelNo = PropertiesLoadUtil.getPropertiesValue("xyqb.haier.channelno","forms-openapi.properties");
	
	private String data;
	
	public String getApplyNo() {
		return applyNo;
	}

	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}

	public String getTradeCode() {
		return tradeCode;
	}

	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}

	public void setChannelNo(String channelNo) {
		this.channelNo = channelNo;
	}

	public String getChannelNo() {
		return channelNo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
}
