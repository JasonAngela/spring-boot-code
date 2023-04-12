package com.qilang.test;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.*;
import cn.hutool.cron.CronUtil;
import cn.hutool.cron.pattern.CronPattern;
import cn.hutool.cron.pattern.CronPatternUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.jwt.JWTUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.compress.utils.Lists;
import org.bouncycastle.crypto.RuntimeCryptoException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.Security;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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


//        String str = "中建一局集团建设发展有限公司";
//
//
//
//        System.out.println(new String(str.getBytes(), StandardCharsets.UTF_8));

        //System.out.println();
        // LocalDateTimeUtil.of);
        //System.out.println(LocalDateTimeUtil.of(new SimpleDateFormat("yyyyMMdd").parse("20220617")));


//        Date now = new Date();
//        DateTime dateTime = DateUtil.parseDate(DateUtil.format(now, DatePattern.NORM_DATE_PATTERN));
//
//
//        Date startData = new CronExpression("0 0 0 1 * ?").getNextValidTimeAfter(DateUtil.parseDate("2023-02-01"));
//        Date endData = new CronExpression("0 4 0 2 * ?").getNextValidTimeAfter(DateUtil.parseDate("2023-02-01"));
//
//
//
//        System.out.println(DateUtil.format(startData, DatePattern.NORM_DATETIME_PATTERN));
//
//        System.out.println(DateUtil.format(endData, DatePattern.NORM_DATETIME_PATTERN));
//
//        System.out.println(DateUtil.format(new Date(), DatePattern.NORM_DATE_PATTERN));




        String data = "{\n" +
                "    \"code\": \"0\",\n" +
                "    \"msg\": \"success\",\n" +
                "    \"column\": null,\n" +
                "    \"deleteList\": [],\n" +
                "    \"data\": {\n" +
                "        \"pk_id\": \"431\",\n" +
                "        \"corpId\": \"431\",\n" +
                "        \"name\": \"北京百度网讯科技有限公司\",\n" +
                "        \"queryName\": \"北京百度网讯科技有限公司\",\n" +
                "        \"corpVersion\": \"\",\n" +
                "        \"fatherId\": \"0\",\n" +
                "        \"creditCode\": \"91110000802100433B\",\n" +
                "        \"companyOrgType\": \"有限责任公司(自然人投资或控股)\",\n" +
                "        \"legalPersonName\": \"梁志祥\",\n" +
                "        \"legalType\": \"1\",\n" +
                "        \"legalPersonId\": \"12087025\",\n" +
                "        \"regCapital\": \"1342128.000000万人民币\",\n" +
                "        \"fromTime\": \"2001-06-05 00:00:00\",\n" +
                "        \"toTime\": null,\n" +
                "        \"estiblishTime\": \"2001-06-05 00:00:00\",\n" +
                "        \"regInstitute\": \"北京市海淀区市场监督管理局\",\n" +
                "        \"orgApprovedInstitute\": \"\",\n" +
                "        \"approvedTime\": \"2022-12-26 00:00:00\",\n" +
                "        \"regStatus\": \"存续（在营、开业、在册）\",\n" +
                "        \"regLocation\": \"北京市海淀区上地十街10号百度大厦2层\",\n" +
                "        \"businessScope\": \"一般项目：技术服务、技术开发、技术咨询、技术交流、技术转让、技术推广；计算机软硬件及辅助设备零售；软件开发；计算机系统服务；信息系统集成服务；数据处理服务；数字内容制作服务（不含出版发行）；软件销售；计算机软硬件及辅助设备批发；电子产品销售；电子元器件批发；电子元器件零售；机械设备租赁；广告制作；广告发布；广告设计、代理；专业设计服务；市场营销策划；会议及展览服务；信息技术咨询服务；企业管理咨询；社会经济咨询服务；家用电器销售；机械设备销售；五金产品批发；五金产品零售；玩具、动漫及游艺用品销售；游艺用品及室内游艺器材销售；照相机及器材销售；化妆品批发；化妆品零售；个人卫生用品销售；体育用品及器材批发；体育用品及器材零售；针纺织品销售；服装服饰零售；服装服饰批发；鞋帽零售；鞋帽批发；日用品销售；日用品批发；珠宝首饰零售；珠宝首饰批发；工艺美术品及礼仪用品销售（象牙及其制品除外）；工艺美术品及收藏品批发（象牙及其制品除外）；钟表销售；眼镜销售（不含隐形眼镜）；玩具销售；办公用品销售；摩托车及零配件零售；摩托车及零配件批发；仪器仪表销售；家具销售；塑料制品销售；建筑材料销售；通讯设备销售；食品销售（仅销售预包装食品）；保健食品（预包装）销售；货物进出口；技术进出口；进出口代理；汽车零部件及配件制造；汽车零配件零售；汽车零配件批发；汽车销售；健康咨询服务（不含诊疗服务）；票务代理服务；翻译服务；第一类医疗器械销售；第二类医疗器械销售。（除依法须经批准的项目外，凭营业执照依法自主开展经营活动）许可项目：基础电信业务；第一类增值电信业务；第二类增值电信业务；网络文化经营；出版物零售；出版物批发；演出经纪；职业中介活动；广播电视节目制作经营；信息网络传播视听节目；互联网新闻信息服务；测绘服务。（依法须经批准的项目，经相关部门批准后方可开展经营活动，具体经营项目以相关部门批准文件或许可证件为准）（不得从事国家和本市产业政策禁止和限制类项目的经营活动。）\",\n" +
                "        \"overseas\": null,\n" +
                "        \"updatetime\": \"2023-02-25 00:00:00\",\n" +
                "        \"taxNumber\": \"91110000802100433B\",\n" +
                "        \"orgNumber\": \"802100433\",\n" +
                "        \"regNumber\": \"110108002734659\",\n" +
                "        \"categoryScore\": null,\n" +
                "        \"percentileScore\": null,\n" +
                "        \"industry\": \"科技推广和应用服务业\",\n" +
                "        \"socialStaffNum\": \"5013\",\n" +
                "        \"staffNumRange\": \"5013\",\n" +
                "        \"corpAlias\": null,\n" +
                "        \"actualCapital\": \"1342128万人民币\",\n" +
                "        \"logo\": null,\n" +
                "        \"property3\": \"\",\n" +
                "        \"sourceFlag\": \"yonyou\",\n" +
                "        \"flag\": \"0\",\n" +
                "        \"correctCompanyId\": null,\n" +
                "        \"updateTimes\": \"2023-02-25 00:00:00\",\n" +
                "        \"base\": \"bj\",\n" +
                "        \"bondName\": \"\",\n" +
                "        \"bondNum\": \"\",\n" +
                "        \"historyNames\": \"-\",\n" +
                "        \"bondType\": null,\n" +
                "        \"companyId\": null,\n" +
                "        \"localUpdateTime\": null,\n" +
                "        \"entityType\": null,\n" +
                "        \"cacheType\": null\n" +
                "    }\n" +
                "}";


//        JSONObject jsonObject = JSON.parseObject(data);
//
//
//
//        System.out.println(jsonObject.get("data").toString());


//        String data1 = "{\n" +
//                "    \"code\": \"5000004\",\n" +
//                "    \"msg\": \"{\\\"error_code\\\":40002,\\\"reason\\\":\\\"无数据\\\"}\",\n" +
//                "    \"column\": null,\n" +
//                "    \"deleteList\": [],\n" +
//                "    \"data\": null\n" +
//                "}";

//        JSONObject jsonObject1 = JSON.parseObject(data1);
//
//        jsonObject1.get("data");


        //System.out.println(jsonObject1.get("data").toString());

//        Simple simple = new Simple();
//
//
//        System.out.println(CharSequenceUtil.builder(CharSequenceUtil.isNotBlank(simple.getId()) ? simple.getId() : CharSequenceUtil.EMPTY,
//                CharSequenceUtil.isNotBlank(simple.getName()) ? simple.getName() : CharSequenceUtil.EMPTY));
//        String baseUrl = "https://data.riskstorm.com/v1/company/%s/search";
//        System.out.println(String.format(baseUrl, "121212121"));

        //System.out.println(CharSequenceUtil.strBuilder("asasa", null, "asasapppas").toString(false));

//        String baseUrl = "https://api.riskraider.com/api/v4/finance/getFinanceInfo";
//
//
//        long timestamp = Calendar.getInstance().getTime().getTime();
//
//        String authToken = DigestUtil.md5Hex((timestamp +
//                "91c483bdbf1944d1963f54ef613d71cc" +
//                "a66c9f4f1e4145efaced1472890f10a3")
//                .getBytes());
//
//
//        System.out.println(authToken);
//
//        HttpRequest request = HttpRequest.post(baseUrl)
//                .header("authToken", authToken)
//                .header("timestamp", timestamp + "")
//                .header("apiKey", "91c483bdbf1944d1963f54ef613d71cc");
//
//        Enterprise enterprise = new Enterprise();
//        enterprise.setEnterpriseName("厦门建发高科有限公司 ");
//        HttpResponse response = request.body(JSON.toJSONString(enterprise)).execute();
//        System.out.println(JSON.toJSONString(response.body()));


//        byte[] bytes={1,2,3,4};
//
//        String userId = IdUtil.fastSimpleUUID();
//        Map<String, Object> map = new HashMap<>();
//        map.put("userId",userId);
//        //String pwd = "客商中台-apilink-prd";
//        //String pwd = "客商中台-riskstorm-prd";
//        //hutool工具包的MD5加密 也可以使用spring家的md5
//        String pwd = "客商中台-RiskRiader-prd";
//        String pwdMd5 = SecureUtil.md5(pwd);
//
//        System.out.println(pwdMd5);


        //System.out.println(DateUtil.lastMonth().toString(DatePattern.SIMPLE_MONTH_PATTERN));

//        String fileName = "asasasa.txt";
//        System.out.println(FileUtil.getSuffix(fileName));
//
//        System.out.println(UUID.fastUUID().toString(true));


//        Long[] userIds = {7293183213L,8921931203231L};
//
//        System.out.println(JSON.toJSONString(userIds));


//        List<String> emails = Lists.newArrayList();
//        emails.add("12312312313131");
//        emails.add("673334242422313");
//
//        Long[] test = Convert.toLongArray(emails);
//        System.out.println(JSON.toJSONString(test));


//        List<String> persons = Lists.newArrayList();
//        persons.add("1");
//        List<String> waitUsers = Lists.newArrayList();
//        waitUsers.add("1");
//        //System.out.println(CollUtil.containsAny(persons, waitUsers));
//
//
//        System.out.println(CollUtil.isEqualList(persons, waitUsers));

//        Simple simple = new Simple();
//        simple.setId("1");
//        simple.setName("2");
//
//        Simple simple2 = new Simple();
//        simple.setId("1");
//        simple.setName("2");
//        System.out.println(ObjectUtil.equal(simple, simple2));




//        List<String> list1 = Lists.newArrayList();
//
//        list1.add("1");
//        list1.add("2");
//        list1.add("3");
//        list1.add("4");
//        list1.add("5");
//        list1.add("6");
//
//       List<List<String>> list =  CollUtil.split(list1, 10);
//        System.out.println(list);

//        List<String> persons = Collections.emptyList();
//        List<String> waitAuditUsers = CollUtil.newArrayList("a", "b","c");
//        System.out.println(CollUtil.containsAny(persons, waitAuditUsers));

        Set<String> users = CollUtil.newHashSet();
        users.add("121212313111");
        users.add("2112442354252");
        users.add("21124423542521212");
        users.add("2112488776721212");
        users.add("2112488776721212");
        Long[] arrays = Convert.toLongArray(users);
        System.out.println(JSON.toJSONString(arrays));
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
