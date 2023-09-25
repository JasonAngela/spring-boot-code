package com.qilang.test.json;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

/**
 * 股东信息
 * @author hql
 */
@Data
public class HolderVO  {

    /*
      localUpdateTime :
      capital : [{"capitalType":"","localUpdateTime":"","amomon":"48600.0万","pk_id":"","amomonTime":"","dBPk":"","parentPkId":"","paymet":"","time":"","bID":"null48600.0万nullnull","percent":"60.75%","moneyPercent":"60.75%"}]
      holderName : 林印孙
      pk_id :
      corpLogo :
      corpName : 正邦集团有限公司
      type : 1
      moneyPercent :
      toco :
      amomon :
      amomonTime :
      dBPk :
      capitalActl : [{"capitalType":"","localUpdateTime":"","amomon":"48600","pk_id":"","amomonTime":"","dBPk":"","parentPkId":"","paymet":"","time":"","bID":"null48600nullnull","percent":"100.00%","moneyPercent":"100.00%"}]
      name : 林印孙
      logo :
      tableId : 3153759
      id : 3153759
      bID : 正邦集团有限公司3153759林印孙1
      holderType : 1
     */

    /**
     *
     */
    @JsonAlias("localUpdateTime")
    @JsonProperty("local_update_time")
    private String localUpdateTime;
    /**
     *
     */
    @JsonAlias("holderName")
    @JsonProperty("holder_name")
    private String holderName;
    /**
     *
     */
    @JsonAlias("pk_id")
    @JsonProperty("pk_id")
    private String pk_id;
    /**
     *
     */
    @JsonAlias("corpLogo")
    @JsonProperty("corp_logo")
    private String corpLogo;
    /**
     *
     */
    @JsonAlias("corpName")
    @JsonProperty("corp_name")
    private String corpName;
    /**
     *
     */
    @JsonAlias("type")
    @JsonProperty("type")
    private int type;
    /**
     *
     */
    @JsonAlias("moneyPercent")
    @JsonProperty("money_percent")
    private String moneyPercent;
    /**
     *
     */
    @JsonAlias("toco")
    @JsonProperty("toco")
    private String toco;
    /**
     *
     */
    @JsonAlias("amomon")
    @JsonProperty("amomon")
    private String amomon;
    /**
     *
     */
    @JsonAlias("amomonTime")
    @JsonProperty("amomon_time")
    private String amomonTime;
    /**
     *
     */
    @JsonAlias("dBPk")
    @JsonProperty("d_b_pk")
    private String dBPk;
    /**
     *
     */
    @JsonAlias("name")
    @JsonProperty("name")
    private String name;
    /**
     *
     */
    @JsonAlias("logo")
    @JsonProperty("logo")
    private String logo;
    /**
     *
     */
    @JsonAlias("tableId")
    @JsonProperty("table_id")
    private String tableId;

    /**
     *
     */
    @JsonAlias("bID")
    @JsonProperty("b_id")
    private String bID;
    /**
     *
     */
    @JsonAlias("holderType")
    @JsonProperty("holder_type")
    private int holderType;
    /**
     *
     */
    @JsonAlias("capital")
    @JsonProperty("capital")
    @JSONField(serialize = false)
    private List<HolderCapitalVO> capital;
    /**
     *
     */
    @JsonAlias("capitalActl")
    @JsonProperty("capital_actl")
    @JSONField(serialize = false)
    private List<HolderCapitalVO> capitalActl;
}