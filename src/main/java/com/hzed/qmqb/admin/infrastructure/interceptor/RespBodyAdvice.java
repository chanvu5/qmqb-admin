package com.hzed.qmqb.admin.infrastructure.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hzed.qmqb.admin.infrastructure.model.Response;
import com.hzed.qmqb.admin.infrastructure.utils.ComUtil;
import com.hzed.qmqb.admin.infrastructure.utils.RequestUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 拦截返回并封装成 com.hzed.easyget.infrastructure.model.Response
 *
 * @author guichang
 * @date 2018/6/18
 */
@Slf4j
@RestControllerAdvice
public class RespBodyAdvice implements ResponseBodyAdvice<Object> {


    /**
     * 全部进入
     */
    @Override
    public boolean supports(MethodParameter parameter, Class<? extends HttpMessageConverter<?>> converterType) {
        // 拦截swagger的请求
        String requestURI = RequestUtil.getHttpServletRequest().getRequestURI();
        return requestURI.indexOf("swagger") == -1 && requestURI.indexOf("api-docs") == -1;
    }

    /**
     * 返回结果转换
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter parameter,
                                  org.springframework.http.MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        Object result = body;
     //   ModuleFunc moduleFunc = RequestUtil.getModuleFunc();
        ApiOperation apiOperation = RequestUtil.getApiOperation();
        if (!(body instanceof Response) && apiOperation != null) {
            Response resp = Response.getSuccessResponse(body);
            resp.setCode(resp.getCode());
            resp.setMessage(resp.getMessage());
            result = resp;
        }
        log.info("返回报文：{}", ComUtil.subJsonString(JSON.toJSONString(result, SerializerFeature.WriteMapNullValue), 300)) ;
        return result;
    }

}
