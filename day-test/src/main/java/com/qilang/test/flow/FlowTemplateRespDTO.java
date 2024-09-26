// FlowTemplateRespDTO.java

package com.qilang.test.flow;

import lombok.Data;

import java.util.List;

/**
 * 流程對象
 * @author gatsby.Luo (luolonglong@itg.com.cn)
 * @version 1.0.0
 * @since 2022/10/27
 */
@Data
public class FlowTemplateRespDTO {
    /**
     * 流程实例数
     */
    private Long instanceNum;
    /**
     * 模板编码
     */
    private String modelCode;
    /**
     * 模板名称
     */
    private String modelName;
    /**
     * 流程数据
     */
    private List<FlowTemplateTaskRespDTO> taskRespDTOS;


}




