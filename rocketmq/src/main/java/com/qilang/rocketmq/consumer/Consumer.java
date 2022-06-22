package com.qilang.rocketmq.consumer;

import com.qilang.rocketmq.consts.Const;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @Author jason.hu
 * @Description
 * @Date
 **/
@Slf4j
@Service
@RocketMQMessageListener(topic = Const.TOPIC, consumerGroup = "tengxunyun-group")
public class Consumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("Received message : {}", message);
    }
}
