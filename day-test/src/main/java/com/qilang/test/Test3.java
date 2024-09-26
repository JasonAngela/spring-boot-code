package com.qilang.test;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.qilang.test.json.ReqestDTO;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

/**
 * @author huql
 **/
public class Test3 {

    public static void main(String[] args) {
        /*ReqestDTO reqestDTO = new ReqestDTO();
        reqestDTO.setBillCode("asasa");
        //reqestDTO.setTime("w1231");
        System.out.println(JSON.toJSONString(reqestDTO));
        //转换成key value 形式
        JSON.parseObject(JSON.toJSONString(reqestDTO), HashMap.class).forEach((k, v) -> {
            System.out.println(k + "=" + v);
        });

        System.out.println(URLUtil.encode(JSON.toJSONString(reqestDTO)));
        String str = "ea5b29320cb3d15a9883c1fa4654bd02_app=3823532979&_t=1682308114&bill_code=XD221021000709&limit=200&page=1&query_extend=%7B%22encry_address%22%3Atrue%7Dea5b29320cb3d15a9883c1fa4654bd02";
        System.out.println(SecureUtil.md5(str).toUpperCase());

        String suffix = CharSequenceUtil.subAfter("/a/courtAnnouncement/c", "/", false);
        System.out.println(suffix);
        String[] suffixs = suffix.split("/", 2);
        for (String s : suffixs) {
            System.out.println(s);
        }

        String[] arrays = new String[]{};*/

        //System.out.println(DateUtil.format(new Date(), DatePattern.PURE_DATE_PATTERN));

        /*String sign = DigestUtil.md5Hex(String.format("%s%s", "b91eq", DateUtil.format(new Date(), DatePattern.PURE_DATE_PATTERN)));
        System.out.println(sign);*/


    }
}
