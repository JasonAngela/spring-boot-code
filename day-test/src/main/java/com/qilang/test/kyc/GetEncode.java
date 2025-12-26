package com.qilang.test.kyc;


import cn.hutool.http.HttpStatus;

public class GetEncode {
    public GetEncode() {
    }

    public static String getSm2(String str, String key) {
        try {
            return SM2Utils.encryptByPK1(key, str);
        } catch (Exception e) {
            throw new RuntimeException("获取getSm2失败", e);
        }

    }
}
