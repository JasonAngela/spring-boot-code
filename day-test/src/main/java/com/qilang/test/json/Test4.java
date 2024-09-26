package com.qilang.test.json;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Test4 {

    public static void main(String[] args) {

        Map<String, Object> map = MapUtil.newHashMap();
        map.put("account", "1212");
        map.put("name","jason");
        map.put("box",true);

        Map<String, Object> sortMap =  MapUtil.sort(map);
        System.out.println(CharSequenceUtil.join("", sortMap));
        System.out.println(MapUtil.joinIgnoreNull(sortMap, "", "", CharSequenceUtil.EMPTY));
        /*String str = "{\n" +
                "    \"searchKey\":\"安科瑞电气股份有限公司\",\n" +
                "    \"ancheYear\":\"2023\"\n" +
                "}";
        Search search = JSON.parseObject(str, Search2.class);
        System.out.println(JSON.toJSONString(search));*/
        /*Date now = new Date();
        Date beginDate = DateUtil.offset(now, DateField.MONTH, -3);
        System.out.println(beginDate);
        System.out.println(beginDate.getTime()/1000);
        System.out.println(now.getTime()/1000);*/

        //String str = "[{}]";
        /*List<Search> searches = CollUtil.newArrayList(new Search());
        searches.forEach(search -> System.out.println(search+"asas"));*/

        //List<Search> searches = JSON.parseArray(str, Search.class);
        //searches.forEach(search -> System.out.println(search+"asas"));

        /*String str = "{total:0,hits:[]}";
        List<Search> bids = JSON.parseArray(JSON.parseObject(str)
                .getString("hits"), Search.class);
        System.out.println(CollUtil.isEmpty(bids));
        System.out.println(bids.size());
        if (CollUtil.isEmpty(bids)) {
            bids = CollUtil.newArrayList(new Search());
        }
        bids.forEach(bid -> {
            bid.setSearchKey("asa");
            System.out.println(bid);
        });*/
        //Search search = new Search();
        //System.out.println(search.getClass());
        //List<String> list = CollUtil.newArrayList("1","2","3");
        //System.out.println(StrUtil.join(",", list));


        //String str = " as asa  ";
        //System.out.println(str.trim());
        


                /*List<String> originalList = Collections.emptyList();
                List<Long> newList = originalList.stream()
                        .flatMap(s -> Arrays.stream(s.split(",")))
                        .map(Long::parseLong)
                        .collect(Collectors.toList());
                // 输出: [a, b, c, d, e, f, g, h, i]
                System.out.println(newList);*/

        /*Date now = new Date();
        System.out.println(now);
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        List<String> originalList = Collections.emptyList();
        for (String str: originalList) {
            System.out.println(str);
        }*/
        /*String str = ",1679040018506985474,1688444617823109121,";
        List<String> postRoleIds =CollUtil.newArrayList(StrUtil.removePrefix(StrUtil.removeSuffix(str, ","), ","));
        List<Long> activeRoleIds = postRoleIds.stream()
                .flatMap(s -> Arrays.stream(s.split(","))).map(Long::parseLong)
                .collect(Collectors.toList());
        System.out.println(activeRoleIds);*/

        String path = "https://tapi.ccxcredit.com/data-service/icinfo/business/industry/company/v2";
        String url = "https://tapi.ccxcredit.com/data-service/";


        System.out.println(StrUtil.subSuf(path, url.length()));
    }
}
