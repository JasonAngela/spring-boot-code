package com.qilang.test.json;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


/**
 * @author hql
 */
@Data
public class ApiLinkContent<T> implements Serializable {

    private static final long serialVersionUID = -4753031059534482761L;

    private List<T> content;

    private Integer totalElements;
}
