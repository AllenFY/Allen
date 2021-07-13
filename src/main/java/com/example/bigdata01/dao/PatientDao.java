package com.example.bigdata01.dao;

import com.example.bigdata01.pojo.MapValue;
import com.example.bigdata01.pojo.Patient;
import com.example.bigdata01.pojo.ResultNum;

import java.util.List;
import java.util.Map;

//Dao：数据访问层 连接数据库
public interface PatientDao {
    List<Patient> queryAll();

    Patient queryByIdCard(String idCard);

    Patient queryById(int id);
    //统计各省病例情况
    int queryByProvince();

    public ResultNum getPatientCount();

    public List<MapValue> queryProvinceCount();
}
