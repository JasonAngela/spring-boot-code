package com.qilang.test;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {


    private static final String upperStr="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lowerStr="abcdefghijklmnopqrstuvwxyz";
    private static final String numStr="1234567890";



    public static void main(String[] args) {


//        Map<String, String> map = new HashMap<>();
//        map.put("a", "b");
//        map.put("b", "c");
//        System.out.println(map.keySet());
//
//
//        List<String> list = new ArrayList<>();
//        Map<String,String> map1 = list.stream().collect(Collectors.toMap(k -> k, v -> v));
//        List<String> list1 = new ArrayList<>();
//        list1.add("12");
//        map1.keySet().removeAll(list1);
//        System.out.println(map1.keySet());
        int randomIntA = RandomUtil.randomInt(4, 9);
        int randomIntB = RandomUtil.randomInt(4, 9);

        String a = RandomUtil.randomString(4);
        String b = RandomUtil.randomStringUpper(4);

        System.out.println(CharSequenceUtil.appendIfMissing(a, b));


//        String randomString="";
//        while (!(StrUtil.containsAny(randomString, upperStr) && StrUtil.containsAny(randomString,lowerStr) && StrUtil.containsAny(randomString,numStr))){
//            // 生成8到17之间的随机整数(包含8不包含17)
//            int randomInt = RandomUtil.randomInt(8, 17);
//            randomString = RandomUtil.randomString(upperStr + lowerStr + numStr, randomInt);
//        }
//        System.out.println(randomString);


        Simple simple = new Simple();
        simple.setId("asasa");
        simple.setName("9231jsak");

        System.out.println(BeanUtil.beanToMap(simple));
    }
}
