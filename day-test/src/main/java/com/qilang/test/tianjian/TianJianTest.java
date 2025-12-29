package com.qilang.test.tianjian;

import cn.hutool.core.lang.UUID;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.apache.commons.lang.time.DateUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TianJianTest {

    public static void main(String[] args) {
        String cropId = "8b95a80b266f4722b7124545d86dac68";
        //指定签名使用的算法,对应jwt的header部分
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //创建jwt的payload的私有声明
        Map<String,Object> claims = new HashMap<>();
        claims.put("corpCode", cropId);
        //生成签名使用的秘钥secret
        String secret = "tjzx8866";

        //payload添加标准声明和私有声明
        JwtBuilder builder = Jwts.builder()
                //私有声明
                .setClaims(claims)
                //设置jwt的唯一标识，用来作为一次性token
                .setId(UUID.fastUUID().toString())
                //签发时间
                .setIssuedAt(new Date())
                //设置签名算法和使用的秘钥
                .signWith(signatureAlgorithm, TextCodec.BASE64.encode(secret));
        //设置过期时间
        builder.setExpiration(DateUtils.addHours(new Date(),1));
        String token = builder.compact();
        System.out.println(token);
    }



}
