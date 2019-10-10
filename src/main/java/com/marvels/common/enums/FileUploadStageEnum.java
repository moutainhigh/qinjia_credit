package com.marvels.common.enums;
/**
 * LP40002文件上传接口中的上送阶段枚举值
 * @author jason
 *
 */
public enum FileUploadStageEnum {
	
	ED("额度阶段","额度阶段"),
	ZY("支用阶段","支用阶段"),
	ED_PRE("额度预审批","额度预审批"),
	ZY_PRE("支用预审批","支用预审批");
	
	private String stage;
	private String desc;
	
	private FileUploadStageEnum(String stage, String desc) {
		this.stage = stage;
		this.desc = desc;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

}
