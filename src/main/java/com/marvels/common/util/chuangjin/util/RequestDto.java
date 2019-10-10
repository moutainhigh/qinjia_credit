package com.marvels.common.util.chuangjin.util;

import java.io.Serializable;
import java.util.Date;

/**
 * 云科贷调榕树的请求参数
 * @author Administrator
 *
 */
public class RequestDto  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer appId;//榕树分配给云科贷的机构编码
	
	private String sign;//签名
	
	private long timestamp;//时间戳
	
	private String request;//请求参数
	
	public RequestDto() {}
	
	public RequestDto(Integer appId, String request) {
		super();
		this.appId = appId;
		this.timestamp = new Date().getTime();
		this.request = request;
	}

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	@Override
	public String toString() {
		return "RequestDto [appId=" + appId + ", sign=" + sign + ", timestamp=" + timestamp + ", request=" + request
				+ "]";
	}
	
	
}
