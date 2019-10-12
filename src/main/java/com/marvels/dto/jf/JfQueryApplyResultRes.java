package com.marvels.dto.jf;

/**
 * 玖富-授信结果查询-响应对象
 * @author shiwubin
 *
 */
public class JfQueryApplyResultRes {
	
	/**
	 * 流水号
	 */
	private String flowId;
	
	/**
	 * 客户号
	 */
	private String customerId;
	
	/**
	 * 授信状态
	 */
	private String creditStatus;
	
	/**
	 * 额度
	 */
	private String creditQuota;
	
	/**
	 * 报错信息
	 */
	private String errorMessage;

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCreditStatus() {
		return creditStatus;
	}

	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}

	public String getCreditQuota() {
		return creditQuota;
	}

	public void setCreditQuota(String creditQuota) {
		this.creditQuota = creditQuota;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
