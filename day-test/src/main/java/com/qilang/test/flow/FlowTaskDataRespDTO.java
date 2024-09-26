package com.qilang.test.flow;

import lombok.Data;

import java.util.List;

/**
 * FlowTaskDataRespDTO
 */
@Data
public class FlowTaskDataRespDTO {
    /** 审批权限 */
    private List<String> auditPermission;
    /** 可审批角色 */
    private List<FlowTaskRoleDataRespDTO> auditRoles;
    private List<FlowTaskUserDataRespDTO> auditUsers;
    /** 会签前置节点编码 */
    private List<String> mergeTaskCodes;
    /**
     下节点     */
    private List<String> nextTasks;
    /** 节点编码 */
    private String taskCode;
    /** 节点条件 */
    private List<String> taskCondition;
    private String taskName;
    /**
     节点类型 */
    private String taskType;
}