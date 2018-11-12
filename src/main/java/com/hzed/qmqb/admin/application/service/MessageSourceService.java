package com.hzed.qmqb.admin.application.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hzed.qmqb.admin.infrastructure.model.Response;
import com.hzed.qmqb.admin.infrastructure.utils.ComUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * @author: yangmengjun
 * @date: 2018\6\5 17:15
 */
@Slf4j
@Component
public class MessageSourceService {

    @Resource
    private MessageSource messageSource;

    /**
     * @param code：对应messages配置的key.
     * @return
     */
    public String getMessage(String code) {
        return this.getMessage(code, new Object[]{});
    }

    public String getMessage(String code, String defaultMessage) {
        return this.getMessage(code, null, defaultMessage);
    }

    public String getMessage(String code, String defaultMessage, Locale locale) {
        return this.getMessage(code, null, defaultMessage, locale);
    }

    public String getMessage(String code, Locale locale) {
        return this.getMessage(code, null, "", locale);
    }

    /**
     * @param code：对应messages配置的key.
     * @param args                   :数组参数.
     * @return
     */
    public String getMessage(String code, Object[] args) {
        return this.getMessage(code, args, "");
    }

    public String getMessage(String code, Object[] args, Locale locale) {
        return this.getMessage(code, args, "", locale);
    }

    /**
     * @param code：对应messages配置的key.
     * @param args                   :数组参数.
     * @param defaultMessage         :没有设置key的时候的默认值.
     * @return
     */
    public String getMessage(String code, Object[] args, String defaultMessage) {
        //这里使用比较方便的方法，不依赖request.
        Locale locale = LocaleContextHolder.getLocale();
        return this.getMessage(code, args, defaultMessage, locale);
    }

    /**
     * 指定语言.
     *
     * @param code
     * @param args
     * @param defaultMessage
     * @param locale
     * @return
     */
    public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        return messageSource.getMessage(code, args, defaultMessage, locale);
    }

    /**
     * 根据Locale获取语言，默认中文-zh
     *
     * @param locale
     * @return
     */
    public String getLanguageFromLocale(Locale locale) {
        String lang = locale.getLanguage();
        return StringUtils.isBlank(lang) ? "zh" : lang;
    }

    public Response doObject(Response resp) {
       /* String i18n = resp.getI18n();
        if (StringUtils.isNotBlank(i18n)) {
            resp.setMsg(getMessage(i18n));
        }*/
        log.info("返回报文：{}", ComUtil.subString(JSON.toJSONString(resp, SerializerFeature.WriteMapNullValue), 500));
        return resp;
    }
}
