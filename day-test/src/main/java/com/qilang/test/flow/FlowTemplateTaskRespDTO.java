package com.qilang.test.flow;

import lombok.Data;

import java.util.List;

/**
 * 流程数据
 * @author gatsby.Luo (luolonglong@itg.com.cn)
 * @version 1.0.0
 * @since 2022/10/27
 */
@Data
public class FlowTemplateTaskRespDTO {
	/**
	 * 会签前置节点编码
	 */
	private List<String> mergeTaskCodes;
	/**
	 * 下节点
	 */
	private List<String> nextTasks;
	/**
	 * 节点编码
	 */
	private String taskCode;
	/**
	 * 节点条件
	 */
	private List<String> taskCondition;
	/**
	 * 节点名称
	 */
	private String taskName;
	/**
	 * 节点类型
	 */
	private String taskType;


}