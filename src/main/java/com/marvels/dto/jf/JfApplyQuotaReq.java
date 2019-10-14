package com.marvels.dto.jf;

/**
 * 玖富-授信申请-请求对象
 * @author shiwubin
 *
 */
public class JfApplyQuotaReq {
	
	/**
	 * 客户号
	 */
	private String customerId;
	
	/**
	 * 产品ID
	 */
	private String productId;
	
	/**
	 * 回调地址
	 */
	private String backUrl;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getBackUrl() {
		return backUrl;
	}

	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}
}
