package com.hzed.qmqb.admin.infrastructure.utils;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.util.Map;

/**
 * @author wuchengwu
 * @since 2018/11/15
 */
@Slf4j
public class JwtUtil {
    private static final String SECRET = "NBG)(#*!()!KLowXX#$%()(#*!()!KLf>?N<:{LWPW";
    private static final String PLAYlOAD = "playload";
    private static final String ALG = "alg";
    private static final String HS256 = "HS256";
    private static final String TYPE = "type";
    private static final String TYPE_JWT = "JWT";

    /**
     * token失效时间
     */

    private static final int EXPIRE_DAYS = 7;

    /**
     * 根据用户创建token
     */
    public static <T> String createToken(T t){
        try {
            Map<String,Object> map = Maps.newHashMap();
            Date date = DateUtils.addDays(new Date(), EXPIRE_DAYS);
            map.put(ALG,HS256);
            map.put(TYPE,TYPE_JWT);
            return JWT.create().withHeader(map).withClaim(PLAYlOAD,JSON.toJSONString(t)).withExpiresAt(date).sign(Algorithm.HMAC256(SECRET));
        } catch (Exception e) {
            log.info("创建token失败，用户信息：{}",JSON.toJSONString(t),e);
            return null;
        }
    }



}