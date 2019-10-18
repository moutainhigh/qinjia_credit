package com.marvels.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.marvels.common.config.FormsOpenapiConfig;
import com.marvels.common.enums.PublicEnums;
import com.marvels.common.mq.MsgProducer;
import com.marvels.dao.SendSmsDao;
import com.marvels.dto.common.SendSms;
import com.marvels.dto.common.SendSmsReq;
import com.marvels.dto.jf.JfRequestDto;
import com.marvels.dto.jf.JfResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marvels.dao.ApiLogDao;
import com.marvels.dto.common.ApiLog;
import com.marvels.service.CommonService;

/**
 * 记录接口日志
 * @author houyl
 * @date 2019/10/11 10:33
 */
@Service("commonService")
public class CommonServiceImpl implements CommonService {

    @Autowired
    private ApiLogDao apiLogDao;
    @Autowired
    private SendSmsDao sendSmsDao;
    @Autowired
    private MsgProducer producer;

    @Autowired
    private static FormsOpenapiConfig formsOpenapiConfig;

    private static IAcsClient client;

    static  {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", formsOpenapiConfig.getSendSms_accessKeyId(), formsOpenapiConfig.getSendSms_accessSecret());
        client = new DefaultAcsClient(profile);
    }

    /**
     * 玖富记录接口日志
     *
     * @param apiLog
     */
    @Override
    public void saveApiLog(ApiLog apiLog) {
    	apiLogDao.addApiLog(apiLog);
    }


    /**
     * 发送短信服务
     * @param param
     * @return
     * @throws Exception
     */
    @Override
    public JfResponseDto  sendSms(JfRequestDto<SendSmsReq> param) throws Exception {
        JfResponseDto result = new JfResponseDto();
        if (null != param.getBody()){
            result.setStatus("350001");
            result.setMessage("参数错误");
        }
        /**填充参数*/
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain(formsOpenapiConfig.getSendSms_url());
        request.setVersion(formsOpenapiConfig.getSendSms_version());
        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers",param.getBody().getPhoneNumbers());
        request.putQueryParameter("SignName",formsOpenapiConfig.getSendSms_signName());
        request.putQueryParameter("TemplateCode", param.getBody().getTemplateCode());
        if (null != param.getBody() && null != param.getBody().getTemplateParam()){
            request.putQueryParameter("TemplateParam", param.getBody().getTemplateParam());
        }
        try {
            CommonResponse response = client.getCommonResponse(request);
            JSONObject object = (JSONObject) JSONObject.parse(response.getData());
            result.setStatus("OK".equals(object.getString("Code"))?"000000":object.getString("Code"));
            result.setMessage("OK".equals(object.getString("Code"))?"成功":object.getString("Message"));
            if(null != object){
                //信息入库
                SendSms send = new SendSms();
                send.setRequestId(object.getString("RequestId"));
                send.setCode(object.getString("Code"));
                send.setMessage(object.getString("Message"));
                send.setBizId(object.getString("BizId"));
                send.setPhoneNumbers(param.getBody().getPhoneNumbers());
                send.setTemplateCode(param.getBody().getTemplateCode());
                if (null != param.getBody() && null != param.getBody().getTemplateParam()) {
                    send.setTemplateParam(param.getBody().getTemplateParam());
                }
                sendSmsDao.addSendSms(send);
                // 接口日志入口
                ApiLog qjItfLog = new ApiLog();
                qjItfLog.setItfCode(PublicEnums.JfInterfaceCodeEnum.SMS10001.getCode());
                qjItfLog.setItfName(PublicEnums.JfInterfaceCodeEnum.SMS10001.getDesc());
                qjItfLog.setItfUri(PublicEnums.JfInterfaceCodeEnum.SMS10001.getUri());
                qjItfLog.setInParam(JSONObject.toJSONString(param));
                qjItfLog.setOutParam(JSONObject.toJSONString(response.getData()));
                producer.sendLogMsg(JSONObject.toJSONString(qjItfLog));
            }
            return result;
        } catch (ClientException e) {
            result.setStatus("999999");
            result.setMessage("系统异常");
            e.printStackTrace();
        }
        return result;
    }
}
