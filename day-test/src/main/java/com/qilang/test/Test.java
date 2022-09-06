package com.qilang.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {


        Map<String, String> map = new HashMap<>();
        map.put("a", "b");
        map.put("b", "c");
        System.out.println(map.keySet());


        List<String> list = new ArrayList<>();
        Map<String,String> map1 = list.stream().collect(Collectors.toMap(k -> k, v -> v));
        List<String> list1 = new ArrayList<>();
        list1.add("12");
        map1.keySet().removeAll(list1);
        System.out.println(map1.keySet());
    }
}
