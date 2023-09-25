package com.qilang.test;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ObjectUtil;
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


        Object a = null;
        Object b = "1212";
        Object c = new ArrayList<>();
        System.out.println(ObjectUtil.isAllNotEmpty(a, b, c));


        String json = "{\n" +
                "    \"Status\": \"201\",\n" +
                "    \"Message\": \"【有效请求】查询无结果\",\n" +
                "    \"OrderNumber\": \"BELONGGROUP2023052915234078676625\",\n" +
                "    \"Result\": null\n" +
                "}";

        QccResponseDTO qccResponseDTO = JSON.parseObject(json, QccResponseDTO.class);
        System.out.println(ObjectUtil.isNotNull(qccResponseDTO) && ObjectUtil.isNotNull(qccResponseDTO.getResult()) && ObjectUtil.isNotNull(qccResponseDTO.getResult().getData()));
        //System.out.println(!ObjectUtil.isAllNotEmpty(qccResponseDTO, qccResponseDTO.getResult(), qccResponseDTO.getResult().getData()));


//        System.out.println(qccResponseDTO);
//        System.out.println(qccResponseDTO.getResult());
//        System.out.println(qccResponseDTO.getResult()).;
    }
}
