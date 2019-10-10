package com.marvels.dto.hexj.request;

import java.io.Serializable;

import com.marvels.common.annatation.Required;
import com.marvels.dto.common.RequestBaseDto;

/**
 * 
　 * 标题: BankCardRouterAndQueryReq.java 
　 * 描述: 	【LP10001】签约路由+签约查询
　 * Copyright: 2019年7月30日 
　 * @author 李瑶 
　 * @date 2019年7月30日 
　 * @version 1.0
 */
public class BankCardRouterAndQueryReq  extends RequestBaseDto implements Serializable {

	/**
	*
	*/
	private static final long serialVersionUID = 1L;

	//系统跟踪号  参数是否必输--是 
	private String traceNo; 

	//银行卡号  参数是否必输--是 
	@Required(desc="银行卡号(cardNo)")
	private String cardNo; 

	//持卡人姓名  参数是否必输--是 
	@Required(desc="持卡人姓名(actName)")
	private String actName; 

	//后续交易大概金额  参数是否必输--否 
	private String amt;

	public String getTraceNo() {
		return traceNo;
	}

	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	@Override
	public String toString() {
		return "BankCardRouterAndQueryReq [traceNo=" + traceNo + ", cardNo=" + cardNo + ", actName=" + actName
				+ ", amt=" + amt + "]";
	} 
}
