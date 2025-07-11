package com.example.chaoliuzhikongspring.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.chaoliuzhikongspring.entity.user_info;
import com.example.chaoliuzhikongspring.mapper.UserMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserserviceImpl extends ServiceImpl<UserMapper, user_info> implements Userservice {
        @Autowired
        private  UserMapper userMapper;

        @Override
        public IPage<user_info> getUserPage(Integer pageNum, Integer pageSize){
//            在服务层创建分页对象
            Page<user_info> page = new Page<>(pageNum,pageSize);
            return userMapper.selectPage(page,null);
        }
        @Override
        public user_info mygetUser(String userId){
            return userMapper.mygetUser(userId);
        }

}
