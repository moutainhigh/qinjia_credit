package com.marvels.common.util.hexj.dto;

import java.util.List;

import com.marvels.common.annatation.Required;

/**
 * 
 * @author jason
 *
 */
public class CallbackRequestBody {

	/**
	 * 额度申请返回的applSeq
	 */
	@Required(desc="申请编号")
	private String applSeq;
	@Required(desc = "渠道编号")
	private String channelNo;
	/**
	 * 见额度审批状态枚举
	 */
	@Required(desc = "审批状态")
	private String outSts;
	/**
	 * 审批描述: 若失败，有失败原因，若成功为空。
	 */
	private String message;
	/**
	 * 推送类型 01: 贷款审批消息推送 02: 额度审批消息推送
	 */
	@Required(desc = "推送类型")
	private String msgTyp;
	@Required(desc = "身份证号")
	private String idNo;

	/**
	 * 产品信息
	 */
	private List<CallbackRequestBodyProduct> productInfo;

	public String getApplSeq() {
		return applSeq;
	}

	public void setApplSeq(String applSeq) {
		this.applSeq = applSeq;
	}

	public String getChannelNo() {
		return channelNo;
	}

	public void setChannelNo(String channelNo) {
		this.channelNo = channelNo;
	}

	public String getOutSts() {
		return outSts;
	}

	public void setOutSts(String outSts) {
		this.outSts = outSts;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMsgTyp() {
		return msgTyp;
	}

	public void setMsgTyp(String msgTyp) {
		this.msgTyp = msgTyp;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public List<CallbackRequestBodyProduct> getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(List<CallbackRequestBodyProduct> productInfo) {
		this.productInfo = productInfo;
	}


}
