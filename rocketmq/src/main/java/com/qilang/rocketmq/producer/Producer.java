package com.qilang.rocketmq.producer;

import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @Author jason.hu
 * @Description
 * @Date
 **/
@Component
public class Producer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * @Description  发送消息的实例
     **/
    public void sendMessage(String topic, String msg) {
        rocketMQTemplate.convertAndSend(topic, msg);
    }

    /**
     * @Description  发送事务消息的实例
     **/
    public void sendMessageInTransaction(String topic, String msg) throws InterruptedException {
        String[] tags = {"TagA", "TagB", "TagC", "TagD", "TagE"};
        for (int i = 0; i < 10; i++) {
            Message<String> message = MessageBuilder.withPayload(msg).build();
            String destination = topic + ":" + tags[i % tags.length];

            TransactionSendResult sendResult =
                    rocketMQTemplate.sendMessageInTransaction(destination, message, destination);

            Thread.sleep(10);
        }
    }



}
