package com.example.chaoliuzhikongspring.service.User;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.chaoliuzhikongspring.entity.UserInfo;
import com.example.chaoliuzhikongspring.entity.loginRequest;
import com.example.chaoliuzhikongspring.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserserviceImpl extends ServiceImpl<UserMapper, UserInfo> implements Userservice {
        @Autowired
        private  UserMapper userMapper;

        @Override
        public UserInfo getUserByemail(String email) {
            UserInfo use = userMapper.getUserByemail(email);
            return use;
        }


        @Override
        public IPage<UserInfo> getUserPage(Integer pageNum, Integer pageSize){
//            在服务层创建分页对象
            Page<UserInfo> page = new Page<>(pageNum,pageSize);
            return userMapper.selectPage(page,null);
        }
        @Override
        public UserInfo mygetUser(String userId){
            return userMapper.mygetUser(userId);
        }

        @Override
        public loginRequest login(loginRequest LoginRequest){
            loginRequest myloginResult = userMapper.login(LoginRequest);
            return myloginResult;
        }
        @Override
        public void updateUserInfo(loginRequest LoginRequest){
            userMapper.updateUserlastLogin(LoginRequest);
        }

        @Override
        public UserInfo getUserByPhone(String userPhone){
            return userMapper.getUserByPhone(userPhone);
        }
}
