package com.qilang.test.json;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * 类猫叔：百度地址返回数据体
 *
 * @author hql
 */
@Data
public class BaiduAddressResponseDTO implements Serializable {

    private static final long serialVersionUID = 7932804508764390267L;

//    log_id	uint64	请求唯一标识码
//    text	string	原始输入的文本内容
//    province	string	省（直辖市/自治区）
//    province_code	string	省国标code
//    city	string	市
//    city_code	string	城市国标code
//    county	string	区（县）
//    county_code	string	区县国标code
//    town	string	街道（乡/镇）
//    town_code	string	街道/乡镇国标code
//    person	string	姓名
//    detail	string	详细地址
//    phonenum	string	电话号码
//    lat	float	纬度（百度坐标，仅供参考）
//    Ing	float	经度（百度坐标，仅供参考）

    @JsonAlias("log_id")
    @JsonProperty("log_id")
    private Long logId;

    @JSONField(name = "text")
    private String text;

    @JSONField(name = "province")
    private String province;

    @JSONField(name = "city")
    private String city;

    @JsonAlias("city_code")
    @JsonProperty("city_code")
    private String cityCode;

    @JSONField(name = "county")
    private String county;

    @JSONField(name = "county_code")
    private String countyCode;

    @JSONField(name = "town")
    private String town;

    @JSONField(name = "town_code")
    private String townCode;

    @JSONField(name = "person")
    private String person;

    @JSONField(name = "detail")
    private String detail;

    @JSONField(name = "phonenum")
    private String phoneNum;

    @JSONField(name = "lat")
    private Float lat;

    @JSONField(name = "lng")
    private Float lng;

    private String custId;
}
