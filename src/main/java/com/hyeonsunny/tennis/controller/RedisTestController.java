package com.hyeonsunny.tennis.controller;

import com.hyeonsunny.tennis.dto.redis.StringEntity;
import com.hyeonsunny.tennis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/redis/test")
public class RedisTestController {

    @Autowired
    RedisService stringRepository;

    @PostMapping("/string")
    public StringEntity saveString(@RequestBody StringEntity stringEntity){
        stringRepository.saveString(stringEntity);
        return stringEntity;
    }

    @GetMapping("/string/{key}")
    public StringEntity get(@PathVariable("key") String key) {
        return stringRepository.findString(key);
    }
}
