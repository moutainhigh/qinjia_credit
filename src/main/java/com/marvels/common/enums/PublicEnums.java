package com.marvels.common.enums;

/**
 * 公共枚举类
 * 
 * @author Administrator
 *
 */
public class PublicEnums {

	/**
	 * 盛银接口名称枚举
	 * 
	 * @author Administrator
	 *
	 */
	public enum SyInterfaceCodeEnum {
		/**
		 * 接口
		 */
		ITF00012("ITF00012", "获取申请编号"), SY00601("SY00601", "贷款申请新增提交"), ITF000031("ITF000031", "亲家消费贷款审批查询接口"),
		ITF00004("ITF00004", "还款计划查询接口"), ITF00002("ITF00002", "影像信息维护（增、改）"), ITF00007("ITF00007", "放款申请"),
		ITF00014("ITF00014", "CA认证盖章接口"), ITF00098("ITF00098", "日终文件上传接口"), ITF00099("SY00601", "日终文件下载接口"),
		ITF00008("ITF00008", "提前结清金额查询"), SY00209("SY00209", "提前结清申请提交实时接口");
		private String code;
		private String desc;

		SyInterfaceCodeEnum(String code, String desc) {
			this.code = code;
			this.desc = desc;
		}

		public String getCode() {
			return code;
		}

		public String getDesc() {
			return desc;
		}
	}

	/**
	 * 玖富接口名称枚举
	 * 
	 * @author Administrator
	 *
	 */
	public enum JfInterfaceCodeEnum {
		/**
		 * 接口
		 */
		JF5501("5501", "实名认证", "/cif/ocr/upload"), JF5503("5503", "人脸识别结果上传", "/cif/customerFace/faceRecogSave/v1"),
		JF5504("5504", "KYC信息提交", "/cif/CustomerKyc/saveCustomerKyc/v1"),
		JF5526("5526", "客户基本信息查询", "/cif/CustomerBaseInfo2Out/getCustomerBaseInfo/v1"),
		JF5527("5527", "根据身份证号码查询客户基本信息", "/cif/CustomerBaseInfo2Out/getCustomerBaseInfoByIdNo/v1"),
		JF5507("5507", "银行卡鉴权", "/cif/bankCard/authorize/v1"), JF5511("5511", "运营商授权", "/cif/operator/authorize/v1"),
		JF5514("5514", "信用卡授权", "/cif/creditCard/authorize/v1"), JF5518("5518", "绑卡列表查询", "/cif/bankCard/query/v1"),
		JF5519("5519", "授信项状态查询", "/cif/authorize/status/v1"), JF5524("5524", "商户接收授权结果", "/cif/authorize/callback/v1"),
		JF5528("5528", "交易换绑卡落库", "/cif/tradingCard/changeCardSave/v1"),JF700005("700005", "授信请求", "/credit/center/applyQuota/v2"),
		JF700006("700005", "授信结果查询", "/credit/center/query/result/v2");
		private String code;
		private String desc;
		private String uri;

		JfInterfaceCodeEnum(String code, String desc, String uri) {
			this.code = code;
			this.desc = desc;
			this.uri = uri;
		}

		public String getCode() {
			return code;
		}

		public String getDesc() {
			return desc;
		}
		
		public String getUri() {
			return uri;
		}
	}

}