package com.marvels.common.mq;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marvels.common.util.MarvelsLogUtil;

/**
 * 消息的生产者
 * @author houyl
 * @date 2019/10/15 16:49
 */
@Component
public class MsgProducer implements RabbitTemplate.ConfirmCallback {
    /** 日志 */
    private MarvelsLogUtil log = MarvelsLogUtil.getInstance();

    /**
     * 由于rabbitTemplate的scope属性设置为ConfigurableBeanFactory.SCOPE_PROTOTYPE，所以不能自动注入
     */
    private RabbitTemplate rabbitTemplate;

    /**
     * 构造方法注入rabbitTemplate
     */
    @Autowired
    public MsgProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
        rabbitTemplate.setConfirmCallback(this);
    }

    /**
     * 推送消息
     * @param content
     */
    public void sendLogMsg(String content) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        //把消息放入ROUTINGKEY_A对应的队列当中去，对应的是队列A
        this.rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_LOG, RabbitConfig.ROUTINGKEY_LOG, content, correlationId);
    }
    
    /**
     * 推送消息
     * @param content
     */
    public void sendSmsMsg(String content) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        //把消息放入ROUTINGKEY_A对应的队列当中去，对应的是队列A
        this.rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_SMS, RabbitConfig.ROUTINGKEY_SMS, content, correlationId);
    }

    /**
     * 回调
     * @param correlationData
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            log.info("消息成功消费");
        } else {
            log.info("消息消费失败:" + cause+"\n重新发送");
        }
    }
}
