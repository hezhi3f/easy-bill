package com.hezhi3f.easybill.service;

public interface RedisService {
    void set(String key, String value, Integer expireTime);

    void set(String key, String value);

    String get(String key);
}
