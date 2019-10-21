package com.marvels.common.mq.handler;

import com.alibaba.fastjson.JSONObject;
import com.marvels.common.util.MarvelsLogUtil;
import com.marvels.dao.SendSmsDao;
import com.marvels.dto.common.SendSms;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 短信消息监听器
 * @author shiwubin
 *
 */
@Component
public class SmsMessageListener {

    /** 日志 */
    private MarvelsLogUtil log = MarvelsLogUtil.getInstance();

    /**
     *	 公共服务
     */
    @Autowired
    private SendSmsDao sendSmsDao;

    /**
     * 短信消息处理
     * @param message
     * @param channel
     * @throws IOException
     */
    @RabbitListener(queues = "QUEUE_SMS")
    @RabbitHandler
    public void process(Message message, Channel channel) {
        byte[] body = message.getBody();
        log.info("处理短信队列当中的消息:" + new String(body));

        try {
            //短信信息入库
            sendSmsDao.addSendSms(JSONObject.parseObject(new String(body), SendSms.class));

            /** RabbitMQ支持消息应答机制。
             当消费者接收到消息并完成任务后会往RabbitMQ服务器发送一条确认的命令，然后RabbitMQ才会将消息删除。*/
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }catch (Exception e) {
            log.error("短信信息消费者异常"+e.getMessage());
            e.printStackTrace();
        }
    }
}

