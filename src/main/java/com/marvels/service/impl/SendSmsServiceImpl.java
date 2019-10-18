package com.marvels.service.impl;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.marvels.common.config.FormsOpenapiConfig;
import com.marvels.service.SendSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SendSmsServiceImpl
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/17 16:54
 * @Version 1.0
 **/
@Service("sendSmsService")
public class SendSmsServiceImpl implements SendSmsService {
    @Autowired
    private FormsOpenapiConfig formsOpenapiConfig;

    private static IAcsClient client;

    static  {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<accessKeyId>", "<accessSecret>");
        client = new DefaultAcsClient(profile);
    }
    /**
     * 发送短信服务
     *  @param phoneNumbers
     * @param TemplateCode
     * @param TemplateParam
     * @return
     */
    @Override
    public CommonResponse SendSms(String phoneNumbers, String TemplateCode, String TemplateParam) throws Exception {

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain(formsOpenapiConfig.getSendSms_url());
        request.setVersion(formsOpenapiConfig.getSendSms_version());
        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers",phoneNumbers);
        request.putQueryParameter("SignName",formsOpenapiConfig.getSendSms_signName());
        request.putQueryParameter("TemplateCode", TemplateCode);
        request.putQueryParameter("TemplateParam", TemplateParam);
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return response;
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }
}
