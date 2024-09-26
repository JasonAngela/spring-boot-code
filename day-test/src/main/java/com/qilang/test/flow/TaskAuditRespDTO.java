package com.qilang.test.flow;

import lombok.Data;

/**
 * TaskAuditResDTO
 *
 */
@Data
public class TaskAuditRespDTO {

    /** 待审核人id */
    private String waitAuditUserId;
    /** 审核评论 */
    private String auditComment;
    /**审核时间 */
    private String auditTime;
    /** 审核人id*/
    private String auditUserId;
    /** 审核操作*/
    private String operate;
    /** 审核人姓名*/
    private String auditUserName;
    /** 审核状态 审批状态0:审核中 1:审核通过 2:审核驳回 3:审核被撤回 4:审核终止*/
    private Integer auditStatus;

}
