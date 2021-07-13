package com.example.bigdata01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Total {

    private int confirm;
    private int suspect;
    private int heal;
    private int dead;
    private int severe;
    private int input;
    private int storeConfirm;

}