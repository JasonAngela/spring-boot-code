package com.qilang.test.flow;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *  FlowAllTaskInfoRespDTO
 *
 * @author hql
 */
@Data
public class FlowAllTaskInfoRespDTO implements Serializable {

    private static final long serialVersionUID = 2438738383233391477L;

    private Integer auditStatus;

    private String auditTime;

    private String auditUserId;

    private String auditUserName;

    private String taskCode;

    private String taskName;

    private String taskType;

    private List<TaskUserDTO> taskUsers;

        @Data
        public static class TaskUserDTO implements Serializable {

            private static final long serialVersionUID = -6000439708226653483L;

            private String key;

            private String roleId;

            private Integer type;

            private String userId;

            private String userName;
        }
}
