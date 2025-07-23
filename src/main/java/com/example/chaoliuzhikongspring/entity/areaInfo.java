package com.example.chaoliuzhikongspring.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("area_info")
public class areaInfo {
    @TableId(value = "area_id",type = IdType.AUTO)
    private Integer areaId;
    @TableField("area")
    private String areaName;
    @TableField("area_status")
    private Integer areaStatus;
    @TableField("area_team_id")
    private Integer areaTeamId;
    @TableField("area_warn_reason")
    private String areaWarnReason;
    @TableField("area_water_use_standard")
    private String areaWaterUseStandard;
    @TableField("water_ladder1")
    private BigDecimal waterLadder1;
    @TableField("water_ladder2")
    private BigDecimal waterLadder2;
    @TableField("water_ladder3")
    private BigDecimal waterLadder3;
    @TableField("supply_prices1")
    private BigDecimal supplyPrices1;
    @TableField("supply_prices2")
    private BigDecimal supplyPrices2;
    @TableField("supply_prices3")
    private BigDecimal supplyPrices3;
    @TableField("sewage_treatment_fee")
    private BigDecimal sewageTreatmentFee;

}
