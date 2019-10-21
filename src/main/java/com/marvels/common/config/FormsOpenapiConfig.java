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

    @Value("${sendSms.accessKeyId}")
    /** 短信发送accessKeyId*/
    private String sendSms_accessKeyId;

    /** 短信发送accessSecret*/
    @Value("${sendSms.accessSecret}")
    private String sendSms_accessSecret;

    /** 玖富接口前缀 */
    @Value("${qj.api.jf}")
    private String qj_api_jf;

    /** 下游系统编码 */
    @Value("${qj.hand.sysCode}")
    private String qj_hand_sysCode;

    /** 云集请求协议code*/
    @Value("${api.jf.yunji.httpHand.code}")
    private String yj_httpHand_code;

    /** 云集请求协议orgCode*/
    @Value("${api.jf.yunji.httpHand.orgCode}")
    private String yj_httpHand_orgCode;

    /** 云集请求协议secret*/
    @Value("${api.jf.yunji.httpHand.secret}")
    private String yj_httpHand_secret;

    /** 云集请求接口sysCode*/
    @Value("${api.jf.yunji.hand.sysCode}")
    private String yj_hand_sysCode;

    /** 吉荣请求协议code*/
    @Value("${api.jf.jirong.httpHand.code}")
    private String jr_httpHand_code;

    /** 吉荣请求协议orgCode*/
    @Value("${api.jf.jirong.httpHand.orgCode}")
    private String jr_httpHand_orgCode;

    /** 吉荣请求协议secret*/
    @Value("${api.jf.jirong.httpHand.secret}")
    private String jr_httpHand_secret;

    /** 吉荣请求接口sysCode*/
    @Value("${api.jf.jirong.hand.sysCode}")
    private String jr_hand_sysCode;

    /** 给米请求协议code*/
    @Value("${api.jf.jimi.httpHand.code}")
    private String jm_httpHand_code;

    /** 给米请求协议orgCode*/
    @Value("${api.jf.jimi.httpHand.orgCode}")
    private String jm_httpHand_orgCode;

    /** 给米请求协议secret*/
    @Value("${api.jf.jimi.httpHand.secret}")
    private String jm_httpHand_secret;

    /** 给米请求接口sysCode*/
    @Value("${api.jf.jimi.hand.sysCode}")
    private String jm_hand_sysCode;

}
