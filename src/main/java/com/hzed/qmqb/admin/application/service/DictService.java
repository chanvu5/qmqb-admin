package com.hzed.qmqb.admin.application.service;

import com.hzed.qmqb.admin.infrastructure.config.redis.RedisService;
import com.hzed.qmqb.admin.infrastructure.enums.BizCodeEnum;
import com.hzed.qmqb.admin.persistence.auto.entity.Dict;
import com.hzed.qmqb.admin.persistence.auto.entity.example.DictExample;
import com.hzed.qmqb.admin.persistence.auto.mapper.DictMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * 暂无描述
 *
 * @author wuchengwu
 * @since 2018/11/14
 */
@Slf4j
@Service
public class DictService {

    @Autowired
    private DictMapper dictMapper;
    @Autowired
    private RedisService redisService;

    private final String dictKey = "DICT_CODE" + ":";

    public Dict getDict(String code) {

        String key = dictKey + code;

        Dict dictCache = redisService.getCache(key);
        if (!ObjectUtils.isEmpty(dictCache)) {
            return dictCache;
        }
        DictExample example = new DictExample();
        example.createCriteria().andDicCodeEqualTo(code);
        Dict dict = dictMapper.selectOneByExample(example);
        redisService.setCacheDefaultTime(key, dict);
        return dict;
    }

    public void clearCache(String code) {
        String key = dictKey + code;
        Object cache = redisService.getCache(key);
        if (ObjectUtils.isEmpty(cache)) {
            log.info("code:{},无缓存，不做清理操作", code);
        }
        log.info("开始清理缓存");
        redisService.clearCache(key);
        log.info("清理完毕");
    }

    public void defensiveRepet(String code) {
        String key = dictKey + code + ":" + "list";
        //请求防重
        redisService.defensiveRepet(key, BizCodeEnum.ILLEGAL_REQUEST);
    }
}