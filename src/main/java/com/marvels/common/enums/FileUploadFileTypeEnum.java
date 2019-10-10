package com.marvels.common.enums;

/**
 * LP40002文件上传接口中的文件类型字段值
 * @author jason
 *
 */
public enum FileUploadFileTypeEnum {
	
	DOC53("DOC53", "身份证正面"),
	DOC54("DOC54", "身份证反面"),
	DOC63("DOC63", "身份证头像"),
	DOC065("DOC065", "人脸照片"),
	DOC001("DOC001", "消费信贷服务协议"),
	DOC087("DOC087", "个人信息使用授权书"),
	DOC004("DOC004", "个人征信查询授权书"),
	DOC100("DOC100", "个人征信查询授权书（三方-联合放款）"),
	DOC005("DOC005", "企业征信查询授权书"),
	DOC012("DOC012", "个人消费贷款用途承诺书"),
	DOC089("DOC089", "融担协议"),
	DOC101("DOC101", "委托担保合同"),
	DOC006("DOC006", "个人借款合同"),
	DOC088("DOC088", "个人借款合同（联合贷）"),
	CADOC006("CADOC006", "个人借款合同(非联合)-代盖消金章"),
	CADOC088("CADOC088", "个人借款合同（联合贷）-代盖消金章"),
	DOC074("DOC074", "配偶身份证正面"),
	DOC075("DOC075", "配偶身份证反面"),
	DOC003("DOC003", "共同申请人身份证"),
	DOC007("DOC007", "工作证明"),
	DOC008("DOC008", "经营证明文件"),
	DOC009("DOC009", "收入证明"),
	DOC010("DOC010", "居住地证明"),
	DOC011("DOC011", "资产证明"),
	DOC013("DOC013", "办理现场照片"),
	DOC014("DOC014", "其他/用户隐私政策"),
	DOC016("DOC016", "营业执照"),
	DL("DL", "结果文件");
	
	private String type;
	private String desc;
	
	private FileUploadFileTypeEnum(String type, String desc) {
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
