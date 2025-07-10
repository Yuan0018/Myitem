package com.example.chaoliuzhikongspring.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class user_info {
    private String id;
    private String user_name;
    private String user_phone;
    private String user_email;
    private String user_password;
    private String user_address;
    private LocalDateTime last_login_time;

}
