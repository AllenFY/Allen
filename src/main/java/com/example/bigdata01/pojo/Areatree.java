package com.example.bigdata01.pojo;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Areatree {

    private Today today;
    private Total total;
    private Extdata extdata;
    private String name;
    private String id;
    private String lastupdatetime;
    private List<String> children;

}