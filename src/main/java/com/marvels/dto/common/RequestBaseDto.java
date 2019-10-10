package com.marvels.dto.common;

public class RequestBaseDto{
	
	protected String ykgTraceNo;//请求编号,只用于日志跟踪,不参与签名

	public String getYkgTraceNo() {
		return ykgTraceNo;
	}

	public void setYkgTraceNo(String ykgTraceNo) {
		this.ykgTraceNo = ykgTraceNo;
	}
	
}
