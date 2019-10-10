package com.marvels.dto.hexj.response;

import com.alibaba.fastjson.annotation.JSONField;

public class ReqToHaierResultDto {
	
	private String serno;
	private String returnCode;
	private String returnMsg;
	private String body;
	
	public ReqToHaierResultDto() {}
	
	public ReqToHaierResultDto(String returnCode,String returnMsg,String body) {
		this.returnCode = returnCode;
		this.returnMsg = returnMsg;
		this.body = body;
	}
	
	public ReqToHaierResultDto(String returnCode,String returnMsg) {
		this.returnCode = returnCode;
		this.returnMsg = returnMsg;
	}
	
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getReturnMsg() {
		return returnMsg;
	}
	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

	public String getSerno() {
		return serno;
	}

	public void setSerno(String serno) {
		this.serno = serno;
	}

	@Override
	public String toString() {
		return "ReqToHaierResultDto [serno=" + serno + ", returnCode=" + returnCode + ", returnMsg=" + returnMsg
				+ ", body=" + body + "]";
	}
	
}
