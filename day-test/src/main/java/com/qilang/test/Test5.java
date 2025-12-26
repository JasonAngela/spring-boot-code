package com.qilang.test;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.*;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test5 {

    private static final List<String> BEFORE_UNIQUE_KEY = CollUtil.newArrayList("customer", "sap_code", "expiry_date");

    private final ThreadLocal<DateFormats> dateFormats = new ThreadLocal<DateFormats>() {
        @Override
        protected DateFormats initialValue() {
            return new DateFormats();
        }
    };


    public static void main(String[] args) throws InterruptedException, ParseException {


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

        //System.out.println(DateUtil.format(new Date(), DatePattern.PURE_DATE_PATTERN));

        /*String url = "http://172.20.1.57:81/api/gateway/service/ztzl0119yg";
        System.out.println(StrUtil.sub(url, url.indexOf("/api"), url.length()));
        System.out.println(StrUtil.subBefore(url, "/api", false));
        System.out.println(StrUtil.subAfter(url, "/api", false));

        List<String> list = Arrays.asList("item1", "item2", "item3");
        // 使用分号连接列表元素
        String result = String.join(";", list);

        System.out.println(result);  // 输出: item1;item2;item3

        StringBuilder msgBuilder = new StringBuilder();
        msgBuilder.append("asaasa"+"\n");
        msgBuilder.append("bbbb"+"\n");
        msgBuilder.append("ccc"+"\n");
        System.out.println(StrUtil.subBefore(msgBuilder.toString(), "\n", true) );*/

        //System.out.println(Id);


       /* String msg = "/api/gateway/service/ztzl00861yg:SAP快照异常\\n/api/gateway/service/ztzl0088yg:SAP快照异常\\n/api/gateway/service/ztzl0102yg:未开始\\n/api/gateway/service/ztzl0110yg:SAP快照异常\\n/api/gateway/service/ztzl0119yg:SAP快照异常";
        System.out.println(JSONObject.parseObject(msg));*/


        /*List<String> list = CollUtil.newArrayList();
        list.add("1");
        list.add("2");
        System.out.println(JSON.toJSONString(list));*/

        /*String str = "KYHASIOAJS";
        System.out.println(StrUtil.subWithLength(str, 0, 100));*/

        /*int page = 10;
        int start = 0;
        while (start != 5) {
            if (start > page) {
                break;
            }
            start++;
            System.out.println(start);
        }*/

       /* String str = "http://dap.cpm.cn/dock/api/kyc/company";
        System.out.println(StrUtil.subAfter(str, "/", true));*/

      /*  BigDecimal a = new BigDecimal("10000");
        BigDecimal b = new BigDecimal("4");
        System.out.println(a.subtract(b).divide(a, RoundingMode.HALF_UP));
        System.out.println(new DecimalFormat("#.##%").format(a.subtract(b).divide(b,2, RoundingMode.HALF_UP)));*/



       /* List<String> list = CollUtil.newArrayList();
        list.add("1");
        list.add("2");
        list.add("3");

        List<String> list2 = CollUtil.newArrayList();
        list2.add("2");
        list2.add("3");
        list2.add("4");*/
        //System.out.println(CollectionUtil.disjunction(list, list2));

        //System.out.println(list.stream().filter("4"::equals).collect(Collectors.toList()).stream().collect(Collectors.toList()));
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date da1 = sdf.parse("2024-10-07");
        Date da2 = sdf.parse("2024-11-06");
        System.out.println(DateUtil.between(da2, da1, DateUnit.DAY));*/
        /*list.forEach(m -> {
            if (m.equals("1")) {
                return;
            }
            System.out.println(m);
        });*/

        /*String strr = "   ";
        System.out.println(CharSequenceUtil.isBlank(strr));*/

       /* List<BaseFlowRespDTO> list = new ArrayList<>();
        BaseFlowRespDTO respDTO = new BaseFlowRespDTO();
        respDTO.setCode("200");
        respDTO.setData("1280121");

        BaseFlowRespDTO respDTO1 = new BaseFlowRespDTO();
        respDTO1.setCode("200");
        respDTO1.setData("12801211212");

        list.add(respDTO);
        list.add(respDTO1);
        List<String> stringList = list.stream()
                .flatMap(dp -> Stream.of(dp.getCode(), dp.getData())).distinct()
                .collect(Collectors.toList());
        System.out.println(stringList);*/

        /*String str1 = "OTHER BODIES";
        String str2 = "other bodies";

        boolean contains = StrUtil.equalsIgnoreCase(str2, str1);
        StrUtil.equalsAnyIgnoreCase(str1, str2);
        System.out.println("字符串是否相等（忽略大小写）: " + contains);*/


        //System.out.println(DateUtil.offsetDay(DateUtil.date(), -65).toString(DatePattern.PURE_DATE_PATTERN));

       // System.out.println(String.format("%s %s", null, "再次提交"));

        //System.out.println(!CharSequenceUtil.startWith("MFSQ202516121", "MFSQ", false));

        String resetDate = "2025-12-24";

        String date = DateUtil.format(new Date(), "yyyy-MM-dd");

        System.out.println(date.compareTo(resetDate) <=0);

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
