package com.qilang.test.flow;

import lombok.Data;

import java.util.List;

@Data
public class FlowPage<T> {
    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 页数
     */
    private Integer pages;
    /**
     * 每页条数
     */
    private Integer pageSize;
    /**
     * 列表数据
     */
    private List<T> records;
    /**
     * 总计条数
     */
    private Integer total;


}