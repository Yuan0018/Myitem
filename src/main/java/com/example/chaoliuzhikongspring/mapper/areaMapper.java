package com.example.chaoliuzhikongspring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.chaoliuzhikongspring.entity.areaInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface areaMapper extends BaseMapper<areaInfo> {
    @Update("UPDATE area_info SET area_team_id =#{teamId} WHERE area_id = #{areaId}")
    int sendteam(Integer areaId,Integer teamId);
}
