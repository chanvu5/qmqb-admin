package com.hzed.qmqb.admin.infrastructure.config.redis;

import com.hzed.qmqb.admin.infrastructure.enums.BizCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * redis相关操作类
 *
 * @author wuchengwu
 * @since 2018/11/14
 */
@Service
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // 放缓存
    public void setCache(String key,Object value,Long seconds){

        redisTemplate.opsForValue().set(key,value,seconds,TimeUnit.SECONDS);
    }

    public void setCacheDefaultTime(String key,Object value){
        setCache(key,value,3600*5L);
    }

    public boolean setIfAbsent(String key, Object value){

        return redisTemplate.opsForValue().setIfAbsent(key,value);
    }

    /**
     * 取缓存
     * @param key
     * @param <T>
     * @return
     */
    public <T> T getCache(String key) {
        try {
            return (T) redisTemplate.opsForValue().get(key);
        } catch (SerializationException ex) {
            String errMsg = "Unrecognized token";
            if (ex.getMessage().indexOf(errMsg) > -1) {
                // 兼容旧字符串数据
                return (T) stringRedisTemplate.opsForValue().get(key);
            } else {
                // 旧对象重新查询
                return null;
            }
        }
    }

    public void expire(String key, long timeout, TimeUnit timeUnit){

        redisTemplate.expire(key,timeout,timeUnit);
    }

    /**
     * 清理缓存
     * @param key
     */
    public void clearCache(String key){
        redisTemplate.delete(key);
    }

    /**
     * redis防重
     * @param key
     * @param bizCodeEnum
     */
    public void defensiveRepet(String key, BizCodeEnum bizCodeEnum){
        defensiveRepet(key, bizCodeEnum, 180L);
    }

    /**
     * redis防重
     * @param key
     * @param bizCodeEnum
     * @param seconds
     */
    private void defensiveRepet(String key, BizCodeEnum bizCodeEnum, long seconds) {

        if(exitRedisKey(key,seconds)){

            System.out.println("----------重复点击-------");
        }
    }

    /***
     *
     * @param key
     * @param seconds
     * @return rue-存在 false-不存在
     */
    public boolean exitRedisKey(String key, long seconds){
        if(setIfAbsent(key,0)){
            expire(key, seconds,TimeUnit.SECONDS);
            return false;
        }

        return true;
    }
}