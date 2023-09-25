package com.qilang.test.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        //String str = "[{\"debttoassets\":47.2684,\"fa_Latelyyear2\":2020.0,\"net_profit_is\":628195940.09,\"stmnote_seg_1701\":19257216397.08,\"tax\":173753870.48,\"tot_assets\":20484494619.23,\"tot_equity\":10801794822.08,\"tot_liab\":9682699797.15,\"tot_oper_rev\":19909350658.56,\"tot_profit\":801949810.57,\"yoy_or\":2.2463,\"yoyop\":22.1739,\"yoyop2\":7.102974652302159,\"yoyprofit\":12.404397944266565},{\"debttoassets\":34.8986,\"fa_Latelyyear2\":2021.0,\"net_profit_is\":1133032824.33,\"stmnote_seg_1701\":23141074192.25,\"tax\":250083899.72,\"tot_assets\":18062119861.99,\"tot_equity\":11758696580.07,\"tot_liab\":6303423281.92,\"tot_oper_rev\":23468553115.67,\"tot_profit\":1383116724.05,\"yoy_or\":17.877,\"yoyop\":71.2211,\"yoyop2\":147.80747787040775,\"yoyprofit\":80.36296512321827},{\"debttoassets\":30.8768,\"fa_Latelyyear2\":2022.0,\"net_profit_is\":1060938997.15,\"stmnote_seg_1701\":19618633967.92,\"tax\":298949122.78,\"tot_assets\":18100294856.56,\"tot_equity\":12511499192.28,\"tot_liab\":5588795664.28,\"tot_oper_rev\":19918051356.78,\"tot_profit\":1359888119.93,\"yoy_or\":-15.4567,\"yoyop\":-1.7942,\"yoyop2\":-29.71161820162147,\"yoyprofit\":-6.070992429698666},{\"debttoassets\":NaN,\"fa_Latelyyear2\":2022.0,\"net_profit_is\":NaN,\"stmnote_seg_1701\":NaN,\"tax\":NaN,\"tot_assets\":NaN,\"tot_equity\":NaN,\"tot_liab\":NaN,\"tot_oper_rev\":NaN,\"tot_profit\":NaN,\"yoy_or\":NaN,\"yoyop\":NaN,\"yoyop2\":NaN,\"yoyprofit\":NaN}]";
//        DateDemo dateDemo =  JSON.parseObject(str, DateDemo.class);
//        System.out.println(dateDemo.getDebtToassets());

        String str = "[{\"debttoassets\":48.6792,\"fa_Latelyyear2\":2020.0,\"net_profit_is\":2180045.87,\"stmnote_seg_1701\":NaN,\"tax\":2418106.21,\"tot_assets\":281899908.84,\"tot_equity\":144673340.03,\"tot_liab\":137226568.81,\"tot_oper_rev\":149746689.03,\"tot_profit\":4598152.08,\"yoy_or\":73.1664,\"yoyop\":-33.4582,\"yoyop2\":-85.36888386899328,\"yoyprofit\":-57.95244370616576},{\"debttoassets\":38.5323,\"fa_Latelyyear2\":2021.0,\"net_profit_is\":29129774.58,\"stmnote_seg_1701\":NaN,\"tax\":9096959.61,\"tot_assets\":280528380.04,\"tot_equity\":172434343.23,\"tot_liab\":108094036.81,\"tot_oper_rev\":292703776.86,\"tot_profit\":38226734.19,\"yoy_or\":95.4659,\"yoyop\":732.4319,\"yoyop2\":3139.9131406176334,\"yoyprofit\":1236.200076377292},{\"debttoassets\":26.4628,\"fa_Latelyyear2\":2022.0,\"net_profit_is\":34901343.78,\"stmnote_seg_1701\":NaN,\"tax\":13161899.92,\"tot_assets\":288886978.81,\"tot_equity\":212439395.48,\"tot_liab\":76447583.33,\"tot_oper_rev\":367570583.96,\"tot_profit\":48063243.7,\"yoy_or\":25.5777,\"yoyop\":8.8228,\"yoyop2\":42.60308725071862,\"yoyprofit\":19.813298534629453},{\"debttoassets\":NaN,\"fa_Latelyyear2\":2022.0,\"net_profit_is\":NaN,\"stmnote_seg_1701\":NaN,\"tax\":NaN,\"tot_assets\":NaN,\"tot_equity\":NaN,\"tot_liab\":NaN,\"tot_oper_rev\":NaN,\"tot_profit\":NaN,\"yoy_or\":NaN,\"yoyop\":NaN,\"yoyop2\":NaN,\"yoyprofit\":NaN}]";
        List<WsdResDTO> list = JSON.parseArray(str, WsdResDTO.class);
        list.forEach(m -> System.out.println(JSON.toJSONString(m)));
    }
}
