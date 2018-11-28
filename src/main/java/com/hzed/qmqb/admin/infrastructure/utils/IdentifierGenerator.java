package com.hzed.qmqb.admin.infrastructure.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IdentifierGenerator {

    private final static String WORK_ID = "1";
    private final static String DATA_CENTER_ID = "2";

    private static SnowflakeIdWorker idWorker;

    public IdentifierGenerator() {
    }

    public static long nextId() {
        return idWorker.nextId();
    }

    static {
        try {
            long idWorkerId = Long.parseLong(System.getProperty("idWorkerId", WORK_ID));
            long idDataCenterId = Long.parseLong(System.getProperty("idDataCenterId", DATA_CENTER_ID));
            idWorker = new SnowflakeIdWorker(idWorkerId, idDataCenterId);
        } catch (NumberFormatException e) {
            log.error("雪花算法，初始化ID生成器出错", e);
        }

    }
}
