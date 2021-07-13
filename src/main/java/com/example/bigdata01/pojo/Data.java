package com.example.bigdata01.pojo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;


@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class Data {

    private Chinatotal chinatotal;
    private List<Chinadaylist> chinadaylist;
    private String lastupdatetime;
    private String oversealastupdatetime;
    private List<Areatree> areatree;

}