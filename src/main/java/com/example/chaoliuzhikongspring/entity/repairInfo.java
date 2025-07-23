package com.example.chaoliuzhikongspring.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("repair_info")
public class repairInfo {
    @TableId(value = "repair_id",type = IdType.AUTO)
    private Integer repairId;
    @TableField("repair_device_type")
    private String repairDeviceType;
    @TableField("repair_device_id")
    private String repairDeviceId;
    @TableField("repair_reason")
    private String repairReason;
    @TableField("repair_logs")
    private LocalDate repairLogs;
    @TableField("repair_status")
    private Integer repairStatus;
}
