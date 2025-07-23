package com.example.chaoliuzhikongspring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.chaoliuzhikongspring.entity.historyInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface historyMapper extends BaseMapper<historyInfo> {

}
