package com.marvels.common.util.chuangjin.util;

import java.io.Serializable;

/**
 * 创金调云科谷的请求dto
 * @author Administrator
 *
 */
public class CJRequestDto  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String channelId;//云科谷分配给创金的唯一标识，如'chuangjin'
	
	private String requestNo;//请求编号,只用于日志跟踪,不参与签名
	
	private String sign;//签名
	
	private long timestamp;//时间戳

	private String request;//请求参数
	
	private String productId;//产品id(没有特别说明，可不填)

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
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

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "RongshuRequestDto [channelId=" + channelId + ", sign=" + sign 
				+ ", timestamp=" + timestamp+ ", productId=" + productId
				+ ", request=" + request + "]";
	}
	
	
	
}
