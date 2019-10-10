package com.marvels.common.util.hexj.dto;

/**
 * 消金回调消息结构 <br>
 * <pre>
{
	"head": {
		"retFlag": "00000",
		"retMsg": "处理成功"
	},
	"body": {
		"applSeq":”12345678”
	}
}
 * </pre>
 * @author jason
 *
 */
public class CallbackResponse {

	private CallbackResponseHead head;
	private CallbackResponseBody body;

	public CallbackResponseHead getHead() {
		return head;
	}

	public void setHead(CallbackResponseHead head) {
		this.head = head;
	}

	public CallbackResponseBody getBody() {
		return body;
	}

	public void setBody(CallbackResponseBody body) {
		this.body = body;
	}

}
