package com.example.bigdata01.controller;


import com.example.bigdata01.pojo.Chinadaylist;
import com.example.bigdata01.service.ChinaDayListService;
import com.example.bigdata01.service.InterfaceService;
import com.example.bigdata01.vo.ChinaDayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ChinaDayListController {
    @Resource
    ChinaDayListService chinaDayListService;
    @Resource
    InterfaceService interfaceService;

    @RequestMapping("/getChinadaylist")
    @ResponseBody

    public ChinaDayList getChinadaylist(){
        List<Chinadaylist> china = interfaceService.queryBychinaDayList();
        ChinaDayList chinaDaylist = new ChinaDayList();
        chinaDaylist.setId(0);
        try {
            chinaDaylist.setTodayConfirm(china.get(0).getToday().getConfirm());
        }catch (NullPointerException e)
        {}

        try {
            chinaDaylist.setTodaySuspect(china.get(0).getToday().getSuspect());
        }catch (NullPointerException e)
        {}

        chinaDaylist.setData(china.get(0).getDate());
        chinaDaylist.setTodayHeal(china.get(0).getToday().getHeal());
        chinaDaylist.setTodayDead(china.get(0).getToday().getDead());
        chinaDaylist.setTodaySevere(china.get(0).getToday().getSevere());
        chinaDaylist.setTodayStoreConfirm(china.get(0).getToday().getStoreconfirm());
        chinaDaylist.setTodayInput(china.get(0).getToday().getInput());
        chinaDaylist.setTotalConfirm(china.get(0).getTotal().getConfirm());
        chinaDaylist.setTotalSuspect(china.get(0).getTotal().getSuspect());
        chinaDaylist.setTotalHeal(china.get(0).getTotal().getHeal());
        chinaDaylist.setTotalDead(china.get(0).getTotal().getDead());
        chinaDaylist.setTotalSevere(china.get(0).getTotal().getSevere());
        chinaDaylist.setTotalInput(china.get(0).getTotal().getInput());
        chinaDaylist.setTotalStoreConfirm(china.get(0).getTotal().getStoreConfirm());
        chinaDayListService.insert(chinaDaylist);
        return chinaDaylist;
    }

}
