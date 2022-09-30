package com.qilang.test;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
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
            int randomInt = RandomUtil.randomInt(8, 17);
//            randomString = RandomUtil.randomString(upperStr + lowerStr + numStr, randomInt);
//        }
//        System.out.println(randomString);


//        Simple simple = new Simple();
//        simple.setId("asasa");
//        simple.setName("9231jsak");
//
//        System.out.println(BeanUtil.beanToMap(simple));
//
//
//        String str = "1231212a";
//
//        Pattern p = Pattern.compile("[a-zA-z]");
//
//        System.out.println(p.matcher(str).find());
//
//        List<String> list1 = new ArrayList<>();
//        list1.add("1122");
//        list1.add("2321");
//        list1.add("2asa321");
//
//
//        List<String> list2 = new ArrayList<>();
//        list2.add("1122");
//        list2.add("2320");
//        list2.add("2321");
//        list2.add("2321xxx");
//        list2.add("2asa321");
//
//        System.out.println(list1.containsAll(list2));
//
//        System.out.println(CollUtil.containsAll(list1, list2));
//        List<String> sub = (List<String>) CollUtil.subtract(list2, list1);
//        System.out.println(sub);

        Set<String> mdmCodes = new HashSet<>();
        mdmCodes.add("12sasa");
        mdmCodes.add("opo09102");
        mdmCodes.add("8723nksada");

        AtomicReference<String> param = new AtomicReference<>("");
        mdmCodes.forEach(m -> param.set(param.get() + "mdm_code = '" + m + "' || "));

        System.out.println(param.get());


        System.out.println(CharSequenceUtil.subBefore(param.get(),"||", true));


    }
}
