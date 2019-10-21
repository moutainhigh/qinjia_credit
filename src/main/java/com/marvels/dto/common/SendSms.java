package com.marvels.dto.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName SendSms
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/18 16:35
 * @Version 1.0
 **/
@Getter
@Setter
public class SendSms {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
    /**  id*/
    private String id;
    /**  请求id*/
    private String requestId;
    /**  状态码-返回OK代表请求成功,其他错误码详见错误码列表*/
    private String code;
    /**  状态码的描述*/
    private String message;
    /**  发送回执ID,可根据该ID查询具体的发送状态*/
    private String bizId;
    /**  电话号码*/
    private String phoneNumbers;
    /**  模板编号*/
    private String templateCode;
    /**  模板参数*/
    private String templateParam;
}
