package com.qilang.test.flow;

import lombok.Data;

/**
 * FlowTaskRoleDataRespDTO
 */
@Data
public class FlowTaskRoleDataRespDTO {
    /** 角色id */
    private String roleId;
    /** 角色名称 */
    private String roleName;
    /**
     * 前端key
     */
    private String key;
}