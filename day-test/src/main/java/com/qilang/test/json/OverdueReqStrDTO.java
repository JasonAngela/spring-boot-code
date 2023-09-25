package com.qilang.test.json;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hql
 */
@Data
public class OverdueReqStrDTO implements Serializable {

    private static final long serialVersionUID = 6029838688943232863L;

    /**
     * pageNo
     */
    private Integer pageNo;

    /**
     * pageSize
     */
    private Integer pageSize;

    /**
     * inFields
     */
    private String inFields;
}
