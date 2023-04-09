package com.qilang.test.common;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

import java.util.Arrays;

/**
 * @Author huql
 * @Description $
 * @Date $ $
 **/
public class SimpleUsageDemo {
    private static ExpressRunner runner = new ExpressRunner();
    private static DefaultContext<String, Object> context = new DefaultContext<>();

    static {
        context.put("a", 1);
        context.put("b", 2);
        context.put("c", 3);
        context.put("d", 5);
        context.put("e", String.valueOf(2));
        context.put("list", Arrays.asList(1, 2, 3, 4));
        context.put("list2", Arrays.asList("1", "2", "3", "4"));
        context.put("g", "2023-08-09 12:09:12");
        context.put("h", "10000.0");
    }

    private static Object process(String express) throws Exception {
        return runner.execute(express, context, null, true, false);
    }

    public static void main(String[] args) throws Exception {
        // 四则运算
        // 1 + 2 * 3 + 5 % 2 + 5 / 2 = 10
//        String express = "a + b * c + d % 2 + d / 2";
//        System.out.println("四则计算:" + process(express));


//        System.out.println("in:" + process("a in list"));
//        System.out.println("in:" + process("d in list"));

        System.out.println("e == '哈哈哈哈哈1' :" + process("e == '哈哈哈哈哈1'"));
        System.out.println("a == 1:" + process("a == 1"));
        System.out.println("b == '2':" + process("b == \"2\""));
        System.out.println("b != '2':" + process("b != \"2\""));

        context.put("name", "abc");
        System.out.println("like:" + process("name like '%abc%'"));

        System.out.println("a == e :" + process("a == e"));

        context.put("sa", "1");
        System.out.println("e in:" + process("e in list"));

        System.out.println("e in:" + process("e in list2"));


        context.put("f", "2023-08-09 12:09:12");
        System.out.println("f == g:" + process("f == g"));


        System.out.println("h == 哈哈哈哈:" + process("h == 哈哈哈哈"));

    }
}
