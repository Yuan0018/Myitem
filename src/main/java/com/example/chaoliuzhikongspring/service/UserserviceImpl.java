package com.example.chaoliuzhikongspring.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.chaoliuzhikongspring.entity.user_info;
import com.example.chaoliuzhikongspring.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserserviceImpl extends ServiceImpl<UserMapper, user_info> implements Userservice {

}
