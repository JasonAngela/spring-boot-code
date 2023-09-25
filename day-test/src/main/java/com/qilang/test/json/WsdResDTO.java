package com.qilang.test.json;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * 类描述：WSD接口返回DTO
 *
 * @author hql
 */
@Data
public class WsdResDTO implements Serializable {

    private static final long serialVersionUID = 3311139685611573324L;

    @JSONField(name = "debttoassets")
    private String debtToassets;

    @JSONField(name = "fa_Latelyyear2")
    private String faLatelyyear2;

    @JSONField(name = "net_profit_is")
    private String netProfitIs;

    @JSONField(name = "stmnote_seg_1701")
    private String stmnoteSeg1701;

    @JSONField(name = "tax")
    private String tax;

    @JSONField(name = "tot_assets")
    private String totAssets;

    @JSONField(name = "tot_equity")
    private String totEquity;

    @JSONField(name = "tot_liab")
    private String totLiab;

    @JSONField(name = "tot_oper_rev")
    private String totOperRev;

    @JSONField(name = "tot_profit")
    private String totProfit;

    @JSONField(name = "yoy_or")
    private String yoyOr;

    @JSONField(name = "yoyop")
    private String yoYop;

    @JSONField(name = "yoyop2")
    private String yoYop2;

    @JSONField(name = "yoyprofit")
    private String yoyProfit;
}
