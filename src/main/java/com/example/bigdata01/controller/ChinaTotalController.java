package com.example.bigdata01.controller;

import com.example.bigdata01.pojo.Chinatotal;
import com.example.bigdata01.service.ChinaTotalService;
import com.example.bigdata01.service.InterfaceService;
import com.example.bigdata01.vo.ChinaTotal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class ChinaTotalController {

    @Resource
    ChinaTotalService chinaTotalService;
    @Resource
    InterfaceService interfaceService;

    @RequestMapping("/getChinatotal")
    @ResponseBody
    public ChinaTotal getChinatotal(){
        Chinatotal china = interfaceService.queryByChinatotal();
        ChinaTotal chinaTotal = new ChinaTotal();
        chinaTotal.setId(0);
        chinaTotal.setTodayConfirm(china.getToday().getConfirm());
        chinaTotal.setTodaySuspect(china.getToday().getSuspect());
        chinaTotal.setTodayHeal(china.getToday().getHeal());
        chinaTotal.setTodayDead(china.getToday().getDead());
        chinaTotal.setTodaySevere(china.getToday().getSevere());
        chinaTotal.setTodayStoreConfirm(china.getToday().getStoreconfirm());
        chinaTotal.setTodayInput(china.getToday().getInput());
        chinaTotal.setTotalConfirm(china.getTotal().getConfirm());
        chinaTotal.setTotalSuspect(china.getTotal().getSuspect());
        chinaTotal.setTotalHeal(china.getTotal().getHeal());
        chinaTotal.setTotalDead(china.getTotal().getDead());
        chinaTotal.setTotalSevere(china.getTotal().getSevere());
        chinaTotal.setTotalInput(china.getTotal().getInput());
        chinaTotal.setExtDataIncrNoSymptom(china.getExtdata().getIncrNoSymptom());
        chinaTotal.setExtDataNoSymptom(china.getExtdata().getNoSypmtom());
        chinaTotal.setCreateDate(china.getToday().getDate());
        chinaTotalService.insert(chinaTotal);
        return chinaTotal;
        }

}
