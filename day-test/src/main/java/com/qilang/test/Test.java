package com.qilang.test;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {


        Map<String, String> map = new HashMap<>();
        map.put("a","b");
        map.put("b","c");
        System.out.println(map.keySet());
    }
}
