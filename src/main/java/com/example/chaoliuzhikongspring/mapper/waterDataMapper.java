package com.example.chaoliuzhikongspring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.chaoliuzhikongspring.entity.waterInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface waterDataMapper extends BaseMapper<waterInfo> {
    @Select("SELECT * FROM waterdata WHERE user_id = #{id}")
    waterInfo mygetByid(String id);
}
