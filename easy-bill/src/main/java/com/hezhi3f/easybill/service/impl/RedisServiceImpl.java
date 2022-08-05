package com.hezhi3f.easybill.service.impl;

import com.hezhi3f.easybill.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RedisServiceImpl implements RedisService {
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void set(String key, String value, Integer expireTime) {
        set(key, value);
        stringRedisTemplate.expire(key, Duration.ofSeconds(expireTime));
    }

    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Autowired
    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }
}
