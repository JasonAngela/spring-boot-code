package com.qilang.test.json;

import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.BCUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.SM2;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;

import java.security.KeyPair;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        //String str = "[{\"debttoassets\":47.2684,\"fa_Latelyyear2\":2020.0,\"net_profit_is\":628195940.09,\"stmnote_seg_1701\":19257216397.08,\"tax\":173753870.48,\"tot_assets\":20484494619.23,\"tot_equity\":10801794822.08,\"tot_liab\":9682699797.15,\"tot_oper_rev\":19909350658.56,\"tot_profit\":801949810.57,\"yoy_or\":2.2463,\"yoyop\":22.1739,\"yoyop2\":7.102974652302159,\"yoyprofit\":12.404397944266565},{\"debttoassets\":34.8986,\"fa_Latelyyear2\":2021.0,\"net_profit_is\":1133032824.33,\"stmnote_seg_1701\":23141074192.25,\"tax\":250083899.72,\"tot_assets\":18062119861.99,\"tot_equity\":11758696580.07,\"tot_liab\":6303423281.92,\"tot_oper_rev\":23468553115.67,\"tot_profit\":1383116724.05,\"yoy_or\":17.877,\"yoyop\":71.2211,\"yoyop2\":147.80747787040775,\"yoyprofit\":80.36296512321827},{\"debttoassets\":30.8768,\"fa_Latelyyear2\":2022.0,\"net_profit_is\":1060938997.15,\"stmnote_seg_1701\":19618633967.92,\"tax\":298949122.78,\"tot_assets\":18100294856.56,\"tot_equity\":12511499192.28,\"tot_liab\":5588795664.28,\"tot_oper_rev\":19918051356.78,\"tot_profit\":1359888119.93,\"yoy_or\":-15.4567,\"yoyop\":-1.7942,\"yoyop2\":-29.71161820162147,\"yoyprofit\":-6.070992429698666},{\"debttoassets\":NaN,\"fa_Latelyyear2\":2022.0,\"net_profit_is\":NaN,\"stmnote_seg_1701\":NaN,\"tax\":NaN,\"tot_assets\":NaN,\"tot_equity\":NaN,\"tot_liab\":NaN,\"tot_oper_rev\":NaN,\"tot_profit\":NaN,\"yoy_or\":NaN,\"yoyop\":NaN,\"yoyop2\":NaN,\"yoyprofit\":NaN}]";
//        DateDemo dateDemo =  JSON.parseObject(str, DateDemo.class);
//        System.out.println(dateDemo.getDebtToassets());

        // 创建一个 JSON 数组字符串
        //String jsonArrayStr = "[{\"name\": \"John\", \"age\": 30}, {\"name\": \"Jane\", \"age\": 25}]";

        // 解析 JSON 数组字符串
        //JSONArray jsonArray = JSON.parseArray(jsonArrayStr);

        // 遍历 JSONArray 并对每个 JSONObject 添加新属性
        /*for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            // 添加新的属性
            jsonObject.put("gender", i % 2 == 0 ? "male" : "female");
            jsonObject.put("id", i + 1);
            jsonObject.put("active", true);
        }*/

        // 打印修改后的 JSONArray
        //System.out.println(jsonArray.toJSONString());


        //KeyPair pair = SecureUtil.generateKeyPair("SM2");

        //创建sm2 对象
        SM2 sm2 = SmUtil.sm2();
        //这里会自动生成对应的随机秘钥对 , 注意！ 这里一定要强转，才能得到对应有效的秘钥信息
        byte[] privateKey = BCUtil.encodeECPrivateKey(sm2.getPrivateKey());
        //这里公钥不压缩  公钥的第一个字节用于表示是否压缩  可以不要
        //byte[] publicKey = ((BCECPublicKey) sm2.getPublicKey()).getQ().getEncoded(false);
        //这里得到的 压缩后的公钥   ((BCECPublicKey) sm2.getPublicKey()).getQ().getEncoded(true);
         byte[] publicKeyEc = BCUtil.encodeECPublicKey(sm2.getPublicKey());
        //打印当前的公私秘钥
        System.out.println("私钥: " + HexUtil.encodeHexStr(privateKey).toUpperCase());
        System.out.println("公钥: " + HexUtil.encodeHexStr(publicKeyEc).toUpperCase());

    }
}
