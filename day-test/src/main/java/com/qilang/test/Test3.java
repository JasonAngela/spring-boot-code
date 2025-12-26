package com.qilang.test;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.qilang.test.json.ReqestDTO;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
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
        /*String password = "kfa9aDqcrqWPzDXPjp3VObiP+B7nlN+N7Yh71ij4k5lyalVA8KrB6HglSrnbp5WCiLWZBeeDmnT93n6tcZHzg9FIcmN8RLxe0Umh/Xhnlobs7HvDH9XyjQvUUHJljtrRSRMJiN9m6EjproCf/9YvwHR5Ah6eF9GErdy5I2VBZUcx9eNWwO93orvFwmS2SoF7tRhqnDot9ZIdmeJeCo06k7p4D9vg4vqYtaYLjg0TsXKzOQj2J7VL0gtGdmnVLbRcti1oCYvD6B/TyZAirqSKpf83TVRZMPZ1qoYZ87IojYJu5tPdRqVEodrh3dmpEK6bAV5EnvEfY8XYj2aissdvow==";

        String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDaAooxhQVOMZ/ePLmFEHPQ91+aIxh8oG//cnBgWvIjKqTBRNZZQ7FjBRHShuk7K+IIA1/FiHAMOWvZzrhP36En0ddLLTWDJHci7tuTTNnf4PjzdjlQVUXUa6n1V/NFMc8ktuf4Taq1Wgw09Q4D64JyBplcyx1zmzt72LPAefcQrqUTu6HcUtybN2vNq4vadnQSYa57vR+lUJh5e8zWnzE0pQwigQ+XJ1lncWGldmCJ9xPsIAxHkoPGFJ2yEqo1s9wz8px2wtBLqnO3A4mQ6bFFCrfhUaVTa6Ux/i1OTrWw7zHlrXFrMz9HaD96p6GsJ8yvuB5oxxURBtxxWhjIXvdVAgMBAAECggEASCRlBKQHMGv9gjZIEf9yw+jISyJn/P2+ciK1iz0tOXPoF0inQdzDu4e28RrR3VHVN1+edqiCo5jw1p+woEXZd2raOrdYKPCNOBMguCrLQmmZGD+8EZhWRkfmcxjKmNA1wul/88wHvIFy3qdlHuj1PrRuVaWlNlddJMt+GCiEGJGFwjMolVdlT6PHlZbuFUxK16sNuAgTQ6HWdoFY5LBBFNBl0MgFjvPgpK+yL4gpgyrhsVAg1Tln2PMqD2FHACgMmELkMwyjGDAZrHNY7KfIyGJinFDrlFL4iG3sNMO0PbzYsWY5rnaE2Y1kbNYX1+JhlN35H50/VUalSPMv4Z3MAQKBgQD8E5GFVRWGcY/QkGZDj2euDUDgxCqGnOU7vaTmRo1SMfVOQLh9OtnqWn1P7CHfjx9ia8cFlbZQvP6t66eE7wlu/NkQrdfvz3Cn9aWxBD7RWND3/o0Eduj63A3zdzf6uCgPtFOvAiZ3uyAjTfxLZH2MF6VKlKneT4POol/TezcRAQKBgQDdZzqXwmQnOnaFfc99t3/ba/TpHSaw7aJbfYDOn4sjtfPtgp58QFtF8PwoHTC/gN0vG9MLqQQSzjesV6qi8Id0EeMKRMgxs3Gq1qNAM/wzgc7KcUBo2Ng2fsys+KZFShjBWOtscXnP6phhLgVKJTeplB/V/l6BDs6JLhpbV6RSVQKBgQDd7sycO0DsUWdxFPE0YjnCP+DzA0L9qX0Zj+py44Lg7yMudkT33KynbGwPxbI9BeF34bQj8p/FjeAcd/HRVDNWCD+EM8p+VIC3H8t1gmtcHXo+HVtCpv6QftW5mSksEJ8U1Iso9hewKowtCSgrqJnwkZDxjNnR5OgDMWp043KkAQKBgDM6e3g55mqdQGdK4QO5vb/LjvORZy5xDawVsgQdLlio9TPzkTA2w+e/BtlRR8JH0uXfjkmYZfTj+kXKUxU4il709I+fsqKtXpOk7kkgvi48zthQtBKOehjB5iHvtqk5p9i09mQ1LXZKVc/GkjrBuctnFqaxILTD9E4ReM/By6exAoGBAMiDLYolWTloEMecgmvSN7aMNC0SrVuEUKWgB9DaZmcZAATN9zsTMhkYM+T8bvqApby8VhR5V0DrGLKgP47JYklUrDOJQwbHOONPgx4a9GYURH3393pWu0axUrI7b9PHrH+EIMxgr+neICOEtnAyZIYqmwOQOYvVljwHAZOdJe4M";
        RSA rsa = new RSA(privateKey, null);
        String pass = rsa.decryptStr(password, KeyType.PrivateKey);
        System.out.println(pass);*/
        System.out.println( DateUtil.format(DateUtil.beginOfDay(DateUtil.parse("2025-11-01")), DatePattern.NORM_DATETIME_FORMAT));

        System.out.println( DateUtil.format(DateUtil.endOfDay(DateUtil.parse("2025-11-01")), DatePattern.NORM_DATETIME_FORMAT));
    }
}
