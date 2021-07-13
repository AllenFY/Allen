package com.example.bigdata01.controller;

import com.example.bigdata01.pojo.ResponseValue;
import com.example.bigdata01.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@CrossOrigin
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping("/user/login")
    @ResponseBody
    public ResponseValue login(@RequestParam("name") String username , @RequestParam("pwd") String password){
        ResponseValue value = new ResponseValue();
        try{
            userService.login(username,password);
            value.setStatus(200);
            value.setMessage("登录成功");
        }catch (Exception e){
            value.setStatus(300);
            value.setMessage(e.getMessage());
        }

        return value;
    }
}
