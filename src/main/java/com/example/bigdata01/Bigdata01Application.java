package com.example.bigdata01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.bigdata01")
@MapperScan("com.example.bigdata01.dao")
public class Bigdata01Application {

    public static void main(String[] args) {
        SpringApplication.run(Bigdata01Application.class, args);
    }

}
