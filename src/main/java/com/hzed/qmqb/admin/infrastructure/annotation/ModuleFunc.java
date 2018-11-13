package com.hzed.qmqb.admin.infrastructure.annotation;

import java.lang.annotation.*;

/**
 * 标志controller中方法的用处
 *
 * @author guichang
 * @date 2018/05/16
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ModuleFunc {
    /**
     * 模块名
     */
    String value() default "未命名模块";

    /**
     * 打印请求参数的长度，部分请求可能请求参数过长，用此参数限制
     * 默认 -1 表示无限制
     */
    int printParameterLength() default -1;

    /**
     * 是否转换为com.hzed.qmqb.infrastructure.model.Response
     * 默认 true-转换
     */
    boolean isCommonResponse() default true;

}