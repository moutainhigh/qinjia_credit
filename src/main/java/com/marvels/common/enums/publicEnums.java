package com.marvels.common.enums;

public class publicEnums {
	/**
	 * 接口名称枚举
	 * @author Administrator
	 *
	 */
	 enum interfaceCodeEnum {
		ITF00012("ITF00012","获取申请编号"),
		SY00601("SY00601","贷款申请新增提交"),
		ITF000031("ITF000031","亲家消费贷款审批查询接口"),
		ITF00004("ITF00004","还款计划查询接口"),
		ITF00002("ITF00002","影像信息维护（增、改）"),
		ITF00007("ITF00007","放款申请"),
		ITF00014("ITF00014","CA认证盖章接口"),
		ITF00098("ITF00098","日终文件上传接口"),
		ITF00099("SY00601","日终文件下载接口"),
		ITF00008("ITF00008","提前结清金额查询"),
		SY00209("SY00209","提前结清申请提交实时接口");
		private String code;
	    private String desc;
	    private interfaceCodeEnum(String code, String desc) {
	        this.code = code;
	        this.desc = desc;
	    }
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
}