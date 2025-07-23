package com.example.chaoliuzhikongspring.service.areaService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.chaoliuzhikongspring.common.Result;
import com.example.chaoliuzhikongspring.entity.UserInfo;
import com.example.chaoliuzhikongspring.entity.areaInfo;
import com.example.chaoliuzhikongspring.mapper.areaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class areaServiceImpl extends ServiceImpl<areaMapper, areaInfo> implements areaService {
    @Autowired
    private areaMapper areaMapper;
//    分页查询
    @Override
    public IPage<areaInfo> pageArea(Integer pageNum, Integer pageSize){
        Page<areaInfo> page = new Page<>(pageNum, pageSize);
        return areaMapper.selectPage(page,null);
    }
//     团队派遣
    @Override
    public boolean sendteam(Integer areaId, Integer teamId) {
       int res =  areaMapper.sendteam(areaId,teamId);
       if (res>0) return true;
       else return false;
    }

}
