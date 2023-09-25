package com.qilang.test.json;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class DateDemo {
//    {
//        "debttoassets": 67.8183,
//            "fa_Latelyyear2": 2020.0,
//            "net_profit_is": -352822686.65,
//            "stmnote_seg_1701": 975380872.1,
//            "tax": 26463468.06,
//            "tot_assets": 2931012359.75,
//            "tot_equity": 943250935.05,
//            "tot_liab": 1987761424.7,
//            "tot_oper_rev": 989107970.4,
//            "tot_profit": -326359218.59,
//            "yoy_or": -31.2737,
//            "yoyop": 51.0304,
//            "yoyop2": 58.40659903931257,
//            "yoyprofit": 42.70884611013066
//    }

    @JSONField(name = "debttoassets")
    private String debtToassets;
}
