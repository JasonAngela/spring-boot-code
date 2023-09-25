package com.qilang.test.json;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


/**
 * @author hql
 */
@Data
public class HolderCapitalVO {

    /*
      capitalType :
      localUpdateTime :
      amomon : 48600.0万
      pk_id :
      amomonTime :
      dBPk :
      parentPkId :
      paymet :
      time :
      bID : null48600.0万nullnull
      percent : 60.75%
      moneyPercent : 60.75%
     */

    /**
     *
     */
    @JsonAlias("capitalType")
    @JsonProperty("capital_type")
    private String capitalType;
    /**
     *
     */
    @JsonAlias("localUpdateTime")
    @JsonProperty("local_update_time")
    private String localUpdateTime;
    /**
     *
     */
    @JsonAlias("amomon")
    @JsonProperty("amomon")
    private String amomon;
    /**
     *
     */
    @JsonAlias("pk_id")
    @JsonProperty("pk_id")
    private String pk_id;
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
    @JsonAlias("parentPkId")
    @JsonProperty("parent_pk_id")
    private String parentPkId;
    /**
     *
     */
    @JsonAlias("paymet")
    @JsonProperty("paymet")
    private String paymet;
    /**
     *
     */
    @JsonAlias("time")
    @JsonProperty("time")
    private String time;
    /**
     *
     */
    @JsonAlias("bID")
    @JsonProperty("b_id")
    private String bID;
    /**
     *
     */
    @JsonAlias("percent")
    @JsonProperty("percent")
    private String percent;
    /**
     *
     */
    @JsonAlias("moneyPercent")
    @JsonProperty("money_percent")
    private String moneyPercent;
    /**
     *
     */
    @JsonAlias("holerId")
    @JsonProperty("holer_id")
    private String holerId;
    /**
     *
     */
    @JsonAlias("holderName")
    @JsonProperty("holder_name")
    private String holderName;
    /**
     *
     */
    @JsonAlias("holderCreditCode")
    @JsonProperty("holder_credit_code")
    private String holderCreditCode;
}
