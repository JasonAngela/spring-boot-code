package com.qilang.test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wind.api.WindData;
import java.util.ArrayList;

public class WindTest {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> dataArrayList = new ArrayList();
        JSONArray objects =  JSON.parseArray("[\n" +
                "            {\n" +
                "                \"pkId\": \"1645600641376006145\",\n" +
                "                \"name\": \"API风报test\",\n" +
                "                \"templateName\": null,\n" +
                "                \"frequency\": \"0 00 00 * * ?\",\n" +
                "                \"status\": 0,\n" +
                "                \"type\": 2\n" +
                "            },\n" +
                "            {\n" +
                "                \"pkId\": \"1645349077114257410\",\n" +
                "                \"name\": \"【创新测试】纸张事业部逾期反馈-黑纸逾期反馈test\",\n" +
                "                \"templateName\": \"黑纸逾期反馈\",\n" +
                "                \"frequency\": \"0 00,02 00 * * ?\",\n" +
                "                \"status\": 2,\n" +
                "                \"type\": 1\n" +
                "            },\n" +
                "            {\n" +
                "                \"pkId\": \"1645687117346959362\",\n" +
                "                \"name\": \"白纸逾期反馈情况test\",\n" +
                "                \"templateName\": \"测试模版1\",\n" +
                "                \"frequency\": \"0 00,06 00 ? * MON-THU\",\n" +
                "                \"status\": 2,\n" +
                "                \"type\": 1\n" +
                "            },\n" +
                "            {\n" +
                "                \"pkId\": \"1645714648114417666\",\n" +
                "                \"name\": \"包装纸事业部超期付款未到货test\",\n" +
                "                \"templateName\": \"1\",\n" +
                "                \"frequency\": \"0 02,04 00 1-5 * ?\",\n" +
                "                \"status\": 0,\n" +
                "                \"type\": 1\n" +
                "            },\n" +
                "            {\n" +
                "                \"pkId\": \"1645990827623837698\",\n" +
                "                \"name\": \"包装纸事业部超期未出仓直运库存test\",\n" +
                "                \"templateName\": \"包装纸事业部超期未出仓直运库存\",\n" +
                "                \"frequency\": \"0 00,05 00 * * ?\",\n" +
                "                \"status\": 2,\n" +
                "                \"type\": 1\n" +
                "            },\n" +
                "            {\n" +
                "                \"pkId\": \"1646040116492365825\",\n" +
                "                \"name\": \"日常关联交易统计test\",\n" +
                "                \"templateName\": \"日常关联交易统计\",\n" +
                "                \"frequency\": \"0 03,07 00 * * ?\",\n" +
                "                \"status\": 2,\n" +
                "                \"type\": 1\n" +
                "            },\n" +
                "            {\n" +
                "                \"pkId\": \"1646063561168871425\",\n" +
                "                \"name\": \"特殊业务合同台账和货权台账test\",\n" +
                "                \"templateName\": \"特殊业务合同台账和货权台账\",\n" +
                "                \"frequency\": \"0 00,44 00 * * ?\",\n" +
                "                \"status\": 2,\n" +
                "                \"type\": 1\n" +
                "            },\n" +
                "            {\n" +
                "                \"pkId\": \"1646339183532335105\",\n" +
                "                \"name\": \"纸张事业部超期付款未到货test\",\n" +
                "                \"templateName\": \"纸张事业部超期付款未到货\",\n" +
                "                \"frequency\": \"0 00,07 00 * * ?\",\n" +
                "                \"status\": 2,\n" +
                "                \"type\": 1\n" +
                "            },\n" +
                "            {\n" +
                "                \"pkId\": \"1646397324599595009\",\n" +
                "                \"name\": \"纸张事业部超期未出仓直运库存test\",\n" +
                "                \"templateName\": \"纸张事业部超期未出仓直运库存\",\n" +
                "                \"frequency\": \"0 01,24 00 * * ?\",\n" +
                "                \"status\": 2,\n" +
                "                \"type\": 1\n" +
                "            },\n" +
                "            {\n" +
                "                \"pkId\": \"1646414459283542018\",\n" +
                "                \"name\": \"走访信息登记test\",\n" +
                "                \"templateName\": \"走访信息登记\",\n" +
                "                \"frequency\": \"0 01,24 00 * * ?\",\n" +
                "                \"status\": 2,\n" +
                "                \"type\": 1\n" +
                "            }\n" +
                "        ]");

        for(int i = 0; i < objects.size(); ++i) {
            ArrayList<String> list = new ArrayList();
            JSONArray objArray = JSONObject.parseArray(objects.getString(i));

            for(int j = 0; j < objArray.size(); ++j) {
                String jString = objArray.getString(j);
                list.add(jString);
            }

            dataArrayList.add(list);
        }

        WindData windData = new WindData();
        windData.data = dataArrayList;
        System.out.println(windData.data);
    }
}
