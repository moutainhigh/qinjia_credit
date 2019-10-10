package com.marvels.common.util.hexj.dto;

/**
 * LP30005 回调接受消息结构
 * @author jason
 *
 */
public class CallbackRepaymentRequest {
	
	private CallbackRequestHead head;
	private CallbackRepaymentRequestBody body;
	public CallbackRequestHead getHead() {
		return head;
	}
	public void setHead(CallbackRequestHead head) {
		this.head = head;
	}
	public CallbackRepaymentRequestBody getBody() {
		return body;
	}
	public void setBody(CallbackRepaymentRequestBody body) {
		this.body = body;
	}

}
