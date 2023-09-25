package com.qilang.test;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author hql
 */
@Data
public class QccResponseDTO implements Serializable {

    private static final long serialVersionUID = 403232870570633143L;

    @JSONField(name = "Status")
    private String status;

    @JSONField(name = "Message")
    private String message;

    @JSONField(name = "OrderNumber")
    private String orderNumber;

    @JSONField(name = "Result")
    private Result result;

    @Data
    public static class Result implements Serializable {

        private static final long serialVersionUID = -5234980049981892974L;

        @JSONField(name = "VerifyResult")
        private Integer verifyResult;

        @JSONField(name = "Data")
        private ResultData data;

        @Data
        public static class ResultData implements Serializable {

            private static final long serialVersionUID = 2234346427033783139L;

            @JSONField(name = "GroupId")
            private String groupId;

            @JSONField(name = "Name")
            private String name;

            @JSONField(name = "GroupType")
            private String groupType;

            @JSONField(name = "Logo")
            private String logo;

            @JSONField(name = "Count")
            private String count;
        }

    }
}
