package com.qilang.test.flow;

import lombok.Data;

/**
 * 类描述：返回流程实例待办数
 *
 * @author huql
 **/
@Data
public class FlowNumRespDTO {

    /**
     * 流程实例编码
     */
    private String flowCode;

    /**
     * 待办数
     */
    private Integer num;

}
