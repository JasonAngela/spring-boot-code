package com.qilang.test;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * 类描述: flow返回基础类 相当于code
 * @author hql
 */
@Data
public class BaseFlowRespDTO implements Serializable {

    private static final long serialVersionUID = -8366799312291793077L;

    @JSONField(name = "code")
    private String code;

    @JSONField(name = "message")
    private String message;

    @JSONField(name = "data")
    private String data;

    @JSONField(name = "success")
    private Boolean success;
}
