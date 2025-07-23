package com.example.chaoliuzhikongspring.service.User;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.chaoliuzhikongspring.entity.UserInfo;
import com.example.chaoliuzhikongspring.entity.loginRequest;


public interface Userservice extends IService<UserInfo> {

    IPage<UserInfo> getUserPage(Integer pageNum,Integer pageSize);

    UserInfo getUserByemail(String email);

    UserInfo mygetUser(String userId);

    loginRequest login(loginRequest LoginRequest);

    void updateUserInfo(loginRequest LoginRequest);

    UserInfo getUserByPhone(String userPhone);
}
