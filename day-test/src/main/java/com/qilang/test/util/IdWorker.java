package com.qilang.test.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class IdWorker {

    private static Sequence WORKER = new Sequence();
    public static final DateTimeFormatter MILLISECOND = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

    public IdWorker() {
    }

    public static long getId() {
        return WORKER.nextId();
    }

    public static String getIdStr() {
        return String.valueOf(WORKER.nextId());
    }

    public static String getMillisecond() {
        return LocalDateTime.now().format(MILLISECOND);
    }

    public static String getTimeId() {
        return getMillisecond() + getId();
    }

    public static void initSequence(long workerId, long datacenterId) {
        WORKER = new Sequence(workerId, datacenterId);
    }

    public static String get32UUID() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return (new UUID(random.nextLong(), random.nextLong())).toString().replace("-", "");
    }


    public static void main(String[] args) {
        System.out.println(getIdStr());
    }
}
