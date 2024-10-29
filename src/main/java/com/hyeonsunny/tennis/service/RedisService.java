package com.hyeonsunny.tennis.service;

import com.hyeonsunny.tennis.dto.redis.StringEntity;
import com.hyeonsunny.tennis.model.Booking;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
@Slf4j
public class RedisService {
    private RedisTemplate<String, Object> redisTemplate;
    private StringRedisTemplate stringRedisTemplate;
    private ValueOperations valueOperationsStr;
    private ValueOperations<String, Object> valueOperationsMap;

    public RedisService(RedisTemplate redisTemplate, StringRedisTemplate stringRedisTemplate) {
        this.redisTemplate = redisTemplate;
        this.stringRedisTemplate = stringRedisTemplate;
        this.valueOperationsStr = stringRedisTemplate.opsForValue();
        this.valueOperationsMap = redisTemplate.opsForValue();
    }

    public List<Booking> findAllBooking() {
        Set<String> keys = redisTemplate.keys("*");
        List<Booking> list = new ArrayList<>();

        if(keys != null) {
            for(String key : keys) {
                try {
                    Booking booking = (Booking) valueOperationsMap.get(key);

                    if(booking != null) {
                        list.add(booking);
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }

    public Booking findBooking(String key) {
        Object value = valueOperationsMap.get(key);

        if(value == null) {
            log.info("value is null");
            return null;
        }
        return (Booking) value;
    }

    public void saveBooking(Booking booking) {
        valueOperationsMap.set(booking.getSvcid(), booking);
    }

    public void removeAllBooking() {
        Set<String> keys = redisTemplate.keys("*");
        if(keys != null) {
            for (String key : keys) {
                redisTemplate.delete(key);
            }
        }
    }

    /**
     * test
     */
    public void saveString(StringEntity stringEntity) {
        valueOperationsStr.set(stringEntity.getKey(), stringEntity.getValue());
    }

    public StringEntity findString(String key) {
        String value = (String) valueOperationsStr.get(key);
        if (value == null) {
            log.info("value is null");
            return null;
        }
        return new StringEntity(key, value);
    }
}
