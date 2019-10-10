package com.marvels.common.util.hexj.dto;

/**
 * 接受回调内容的消息结构
 * @author jason
 *
 */
public class CallbackRequest {

	private CallbackRequestHead head;
	private CallbackRequestBody body;

	public CallbackRequestHead getHead() {
		return head;
	}

	public void setHead(CallbackRequestHead head) {
		this.head = head;
	}

	public CallbackRequestBody getBody() {
		return body;
	}

	public void setBody(CallbackRequestBody body) {
		this.body = body;
	}

}
