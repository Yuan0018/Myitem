package com.example.chaoliuzhikongspring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.chaoliuzhikongspring.common.Result;
import com.example.chaoliuzhikongspring.entity.UserInfo;

import com.example.chaoliuzhikongspring.entity.loginRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

@Mapper
public interface UserMapper extends BaseMapper<UserInfo> {


    @Select("SELECT * FROM user_info WHERE user_id = #{userId}")
    UserInfo mygetUser(String userId);

    @Select("SELECT * FROM user_info WHERE user_phone = #{userPhone} OR user_email = #{userEmail}")
    loginRequest login(loginRequest LoginRequest);

    @Update("UPDATE user_info SET last_login_time = NOW() WHERE user_phone = #{userPhone} OR user_email = #{userEmail}")
    void updateUserlastLogin(loginRequest lastLogin);

    @Select("SELECT * FROM user_info WHERE user_email = #{email}")
    UserInfo getUserByemail(String email);

    @Select("SELECT * FROM user_info WHERE user_phone = #{userPhone}")
    UserInfo getUserByPhone(String userPhone);
}
