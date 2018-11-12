package com.hzed.qmqb.admin.infrastructure.utils;

import org.slf4j.MDC;

import java.util.UUID;

/**
 * @author hfj
 * @date 2018/6/8
 */
public class MdcUtil {

    public static final String MODULENAME = "moduleName";
    public static final String TRACE = "trace";

    private MdcUtil() {
    }

    public static void putTrace() {
        MDC.put(TRACE, UUID.randomUUID().toString().replaceAll("-", "").substring(3, 20));
    }

    public static String getTrace() {
        return MDC.get(TRACE);
    }

    public static void putModuleName(String moduleName) {
        MDC.put(MODULENAME, moduleName);
    }

    public static void clearTrace() {
        MDC.remove(TRACE);
    }

    public static void clearModuleName() {
        MDC.remove(MODULENAME);
    }

    public static void clear() {
        MDC.clear();
    }
}
