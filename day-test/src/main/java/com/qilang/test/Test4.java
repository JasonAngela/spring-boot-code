package com.qilang.test;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Test4 {


    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("page", 1);
        map.put("limit", 100);
        map.put("bill_code", "XXU1231");
        map.put("_app", 12319);
        map.put("_sign", "DU18291QW");
        map.put("_t", "1212121");
        System.out.println(map);
        System.out.println(MapUtil.joinIgnoreNull(map, "&", "=", CharSequenceUtil.EMPTY));

//        TreeMap treeMap = MapUtil.sort(map, Comparator.comparing((o1, o2) -> {
//        }));
//        System.out.println(treeMap);
//        System.out.println(MapUtil.joinIgnoreNull(treeMap, "&", "=", CharSequenceUtil.EMPTY));
    }
}
