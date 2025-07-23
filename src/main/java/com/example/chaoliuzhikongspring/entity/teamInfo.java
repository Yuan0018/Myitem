package com.example.chaoliuzhikongspring.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("team_info")
public class teamInfo {
    @TableId(value = "team_id",type = IdType.AUTO)
    private Integer teamId;
    @TableField("team_name")
    private String teamName;
    @TableField("team_status")
    private Integer teamStatus;
    @TableField("repair_id")
    private Integer repairId;
    @TableField("remark")
    private String remark;


}
