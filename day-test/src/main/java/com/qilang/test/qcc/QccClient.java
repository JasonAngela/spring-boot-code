package com.qilang.test.qcc;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.sun.crypto.provider.HmacSHA1;
import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hql
 */
public class QccClient {


    private static final ThreadLocal<String> params = new ThreadLocal<>();

    public static void main(String[] args) {

        long time = DateUtil.currentSeconds();
        String token = DigestUtil.md5Hex(String.format("%s%s%s", "ab8e6840bd2148bba495de647ad56e47", time, "385C3F6AA2309D913685BC4345E2591A")).toUpperCase();
        Map<String, Object> params = MapUtil.newHashMap();
        params.put("key", "ab8e6840bd2148bba495de647ad56e47");
        params.put("searchKey","WEALTH INT'L TRADE LIMITED");
        HttpResponse response = HttpRequest.get("http://api.qichacha.com/BelongGroup/GetInfo")
                .header("Token", token)
                .header("Timespan", String.valueOf(time))
                .form(params).execute();
        System.out.println(response.body());









       // System.out.println(System.currentTimeMillis());

//        String text = "{\n" +
//                "  \"caseId\": \"my customer ID\",\n" +
//                "  \"name\": \"John Doe\",\n" +
//                "  \"providerTypes\": [\"WATCHLIST\"]\n" +
//                "}";
//        String key = "1234";
//        // 构建Hmac对象，指定算法
//        HMac hmac = new HMac(HmacAlgorithm.HmacSHA256, key.getBytes());
//
//        // 进行哈希运算
//        byte[] result = hmac.digest(text.getBytes());
//        // 将结果转换为16进制字符串
//        String hexResult = HexUtil.encodeHexStr(result, false);
//
//        // 输出结果
//        System.out.println("HMAC哈希值：" + hmac.digestHex(text));

        //System.out.println(HttpMethod.GET.name().toLowerCase());




//        params.set("1");
//        params.set("2");
//        System.out.println(params.get());
//        params.remove();

        /*for (int i = 0; i<5; i++) {
            if(i == 3) {
                System.out.println(i);
                break;
            }
        }*/


    }
}
