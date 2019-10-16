package com.marvels.common;

import com.alibaba.fastjson.JSONObject;
import com.marvels.common.util.MarvelsLogUtil;
import com.marvels.dto.common.QjItfLog;
import com.marvels.service.QjItfLogService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消费者
 * @author houyl
 * @date 2019/10/15 16:58
 */
@Component
@RabbitListener(queues = RabbitConfig.QUEUE_A)
public class MsgReceiver {
    /** 日志 */
    private MarvelsLogUtil log = MarvelsLogUtil.getInstance();
    @Autowired
    private QjItfLogService qjItfLogService;

    /**
     * 消息处理
     * @param content
     */
    @RabbitHandler
    public void process(String content) {
        log.info("接收处理队列A当中的消息： " + content);
        QjItfLog qjItfLog = JSONObject.parseObject(content, QjItfLog.class);
        qjItfLogService.inOutParamsItfLog(qjItfLog);
    }
}
