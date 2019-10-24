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
		ITF00012("ITF00012", "获取申请编号", ""),
        SY00601("SY00601", "贷款申请新增提交", ""),
        ITF000031("ITF000031", "亲家消费贷款审批查询接口", ""),
		ITF00004("ITF00004", "还款计划查询接口", ""),
        ITF00002("ITF00002", "影像信息维护（增、改）", ""),
        ITF00007("ITF00007", "放款申请", ""),
		ITF00014("ITF00014", "CA认证盖章接口", ""),
        ITF00098("ITF00098", "日终文件上传接口", ""),
        ITF00099("SY00601", "日终文件下载接口", ""),
		ITF00008("ITF00008", "提前结清金额查询", ""),
        SY00209("SY00209", "提前结清申请提交实时接口", "");
		private String code;
		private String desc;
        private String uri;

		SyInterfaceCodeEnum(String code, String desc, String uri) {
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
		
		/**
		 * 下单业务
		 */
		JF100150("100150", "资金路由", "/fincloud/common.intf"),
		JF100151("100151", "借款试算", "/fincloud/common.intf"),
		JF100152("100152", "下单", "/fincloud/common.intf"),
		JF100153("100153", "资产端关单申请", "/fincloud/common.intf"),
		JF100154("100154", "工单信息查询", "/fincloud/common.intf"),
		JF100155("100155", "资产端关单结果查询", "/fincloud/common.intf"),
		JF100156("100156", "工单合同信息查询", "/fincloud/common.intf"),
		JF100157("100157", "放款结果通知-回调", ""),
		JF100158("100158", "关单结果通知-回调", ""),
        JF100189("100189", "工单信息查询接口", "/fincloud/common.intf"),
        JF100250("100250", "用户工单列表查询接口", "/fincloud/common.intf"),
		/**
		 * 支付业务接口
		 */
		JF100159("100159", "查询支持的银行列表", "/fincloud/common.intf"),
		JF100160("100160", "卡bin查询", "/fincloud/common.intf"),
		JF100161("100161", "签约申请", "/fincloud/common.intf"),
		JF100162("100162", "签约确认", "/fincloud/common.intf"),
		
		/**
		 * 客户&授权业务接口
		 */
		JF100163("100163", "实名认证", "/fincloud/common.intf"),
		JF100164("100164", "人脸识别结果上传", "/fincloud/common.intf"),
		JF100165("100165", "KYC信息提交", "/fincloud/common.intf"),
		JF100166("100166", "借记卡授权", "/fincloud/common.intf"),
		JF100167("100167", "运营商授权", "/fincloud/common.intf"),
		JF100168("100168", "信用卡授权", "/fincloud/common.intf"),
		JF100169("100169", "授信项状态查询", "/fincloud/common.intf"),
		JF100170("100170", "商户接收授权结果", "/fincloud/common.intf"),
		JF100171("100171", "授信请求", "/fincloud/common.intf"),
		JF100172("100172", "授信结果查询", "/fincloud/common.intf"),
		JF100173("100173", "商户授信结果信息接收-回调", ""),
		JF100183("100183", "风控设备指纹实时反欺诈-前置接口", ""),
		JF100184("100184", "额度查询-前置接口", ""),
		
		/**
		 * 还款业务接口
		 */
		JF100174("100174", "借据编号查询借据", "/fincloud/common.intf"),
		JF100175("100175", "还款计划查询", "/fincloud/common.intf"),
		JF100176("100176", "还款金额试算", "/fincloud/common.intf"),
		JF100177("100177", "主动还款", "/fincloud/common.intf"),
		JF100178("100178", "扣款结果查询", "/fincloud/common.intf"),
		JF100179("100179", "查询用户还款记录", "/fincloud/common.intf"),
		JF100180("100180", "扣款结果通知-回调", ""),
        S10001("S10001", "实时短信发送接口", "dysmsapi.aliyuncs.com");
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