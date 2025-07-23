package com.example.chaoliuzhikongspring.service.deviceService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.chaoliuzhikongspring.entity.deviceInfo;
import com.example.chaoliuzhikongspring.mapper.deviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class deviceServiceImpl extends ServiceImpl<deviceMapper, deviceInfo> implements deviceService {
    @Autowired
    private deviceMapper deviceMapper;

    @Override
    public IPage<deviceInfo> getPageData(Integer pageNum,Integer pageSize){
        Page<deviceInfo> page = new Page<>(pageNum,pageSize);
        return deviceMapper.selectPage(page,null);
    }
    @Override
    public long onlineCount() {
        QueryWrapper<deviceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status",1);
        return deviceMapper.selectCount(queryWrapper);
    }
    @Override
    public long totalCount() {
        QueryWrapper<deviceInfo> queryWrapper = new QueryWrapper<>();
        return deviceMapper.selectCount(queryWrapper);
    }
}
