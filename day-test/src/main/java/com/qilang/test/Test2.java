package com.qilang.test;

import cn.hutool.core.comparator.CompareUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.ObjectUtil;
import com.qilang.test.common.ExpressRunnerUtil;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @Author huql
 * @Description $
 * @Date $ $
 **/
public class Test2 {
    public static void main(String[] args) {


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
        System.out.println(ExpressRunnerUtil.getExpressRunner() != null);
        // TODO: 2023/4/9
        //确认执行QL执行表达式的用法 基于需求 每个ql都要校验一下
        //ExpressRunnerUtil.getExpressRunner().execute()
    }
}
