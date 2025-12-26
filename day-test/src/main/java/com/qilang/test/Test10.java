package com.qilang.test;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test10 {

    public static List<String> parseFirstThreeChars(List<String> input) {
        return input.stream()
                .flatMap(code ->
                        IntStream.rangeClosed(1, code.length() / 3) // 生成层级数（如3位长度对应1层，6位对应2层）
                                .map(i -> 3 * i)                       // 转换为截取位置：3,6,9...
                                .mapToObj(i -> code.substring(0, i))
                )
                .collect(Collectors.toList());

        /*return input.stream()
                // 过滤非空且长度≥3的字符串
                .filter(s -> StrUtil.length(s) % 3 == 0)
                // 提取前3位
                .map(s -> s.substring(0, 3))
                // 去重
                .distinct()
                .collect(Collectors.toList());*/
    }

    /*public static List<String> parseHierarchy(List<String> input) {
        return input.stream()
                // 过滤无效字符串（长度非3的倍数）
                .filter(s -> StrUtil.length(s) % 3 == 0)
                // 生成所有层级（最后一层可选保留或丢弃）
                .flatMap(s -> CollUtil.range(3, s.length(), 3)
                        .stream()
                        .mapToObj(end -> StrUtil.sub(s, 0, end))
                )
                // 去重并保持顺序
                .distinct()
                .collect(Collectors.toList());
    }*/

    private static final Snowflake snowflake = IdUtil.getSnowflake(1, 1);

    /**
     * 生成8位不重复分享码（字母数字混合）
     */
    public static String generateShareCode() {
        long id = snowflake.nextId();
        return Long.toHexString(id).toUpperCase()
                + RandomUtil.randomString(2);
    }
    public static void main(String[] args) {
        /*List<String> input = CollUtil.newArrayList("001001001", "002001", "003001001","004");
        List<String> output = parseFirstThreeChars(input);
        System.out.println(output);*/


        System.out.println(generateShareCode());

        /*ShareUrlDTO shareUrlDTO = ShareUrlDTO.builder()
                .id(1917115869645307905L)
                .appCode("XD001")
                .systemCode("SJCJ001")
                .build();



        System.out.println(Base64.encode(JSON.toJSONString(shareUrlDTO)));
        System.out.println(Base64.decodeStr("eyJhY3Rpb25JZCI6MTkxNzExNTg2OTY0NTMwNzkwNSwiYWN0aXZlTmFtZSI6InRhc2tVbmRvIiwiYXBwQ29kZSI6IlhEMDAxIiwiY3VycmVudEF1ZGl0VGFzayI6IuWuoeaguOiKgueCuV8xIiwiZmxvd05vIjoi5L+h6L6+5rWL6K+V5rWB56iLQ0hZLTItMjAyNTA0MjkwMDAwMDMiLCJyZWZyZXNoIjoxLCJzeXN0ZW1Db2RlIjoiU0pDSjAwMSIsInRhZ05hbWUiOiIiLCJ0YXNrQ29kZSI6InQtMyJ9\n"));
       */// c();
        /*String params = "ASAS=1212&JAKSKAS=213132";
        Map<String, String> map = HttpUtil.decodeParamMap(params, StandardCharsets.UTF_8);
        System.out.println(JSON.toJSONString(map));*/


        /*BaseFlowRespDTO flowRespDTO = new BaseFlowRespDTO();
        flowRespDTO.setCode("1sasa");
        flowRespDTO.setNames(new ArrayList<>());
        System.out.println(JSON.toJSONString(flowRespDTO));*/


        /*List<String> list1 = new ArrayList<>();
        list1.add("121a");
        list1.add("121b");
        list1.add("121c");
        list1.add("121asa");
        list1.add("121121");
        list1.add("121weas");
        list1.add("121trtrew");
        list1.add("121aadq231");
        list1.add("121asegewq");
        list1.add("12131231gd3");
        list1.add("1weq21");
        list1.add("32da121");
        list1.add("1dsa2asd1");
        list1.add("weq121232313");
        list1.add("1qqqqq2weq1");
        list1.add("1eew2cccc1we");
        list1.add("ewqe12314421423dsa");


        List<List<String>> list2 = CollUtil.split(list1, 20);

        System.out.println(JSON.toJSONString(list2));*/

        /*boolean a = true;
        System.out.println(Convert.toStr(a));*/




        //FlowInstanceRespDTO flowInstanceRespDTO = JSON.parseObject(str2, new TypeReference<FlowInstanceRespDTO>(){});
       // System.out.println(JSON.toJSONString(flowInstanceRespDTO));
        /*FlowInstanceRespDTO flowInstanceRespDTO = new FlowInstanceRespDTO();
        AtomicInteger successNum = new AtomicInteger(0);
        flowInstanceRespDTO.setSuccessNum(successNum);
        for(int i= 0; i<10; i++) {
            flowInstanceRespDTO.getSuccessNum().addAndGet(1);
        }
        System.out.println(flowInstanceRespDTO.getSuccessNum().get());*/


    }


    public static Integer a() {
       // System.out.println("aaaa");
        return 1;
    }

    public static Integer b() {
       // System.out.println("bbb");
        return 2;
    }
    
    public static Integer c() {
        a();
        return b();
    }
}
