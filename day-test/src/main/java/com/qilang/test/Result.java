package com.qilang.test;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author huql
 * @Description $
 * @Date $ $
 **/
@Data
public class Result implements Serializable {

    private String code;

    private String message;

    private boolean data;

    private Boolean success;
}
