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
    private FormsOpenapiConfig formsOpenapiConfig;

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
     * 保存信息
     *
     * @param sms
     */
    @Override
    public void saveSendSms(SendSms sms) {
        sendSmsDao.addSendSms(sms);
    }


    /**
     * 发送短信服务
     * @param param
     * @return
     */
    @Override
    public JfResponseDto  sendSms(JfRequestDto<SendSmsReq> param) {
        JfResponseDto result = new JfResponseDto();
        if (null == param.getBody()){
            result.setStatus("350001");
            result.setMessage("参数错误");
            return result;
        }
        /**填充参数*/
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain(formsOpenapiConfig.getSendSms_url());
        request.setSysVersion(formsOpenapiConfig.getSendSms_version());
        request.setSysAction("SendSms");
        request.putQueryParameter("PhoneNumbers",param.getBody().getPhoneNumbers());
        request.putQueryParameter("SignName",formsOpenapiConfig.getSendSms_signName());
        request.putQueryParameter("TemplateCode", param.getBody().getTemplateCode());
        if (null != param.getBody() && null != param.getBody().getTemplateParam()){
            request.putQueryParameter("TemplateParam", param.getBody().getTemplateParam());
        }
        try {
            DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", formsOpenapiConfig.getSendSms_accessKeyId(), formsOpenapiConfig.getSendSms_accessSecret());
            IAcsClient client = new DefaultAcsClient(profile);

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
                producer.sendSmsMsg(JSONObject.toJSONString(send));
                // 接口日志入口
                ApiLog qjItfLog = new ApiLog(PublicEnums.JfInterfaceCodeEnum.S10001, JSONObject.toJSONString(param), JSONObject.toJSONString(response.getData()));
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
