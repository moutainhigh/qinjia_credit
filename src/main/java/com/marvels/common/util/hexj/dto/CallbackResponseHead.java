package com.marvels.common.util.hexj.dto;

/**
 * 
 * @author jason
 *
 */
public class CallbackResponseHead {

	/**
	 * 返回标志:成功：00000,其他均为失败
	 */
	private String retFlag;
	/**
	 * 返回消息
	 */
	private String retMsg;
	
	public CallbackResponseHead() {}
	
	public CallbackResponseHead(String retFlag) {
		this.retFlag = retFlag;
	}

	public String getRetFlag() {
		return retFlag;
	}

	public void setRetFlag(String retFlag) {
		this.retFlag = retFlag;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

}
