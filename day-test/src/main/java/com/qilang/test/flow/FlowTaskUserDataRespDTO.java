package com.qilang.test.flow;

import lombok.Data;

/**
 * FlowTaskUserDataRespDTO
 */
@Data
public class FlowTaskUserDataRespDTO {
    private Integer type;
    private String userId;
    private String userName;

    /**
     * 前端key
     */
    private String key;
}
