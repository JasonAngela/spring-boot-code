package com.qilang.test.flow;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 流程评论信息
 *
 * @author gatsby.Luo
 * @since 2022/11/22
 */
@Data
public class FlowTaskAuditDataRespDTO {
    /**
     * 审核时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date auditTime;
    /**
     * 审核人
     */
    private String auditUser;
    /**
     * 审核评论
     */
    private String comment;
    /**
     * 操作类型 1:审核通过 2:审核驳回 3:节点撤回 4:审核终止
     * <p>
     * <p>
     * APPROVED(1, "审核通过"),
     * AUDIT_REJECT(2, "审核驳回"),
     * NODE_RECALL(3, "节点撤回"),
     * AUDIT_TERMINATION(4, "审核终止"),
     */
    private String operateType;


}