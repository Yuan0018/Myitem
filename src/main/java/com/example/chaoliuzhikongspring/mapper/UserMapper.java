package com.example.chaoliuzhikongspring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.chaoliuzhikongspring.entity.user_info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<user_info> {
    @Select("SELECT * FROM user_info WHERE user_id = #{id}")
    user_info mygetUser(String id);
}
