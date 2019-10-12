package com.marvels.dto.jf;

/**
 * 玖富-授信申请-请求对象
 * @author shiwubin
 *
 */
public class JfApplyQuotaReq {
	
	/**
	 * 商户号
	 */
	private String tenantCode;
	
	/**
	 * 产品ID
	 */
	private String productId;
	
	/**
	 * 身份证号
	 */
	private String certId;
	
	/**
	 * 商户用户号
	 */
	private String tenantUserId;
	
	/**
	 * 回调地址
	 */
	private String backUrl;

	public String getTenantCode() {
		return tenantCode;
	}

	public void setTenantCode(String tenantCode) {
		this.tenantCode = tenantCode;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getCertId() {
		return certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}

	public String getTenantUserId() {
		return tenantUserId;
	}

	public void setTenantUserId(String tenantUserId) {
		this.tenantUserId = tenantUserId;
	}

	public String getBackUrl() {
		return backUrl;
	}

	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}
}
