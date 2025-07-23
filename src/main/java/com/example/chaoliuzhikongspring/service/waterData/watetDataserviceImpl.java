package com.example.chaoliuzhikongspring.service.waterData;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.chaoliuzhikongspring.entity.waterInfo;
import com.example.chaoliuzhikongspring.mapper.waterDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class watetDataserviceImpl extends ServiceImpl<waterDataMapper, waterInfo> implements waterDataservice {

    @Autowired
    private waterDataMapper waterDataMapper;
    @Override
    public waterInfo mygetById(String id){
        return waterDataMapper.mygetByid(id);
    }
}
