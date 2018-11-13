package com.hzed.qmqb.admin.infrastructure.interceptor.filter;

import com.alibaba.fastjson.JSONObject;
import com.hzed.qmqb.admin.infrastructure.utils.ComUtil;
import com.hzed.qmqb.admin.infrastructure.utils.MdcUtil;
import com.hzed.qmqb.admin.infrastructure.utils.RequestUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 暂无描述
 *
 * @author wuchengwu
 * @since 2018/11/12
 */
@Slf4j
@Aspect
@Component
public class RequestAspect {

    @Around("@annotation(apiOperation)")
    public static Object aroundTest(ProceedingJoinPoint pPoint, ApiOperation apiOperation) throws Throwable {

        HttpServletRequest request = RequestUtil.getHttpServletRequest();
        log.info("请求URL：{}，来源IP：{}", request.getRequestURL(), RequestUtil.getIp());
        // 设置moduleName
        MdcUtil.putModuleName(apiOperation.value());
    //    RequestUtil.setModuleFunc(apiOperation);
        RequestUtil.setApiOperation(apiOperation);
        Object[] args = pPoint.getArgs();
        if (args == null || args.length <= 0) {
            log.info("请求报文：无请求报文");
        } else {
            for (int i = 0; i < args.length; i++) {
                Object arg = args[i];
                if (!(arg instanceof HttpServletRequest) && !(arg instanceof HttpServletResponse)) {
                    log.info("请求报文{}：{}", (i + 1), ComUtil.subString(JSONObject.toJSONString(arg), 500));
                }
            }
        }

        // 执行请求
        Object result = pPoint.proceed();
       /* if (result instanceof Response) {
            return result;
        }

        log.info("返回报文：{}", ComUtil.subString(JSON.toJSONString(result, SerializerFeature.WriteMapNullValue), 500));*/
        return result;
    }
}