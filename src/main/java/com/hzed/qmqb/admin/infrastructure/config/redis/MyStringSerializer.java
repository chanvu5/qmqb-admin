package com.hzed.qmqb.admin.infrastructure.config.redis;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.util.Assert;

import java.nio.charset.Charset;

/**
 * 自定义redis key序列化
 *
 * @author guichang
 * @date 2018/9/3
 */

public class MyStringSerializer implements RedisSerializer<String> {

    private String prefix;
    private final Charset charset;

    public MyStringSerializer(String prefix) {
        this(Charset.forName("UTF8"), prefix);
        Assert.notNull(prefix, "prefix must not be null!");
    }

    public MyStringSerializer(Charset charset, String prefix) {
        this.charset = charset;
        // 加分割符
        if (!prefix.endsWith(":")) {
            this.prefix = prefix + ":";
        }
    }

    @Override
    public String deserialize(byte[] bytes) {
        String saveKey = new String(bytes, charset);
        if (saveKey.indexOf(prefix) == 0) {
            saveKey = saveKey.substring(prefix.length());
        }
        return (saveKey.getBytes() == null ? null : saveKey);
    }

    @Override
    public byte[] serialize(String key) {
        if (StringUtils.isNotBlank(key) && key.indexOf(prefix) != 0) {
            key = prefix + key;
        }
        return (key == null ? null : key.getBytes(charset));
    }
}