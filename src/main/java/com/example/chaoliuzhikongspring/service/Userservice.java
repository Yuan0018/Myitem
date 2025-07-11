package com.example.chaoliuzhikongspring.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.chaoliuzhikongspring.entity.user_info;


public interface Userservice extends IService<user_info> {

    IPage<user_info> getUserPage(Integer pageNum, Integer pageSize);

    user_info mygetUser(String userId);
}
