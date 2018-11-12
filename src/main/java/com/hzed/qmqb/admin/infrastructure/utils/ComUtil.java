package com.hzed.qmqb.admin.infrastructure.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Map;

/**
 * @author Administrator
 */
@Slf4j
public class ComUtil {

    public static Locale IDLOCALE = new Locale("in", "ID");

    public static String subString(String str, int length) {
        if (length < 0) {
            return str;
        } else if (StringUtils.isBlank(str)) {
            return null;
        } else if (str.length() <= length) {
            return str;
        } else {
            return str.substring(0, length) + "...";
        }
    }

    public static String subJsonString(String json, int length) {
        Map mapResult = Maps.newHashMap();
        JSONObject jsonObject;
        try {
            jsonObject = JSON.parseObject(json);
            jsonObject.entrySet().forEach(obj -> mapResult.put(obj.getKey(), subString(obj.getValue().toString(), length)));
        } catch (Exception ex) {
            return subString(json, length);
        }

        return JSON.toJSONString(mapResult);
    }

    /**
     * 字符串首字母大写
     */
    public static String toUpperCaseIndex(String str) {
        char[] cs = str.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }

    /**
     * 产生随机码
     */
//    public static String getRandomNumber(int size) {
//        //元素
//
//        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//
//        //随机对象
//        Random rand = new Random();
//
//        //循环产生
//        for (int i = 10; i > 1; i--) {
//            int index = rand.nextInt(i);
//            int tmp = array[index];
//            array[index] = array[i - 1];
//            array[i - 1] = tmp;
//        }
//
//        //拼接结果为字符串
//        int result = 0;
//        for (int i = 0; i < size; i++) {
//            result = result * 10 + array[i];
//        }
//        String sixString = Integer.toString(result);
//
//        //有可能出现5位数，前面加0补全
//        if (sixString.length() == size - 1) {
//            sixString = "0" + sixString;
//        }
//        //打印结果
//        return sixString;
//    }
}
