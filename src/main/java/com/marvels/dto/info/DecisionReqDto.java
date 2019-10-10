package com.marvels.dto.info;

import java.io.Serializable;

public class DecisionReqDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idNo;
	private String custName;
	private String mobile;
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
}
