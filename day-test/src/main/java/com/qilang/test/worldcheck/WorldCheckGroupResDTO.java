package com.qilang.test.worldcheck;

import lombok.Data;

import java.io.Serializable;


/**
 * 类描述：分组返回
 *
 * @author hql
 */
@Data
public class WorldCheckGroupResDTO implements Serializable {

    private static final long serialVersionUID = 3900713190558063933L;

    private String id;

    private String name;

    private String parentId;

    private Boolean hasChildren;

    private String status;

    //排除children 节点 暂时不用
}
