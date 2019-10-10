package com.marvels.common.enums;

/**
 * 信用钱包接口编号和请求url枚举
 * @author lvgb
 *
 */
public enum XyqbCodeAndUrlEnum {

	LP10001("LP1000101","hrlp/credit/LP10001"),
	LP10008("ACQ-4001","hrlp/credit/LP10008"),
	LP10002("LP1000201","hrlp/credit/LP10002"),
	LP10003("LP1000301","hrlp/credit/LP10003"),
	LP10009("ACQ-4002","hrlp/credit/LP10009"),
	LP10010("ACQ-4003","hrlp/credit/LP10010"),
	LP10011(null,"hrlp/credit/LP10011"),
	LP10012("ACQ-4015","hrlp/credit/LP10012"),
	LP20002("100001","hrlp/loan/LP20002"),
	LP40001("LP4000101","hrlp/common/LP40001"),
	LP40002("LP4000201","hrlp/common/LP40002"),
	LP40007("LP4000701","hrlp/common/LP40007"),
	LP20001("100032","hrlp/loan/LP20001"),
	LP20003("100026","hrlp/loan/LP20003"),
	LP20005("ACQ-1146","hrlp/loan/LP20005"),
	LP30006("LP3000601","hrlp/repay/LP30006"),
	LP30015("LP3001501","hrlp/repay/LP30015"),
	LP30001("ACQ_100086","hrlp/repay/LP30001"),
	LP30002("ACQ-2101","hrlp/repay/LP30002"),
	LP30003("ACQ-2202","hrlp/repay/LP30003"),
	LP40003("LP4000301","hrlp/common/LP40003"),
	LP40011("LP4001101","hrlp/common/LP40011");


	String code;
	
	String url;

	private XyqbCodeAndUrlEnum(String code, String url) {
		this.code = code;
		this.url = url;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
