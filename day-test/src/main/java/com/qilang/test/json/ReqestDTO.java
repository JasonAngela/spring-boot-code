package com.qilang.test.json;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import java.io.Serializable;

/**
 * @author huql
 **/
@Data
public class ReqestDTO implements Serializable {

    @JSONField(name = "bill_code")
    private String billCode;

    @JSONField(name = "_time")
    private String time;
}
