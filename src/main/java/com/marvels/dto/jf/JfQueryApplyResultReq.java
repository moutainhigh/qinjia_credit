package com.marvels.dto.jf;

/**
 * 玖富-授信结果查询-请求对象
 * @author shiwubin
 *
 */
public class JfQueryApplyResultReq {

	/**
	 * 授信请求流水号
	 */
	private String flowId;
	
	/**
	 * 客户号
	 */
	private String customerId;

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
}
