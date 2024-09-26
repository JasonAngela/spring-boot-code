package com.qilang.test.flow;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author gatsby.Luo (luolonglong@itg.com.cn)
 * @version 1.0.0
 * @since 2022/11/21  16:36
 */
@NoArgsConstructor
@Data
public class FlowSubmitRespDTO {

    /**
     当前审核节点信息 */
    private List<FlowCurrentAuditRespDTO> currentAuditRespDTOS;
    /** 流程编号 */
    private String flowNo;

    /**
     * 流程是否完结
     */
    private Boolean endFlag;

    @NoArgsConstructor
    @Data
    public static class FlowCurrentAuditRespDTO {
        /**
         待审核节点编码 */
        private String taskCode;
        /** 待审核节点名称 */
        private String taskName;
        /** 待审核节点类型 */
        private String taskType;
        /**
         待审核人id  */
        private String waitAuditUser;
        /**
         待审核人名称 */
        private String waitAuditUserName;
    }
}
