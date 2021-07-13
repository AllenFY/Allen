package com.example.bigdata01.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chinatotal {

    private Today today;
    private Total total;
    private Extdata extdata;
    private Date date;
}