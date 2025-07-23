package com.example.chaoliuzhikongspring.service.deviceService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.chaoliuzhikongspring.entity.deviceInfo;

public interface deviceService extends IService<deviceInfo> {
    IPage<deviceInfo> getPageData(Integer pageNum,Integer pageSize);
    long onlineCount();
    long totalCount();
}
