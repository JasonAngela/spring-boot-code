package com.qilang.test.json;

import com.alibaba.fastjson.JSON;

public class Test2 {
    public static void main(String[] args) {

        String str = "{\n" +
                "        \"lat\": 31.185795,\n" +
                "        \"detail\": \"纳贤路701号百度上海研发中心F4A000\",\n" +
                "        \"town\": \"张江镇\",\n" +
                "        \"phonenum\": \"\",\n" +
                "        \"city_code\": \"310100\",\n" +
                "        \"province\": \"上海市\",\n" +
                "        \"person\": \"张三\",\n" +
                "        \"lng\": 121.612334,\n" +
                "        \"province_code\": \"310000\",\n" +
                "        \"text\": \"上海市浦东新区纳贤路701号百度上海研发中心 F4A000 张三\",\n" +
                "        \"county\": \"浦东新区\",\n" +
                "        \"city\": \"上海市\",\n" +
                "        \"county_code\": \"310115\",\n" +
                "        \"town_code\": \"310115125\",\n" +
                "        \"log_id\": 1674667526058122860\n" +
                "    }";

        BaiduAddressResponseDTO responseDTO = JSON.parseObject(str, BaiduAddressResponseDTO.class);

        responseDTO.setCustId("asasasa");

        System.out.println(JSON.toJSONString(responseDTO));
//        BaiduAddressResponseDTO baiduAddressResponseDTO = new BaiduAddressResponseDTO();
//        baiduAddressResponseDTO.setLogId(128192L);
//        baiduAddressResponseDTO.setCityCode("8231321");
//        baiduAddressResponseDTO.setCustId("82ksaodas");
//        System.out.println(JSON.toJSONString(baiduAddressResponseDTO));
//        "lat": 31.185795,
//                "detail": "纳贤路701号百度上海研发中心F4A000",
//                "town": "张江镇",
//                "phonenum": "",
//                "city_code": "310100",
//                "province": "上海市",
//                "person": "张三",
//                "lng": 121.612334,
//                "province_code": "310000",
//                "text": "上海市浦东新区纳贤路701号百度上海研发中心 F4A000 张三",
//                "county": "浦东新区",
//                "city": "上海市",
//                "county_code": "310115",
//                "town_code": "310115125",
//                "log_id": 1674667526058122860

    }
}
