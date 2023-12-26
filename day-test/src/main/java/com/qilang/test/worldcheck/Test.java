package com.qilang.test.worldcheck;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpMethod;

import java.net.URI;
import java.util.Date;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
//        URI uri = URI.create("https://api-worldcheck.refinitiv.com/v2/cases/screeningRequest");
//        String payload = "{\"caseScreeningState\":{\"WATCHLIST\":\"ONGOING\"},\"entityType\":\"ORGANISATION\",\"groupId\":\"5jb8cjsl3w581hr6hmnf5r935\",\"name\":\"拼多多\",\"providerTypes\":[\"WATCHLIST\"]}";
//        System.out.println(payload.getBytes().length);
//        Map<String, String> map = AuthHeadersBuilder.generateAuthHeaders("9c4f1304-904f-474c-93f5-a6182fd25f09"
//                , "BdScvwbbLCFWBoOu+kglitnWJYfVQ0QxZmjdRVHH2MypM78MezC+VDAU7/nDCtRT5BzVFPnrpyFJVLqVV2M/1w=="
//                , HttpMethod.POST.name(), uri, ContentType.JSON.getValue(), payload);
//        System.out.println(JSON.toJSONString(map));
//        HttpResponse response = HttpRequest.post("https://api-worldcheck.refinitiv.com/v2/cases/screeningRequest")
//                .headerMap(map, true).body(payload).execute();
//        System.out.println(response.getStatus());
//        System.out.println(response.body());
        System.out.println(DateUtil.offsetDay(new Date(), -17)
                .toString(DatePattern.PURE_DATE_PATTERN));
    }
}
