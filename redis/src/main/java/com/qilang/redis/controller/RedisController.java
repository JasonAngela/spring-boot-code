package com.qilang.redis.controller;

import com.qilang.redis.dto.RedisDTO;
import com.qilang.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author jason.hu
 * @Description
 * @Date
 **/
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @PostMapping("/save")
    public String sendMessage(@RequestBody RedisDTO redisDTO) {
        redisService.setCacheObject("vvvvvv", "pppp");
        return "保存缓存成功";
    }
}
