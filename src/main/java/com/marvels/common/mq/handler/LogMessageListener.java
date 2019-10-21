package com.marvels.common.mq.handler;

import java.io.IOException;

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
 * 日志记录消息监听器
 * @author shiwubin
 *
 */
@Component
@RabbitListener(queues = "QUEUE_LOG")
public class LogMessageListener {
	
	/** 日志 */
    private MarvelsLogUtil log = MarvelsLogUtil.getInstance();
    
    /**
     *	 公共服务
     */
    @Autowired
    private CommonService commonService;

	@RabbitHandler
    public void process(Message message, Channel channel) throws IOException {
        byte[] body = message.getBody();
        log.info("手工确认模式接收处理队列A当中的消息:" + new String(body));
        
        // 日志入库
        commonService.saveApiLog(JSONObject.parseObject(new String(body), ApiLog.class));

        /** RabbitMQ支持消息应答机制。
         	当消费者接收到消息并完成任务后会往RabbitMQ服务器发送一条确认的命令，然后RabbitMQ才会将消息删除。*/
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
