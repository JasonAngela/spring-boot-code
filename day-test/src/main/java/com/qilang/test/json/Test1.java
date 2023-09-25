package com.qilang.test.json;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {

//        Map<String, Object> map = new HashMap<>();
//        map.put("1212", 89);
//        map.put("12121121", "LLLL");
//
//        OverdueReqStrDTO overdueReqStrDTO = new OverdueReqStrDTO();
//        overdueReqStrDTO.setPageNo(1);
//        overdueReqStrDTO.setPageSize(50);
//        overdueReqStrDTO.setInFields(JSON.toJSONString(map));
//        System.out.println(JSON.toJSONString(overdueReqStrDTO));
//
//
//        BigDecimal bigDecimal = new BigDecimal("0.21");
//        String str = "0.21";
//        System.out.println(ObjectUtil.equal(bigDecimal, str));

//        Object s = "";
//        System.out.println(ObjectUtil.equal("", s));

//        Map<String, Object> map = MapUtil.newHashMap();
//        map.put("asas", null);
        List<Object> list = new ArrayList<>();
        list.add("ASKLSA");
        list.add(989);
        list.add(2839128312L);
        System.out.println(CharSequenceUtil.join(":", list));

        BigDecimal a = new BigDecimal(188.360);
        BigDecimal b = new BigDecimal(188.36);
        System.out.println(ObjectUtil.equal(a, b));
    }
}
