package com.marvels.common.enums;

/**
 * LP40001通用风险接口中的type字段值
 * @author jason
 *
 */
public enum RiskInfoUploadTypeEnum {
	
	USED("used", "支用"),ED_APPLY("edApply","额度"),ED_EXAMINE("edExamine", "额度人工审批"),REPORT("report","报告阶段");
	
	private String type;
	private String desc;
	
	private RiskInfoUploadTypeEnum(String type, String desc) {
		this.type = type;
		this.desc = desc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
