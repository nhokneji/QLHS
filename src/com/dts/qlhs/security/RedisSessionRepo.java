package com.dts.qlhs.security;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

//@Repository
public class RedisSessionRepo {
    private static final String KEY = "qlhs.session";

//    private RedisTemplate<String, User> redisTemplate;
    private HashOperations hashOps;

//    @Autowired
//    public RedisSessionRepo(RedisTemplate redisTemplate) {
//        this.redisTemplate = redisTemplate;
//    }

//    @PostConstruct
//    private void init() {
//        hashOps = redisTemplate.opsForHash();
//    }

    public void save(String key, User user) {
        hashOps.put(KEY, key, user);
    }

    public User find(String token) {
        return (User) hashOps.get(KEY, token);
    }

    public Map<Object, Object> findAll() {
        return hashOps.entries(KEY);
    }

    public boolean exist(String token) {
        return hashOps.hasKey(KEY, token);
    }

    public void delete(String token) {
        hashOps.delete(KEY, token);
    }
}
