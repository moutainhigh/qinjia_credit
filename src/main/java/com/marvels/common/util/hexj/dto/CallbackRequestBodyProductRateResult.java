package com.marvels.common.util.hexj.dto;

/**
 * 
 * @author jason
 *
 */
public class CallbackRequestBodyProductRateResult {

	/**
	 * 增值服务集编号
	 */
	private String valueaddCde;
	/**
	 * 基础产品编号
	 */
	private String typCde;
	/**
	 * 基础产品名称
	 */
	private String typDesc;
	/**
	 * 增值服务产品编号
	 */
	private String loanTypCde;
	/**
	 * 增值服务产品名称
	 */
	private String loanName;
	/**
	 * 增值服务名称
	 */
	private String serviceName;
	/**
	 * 增值服务描述
	 */
	private String serviceDesc;
	/**
	 * 价格描述
	 */
	private String priceDesc;
	/**
	 * 是否默认
	 */
	private String valueaddInd;

	public String getValueaddCde() {
		return valueaddCde;
	}

	public void setValueaddCde(String valueaddCde) {
		this.valueaddCde = valueaddCde;
	}

	public String getTypCde() {
		return typCde;
	}

	public void setTypCde(String typCde) {
		this.typCde = typCde;
	}

	public String getTypDesc() {
		return typDesc;
	}

	public void setTypDesc(String typDesc) {
		this.typDesc = typDesc;
	}

	public String getLoanTypCde() {
		return loanTypCde;
	}

	public void setLoanTypCde(String loanTypCde) {
		this.loanTypCde = loanTypCde;
	}

	public String getLoanName() {
		return loanName;
	}

	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceDesc() {
		return serviceDesc;
	}

	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}

	public String getPriceDesc() {
		return priceDesc;
	}

	public void setPriceDesc(String priceDesc) {
		this.priceDesc = priceDesc;
	}

	public String getValueaddInd() {
		return valueaddInd;
	}

	public void setValueaddInd(String valueaddInd) {
		this.valueaddInd = valueaddInd;
	}

}
