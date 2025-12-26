package com.qilang.test.kyc;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.crypto.SecureUtil;

public class KycTest {

    public static void main(String[] args) {

        String reqTid = TidUtil.generateTid();
        System.out.println(reqTid);
        System.out.println(toGetSign(reqTid));
    }


    public static String toGetSign(String reqTid) {
        String sign = CharSequenceUtil.join(""
                , "account", "zcx_ctest"
                , "monitorDate", "2025-07-31"
                , "reqTid",  reqTid, "test123");
        //log.info("终本案件核查-加签字段组合:{}", sign);
        return SecureUtil.md5(sign).toUpperCase();
    }
}
