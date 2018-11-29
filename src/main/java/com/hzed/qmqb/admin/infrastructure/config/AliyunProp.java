package com.hzed.qmqb.admin.infrastructure.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 暂无描述
 *
 * @author wuchengwu
 * @since 2018/11/28
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "aliyun")
public class AliyunProp {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
}