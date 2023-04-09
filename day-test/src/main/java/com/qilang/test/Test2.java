package com.qilang.test;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.comparator.CompareUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import com.qilang.test.common.ExpressRunnerUtil;
import com.ql.util.express.DefaultContext;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Author huql
 * @Description $
 * @Date $ $
 **/
public class Test2 {
    public static void main(String[] args) throws Exception {

        //Predicate<LinkedHashMap<String, Object>> predicate =

        //Validator.equal()

//        Simple simple1 = new Simple();
//        simple1.setId("1");
//        simple1.setName("aaa");
//        Simple simple2 = new Simple();
//        simple2.setId("1");
//        simple2.setName("aaa");
//
//
//
//        System.out.println(ObjectUtil.equal(simple1, simple2));

//        Predicate<Map<String, Object>> predicate = t -> t.get("a").equals("3");
//        Map<String, Object> map = new HashMap<>();
//        map.put("b", "3");
//        System.out.println(predicate.test(map));

//        Object a = 1;
//        String b = "1";
//        System.out.println(Validator.equal(a, b));
        //System.out.println(ExpressRunnerUtil.getExpressRunner() != null);
        // TODO: 2023/4/9
        //确认执行QL执行表达式的用法 基于需求 每个ql 表达式都要校验一下
        //ExpressRunnerUtil.getExpressRunner().execute()

//        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
//        long id = snowflake.nextId();
//        System.out.println(id);
        // =(ok)、!=、>=、>、<=、<、IN、NOT IN、LIKE、NOT LIKE
        //1. test ==


//        Map<String, Object> map = new HashMap<>();
//        map.put("aa", "国贸纸业广州区");
//        String context = map.get("aa") + "LIKE".toLowerCase() + "%国贸纸业%";
//        Predicate<Map<String, Object>> predicate = t -> {
//            Object o;
//            try {
//                o = ExpressRunnerUtil.getExpressRunner().execute(context, new DefaultContext<>(), null, true, true);
//            } catch (Exception e) {
//                return false;
//            }
//            return (boolean) o;
//        };
//        System.out.println(predicate.test(map));

        String str = "10000.00,20000";

        String[] array = str.replace("，", ",").split(",");
        Number[] numbers = {10000.00};

        //String express = "'国贸石化'" + " in " + Arrays.asList(array).toString();


//        DefaultContext<String, Object> context = new DefaultContext<>();
//        context.put("amount", 20000.00);
//        context.put("amounts" , NumberUtil.parseNumber("20000"));
//        String express = "amount == amounts";

        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("amount", 20000.00);
        context.put("amounts" , Arrays.stream(array).map(NumberUtil::parseNumber).collect(Collectors.toList()));
        String express = "amount in amounts";
        Object r =  ExpressRunnerUtil.getExpressRunner().execute(express,context, null, false,false);
        System.out.println("表达式计算：" + express + " = " + r);

    }
}
