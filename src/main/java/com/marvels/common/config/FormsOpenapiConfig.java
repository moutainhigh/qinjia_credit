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
    /** 玖富请求接口uri地址*/
    @Value("${qj.main.request.uri}")
    private String request_uri;

    /** 玖富接口前缀 */
    @Value("${qj.api.jf}")
    private String qj_api_jf;

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

    /** 云集请求协议code*/
    @Value("${yunji.api.httpHand.code}")
    private String yj_httpHand_code;

    /** 云集请求协议orgCode*/
    @Value("${yunji.api.httpHand.orgCode}")
    private String yj_httpHand_orgCode;

    /** 云集请求协议secret*/
    @Value("${yunji.api.httpHand.secret}")
    private String yj_httpHand_secret;

    /** 云集请求接口sysCode*/
    @Value("${yunji.api.hand.sysCode}")
    private String yj_hand_sysCode;

    /** 云集接口回调地址*/
    @Value("${yunji.callBack.url}")
    private String yj_callBack_url;

    /** 吉荣请求协议code*/
    @Value("${jirong.api.httpHand.code}")
    private String jr_httpHand_code;

    /** 吉荣请求协议orgCode*/
    @Value("${jirong.api.httpHand.orgCode}")
    private String jr_httpHand_orgCode;

    /** 吉荣请求协议secret*/
    @Value("${jirong.api.httpHand.secret}")
    private String jr_httpHand_secret;

    /** 吉荣请求接口sysCode*/
    @Value("${jirong.api.hand.sysCode}")
    private String jr_hand_sysCode;

    /** 吉荣接口回调地址*/
    @Value("${jirong.callBack.url}")
    private String jr_callBack_url;

    /** 给米请求协议code*/
    @Value("${jimi.api.httpHand.code}")
    private String jm_httpHand_code;

    /** 给米请求协议orgCode*/
    @Value("${jimi.api.httpHand.orgCode}")
    private String jm_httpHand_orgCode;

    /** 给米请求协议secret*/
    @Value("${jimi.api.httpHand.secret}")
    private String jm_httpHand_secret;

    /** 给米请求接口sysCode*/
    @Value("${jimi.api.hand.sysCode}")
    private String jm_hand_sysCode;

    /** 给米接口回调地址*/
    @Value("${jimi.callBack.url}")
    private String jm_callBack_url;

    /** 短信发送url*/
    @Value("${sendSms.url}")
    private String sendSms_url;

    /** 短信发送版本*/
    @Value("${sendSms.version}")
    private String sendSms_version;

    /** 短信发送签名*/
    @Value("${sendSms.signName}")
    private String sendSms_signName;

    @Value("${sendSms.accessKeyId}")
    /** 短信发送accessKeyId*/
    private String sendSms_accessKeyId;

    /** 短信发送accessSecret*/
    @Value("${sendSms.accessSecret}")
    private String sendSms_accessSecret;

}
