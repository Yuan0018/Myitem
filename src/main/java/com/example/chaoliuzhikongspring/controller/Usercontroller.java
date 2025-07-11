package com.example.chaoliuzhikongspring.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
//  新增用户
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
//  根据ID修改用户数据  ID不能为空
    @PutMapping("/user")
    public Result updateuser(@RequestBody user_info user){
        if(user.getUser_id()==null){
            return Result.error("ID不能为空");
        }
        boolean success = userservice.updateById(user);
        if(success) return Result.success();
        else return Result.error();
    }
//    根据用户ID查询用户数据
    @GetMapping("/user/{user_id}")
    public Result getuser(@PathVariable String user_id) {
        user_info user = userservice.mygetUser(user_id);
        if (user != null) return Result.success(user);
        else return Result.error("信息查询不到");

    }
//    用户数据分页查询
    @GetMapping ("/user/page")
    public Result getuserpage(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        Page<user_info> page = new Page<>(pageNum,pageSize);
        IPage<user_info> userPage = userservice.page(page);
        if (userPage != null) return Result.success(userPage);
        else return Result.error("查询不到数据");
    }
}
