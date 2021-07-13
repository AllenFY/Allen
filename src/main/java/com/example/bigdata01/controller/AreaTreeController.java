package com.example.bigdata01.controller;

import com.example.bigdata01.pojo.Areatree;
import com.example.bigdata01.service.AreaTreeService;
import com.example.bigdata01.service.InterfaceService;
import com.example.bigdata01.vo.AreaTree;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class AreaTreeController {
    @Resource
    AreaTreeService areaTreeService;
    @Resource
    InterfaceService interfaceService;

    @RequestMapping("/getAreatree")
    @ResponseBody

    public AreaTree getAreatree(){
        List<Areatree> area = interfaceService.queryByAreatree();
        AreaTree areaTree= new AreaTree();
        areaTree.setId(0);
        areaTree.setTodayConfirm(area.get(0).getToday().getConfirm());
        areaTree.setTodaySuspect(area.get(0).getToday().getSuspect());
        areaTree.setTodayHeal(area.get(0).getToday().getHeal());
        areaTree.setTodayDead(area.get(0).getToday().getDead());
        areaTree.setTodaySevere(area.get(0).getToday().getSevere());
        areaTree.setTodayStoreConfirm(area.get(0).getToday().getStoreconfirm());
        areaTree.setTotalConfirm(area.get(0).getTotal().getConfirm());
        areaTree.setTotalSuspect(area.get(0).getTotal().getSuspect());
        areaTree.setTotalHeal(area.get(0).getTotal().getHeal());
        areaTree.setTotalDead(area.get(0).getTotal().getDead());
        areaTree.setTotalSevere(area.get(0).getTotal().getSevere());
        areaTree.setTotalInput(area.get(0).getTotal().getInput());
        areaTree.setExtDataIncrNoSymptom(area.get(0).getExtdata().getIncrNoSymptom());
        areaTree.setName(area.get(0).getName());
        areaTreeService.insert(areaTree);
        return areaTree;
    }

}
