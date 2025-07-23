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
@TableName("history_operation")
public class historyInfo {
    @TableId(value = "history_id",type = IdType.AUTO)
    private Integer historyid;
    @TableField("user_id")
    private String userid;
    @TableField("operation")
    private String operation;
    @TableField("operation_time")
    private LocalDateTime operationtime;
}
