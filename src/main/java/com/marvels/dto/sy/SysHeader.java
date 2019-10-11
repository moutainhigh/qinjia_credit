package com.marvels.dto.sy;

public class SysHeader {
	//（客户类型）：非必送；
	private String customerType;
	//（客户号）：非必送；
	private String customerId;
	//（平台ID）：非必送；
	private String EMP_SID;
	//交易代码）：接口交易码，必送；例如：CY001002
	private String currentBusinessCode;
	//必送，默认送JSON；
	private String responseFormat;
	//渠道号）：必送，需要线下分配给第三方
	private String channel;
	//（客户端上送的时间戳）：必送，时间戳（毫秒数1501468797911 (支持java,如果是其他语言，请提前沟通)）；
	private String reqTime;
	//交易流水号）：必送，"进单渠道(appOrigin)"+13位不可重复的数字+5位序列号，共20位；
	private String sequenceNo;
	
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getEMP_SID() {
		return EMP_SID;
	}
	public void setEMP_SID(String eMP_SID) {
		EMP_SID = eMP_SID;
	}
	public String getCurrentBusinessCode() {
		return currentBusinessCode;
	}
	public void setCurrentBusinessCode(String currentBusinessCode) {
		this.currentBusinessCode = currentBusinessCode;
	}
	public String getResponseFormat() {
		return responseFormat;
	}
	public void setResponseFormat(String responseFormat) {
		this.responseFormat = responseFormat;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getReqTime() {
		return reqTime;
	}
	public void setReqTime(String reqTime) {
		this.reqTime = reqTime;
	}
	public String getSequenceNo() {
		return sequenceNo;
	}
	public void setSequenceNo(String sequenceNo) {
		this.sequenceNo = sequenceNo;
	}
	
	
}
