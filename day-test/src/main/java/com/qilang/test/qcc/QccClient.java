package com.qilang.test.qcc;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hql
 */
public class QccClient {


    public static void main(String[] args) {

        long time = DateUtil.currentSeconds();
        String token = DigestUtil.md5Hex(String.format("%s%s%s", "ab8e6840bd2148bba495de647ad56e47", time, "385C3F6AA2309D913685BC4345E2591A")).toUpperCase();
        Map<String, Object> params = MapUtil.newHashMap();
        params.put("key", "ab8e6840bd2148bba495de647ad56e47");
        params.put("searchKey","中国石油化工股份有限公司");
        HttpResponse response = HttpRequest.get("http://api.qichacha.com/BelongGroup/GetInfo")
                .header("Token", token)
                .header("Timespan", String.valueOf(time))
                .form(params).execute();
        System.out.println(response.body());
    }
}
