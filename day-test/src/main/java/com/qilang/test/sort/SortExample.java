package com.qilang.test.sort;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.map.MapUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class SortExample {
    public static void main(String[] args) {
        /*List<MyObject> objects = new ArrayList<>();
        objects.add(new MyObject("a"));
        objects.add(new MyObject("c"));
        objects.add(new MyObject("b"));
        objects.add(new MyObject("d"));

        // 将名为'a'和'b'的对象排在最后
        objects.sort(new Comparator<MyObject>() {
            private final List<String> namesToPutLast = Arrays.asList("a", "e","c");

            @Override
            public int compare(MyObject o1, MyObject o2) {
                boolean o1Last = namesToPutLast.contains(o1.getName());
                boolean o2Last = namesToPutLast.contains(o2.getName());

                if (o1Last && o2Last) {
                    return o1.getName().compareTo(o2.getName()); // 如果两者都需要排最后，按名称排序
                }
                if (o1Last) {
                    return 1; // o1排在o2后面
                }
                if (o2Last) {
                    return -1; // o2排在o1后面
                }
                return o1.getName().compareTo(o2.getName()); // 其他情况按名称排序
            }
        });

        // 输出排序后的列表
        for (MyObject obj : objects) {
            System.out.println(obj);
        }*/

        /*Map<String, Object> map = MapUtil.newHashMap();
        map.put("a",null);

        map.put("b", null);

        System.out.println(Convert.toBigDecimal(map.get("a"),
                BigDecimal.ZERO).add(Convert.toBigDecimal(map.get("b"), BigDecimal.ZERO)));*/
        // 计算需要切分的次数
        /*String inputString = "\"isLeafNode\\\":true,\\\"name\\\":\\\"逾期还款-copy3\\\",\\\"parentId\\\":1693819490042458114,\\\"pkId\\\":1699612275187466241,\\\"status\\\":0,\\\"type\\\":2}],\\\"code\\\":\\\"\\\",\\\"isLeafNode\\\":false,\\\"name\\\":\\\"肖波模版\\\",\\\"pkId\\\":1693819490042458114,\\\"status\\\":0,\\\"type\\\":1},{\\\"children\\\":[{\\\"PCode\\\":\\\"\\\",\\\"PName\\\":\\\"运管部\\\",\\\"code\\\":\\\"\\\",\\\"isLeafNode\\\":true,\\\"name\\\":\\\"保证金比例排查\\\",\\\"parentId\\\":1696090450051006466,\\\"pkId\\\":1701504097519165441,\\\"status\\\":1,\\\"type\\\":2},{\\\"PCode\\\":\\\"\\\",\\\"PName\\\":\\\"运管部\\\",\\\"code\\\":\\\"\\\",\\\"isLeafNode\\\":true,\\\"name\\\":\\\"担保抵质押v2.0\\\",\\\"parentId\\\":1696090450051006466,\\\"pkId\\\":1703004509543145473,\\\"status\\\":0,\\\"type\\\":2},{\\\"PCode\\\":\\\"\\\",\\\"PName\\\":\\\"运管部\\\",\\\"code\\\":\\\"\\\",\\\"isLeafNode\\\":true,\\\"name\\\":\\\"担保抵质押-WFTEST\\\",\\\"parentId\\\":1696090450051006466,\\\"pkId\\\":1702237108719394817,\\\"status\\\":1,\\\"type\\\":2},{\\\"PCode\\\":\\\"\\\",\\\"PName\\\":\\\"运管部\\\",\\\"children\\\":[{\\\"PCode\\\":\\\"\\\",\\\"PName\\\":\\\"风管报表\\\",\\\"code\\\":\\\"\\\",\\\"isLeafNode\\\":true,\\\"name\\\":\\\"特殊业务合同台账和货权台账2\\\",\\\"parentId\\\":1696090521408700417,\\\"pkId\\\":1701873520662093825,\\\"status\\\":1,\\\"type\\\":2}],\\\"code\\\":\\\"\\\",\\\"isLeafNode\\\":false,\\\"name\\\":\\\"风管报表\\\",\\\"parentId\\\":1696090450051006466,\\\"pkId\\\":1696090521408700417,\\\"status\\\":1,\\\"type\\\":1},{\\\"PCode\\\":\\\"\\\",\\\"PName\\\":\\\"运管部\\\",\\\"code\\\":\\\"\\\",\\\"isLeafNode\\\":true,\\\"name\\\":\\\"三项不良v2.0_20240117\\\",\\\"parentId\\\":1696090450051006466,\\\"pkId\\\":1699005535158792194,\\\"status\\\":1,\\\"type\\\":2},{\\\"PCode\\\":\\\"\\\",\\\"PName\\\":\\\"运管部\\\",\\\"code\\\":\\\"\\\",\\\"isLeafNode\\\":true,\\\"name\\\":\\\"三项不良v2.0-最新版2024/3/6\\\",\\\"parentId\\\":1696090450051006466,\\\"pkId\\\":1698626334053691393,\\\"status\\\":1,\\\"type\\\":2},{\\\"PCode\\\":\\\"\\\",\\\"PName\\\":\\\"运管部\\\",\\\"code\\\":\\\"\\\",\\\"isLeafNode\\\":true,\\\"name\\\":\\\"授权评估数据收集v2.0\\\",\\\"parentId\\\":1696090450051006466,\\\"pkId\\\":1704134020514283521,\\\"status\\\":0,\\\"type\\\":2},{\\\"PCode\\\":\\\"\\\",\\\"PName\\\":\\\"运管部\\\",\\\"code\\\":\\\"\\\",\\\"isLeafNode\\\":true,\\\"name\\\":\\\"授信明细总表\\\",\\\"parentId\\\":1696090450051006466,\\\"pkId\\\":1704095874835427329,\\\"status\\\":1,\\\"type\\\":2}],\\\"code\\\":\\\"\\\",\\\"isLeafNode\\\":false,\\\"name\\\":\\\"运管部\\\",\\\"pkId\\\":1696090450051006466,\\\"status\\\":1,\\\"type\\\":1},{\\\"children\\\":[{\\\"PCode\\\":\\\"\\\",\\\"PName\\\":\\\"证券部\\\",\\\"code\\\":\\\"\\\",\\\"isLeafNode\\\":true,\\\"name\\\":\\\"非日常关联交易统计\\\",\\\"parentId\\\":1694911707681058818,\\\"pkId\\\":1694914529453600770,\\\"status\\\":1,\\\"type\\\":2}],\\\"code\\\":\\\"\\\",\\\"isLeafNode\\\":false,\\\"name\\\":\\\"证券部\\\",\\\"pkId\\\":1694911707681058818,\\\"status\\\":1,\\\"type\\\":1}],\\\"message\\\":\\\"\\\",\\\"success\\\":true}\",用户名:huqilang@itg.net";
        System.out.println(inputString.length());
        Integer max_length = 60;
        if (inputString.length() <= max_length) {
            // 如果日志消息长度小于等于 maxLength，直接输出
            System.out.println(inputString);
        } else {
            // 否则，进行拆分输出
            for (int i = 0; i < inputString.length(); i += max_length) {
                int end = Math.min(i + max_length, inputString.length());
                System.out.println(inputString.substring(i, end));
            }
        }*/


       String str = "\"\\xe5\\x9b\\xbd\\xe8\\xb4\\xb8\\xe7\\xba\\xb8\\xe4\\xb8\\x9a\\xe7\\xba\\xb8\\xe5\\xbc\\xa0\\xe4\\xb8\\xad\\xe5\\xbf\\x83\\xe5\\x93\\x88\\xe5\\xb0\\x94\\xe6\\xbb\\xa8\\xe5\\x8c\\xba\"\n" +
               "\"\\\"\\xe7\\xba\\xb8\\xe5\\xbc\\xa0\\xe4\\xba\\x8b\\xe4\\xb8\\x9a\\xe9\\x83\\xa8\\xef\\xbc\\x88\\xe9\\x99\\x88\\xe5\\x88\\xa9\\xe5\\x89\\x91\\xef\\xbc\\x89\\xe7\\xae\\xa1\\xe7\\x90\\x86\\xe5\\x8c\\xba\\xe5\\x9f\\x9f\\\"\"\n" +
               "\"\\xe5\\x9b\\xbd\\xe8\\xb4\\xb8\\xe7\\xba\\xb8\\xe4\\xb8\\x9a\\xe7\\xba\\xb8\\xe5\\xbc\\xa0\\xe4\\xb8\\xad\\xe5\\xbf\\x83\\xe7\\x9f\\xb3\\xe5\\xae\\xb6\\xe5\\xba\\x84\\xe5\\x8c\\xba\"\n" +
               "\"\\\"\\xe7\\xba\\xb8\\xe5\\xbc\\xa0\\xe4\\xba\\x8b\\xe4\\xb8\\x9a\\xe9\\x83\\xa8\\xef\\xbc\\x88\\xe8\\x89\\xbe\\xe6\\xb0\\xb8\\xe6\\xb5\\xa9\\xef\\xbc\\x89\\xe7\\xae\\xa1\\xe7\\x90\\x86\\xe5\\x8c\\xba\\xe5\\x9f\\x9f\\\"\"\n" +
               "\"\\xe5\\x9b\\xbd\\xe8\\xb4\\xb8\\xe7\\xba\\xb8\\xe4\\xb8\\x9a\\xe7\\xba\\xb8\\xe5\\xbc\\xa0\\xe4\\xb8\\xad\\xe5\\xbf\\x83\\xe9\\x9d\\x92\\xe5\\xb2\\x9b\\xe5\\x8c\\xba\"\n" +
               "\"\\\"\\xe7\\xba\\xb8\\xe5\\xbc\\xa0\\xe4\\xba\\x8b\\xe4\\xb8\\x9a\\xe9\\x83\\xa8\\xef\\xbc\\x88\\xe8\\x89\\xbe\\xe6\\xb0\\xb8\\xe6\\xb5\\xa9\\xef\\xbc\\x89\\xe7\\xae\\xa1\\xe7\\x90\\x86\\xe5\\x8c\\xba\\xe5\\x9f\\x9f\\\"\"\n" +
               "\"\\xe5\\x9b\\xbd\\xe8\\xb4\\xb8\\xe7\\xba\\xb8\\xe4\\xb8\\x9a\\xe7\\xba\\xb8\\xe5\\xbc\\xa0\\xe4\\xba\\x8b\\xe4\\xb8\\x9a\\xe9\\x83\\xa8\\xe4\\xba\\x91\\xe8\\xb4\\xb5\\xe5\\x8c\\xba\"\n" +
               "\"\\\"\\xe7\\xba\\xb8\\xe5\\xbc\\xa0\\xe4\\xba\\x8b\\xe4\\xb8\\x9a\\xe9\\x83\\xa8\\xef\\xbc\\x88\\xe5\\xbe\\x90\\xe6\\x81\\xa9\\xe4\\xbc\\x9f\\xef\\xbc\\x89\\xe7\\xae\\xa1\\xe7\\x90\\x86\\xe5\\x8c\\xba\\xe5\\x9f\\x9f\\\"\"\n" +
               "\"\\xe5\\x9b\\xbd\\xe8\\xb4\\xb8\\xe7\\xba\\xb8\\xe4\\xb8\\x9a\\xe5\\x8c\\x85\\xe8\\xa3\\x85\\xe7\\xba\\xb8\\xe4\\xb8\\xad\\xe5\\xbf\\x83\\xe6\\x97\\xa0\\xe9\\x94\\xa1\\xe5\\x8c\\xba\"\n" +
               "\"\\\"\\xe5\\x8c\\x85\\xe8\\xa3\\x85\\xe7\\xba\\xb8\\xe4\\xba\\x8b\\xe4\\xb8\\x9a\\xe9\\x83\\xa8\\xef\\xbc\\x88\\xe6\\x96\\xb9\\xe9\\x95\\xbf\\xe9\\x9d\\x92\\xef\\xbc\\x89\\xe7\\xae\\xa1\\xe7\\x90\\x86\\xe5\\x8c\\xba\\xe5\\x9f\\x9f\\\"\"\n" +
               "\"\\xe5\\x9b\\xbd\\xe8\\xb4\\xb8\\xe7\\xba\\xb8\\xe4\\xb8\\x9a\\xe7\\xba\\xb8\\xe5\\xbc\\xa0\\xe4\\xb8\\xad\\xe5\\xbf\\x83\\xe5\\x8d\\x8e\\xe5\\x8d\\x97\\xe5\\xbc\\x80\\xe5\\x8f\\x91\\xe5\\x8c\\xba\"\n" +
               "\"\\\"\\xe7\\xba\\xb8\\xe5\\xbc\\xa0\\xe4\\xba\\x8b\\xe4\\xb8\\x9a\\xe9\\x83\\xa8\\xef\\xbc\\x88\\xe5\\xbe\\x90\\xe6\\x81\\xa9\\xe4\\xbc\\x9f\\xef\\xbc\\x89\\xe7\\xae\\xa1\\xe7\\x90\\x86\\xe5\\x8c\\xba\\xe5\\x9f\\x9f\\\"\"\n" +
               "\"\\xe5\\x9b\\xbd\\xe8\\xb4\\xb8\\xe7\\xba\\xb8\\xe4\\xb8\\x9a\\xe5\\x8c\\x85\\xe8\\xa3\\x85\\xe7\\xba\\xb8\\xe4\\xb8\\xad\\xe5\\xbf\\x83\\xe5\\xae\\x81\\xe6\\xb3\\xa2\\xe5\\x8c\\xba\"\n" +
               "\"\\\"\\xe5\\x8c\\x85\\xe8\\xa3\\x85\\xe7\\xba\\xb8\\xe4\\xba\\x8b\\xe4\\xb8\\x9a\\xe9\\x83\\xa8\\xef\\xbc\\x88\\xe6\\x96\\xb9\\xe9\\x95\\xbf\\xe9\\x9d\\x92\\xef\\xbc\\x89\\xe7\\xae\\xa1\\xe7\\x90\\x86\\xe5\\x8c\\xba\\xe5\\x9f\\x9f\\\"\"\n" +
               "\"\\xe5\\x9b\\xbd\\xe8\\xb4\\xb8\\xe7\\xba\\xb8\\xe4\\xb8\\x9a\\xe7\\xba\\xb8\\xe5\\xbc\\xa0\\xe4\\xba\\x8b\\xe4\\xb8\\x9a\\xe9\\x83\\xa8\\xe7\\xa6\\x8f\\xe5\\xbb\\xba\\xe5\\xbc\\x80\\xe5\\x8f\\x91\\xe5\\x8c\\xba\"\n" +
               "\"\\\"\\xe7\\xba\\xb8\\xe5\\xbc\\xa0\\xe4\\xba\\x8b\\xe4\\xb8\\x9a\\xe9\\x83\\xa8\\xef\\xbc\\x88\\xe5\\xbe\\x90\\xe6\\x81\\xa9\\xe4\\xbc\\x9f\\xef\\xbc\\x89\\xe7\\xae\\xa1\\xe7\\x90\\x86\\xe5\\x8c\\xba\\xe5\\x9f\\x9f\\\"\"\n" +
               "\"\\xe5\\x9b\\xbd\\xe8\\xb4\\xb8\\xe7\\xba\\xb8\\xe4\\xb8\\x9a\\xe5\\x8c\\x85\\xe8\\xa3\\x85\\xe7\\xba\\xb8\\xe4\\xb8\\xad\\xe5\\xbf\\x83\\xe5\\x90\\x88\\xe8\\x82\\xa5\\xe5\\x8c\\xba\"";


        // 假设这是你的16进制字符串，表示UTF-8编码的中文

        // 将16进制字符串转换为字节数组
        byte[] bytes = hexStringToByteArray(str);

        // 使用UTF-8编码将字节数组解码为字符串
        String chineseText = new String(bytes, StandardCharsets.UTF_8);

        // 输出结果
        System.out.println(chineseText); // 应该输出"中文"

    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
}
