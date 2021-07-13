package com.example.bigdata01.pojo;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chinadaylist {

    private Date date;
    private Today today;
    private Total total;
    private String extdata;
    private String lastupdatetime;

}