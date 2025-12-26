package com.qilang.test.json;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

import static cn.hutool.core.date.DatePattern.NORM_DATE_FORMAT;

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
        /*List<Object> list = new ArrayList<>();
        list.add("ASKLSA");
        list.add(989);
        list.add(2839128312L);
        System.out.println(CharSequenceUtil.join(":", list));

        BigDecimal a = new BigDecimal(188.360);
        BigDecimal b = new BigDecimal(188.36);
        System.out.println(ObjectUtil.equal(a, b));*/

        /*WsdResDTO resDTO1 = new WsdResDTO();
        resDTO1.setFaLatelyyear2("asasasa");


        WsdResDTO resDTO2 = new WsdResDTO();
        resDTO2.setFaLatelyyear2("asasasa");


        List<WsdResDTO> resDTOList = new ArrayList<>();
        resDTOList.add(resDTO1);
        resDTOList.add(resDTO2);

        //System.out.println(JSON.toJSONString(resDTOList));
        System.out.println(convert(resDTOList));*/
        /*Date startDate = DateUtil.parse("2025-09-01", DatePattern.NORM_DATE_FORMAT);
        // 减一天
        Date modifiedDate = DateUtil.offsetDay(new Date(), -4);
        //格式化
        String modifiedTime = DateUtil.format(modifiedDate, DatePattern.NORM_DATE_FORMAT);
        System.out.println(modifiedTime);*/

       /* Date changeDate = DateUtil.parse("2025-09-01", DatePattern.NORM_DATE_FORMAT);

        System.out.println(DateUtil.format(changeDate, DatePattern.NORM_DATE_FORMAT).compareTo(modifiedTime) <= 0);*/
        /*List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        a.add("3");

        List<String> b = new ArrayList<>();
        b.add("2");
        b.add("3");
        b.add("4");
        b.add("1");


        System.out.println(CollUtil.subtractToList(a, b));*/


        RSA rsa = new RSA(null,"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuo/mB3ibeeIMPRBKHngDXj8JNlvbjvVwBLZ5qCDeZFLyJCtMeBPSTXNz0c//ZfrSqkZMtz+6hbJCmLcDRKaGNz7GPq5ZErt/129eB+HSvGsWOH4BexV9OVj62OECS0Uyf1hh/Q0Cr+Goi6IWWdQ3SOVgo1MKB0cTBKWGzxouIZ2RWTv7hm4jQH9CFBPjLpAF5A3nKZxsP46gjM3kcLQfwivzYNIjUfCnjkw7OG0U2FkLuVL0dp033DDzBqyVD3zkNGdf+9p2hOwXgS5ePx1RZ6cv1elpNevA6OqmwQo8dqpirtOTUJZr9ZU2m3+gChLVtBM1bUcOdf5EXzybiOZ2bQIDAQAB");
        //对秘钥进行加密传输，防止篡改数据
        String encryptSecret = rsa.encryptBase64("123456789", CharsetUtil.CHARSET_UTF_8, KeyType.PublicKey);
        System.out.println(encryptSecret);


        RSA rsa1 = new RSA("MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC6j+YHeJt54gw9EEoeeANePwk2W9uO9XAEtnmoIN5kUvIkK0x4E9JNc3PRz/9l+tKqRky3P7qFskKYtwNEpoY3PsY+rlkSu3/Xb14H4dK8axY4fgF7FX05WPrY4QJLRTJ/WGH9DQKv4aiLohZZ1DdI5WCjUwoHRxMEpYbPGi4hnZFZO/uGbiNAf0IUE+MukAXkDecpnGw/jqCMzeRwtB/CK/Ng0iNR8KeOTDs4bRTYWQu5UvR2nTfcMPMGrJUPfOQ0Z1/72naE7BeBLl4/HVFnpy/V6Wk168Do6qbBCjx2qmKu05NQlmv1lTabf6AKEtW0EzVtRw51/kRfPJuI5nZtAgMBAAECggEAHv0kEn2gJcC8k7AO/7yjopYJ67OaZsayErZUwu6iwjtc6VEf5Jo2RpM029cW71OYhpwixhWZ3/daRI+xxUd759VPjL3dIdVvSNPA5MJIBPAswrl7eXx6TnpPQJMvlF0sJCcEL8pndduf6YHFAKrVfBBN2xNCCS9vI0hzehc5Lm/7ANnZS+UJ/wfJK5Pap+v2+LpSLRDo3zdT7VSfpySAsE76raa8FuB/HD6ikDoZ5q41j3czhbwHnemoW7IYoYGqEshNPPMfd6W97S1ZJym8WmkDmhCEU/tstFXPW6o27PvRwTkY/NomMXlOcU6xqN5H57MlZ5kXfuiSiooiRfqmaQKBgQDumZAjIyE+RiulUg2FEkXevlW0xrItUfnYgFIyUEIKmlKfc9w5N5LVqX9uEa28YMhbiH1/94JaMrdt95xWzNORszvqTDFz7vKr7WEemlLYrP4IsqzCczXn9PUCO8LkMbwHqcP87JVFoCV1+tJe0tNVuzMBlUVxQiIlImhcoBQ99wKBgQDIKtbUcXMKahT1tkoi8srEUKFRTSkJQrS8prz0TrjrCspZIaa3mUtiIE12324R2jDIU4ay4xt+F7CWwidsOIra16eIMA0uKs4Q4FdgXdgrZ1VXCe4w+n9F7w5XllCMor6Bd9keUR4Y8C++HtbbKiyfG7/dbUbqMgYipRXKW/uluwKBgHAnsv8xRjEVnvKJDV3d5wX7BiKBu8Nd40mHmBuaalC9ldTqCzzCCL1yfTnqCXahL80G7ac3Wwi3Ck4gtFaA1XqJe8J4qk5Kpbt3S82s0QCU4JyKEHce3Nn55Sl1mfjWAALCJCRBuTEPREye6EA2bazA4AsAdbH1WkOGVvQjMyClAoGBALI0QXJ9VjgNXX+rvLEEirTgO95P3ZrbAmF56HtwonzO7HsR1IVcOpqvu4d7P1kxcYDHrAIS4uUNXi+5xrM4W5adrA85CGLzxOWNdPzcT5nEs1t8Ac0lFq5CN/iOYEP0l7pX4rp06WC2ZSrT9eDE2VkFsXkG0r2pr4CkjJPN9GoFAoGBAIW7k4UhnHcgyB+oOwROe/o3HAPyZINFYbnQeRYcoTenfTWmsaxQF9g2ZHUDuWwrI0txj7iXe6OAEOrEHYoonfFeT8Zu+v/3dZ8sKCLBY65OojolfZDl3La76bI1ZzeZrWmOMh4cICx+pboPk0BHbMFnmIHQEMsQjirPxOWHMjNy", null);
        String pass =  rsa1.decryptStr(encryptSecret, KeyType.PrivateKey);
        System.out.println(pass);
    }


    public static List<Map<String, Object>> convert(List<?> list) {
        String jsonString = JSON.toJSONString(list);
        return JSON.parseObject(jsonString,
                new TypeReference<List<Map<String, Object>>>(){});
    }
}
