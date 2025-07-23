package com.example.chaoliuzhikongspring.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import com.example.chaoliuzhikongspring.config.JsonTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "waterdata")
public class waterInfo {
    @TableId("user_id")
    private String userId;

    @TableField("user_status")
    private Integer userStatus;

    @TableField("error_reason")
    private String errorReason;


    @TableField(value = "year_usewater_total", typeHandler = JsonTypeHandler.class)
    private String yearUsewaterTotal;

    @TableField("year")
    private Integer year;

    @TableField(value = "year_discounted",typeHandler = JsonTypeHandler.class)
    private String yearDiscounted;

    @TableField("month")
    private Integer month;

    @TableField(value = "month_usewater_total",typeHandler = JsonTypeHandler.class)
    private String monthUsewaterTotal;
    @TableField(value = "month_discounted",typeHandler = JsonTypeHandler.class)
    private String monthDiscounted;




}
