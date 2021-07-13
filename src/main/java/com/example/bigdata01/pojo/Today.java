package com.example.bigdata01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Today {

    private int confirm;
    private String suspect;
    private int heal;
    private int dead;
    private int severe;
    private int storeconfirm;
    private int input;
    private Date date;

}