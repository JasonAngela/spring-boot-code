package com.qilang.test.time;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hql
 */
public class TimeDemo {


    public static void main(String[] args) {
       /* // 获取昨天的日期
        LocalDate yesterday = LocalDate.now().minusDays(1);
        // 获取昨天的开始时间：00:00:00
        String startOfYesterday = LocalDateTime.of(yesterday, LocalTime.MIN)
                .format(DateTimeFormatter.ofPattern(DatePattern.NORM_DATETIME_PATTERN));
        // 获取昨天的结束时间：23:59:59
        String endOfYesterday = LocalDateTime.of(yesterday, LocalTime.MAX)
                .format(DateTimeFormatter.ofPattern(DatePattern.NORM_DATETIME_PATTERN));
        System.out.println(startOfYesterday);
        System.out.println(endOfYesterday);*/
        /*List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        list.forEach(m -> {

            if (m.equals("3")) {
                return;
            }
            System.out.println(m);
        });*/
        /*LocalTime startTime = LocalTime.of(16, 24, 0);
        LocalTime endTime = LocalTime.of(16, 29, 0);
        Date date = DateUtil.date();
        LocalDateTime customDateTime = LocalDateTime.of(2024, 4, 10, 16, 30,0);*/

        //System.out.println(isTimeInRange(Date.from(customDateTime.atZone(ZoneId.systemDefault()).toInstant()), startTime, endTime));

        //System.out.println(a);

    }
    public static boolean isTimeInRange(Date rangeTime, LocalTime startTime, LocalTime endTime) {
        LocalTime rangeLocalTime = rangeTime.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
        return !rangeLocalTime.isBefore(startTime) && !rangeLocalTime.isAfter(endTime);
    }

}
