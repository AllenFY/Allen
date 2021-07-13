package com.example.bigdata01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseValue {
    private int status; //200 正常 300 异常
    private String message; //异常
}
