package com.example.bigdata01.controller;

import com.example.bigdata01.pojo.MapValue;
import com.example.bigdata01.pojo.Patient;
import com.example.bigdata01.pojo.ResultNum;
import com.example.bigdata01.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@CrossOrigin
public class PatientController {

    @Resource
    PatientService patientService;
    @ResponseBody
    @RequestMapping("/count")
    public ResultNum getPatientCount(){
        ResultNum resultNum=patientService.getCount();
        return resultNum;
    }
    @ResponseBody
    @RequestMapping("/list")
    public List<Patient> searchAll(){
        List<Patient> list=patientService.searchAll();
        return list;
    }

    @ResponseBody
    @RequestMapping("/provinceCount")
    public List<MapValue> getProvinceCount(){
        List<MapValue> list=patientService.searchProvinceCount();
        return list;
    }
}

