package com.qilang.test;

import cn.hutool.core.util.URLUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.qilang.test.json.ReqestDTO;
import java.util.HashMap;

/**
 * @author huql
 **/
public class Test3 {

    public static void main(String[] args) {
        ReqestDTO reqestDTO = new ReqestDTO();
        reqestDTO.setBillCode("asasa");
        //reqestDTO.setTime("w1231");
        System.out.println(JSON.toJSONString(reqestDTO));
        //转换成key value 形式

        JSON.parseObject(JSON.toJSONString(reqestDTO), HashMap.class).forEach((k, v) -> {
            System.out.println(k + "=" + v);
        });


        System.out.println(URLUtil.encode(JSON.toJSONString(reqestDTO)));
        String str = "ea5b29320cb3d15a9883c1fa4654bd02_app=3823532979&_t=1668131644&bill_code=XD221021000709&limit=200&page=1&query_extend=%7B%22encry_address%22%3Atrue%7Dea5b29320cb3d15a9883c1fa4654bd02";
        System.out.println(SecureUtil.md5(str).toUpperCase());

    }
}
