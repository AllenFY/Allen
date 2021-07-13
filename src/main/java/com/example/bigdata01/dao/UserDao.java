package com.example.bigdata01.dao;

import com.example.bigdata01.pojo.User;

public interface UserDao {
    public User queryByUsername(String name);

}
