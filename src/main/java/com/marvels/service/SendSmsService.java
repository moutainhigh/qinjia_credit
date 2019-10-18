package com.marvels.service;

/**
 * @ClassName SendSmsService
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/17 16:52
 * @Version 1.0
 **/
public interface SendSmsService {
    /**
     * 发送短信服务
     * @param phoneNumbers
     * @param TemplateCode
     * @param TemplateParam
     * @return
     */
    Object SendSms(String phoneNumbers, String TemplateCode, String TemplateParam) throws Exception;
}
