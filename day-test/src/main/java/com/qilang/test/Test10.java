package com.qilang.test;

import cn.hutool.core.collection.CollUtil;

import java.util.ArrayList;
import java.util.List;

public class Test10 {
    public static void main(String[] args) {



        c();
    }


    public static Integer a() {
        System.out.println("aaaa");
        return 1;
    }

    public static Integer b() {
        System.out.println("bbb");
        return 2;
    }
    
    public static Integer c() {
        a();
        return b();
    }
}
