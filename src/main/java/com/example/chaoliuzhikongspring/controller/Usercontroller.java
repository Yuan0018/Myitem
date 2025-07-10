package com.example.chaoliuzhikongspring.controller;

import com.example.chaoliuzhikongspring.common.Result;
import com.example.chaoliuzhikongspring.entity.user_info;
import com.example.chaoliuzhikongspring.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class Usercontroller {

    @Autowired
    private Userservice userservice;

    @PostMapping("/user")
    public Result adduser(@RequestBody user_info user){
//      设置随机10位数为用户ID
        long randomNum = (long) (Math.random() * 10000000000L);
        String id = String.format("%010d", randomNum);
        user.setUser_id(id);
        boolean success = userservice.save(user);
        if(success){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    @PutMapping("/user")
    public Result updateuser(@RequestBody user_info user){
        if(user.getUser_id()==null){
            return Result.error("ID不能为空");
        }
        boolean success = userservice.updateById(user);
        if(success) return Result.success();
        else return Result.error();
    }
}
