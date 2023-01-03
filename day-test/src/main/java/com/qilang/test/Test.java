package com.qilang.test;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.HashUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.cron.CronUtil;
import cn.hutool.cron.pattern.CronPattern;
import cn.hutool.cron.pattern.CronPatternUtil;
import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;
import org.bouncycastle.crypto.RuntimeCryptoException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.Security;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Test {


    private static final String upperStr="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lowerStr="abcdefghijklmnopqrstuvwxyz";
    private static final String numStr="1234567890";



    public static void main(String[] args) throws ParseException, UnsupportedEncodingException {


//        Map<String, String> map = new HashMap<>();
//        map.put("a", "b");
//        map.put("b", "c");
//        System.out.println(map.keySet());
//
//
//        List<String> list = new ArrayList<>();
//        Map<String,String> map1 = list.stream().collect(Collectors.toMap(k -> k, v -> v));
//        List<String> list1 = new ArrayList<>();
//        list1.add("12");
//        map1.keySet().removeAll(list1);
//        System.out.println(map1.keySet());
//        int randomIntA = RandomUtil.randomInt(4, 9);
//        int randomIntB = RandomUtil.randomInt(4, 9);
//
//        String a = RandomUtil.randomString(4);
//        String b = RandomUtil.randomStringUpper(4);
//
//        System.out.println(CharSequenceUtil.appendIfMissing(a, b));


//        String randomString="";
//        while (!(StrUtil.containsAny(randomString, upperStr) && StrUtil.containsAny(randomString,lowerStr) && StrUtil.containsAny(randomString,numStr))){
//            // 生成8到17之间的随机整数(包含8不包含17)
            //int randomInt = RandomUtil.randomInt(8, 17);
//            randomString = RandomUtil.randomString(upperStr + lowerStr + numStr, randomInt);
//        }
//        System.out.println(randomString);


//        Simple simple = new Simple();
//        simple.setId("asasa");
//        simple.setName("9231jsak");
//
//        System.out.println(BeanUtil.beanToMap(simple));
//
//
//        String str = "1231212a";
//
//        Pattern p = Pattern.compile("[a-zA-z]");
//
//        System.out.println(p.matcher(str).find());
//
//        List<String> list1 = new ArrayList<>();
//        list1.add("1122");
//        list1.add("2321");
//        list1.add("2asa321");
//
//
//        List<String> list2 = new ArrayList<>();
//        list2.add("1122");
//        list2.add("2320");
//        list2.add("2321");
//        list2.add("2321xxx");
//        list2.add("2asa321");
//
//        System.out.println(list1.containsAll(list2));
//
//        System.out.println(CollUtil.containsAll(list1, list2));
//        List<String> sub = (List<String>) CollUtil.subtract(list2, list1);
//        System.out.println(sub);

//        Set<String> mdmCodes = new HashSet<>();
//        mdmCodes.add("12sasa");
//        mdmCodes.add("opo09102");
//        mdmCodes.add("8723nksada");
//
//        AtomicReference<String> param = new AtomicReference<>("");
//        mdmCodes.forEach(m -> param.set(param.get() + "mdm_code = '" + m + "' || "));
//
//        System.out.println(param.get());
//
//
//        System.out.println(CharSequenceUtil.subBefore(param.get(),"||", true));

        //System.out.println(Integer.toBinaryString(123));
//        long i = 1;
//        int j = 1;
//        System.out.println(i == j);

       // 0 0 10 * * ?
       // 59 59 23 * * ?

        //CronPatternUtil.matchedDates()

//        CronPattern cronPattern = new CronPattern("0 0 10 * * ?");
//        cronPattern.

//        Date nextValidTime = new CronExpression("59 59 23 * * ?").getNextValidTimeAfter(new Date());
//        System.out.println(DateUtil.format(nextValidTime, "yyyy-MM-dd HH:mm:ss"));

//        Date date1 = DateUtil.parse("2022-12-05 17:47:40.869", "yyyy-MM-dd HH:mm:ss.SSS");
//        System.out.println(date1);
//
//        Date date2 = DateUtil.parse("2022-12-05", "yyyy-MM-dd");
//        System.out.println(date2);
//
//        System.out.println(DateUtil.isSameDay(date1, date2));

          //appkey={AppKey},nonce={Nonce},timestamp ={Timestamp}

        //aub1_e377jw9l5o

        //BeuaYzzMMg6yHtdtBEjdltTpDum3hKdZ


        //12512612712
        //则待签名字符串为：

        //appkey=aub1_4a9e943yqvn, nonce = aef3b69aeec, timestamp = 1544817600

//        第二步：签名数据
//        需要使用使用 HMAC SHA256 算法，以 AppKey 作为 key，
//        对上述拼接后的字符串计算 HMAC哈希。需要将待签名字符串、以及App Secret 的
//        UTF8 编码后，再进行哈希。哈希后的数据，需要转为 hex 格式，并转小写。


//        byte[] key = "aub1_4a9e943yqvn".getBytes();
//        HMac mac = new HMac(HmacAlgorithm.HmacSHA256, key);
//        String signature = "appkey=aub1_4a9e943yqvn,nonce=12512612712,timestamp=1670490413";
//        String appKetSign = mac.digestHex(signature);
//        System.out.println(appKetSign);



//        byte[] key = "BeuaYzzMMg6yHtdtBEjdltTpDum3hKdZ".getBytes();
//        HMac mac = new HMac(HmacAlgorithm.HmacSHA256, key);
//        System.out.println(mac.digestHex("appkey=aub1_e377jw9l5o,nonce=12516GGGGG,timestamp=1670556584"));

        //appSercrt
//        byte[] key2 = "BeuaYzzMMg6yHtdtBEjdltTpDum3hKdZ".getBytes();
//        HMac mac2 = new HMac(HmacAlgorithm.HmacSHA256, key2);
//        mac2.digestHex()
// b977f4b13f93f549e06140971bded384
        //String macHex1 = mac.digestHex(testStr);
        //System.out.println(encrytSHA256("appkey=aub1_e377jw9l5o,nonce=12512612712111,timestamp=1670512731", "BeuaYzzMMg6yHtdtBEjdltTpDum3hKdZ"));


        String str = "中建一局集团建设发展有限公司";



        System.out.println(new String(str.getBytes(), StandardCharsets.UTF_8));

    }

    public static String encrytSHA256(String content, String secret) {
        try {
            Security.addProvider(new BouncyCastleProvider());
            SecretKey secretKey = new SecretKeySpec(secret.getBytes("UTF8"), "HmacSHA256");
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
            mac.init(secretKey);
            byte[] digest = mac.doFinal(content.getBytes("UTF-8"));
            return new HexBinaryAdapter().marshal(digest).toLowerCase();
        } catch (Exception e) {
            throw new RuntimeCryptoException("加密异常");
        }
    }
}
