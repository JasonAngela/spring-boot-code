package com.qilang.test;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ShareUrlDTO implements Serializable {


    private Long id;



    private String systemCode;

    private String appCode;
}
