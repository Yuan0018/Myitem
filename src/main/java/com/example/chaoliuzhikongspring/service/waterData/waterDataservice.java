package com.example.chaoliuzhikongspring.service.waterData;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.chaoliuzhikongspring.entity.waterInfo;

public interface waterDataservice extends IService<waterInfo> {
    waterInfo mygetById(String id);
}
