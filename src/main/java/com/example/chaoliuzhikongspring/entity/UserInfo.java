package com.example.chaoliuzhikongspring.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_info")
public class UserInfo {
    @TableId(value = "user_id", type = IdType.INPUT)
    private String userId; // 建议使用驼峰命名

    @TableField("user_name")
    private String userName;

    @TableField("user_phone")
    private String userPhone;

    @TableField("user_email")
    private String userEmail;

    @TableField("user_password")
    private String userPassword;

    @TableField("user_address")
    private String userAddress;

    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;

    private String permissions;

}

