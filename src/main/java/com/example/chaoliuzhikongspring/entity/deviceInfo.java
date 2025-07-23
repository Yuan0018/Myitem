package com.example.chaoliuzhikongspring.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("device_info")
public class deviceInfo {
    @TableId(value="device_id")
    private String deviceId;
    @TableField("device_type")
    private String deviceType;
    @TableField("device_factory_number")
    private String deviceFactoryNumber;
    @TableField("device_calibre")
    private String deviceCalibre;
    @TableField("device_precision")
    private String devicePrecision;
    @TableField("device_area")
    private String deviceArea;
    @TableField("device_calibration")
    private LocalDate deviceCalibration;
    @TableField("status")
    private Integer status;
    @TableField("electricity")
    private Integer electricity;
    @TableField("firmware_version")
    private String firmwareVersion;
    @TableField("signal_strength")
    private Integer signalStrength;

    @TableField("total_water_flow")
    private Integer totalWaterFlow;

    @TableField("month_flow")
    private Integer monthFlow;

    @TableField("temperature")
    private BigDecimal temperature;

    @TableField("pressure")
    private BigDecimal pressure;

}
