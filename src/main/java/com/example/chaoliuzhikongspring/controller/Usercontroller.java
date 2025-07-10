package com.example.chaoliuzhikongspring.controller;

import com.example.chaoliuzhikongspring.common.Result;
import com.example.chaoliuzhikongspring.entity.user_info;
import com.example.chaoliuzhikongspring.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class Usercontroller {

    @Autowired
    private Userservice userservice;

    @PostMapping("/user")
    public Result adduser(@RequestBody user_info user){
        boolean success = userservice.save(user);
        if(success){
            return Result.success();
        }else {
            return Result.error();
        }
    }
}
