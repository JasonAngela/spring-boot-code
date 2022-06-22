package com.qilang.rocketmq.controller;

import com.qilang.rocketmq.consts.Const;
import com.qilang.rocketmq.producer.Producer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @Author jason.hu
 * @Description //TODO $
 * @Date $ $
 **/
@RestController
@RequestMapping("/MQTest")
public class MQTestController {

    @Resource
    private Producer producer;

    @PostMapping("/msg/send")
    public String sendMessage(@RequestBody String message) {
        producer.sendMessage(Const.TOPIC, message);
        return "消息发送完成";
    }
}
