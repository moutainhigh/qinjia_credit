package com.marvels.common.util.hexj.dto;

import com.alibaba.fastjson.annotation.JSONField;

public class ReqToHaierMsg {
	
	 @JSONField(ordinal = 0)
	private Object head;
	 @JSONField(ordinal = 1)
	private Object body;
	
	public Object getHead() {
		return head;
	}
	public void setHead(Object head) {
		this.head = head;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
}
