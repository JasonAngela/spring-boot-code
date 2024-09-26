package com.qilang.test.flow;

import lombok.Data;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * FlowInstanceRespDTO
 */
@Data
public class FlowInstanceRespDTO {

    /** 是否自动审批0:否 1:是 */
    private Long autoAudit;
    /** 实例编码 */
    private String flowCode;
    /** 实例名称 */
    private String flowName;
    /** 模板编码 */
    private String modelCode;
    /** 节点数据 */
    private List<FlowTaskDataRespDTO> taskData;
    /** 启用状态 0：停用 1：启用 */
    private Long usingFlag;

    private AtomicInteger successNum;
}
