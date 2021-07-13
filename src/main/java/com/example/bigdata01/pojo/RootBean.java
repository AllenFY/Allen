package com.example.bigdata01.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class RootBean {

    private int reqid;
    private int code;
    private String msg;
    private Data data;
    private int timestamp;


}