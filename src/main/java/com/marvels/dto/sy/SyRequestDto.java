package com.marvels.dto.sy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SyRequestDto {
	//报文头
	private SysHeader sysheader;
	//报文头
	private AppHeader appheader;
	//报文体
	private Object reqdata;

    /**
     * 参数请求头
     */
	@Setter
    @Getter
    public static class SysHeader {
        //（客户类型）：非必送；
        private String customerType;
        //（客户号）：非必送；
        private String customerId;
        //（平台ID）：非必送；
        private String EMP_SID;
        //交易代码）：接口交易码，必送；例如：CY001002
        private String currentBusinessCode;
        //必送，默认送JSON；
        private String responseFormat;
        //渠道号）：必送，需要线下分配给第三方
        private String channel;
        //（客户端上送的时间戳）：必送，时间戳（毫秒数1501468797911 (支持java,如果是其他语言，请提前沟通)）；
        private String reqTime;
        //交易流水号）：必送，"进单渠道(appOrigin)"+13位不可重复的数字+5位序列号，共20位；
        private String sequenceNo;
    }

        /**
         * 接口请求公共参数     */
        @Getter
        @Setter
        public static class AppHeader {
            private String security;
            private String tokenCode;
            private String challengeCode;
            private String mobileCode;
            private String signData;
            private String deviceSN;
            private String originData;

        }
}
