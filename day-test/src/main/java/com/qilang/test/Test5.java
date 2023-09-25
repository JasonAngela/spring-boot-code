package com.qilang.test;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test5 {

    private static final List<String> BEFORE_UNIQUE_KEY = CollUtil.newArrayList("customer", "sap_code", "expiry_date");

    private final ThreadLocal<DateFormats> dateFormats = new ThreadLocal<DateFormats>() {
        @Override
        protected DateFormats initialValue() {
            return new DateFormats();
        }
    };


    public static void main(String[] args) {
//        String randomStringUpper = RandomUtil.randomStringUpper(15);
//        System.out.println(randomStringUpper);





//        System.out.println(DateUtil.offsetDay(DateUtil.date(), -6).toString(DatePattern.PURE_DATE_PATTERN));
//
//        System.out.println(NumberUtil.equals(1.00, 1));


       // System.out.println(DateUtil.offsetDay(new Date(), -90).toString(DatePattern.PURE_DATE_PATTERN));



        //String str = "{}";
        //System.out.println(JSON.isValid(str));


        //System.out.println(JSON.parseObject(str).getString("content"));


        //System.out.println(DateUtil.offsetMonth(new Date(), -29).toString(DatePattern.SIMPLE_MONTH_PATTERN));

//        Map<String, Object> map = new HashMap<>();
//        map.put("p_id", "121212");
//
//
//        String result = HttpUtil.urlWithForm("www.baidu.com", map, StandardCharsets.UTF_8, false);
//        System.out.println(result);
//        Map<String, Object> map = MapUtil.newHashMap();
//        map.put("customer", "奥萨克斯");
//        map.put("sap_code", "Q12");
//        map.put("expiry_date", new Date());
//        List<Object> list = CollUtil.newArrayList();
//        BEFORE_UNIQUE_KEY.forEach(m -> {
//            Object fieldValue = map.get(m);
//            if (fieldValue instanceof Date) {
//                //转化成YYYY-MM-DD
//                fieldValue = DateUtil.format((Date) fieldValue, "yyyy-MM-dd 00:00:00");
//            }
//            list.add(fieldValue);
//        });
//
//        System.out.println(CharSequenceUtil.join(":", list));


//        List<Simple> list1 = new ArrayList<>();
//        Simple simple1 = new Simple();
//        simple1.setId("1");
//        simple1.setName("asasa");
//        list1.add(simple1);
//
//        Simple simple2 = new Simple();
//        simple2.setId("2");
//        simple2.setName("asasa2");
//        list1.add(simple2);
//
//        Simple simple3 = new Simple();
//        simple3.setId("3");
//        simple3.setName("asasa3");
//        list1.add(simple3);
//
//        list1.forEach(m -> {
//            if(m.getId().equals("1")) {
//                return;
//            }
//
//            System.out.println(m.getName());
//        });
//        System.out.println(FileUtil.getSuffix("aaaaa.docx"));
//
//        Integer a = 100;
//        Integer b = 1774;
//
//        Long total = 177389L;
//
//        System.out.println((long) a * (1774) > total);

        System.out.println(DateUtil.format(new Date(), DatePattern.PURE_DATE_PATTERN));

    }

    public static Date getBeginDayOfYesterday() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin(new Date()));
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    /**
     * 获取指定天开始时间
     *
     * @param date 日期
     * @return 获得该日期的开始
     */
    public static Date getDayBegin(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        setCalender(calendar, 0, 0, 0, 0);
        return calendar.getTime();
    }

    public static void setCalender(Calendar calendar, int hour, int minute, int second, int milliSecond) {
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, milliSecond);
    }





   public class DateFormats {

        public final SimpleDateFormat hms = new SimpleDateFormat("HH:mm:ss");

        public final SimpleDateFormat hm = new SimpleDateFormat("HH:mm");

        public final SimpleDateFormat ymdhm = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        public final SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");

        public final SimpleDateFormat ym = new SimpleDateFormat("yyyy-MM");

        public final SimpleDateFormat ymdhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        public final SimpleDateFormat ymdChinese = new SimpleDateFormat("yyyy年MM月dd日");

        public final SimpleDateFormat ymdSlash = new SimpleDateFormat("yyyy/MM/dd");

        public final SimpleDateFormat mySlash = new SimpleDateFormat("MM/yyyy");

        public final SimpleDateFormat ymdDigital = new SimpleDateFormat("yyyyMMdd");

        public final SimpleDateFormat ymdhmsDigital = new SimpleDateFormat("yyyyMMddHHmmss");

        public static final String ymdh = "yyyy-MM-dd HH";
    }
}
