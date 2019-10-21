package com.marvels.common.mq.handler;

import java.io.IOException;

import com.marvels.dto.common.SendSms;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.marvels.common.util.MarvelsLogUtil;
import com.marvels.dto.common.ApiLog;
import com.marvels.service.CommonService;
import com.rabbitmq.client.Channel;

/**
 * 短信消息监听器
 * @author shiwubin
 *
 */
@Component
@RabbitListener(queues = "QUEUE_SMS")
public class SmsMessageListener {
	
	/** 日志 */
    private MarvelsLogUtil log = MarvelsLogUtil.getInstance();
    
    /**
     *	 公共服务
     */
    @Autowired
    private CommonService commonService;

	@RabbitHandler
    public void process(String message) {
        log.info("处理短信队列当中的消息:" + message);
        //短信信息入库
        commonService.saveSendSms(JSONObject.parseObject(message, SendSms.class));
    }
}
