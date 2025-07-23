package com.example.chaoliuzhikongspring.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_info")
public class loginRequest {
    @TableField("user_phone")
    private String userPhone;
    @TableField("user_email")
    private String userEmail;
    @TableField("user_password")
    private String userPassword;

    private String permissions;
}
