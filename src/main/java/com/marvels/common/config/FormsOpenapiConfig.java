package com.marvels.common.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ClassName FormsOpenapiProperties
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/17 17:34
 * @Version 1.0
 **/
@Getter
@Component
@PropertySource("forms-openapi.properties")
public class FormsOpenapiConfig {
    /** 玖富请求协议code*/
    @Value("${qj.jiufu.httpHand.code}")
    private String httpHand_code;

    /** 玖富请求协议orgCode*/
    @Value("${qj.jiufu.httpHand.orgCode}")
    private String httpHand_orgCode;

    /** 玖富请求协议secret*/
    @Value("${qj.jiufu.httpHand.secret}")
    private String httpHand_secret;

    /** 玖富请求接口sysCode*/
    @Value("${qj.jiufu.hand.sysCode}")
    private String hand_sysCode;

    /** 玖富请求接口uri地址*/
    @Value("${qj.main.request.uri}")
    private String request_uri;

    /** 短信发送url*/
    @Value("${sendSms.url}")
    private String sendSms_url;

    /** 短信发送版本*/
    @Value("${sendSms.version}")
    private String sendSms_version;

    /** 短信发送签名*/
    @Value("${sendSms.signName}")
    private String sendSms_signName;

    /** 玖富接口前缀 */
    @Value("${qj.api.jf}")
    private String qj_api_jf;

}
