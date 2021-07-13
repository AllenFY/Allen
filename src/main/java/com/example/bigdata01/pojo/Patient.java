package com.example.bigdata01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor  //无参构造方法
@AllArgsConstructor    //有参构造方法
@Data     //getter/setter方法 重写hashCode equals   toString()方法
public class Patient {
    private Integer id;
    private String name;
    private String province;
}
